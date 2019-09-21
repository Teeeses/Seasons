package com.explead.seasons.winter.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.explead.seasons.common.adapters.GridAdapter
import com.explead.seasons.common.app.App
import com.explead.seasons.common.beans.AllLevels.Month.DECEMBER
import com.explead.seasons.common.beans.AllLevels.Month.JANUARY
import com.explead.seasons.common.ui.fragments.LevelsFragment
import com.explead.seasons.databinding.FragmentLevelsWinterBinding

/**
 * Created by Александр on 09.07.2017.
 */

internal class WinterLevelsFragment : LevelsFragment() {

    private lateinit var viewHolder: FragmentLevelsWinterBinding

    private lateinit var decemberAdapter: GridAdapter
    private lateinit var januaryAdapter: GridAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewHolder = FragmentLevelsWinterBinding.inflate(inflater, container, false)

        viewHolder.snowfall.startAnimation()

        val params = RelativeLayout.LayoutParams(App.getWidthScreen().toInt(), (App.getWidthScreen() * 0.646f).toInt())
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
        viewHolder.bottomImage.layoutParams = params

        createAdapters()

        viewHolder.scroll.smoothScrollTo(0, 0)

        return viewHolder.root
    }

    private fun createAdapters() {
        decemberAdapter = createGrid(DECEMBER)
        viewHolder.gvDecember.adapter = decemberAdapter
        viewHolder.gvDecember.numColumns = 3

        januaryAdapter = createGrid(JANUARY)
        viewHolder.gvJanuary.adapter = januaryAdapter
        viewHolder.gvJanuary.numColumns = 3
    }

    override fun onResume() {
        super.onResume()
        decemberAdapter.refreshStatus()
        januaryAdapter.refreshStatus()
        viewHolder.snowfall.startAnimation()
    }

    override fun onStop() {
        super.onStop()
        viewHolder.snowfall.stopAnimation()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewHolder.snowfall.stopAnimation()
    }
}
