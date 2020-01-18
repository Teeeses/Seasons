package com.explead.seasons.winter.logic


import com.explead.seasons.common.logic.Cell
import com.explead.seasons.common.logic.Direction

class WinterCell(x: Int, y: Int) : Cell(x, y) {

    private var onChangePurposeListener: OnChangePurposeListener? = null

    var purpose: PurposeCell? = null
        private set

    //Если не null - значит на этой клетке стрелка
    var direction: Direction? = null
        private set

    val id: Char
        get() = if (purpose == PurposeCell.EMPTY) 'O' else 'X'

    val copyCell: WinterCell
        get() = WinterCell(x, y)

    interface OnChangePurposeListener {
        fun onChangePurpose()
    }

    enum class PurposeCell {
        EMPTY, WALL, ARROW
    }

    fun makeEmpty() {
        purpose = PurposeCell.EMPTY
        direction = null
    }

    fun makeWall() {
        purpose = PurposeCell.WALL
        direction = null
    }

    fun makeArrow(id: Char) {
        purpose = PurposeCell.ARROW
        findDirection(id)
    }

    fun changePurpose(purpose: PurposeCell) {
        if (this.purpose != purpose) {
            this.purpose = purpose
            onChangePurposeListener?.onChangePurpose()
        }
    }

    private fun findDirection(id: Char) {
        when (id) {
            'u' -> direction = Direction.U
            'r' -> direction = Direction.R
            'd' -> direction = Direction.D
            'l' -> direction = Direction.L
        }
    }

    override fun equals(obj: Any?): Boolean {
        val cell = obj as WinterCell?
        return x == cell!!.x && y == cell.y
    }

    fun setOnChangePurposeListener(onChangePurposeListener: OnChangePurposeListener) {
        this.onChangePurposeListener = onChangePurposeListener
    }
}
