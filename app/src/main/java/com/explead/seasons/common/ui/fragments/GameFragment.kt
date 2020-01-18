package com.explead.seasons.common.ui.fragments

import androidx.fragment.app.Fragment
import com.explead.seasons.common.beans.AllLevels
import com.explead.seasons.common.interfaces.OnGameBarClickListener

/**
 * Created by Александр on 09.07.2017.
 */

open class GameFragment : Fragment() {

    protected var level: Int = 0
    protected lateinit var month: AllLevels.Month
}
