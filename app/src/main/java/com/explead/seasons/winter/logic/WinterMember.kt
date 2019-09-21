package com.explead.seasons.winter.logic

import com.explead.screenmovementfinger.beans.Coordinate
import com.explead.seasons.common.logic.ColorMember
import com.explead.seasons.common.logic.Member

class WinterMember(var start: Coordinate? = null,
                   var end: Coordinate? = null): Member() {

    fun start(x: Int, y: Int) = apply {
        this.start = Coordinate(x, y)
    }

    fun end(x: Int, y: Int) = apply {
        this.end = Coordinate(x, y)
    }

    fun color(color: ColorMember) = apply {
        this.color = color
    }
}