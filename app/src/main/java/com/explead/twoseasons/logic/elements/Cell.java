package com.explead.twoseasons.logic.elements;

/**
 * Created by Александр on 09.07.2017.
 */

public class Cell {

    protected int id;
    protected int x;
    protected int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Cell cell = (Cell) obj;
        return (x == cell.getX() && y == cell.getY());
    }

    public Cell getCopy() {
        Cell newCell = new Cell(this.x, this.y);
        newCell.setId(this.id);
        return newCell;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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
