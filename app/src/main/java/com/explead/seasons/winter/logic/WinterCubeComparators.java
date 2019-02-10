package com.explead.seasons.winter.logic;

import java.util.Comparator;

public class WinterCubeComparators {

    public static Comparator<WinterCube> UP = new Comparator<WinterCube>() {
        @Override
        public int compare(WinterCube a, WinterCube b) {
            if (a.getX() < b.getX()) return -1;
            else if (a.getX() == b.getX()) return 0;
            else return 1;
        }
    };

    public static Comparator<WinterCube> DOWN = new Comparator<WinterCube>() {
        @Override
        public int compare(WinterCube a, WinterCube b) {
            if (a.getX() < b.getX()) return 1;
            else if (a.getX() == b.getX()) return 0;
            else return -1;
        }
    };

    public static Comparator<WinterCube> RIGHT = new Comparator<WinterCube>() {
        @Override
        public int compare(WinterCube a, WinterCube b) {
            if (a.getY() < b.getY()) return 1;
            else if (a.getY() == b.getY()) return 0;
            else return -1;
        }
    };

    public static Comparator<WinterCube> LEFT = new Comparator<WinterCube>() {
        @Override
        public int compare(WinterCube a, WinterCube b) {
            if (a.getY() < b.getY()) return -1;
            else if (a.getY() == b.getY()) return 0;
            else return 1;
        }
    };
}