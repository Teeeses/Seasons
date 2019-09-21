package com.explead.seasons.common.beans;

import com.explead.seasons.R;
import com.explead.seasons.common.logic.ColorMember;

public class GetIds {

    public static int getIdCubeFromColor(ColorMember color) {
        Integer id = null;
        if(color == ColorMember.RED) {
            id = R.drawable.red;
        }
        if(color == ColorMember.BLUE) {
            id = R.drawable.blue;
        }
        if(color == ColorMember.GREEN) {
            id = R.drawable.green;
        }
        if(color == ColorMember.YELLOW) {
            id = R.drawable.yellow;
        }
        if(color == ColorMember.VIOLET) {
            id = R.drawable.violet;
        }
        return id.intValue();
    }

    public static int getIdRouteFromColor(ColorMember color) {
        Integer id = null;
        if(color == ColorMember.RED) {
            id = R.drawable.red_route;
        }
        if(color == ColorMember.BLUE) {
            id = R.drawable.blue_route;
        }
        if(color == ColorMember.GREEN) {
            id = R.drawable.green_route;
        }
        if(color == ColorMember.YELLOW) {
            id = R.drawable.yellow_route;
        }
        if(color == ColorMember.VIOLET) {
            id = R.drawable.violet_route;
        }
        return id.intValue();
    }

    public static int getIdWinterInsideCubeFromColor(ColorMember color) {
        Integer id = null;
        if(color == ColorMember.RED) {
            id = R.drawable.icon_inside_red_cube;
        }
        if(color == ColorMember.BLUE) {
            id = R.drawable.icon_inside_blue_cube;
        }
        if(color == ColorMember.YELLOW) {
            id = R.drawable.icon_inside_yellow_cube;
        }
        return id.intValue();
    }

    public static int getIdWinterCubeFromColor(ColorMember color) {
        Integer id = null;
        if(color == ColorMember.RED) {
            id = R.drawable.icon_red_cube;
        }
        if(color == ColorMember.BLUE) {
            id = R.drawable.icon_blue_cube;
        }
        if(color == ColorMember.YELLOW) {
            id = R.drawable.icon_yellow_cube;
        }
        return id.intValue();
    }

}
