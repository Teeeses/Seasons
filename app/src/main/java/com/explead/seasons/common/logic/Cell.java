package com.explead.seasons.common.logic;

public class Cell {

    protected int x;
    protected int y;
    protected ColorCube color;

    public enum ColorCube {
        RED, BLUE, YELLOW, GREEN, VIOLET
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Cell getCopyCell() {
        return new Cell(x, y);
    }

    public ColorCube getColor() {
        return color;
    }

    public void setColor(ColorCube color) {
        this.color = color;
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
