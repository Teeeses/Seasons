package com.explead.seasons.spring.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.explead.seasons.common.adapters.GridAdapter
import com.explead.seasons.common.app.App
import com.explead.seasons.common.ui.fragments.LevelsFragment
import com.explead.seasons.common.utils.Utils
import com.explead.seasons.databinding.FragmentLevelsSpringBinding

import com.explead.seasons.common.beans.AllLevels.Month.MARCH
import com.explead.seasons.common.beans.AllLevels.Month.APRIL

internal class SpringLevelsFragment : LevelsFragment() {

    private lateinit var viewHolder: FragmentLevelsSpringBinding

    private lateinit var marchAdapter: GridAdapter
    private lateinit var aprilAdapter: GridAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewHolder = FragmentLevelsSpringBinding.inflate(inflater, container, false)

        viewHolder.april.typeface = Utils.getTypeFaceLevel(requireContext().assets)
        viewHolder.march.typeface = Utils.getTypeFaceLevel(requireContext().assets)

        viewHolder.scroll.smoothScrollTo(0, 0)

        val params = RelativeLayout.LayoutParams(App.getWidthScreen().toInt(), (App.getWidthScreen() * 0.646f).toInt())
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
        viewHolder.bottomImage.layoutParams = params

        createAdapters()

        viewHolder.scroll.smoothScrollTo(0, 0)

        return viewHolder.root
    }

    private fun createAdapters() {
        marchAdapter = createGrid(MARCH)
        viewHolder.gridMarch.adapter = marchAdapter
        viewHolder.gridMarch.numColumns = 3

        aprilAdapter = createGrid(APRIL)
        viewHolder.gridApril.adapter = aprilAdapter
        viewHolder.gridApril.numColumns = 3
    }

    override fun onResume() {
        super.onResume()
        marchAdapter.refreshStatus()
        aprilAdapter.refreshStatus()
    }
}