package com.explead.seasons.common.beans;

import com.explead.seasons.common.logic.ContainerCells;

import java.util.ArrayList;

/**
 * Created by Александр on 09.07.2017.
 */

public class LevelContainer {

    private char[][] field;
    private ArrayList<ContainerCells> cells;

    public LevelContainer(char[][] field, ArrayList<ContainerCells> cells) {
        this.field = field;
        this.cells = cells;
    }

    public char[][] getField() {
        return field;
    }

    public ArrayList<ContainerCells> getCells() {
        return cells;
    }

    public ArrayList<ContainerCells> getCopyCells() {
        ArrayList<ContainerCells> copy = new ArrayList<>();
        for(int i = 0; i < cells.size(); i++) {
            ContainerCells container = new ContainerCells(cells.get(i).getOneCell().getCopyCell(),
                    cells.get(i).getTwoCell().getCopyCell(), cells.get(i).getColor());
            copy.add(container);
        }
        return copy;
    }

    public char[][] getCopyField() {
        int size = field.length;
        char[][] copy = new char[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                copy[i][j] = field[i][j];
            }
        }
        return copy;
    }

}
