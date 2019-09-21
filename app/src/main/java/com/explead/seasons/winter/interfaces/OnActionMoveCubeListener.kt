package com.explead.seasons.winter.interfaces

import com.explead.seasons.winter.logic.WinterCube

interface OnActionMoveCubeListener {
    fun onNotMove()
    fun onGoOnCell()
    fun onArrow()
    fun onCubeOnPlace(cube: WinterCube)
}
