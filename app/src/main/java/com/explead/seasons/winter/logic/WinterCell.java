package com.explead.seasons.winter.logic;


import com.explead.seasons.common.logic.Cell;

public class WinterCell extends Cell {

    public enum PurposeCell {
        EMPTY, WALL, CUBE, ROUTE
    }

    private PurposeCell purpose;

    public WinterCell(int x, int y) {
        super(x, y);
    }

    public void makeEmpty() {
        purpose = PurposeCell.EMPTY;
    }

    public void makeWall() {
        purpose = PurposeCell.WALL;
    }

    public WinterCell getCopyCell() {
        return new WinterCell(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        WinterCell cell = (WinterCell) obj;
        return (x == cell.getX() && y == cell.getY());
    }
}
