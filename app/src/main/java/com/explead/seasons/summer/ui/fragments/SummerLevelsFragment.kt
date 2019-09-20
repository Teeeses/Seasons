package com.explead.seasons.summer.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout

import com.explead.seasons.R
import com.explead.seasons.common.app.App
import com.explead.seasons.common.beans.AllLevels
import com.explead.seasons.common.ui.fragments.LevelsFragment
import com.explead.seasons.databinding.FragmentLevelsSummerBinding
import com.explead.seasons.databinding.FragmentLevelsWinterBinding

/**
 * Created by Александр on 09.07.2017.
 */

class SummerLevelsFragment : LevelsFragment() {

    private lateinit var viewHolder: FragmentLevelsSummerBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewHolder = FragmentLevelsSummerBinding.inflate(inflater, container, false)

        val params = RelativeLayout.LayoutParams(App.getWidthScreen().toInt(), (App.getWidthScreen() * 0.646f).toInt())
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
        viewHolder.bottomImage.layoutParams = params

        createAdapters()

        viewHolder.scroll.smoothScrollTo(0, 0)

        return viewHolder.root
    }

    private fun createAdapters() {}

    override fun onResume() {
        super.onResume()
    }
}
