package com.explead.seasons.common.logic;


public class ContainerCells {

    private Cell oneCell;
    private Cell twoCell;

    private Cell.ColorCube color;

    public ContainerCells(Cell cell, Cell twoCell, Cell.ColorCube color) {
        this.oneCell = cell;
        this.twoCell = twoCell;
        this.color = color;
    }

    public Cell getOneCell() {
        return oneCell;
    }

    public Cell getTwoCell() {
        return twoCell;
    }

    public Cell.ColorCube getColor() {
        return color;
    }
}
