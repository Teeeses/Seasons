package com.explead.twoseasons.beans;

import com.explead.twoseasons.logic.elements.ContainerCells;

import java.util.ArrayList;

/**
 * Created by Александр on 09.07.2017.
 */

public class LevelContainer {

    private int[][] field;
    private ArrayList<ContainerCells> cells;

    public LevelContainer(int[][] field, ArrayList<ContainerCells> cells) {
        this.field = field;
        this.cells = cells;
    }

    public int[][] getField() {
        return field;
    }

    public ArrayList<ContainerCells> getCells() {
        return cells;
    }


}
