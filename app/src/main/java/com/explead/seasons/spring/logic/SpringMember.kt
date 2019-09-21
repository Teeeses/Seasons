package com.explead.seasons.spring.logic

import com.explead.screenmovementfinger.beans.Coordinate
import com.explead.seasons.common.logic.ColorMember
import com.explead.seasons.common.logic.Member

class SpringMember(var coordinate: Coordinate? = null): Member() {

    fun coordinate(x: Int, y: Int) = apply {
        this.coordinate = Coordinate(x, y)
        currentCoordinate = this.coordinate as Coordinate
    }

    fun color(color: ColorMember) = apply {
        this.color = color
    }
}