package com.explead.seasons.winter.logic

import com.explead.screenmovementfinger.beans.Coordinate
import com.explead.seasons.common.logic.ColorMember
import com.explead.seasons.common.logic.Direction
import com.explead.seasons.common.logic.Member
import com.explead.seasons.winter.interfaces.OnMoveCubeCallback
import com.explead.seasons.winter.interfaces.OnMoveCubeListener

class WinterMember: Member() {

    private lateinit var start: Coordinate
    private lateinit var end: Coordinate

    private var onMoveListener: OnMoveCubeListener? = null
    private var onMoveCubeCallback: OnMoveCubeCallback? = null

    var direction: Direction? = null
    private var lastDirection: Direction? = null
    private var lastX: Int = 0
    private var lastY: Int = 0

    //Есть ли движение
    var move = false

    val isTruePlace: Boolean
        get() = x == end.x && y == end.getY()


    fun start(x: Int, y: Int) = apply {
        this.start = Coordinate(x, y)
        this.x = x
        this.y = y
    }

    fun end(x: Int, y: Int) = apply {
        this.end = Coordinate(x, y)
    }

    fun color(color: ColorMember) = apply {
        this.color = color
    }

    fun move() {
        if (lastDirection === Direction.U) {
            if (lastX != x)
                onMoveListener!!.onUp(lastX, x)
        } else if (lastDirection === Direction.R) {
            if (lastY != y)
                onMoveListener!!.onRight(lastY, y)
        } else if (lastDirection === Direction.D) {
            if (lastX != x)
                onMoveListener!!.onDown(lastX, x)
        } else if (lastDirection === Direction.L) {
            if (lastY != y)
                onMoveListener!!.onLeft(lastY, y)
        }
    }

    fun isCoordinate(x: Int, y: Int): Boolean {
        return this.x == x && this.y == y
    }

    fun setOnMoveListener(onMoveListener: OnMoveCubeListener) {
        this.onMoveListener = onMoveListener
    }

    fun setLastCoordinate() {
        lastX = x
        lastY = y
    }

    fun setCoordinate(x: Int, y: Int) {
        this.x = x
        this.y = y
    }

    fun onFirstMove() {
        onMoveCubeCallback?.onFirstMove()
    }

    fun setOnMoveCubeCallback(onMoveCubeCallback: OnMoveCubeCallback) {
        this.onMoveCubeCallback = onMoveCubeCallback
    }

    fun setLastDirection() {
        this.lastDirection = direction
    }
}