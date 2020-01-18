package com.explead.seasons.winter.logic

import com.explead.seasons.common.logic.Cell
import com.explead.seasons.common.logic.Direction

class WinterArrow(x: Int, y: Int, val id: Int) : Cell(x, y) {
    var direction: Direction? = null
        private set

    init {
        findDirection()
    }

    private fun findDirection() {
        when (id) {
            1 -> direction = Direction.U
            2 -> direction = Direction.R
            3 -> direction = Direction.D
            4 -> direction = Direction.L
        }
    }

    fun gtNameId(): Char {
        return direction?.name?.get(0)!!
    }
}
