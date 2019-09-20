package com.explead.seasons.spring.levels

import com.explead.screenmovementfinger.beans.Coordinate
import com.explead.seasons.common.beans.LevelContainer
import com.explead.seasons.common.logic.Cell
import com.explead.seasons.common.logic.ContainerCells
import com.explead.seasons.spring.logic.LevelField
import com.explead.seasons.spring.logic.Member
import com.explead.seasons.winter.logic.WinterCell

import java.util.ArrayList

class MarchLevels {

    val levels: ArrayList<LevelField> = ArrayList()

    init {
        createLevels()
    }

    private fun createLevels() {
        levels.add(LevelField.Builder()
                .count(1)
                .addMember(Member(Coordinate(0, 0), Cell.ColorCube.RED))
                .field(arrayOf(
                        arrayOf('0', '0', 'x', 'x', 'x'),
                        arrayOf('0', '0', '0', 'x', 'x'),
                        arrayOf('x', '0', '0', '0', 'x'),
                        arrayOf('x', 'x', '0', '0', '0'),
                        arrayOf('x', 'x', 'x', '0', '0'))
                )
                .build())
    }
}
