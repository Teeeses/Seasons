package com.explead.seasons.common.ui.fragments

import android.content.Context
import android.widget.ImageView
import android.widget.TextView

import androidx.fragment.app.Fragment

import com.explead.seasons.common.ui.MainActivity

/**
 * Created by Александр on 09.07.2017.
 */

open class GameFragment : Fragment() {

    protected var activity: MainActivity

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        activity = context as MainActivity?
    }
}
