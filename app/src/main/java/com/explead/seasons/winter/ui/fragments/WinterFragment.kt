package com.explead.seasons.winter.ui.fragments

import android.graphics.Typeface
import android.media.AudioManager
import android.media.SoundPool
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.explead.screenmovementfinger.WinterMovementFinger
import com.explead.seasons.R
import com.explead.seasons.common.app.App
import com.explead.seasons.common.beans.AllLevels
import com.explead.seasons.common.beans.Level
import com.explead.seasons.common.dialogs.DialogHardIsClosed
import com.explead.seasons.common.dialogs.DialogMonthIsClosed
import com.explead.seasons.common.dialogs.DialogWinterHelp
import com.explead.seasons.common.dialogs.DialogWinterWin
import com.explead.seasons.common.interfaces.OnClosedCallback
import com.explead.seasons.common.interfaces.OnDialogCompletionListener
import com.explead.seasons.common.interfaces.OnGameBarClickListener
import com.explead.seasons.common.logic.Direction
import com.explead.seasons.common.ui.MainActivity
import com.explead.seasons.common.ui.fragments.GameFragment
import com.explead.seasons.databinding.FragmentWinterBinding
import com.explead.seasons.winter.logic.FieldWinter
import com.google.android.material.snackbar.Snackbar

/**
 * Created by Александр on 09.07.2017.
 */

class WinterFragment : GameFragment(), FieldWinter.OnControllerListener, OnGameBarClickListener, OnDialogCompletionListener, OnClosedCallback,
        WinterMovementFinger.OnSideFingerMovementCallback {

    private lateinit var viewHolder: FragmentWinterBinding

    private var fieldWinter: FieldWinter? = null

    private var soundPoolWin: SoundPool? = null
    private var soundPoolMove: SoundPool? = null

    private var complication: AllLevels.Complication = AllLevels.Complication.EASY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        level = arguments!!.getInt("level")
        month = arguments?.get("month") as AllLevels.Month
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewHolder = FragmentWinterBinding.inflate(inflater, container, false)

        soundPoolMove = SoundPool(1, AudioManager.STREAM_MUSIC, 100)
        soundPoolWin = SoundPool(1, AudioManager.STREAM_MUSIC, 100)
        soundPoolWin?.load(requireActivity(), R.raw.sound_win, 1)
        soundPoolMove?.load(requireActivity(), R.raw.move, 1)

        initListener()
        createSnowfall()

        checkOnDialogs()

        startGame(level, month, complication)

        return viewHolder.root
    }

    private fun initListener() {
        WinterMovementFinger(this).setTouchView(viewHolder.root)
        viewHolder.containerEasyLevel.setOnClickListener { changeOmEasy() }
        viewHolder.containerHardLevel.setOnClickListener { changeOnHard() }
        viewHolder.gameBar.setOnMenuClickListener(this)
    }

    private fun createSnowfall() {
        viewHolder.snowfall.setPeriodicityCreateSnowflake(400, 800)
        viewHolder.snowfall.setPeriodicityCreateCloud(15000)
    }

    override fun onUp() {
        fieldWinter?.move(Direction.U)
    }

    override fun onDown() {
        fieldWinter?.move(Direction.D)
    }

    override fun onRight() {
        fieldWinter?.move(Direction.R)
    }

    override fun onLeft() {
        fieldWinter?.move(Direction.L)
    }

    private fun checkOnDialogs() {
        if (level == 1 && month == AllLevels.Month.DECEMBER) {
            openHelpDialog()
        } else if (month == AllLevels.Month.JANUARY && !App.getSaverSpref().isLevelCompliated(AllLevels.Month.DECEMBER, Level.LEVEL_NEXT_MODE)) {
            openDialogMonthIsClosed()
        }
    }

    private fun openDialogMonthIsClosed() {
        val dialog = DialogMonthIsClosed(requireActivity(), this)
        dialog.show()
    }

    private fun openHelpDialog() {
        val dialog = DialogWinterHelp(requireActivity())
        dialog.show()
    }

    override fun onRestart() {
        viewHolder.fieldView.clearField()
        startGame(level, month, complication)
    }

    override fun onHelp() {
        val dialog = DialogWinterHelp(requireActivity())
        dialog.show()
    }

    override fun onWin() {
        checkOpenedMode(level)
        App.getSaverSpref().saveCurrentLevel(level, month, complication)
        soundPoolWin?.play(1, 0.2f, 0.2f, 1, 0, 1f)
        Handler().postDelayed({
            val dialog = DialogWinterWin(requireActivity(), this, complication, month, level)
            dialog.show()
        }, 500)
        (requireActivity() as MainActivity).sendEventWinGame(level, month, complication)
    }

    private fun checkOpenedMode(level: Int) {
        if (level == Level.LEVEL_NEXT_MODE && !App.getSaverSpref().isLevelCompliated(AllLevels.Month.DECEMBER, level)) {
            showSnackBarOpenNewMode()
        }
    }

    override fun onFirstMove() {
        soundPoolMove?.play(1, 0.2f, 0.2f, 1, 0, 1f)
    }

    private fun startGame(level: Int, month: AllLevels.Month?, complication: AllLevels.Complication) {
        (requireActivity() as MainActivity).sendEventStartGame(level, month, complication)
        viewHolder.gameBar.setNumberLevel(level)

        fieldWinter = FieldWinter(level, month, complication)
        fieldWinter?.setOnControllerListener(this)
        viewHolder.fieldView.setFieldWinter(fieldWinter)

        viewHolder.fieldView.clearField()
        viewHolder.fieldView.createField()
    }

    private fun changeOmEasy() {
        viewHolder.containerEasyLevel.visibility = View.GONE
        viewHolder.containerHardLevel.visibility = View.VISIBLE
        complication = AllLevels.Complication.EASY
        startGame(level, month, complication)
    }

    private fun changeOnHard() {
        if (!App.getSaverSpref().isLevelCompliated(month, level)) {
            val dialogHardClosed = DialogHardIsClosed(requireActivity())
            dialogHardClosed.show()
        } else {
            viewHolder.containerHardLevel.visibility = View.GONE
            viewHolder.containerEasyLevel.visibility = View.VISIBLE
            complication = AllLevels.Complication.HARD
            startGame(level, month, complication)
        }
    }

    private fun showSnackBarOpenNewMode() {
        if (view != null) {
            val sb = Snackbar.make(viewHolder.root,
                    String.format(requireContext().resources.getString(R.string.open_new_mode), requireContext().resources.getString(R.string.january)),
                    Snackbar.LENGTH_LONG)
            val view = sb.view
            val tv = view.findViewById<TextView>(R.id.snackbar_text)
            tv.textAlignment = View.TEXT_ALIGNMENT_CENTER
            tv.gravity = Gravity.CENTER_HORIZONTAL
            tv.typeface = Typeface.createFromAsset(requireContext().assets, "font/level_personal.ttf")
            sb.show()
        }
    }

    override fun onClosed() {
        requireActivity().onBackPressed()
    }

    override fun onMenu() {
        requireActivity().onBackPressed()
    }

    override fun onNextLevel() {
        level++
        changeOmEasy()
    }

    override fun onHardLevel() {
        changeOnHard()
    }

    override fun onResume() {
        super.onResume()
        viewHolder.snowfall.startAnimation()
    }

    override fun onStop() {
        super.onStop()
        viewHolder.snowfall.stopAnimation()
    }

    override fun onDestroy() {
        viewHolder.snowfall.stopAnimation()
        super.onDestroy()
    }
}
