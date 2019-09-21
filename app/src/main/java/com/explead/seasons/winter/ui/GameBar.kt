package com.explead.seasons.winter.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.explead.seasons.common.interfaces.OnGameBarClickListener
import com.explead.seasons.databinding.WinterGameBarBinding


internal class GameBar @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr), OnGameBarClickListener {

    init {
        init(context)
    }

    private lateinit var viewHolder: WinterGameBarBinding
    private var onGameBarClickListener: OnGameBarClickListener? = null

    private fun init(context: Context) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        viewHolder = WinterGameBarBinding.inflate(inflater)
        viewHolder.actions = this

        this.addView(viewHolder.root)
    }

    fun setOnMenuClickListener(listener: OnGameBarClickListener) {
        onGameBarClickListener = listener
    }

    fun setNumberLevel(level: Int) {
        viewHolder.tvNumberLevel.text = String.format("%s", level)
    }

    override fun onMenu() {
        onGameBarClickListener?.onMenu()
    }

    override fun onRestart() {
        onGameBarClickListener?.onRestart()
    }

    override fun onHelp() {
        onGameBarClickListener?.onHelp()
    }
}
