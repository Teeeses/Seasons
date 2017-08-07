package com.explead.twoseasons.logic.elements;

/**
 * Created by Александр on 09.07.2017.
 */

public class Cell {

    protected int x;
    protected int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Cell cell = (Cell) obj;
        if(x == cell.getX() && y == cell.getY()) {
            return true;
        }
        return false;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
