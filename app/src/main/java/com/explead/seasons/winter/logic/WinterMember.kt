package com.explead.seasons.winter.logic

import com.explead.screenmovementfinger.beans.Coordinate
import com.explead.seasons.common.logic.Cell
import com.explead.seasons.common.logic.Member

class WinterMember(val coordinateStart: Coordinate,
                   val coordinateEnd: Coordinate,
                   override val color: Cell.ColorCube): Member() {

    data class Builder(var coordinateStart: Coordinate,
                       var coordinateEnd: Coordinate,
                       var color: Cell.ColorCube) {


        fun coordinateStart(coordinateStart: Coordinate) = apply {
            this.coordinateStart = coordinateStart
        }

        fun coordinateEnd(coordinateEnd: Coordinate) = apply {
            this.coordinateEnd = coordinateEnd
        }

        fun color(color: Cell.ColorCube) = apply {
            this.color = color
        }

        fun build() = WinterMember(coordinateStart, coordinateEnd, color)
    }
}