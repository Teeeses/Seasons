package com.explead.seasons.spring.logic

import com.explead.screenmovementfinger.beans.Coordinate
import com.explead.seasons.common.logic.Cell
import com.explead.seasons.common.logic.Member

class SpringMember(val coordinate: Coordinate,
                   override val color: Cell.ColorCube): Member()