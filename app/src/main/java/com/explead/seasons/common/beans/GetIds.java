package com.explead.seasons.common.beans;

import com.explead.seasons.R;
import com.explead.seasons.common.logic.Cell;

public class GetIds {

    public static int getIdCubeFromColor(Cell.ColorCube color) {
        Integer id = null;
        if(color == Cell.ColorCube.RED) {
            id = R.drawable.red;
        }
        if(color == Cell.ColorCube.BLUE) {
            id = R.drawable.blue;
        }
        if(color == Cell.ColorCube.GREEN) {
            id = R.drawable.green;
        }
        if(color == Cell.ColorCube.YELLOW) {
            id = R.drawable.yellow;
        }
        if(color == Cell.ColorCube.VIOLET) {
            id = R.drawable.violet;
        }
        return id.intValue();
    }

    public static int getIdRouteFromColor(Cell.ColorCube color) {
        Integer id = null;
        if(color == Cell.ColorCube.RED) {
            id = R.drawable.red_route;
        }
        if(color == Cell.ColorCube.BLUE) {
            id = R.drawable.blue_route;
        }
        if(color == Cell.ColorCube.GREEN) {
            id = R.drawable.green_route;
        }
        if(color == Cell.ColorCube.YELLOW) {
            id = R.drawable.yellow_route;
        }
        if(color == Cell.ColorCube.VIOLET) {
            id = R.drawable.violet_route;
        }
        return id.intValue();
    }
}
