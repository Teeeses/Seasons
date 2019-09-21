package com.explead.seasons.spring.levels

import com.explead.screenmovementfinger.beans.Coordinate
import com.explead.seasons.common.logic.ColorMember
import com.explead.seasons.common.logic.LevelField
import com.explead.seasons.spring.logic.SpringMember
import java.util.*

class MarchLevels {

    private val levels: ArrayList<LevelField> = ArrayList()

    init {
        createLevels()
    }

    private fun createLevels() {
        levels.add(LevelField()
                .count(1)
                .addMember(SpringMember()
                        .coordinate(0, 0)
                        .color(ColorMember.RED))
                .field(listOf(
                        listOf('0', '0', 'x', 'x', 'x'),
                        listOf('0', '0', '0', 'x', 'x'),
                        listOf('x', '0', '0', '0', 'x'),
                        listOf('x', 'x', '0', '0', '0'),
                        listOf('x', 'x', 'x', '0', '0'))
                ))
    }
}
