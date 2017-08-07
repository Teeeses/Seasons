package com.explead.twoseasons.logic.controllers;

import com.explead.twoseasons.beans.LevelContainer;
import com.explead.twoseasons.logic.elements.ContainerCells;
import com.explead.twoseasons.logic.elements.EndCell;
import com.explead.twoseasons.logic.elements.Field;
import com.explead.twoseasons.logic.elements.StartCell;

import java.util.ArrayList;

/**
 * Created by Александр on 09.07.2017.
 */

public class Modes {

    public interface OnGameListener {
        void onWin();
    }

    protected OnGameListener onGameListener;
    protected Field field;

    public LevelContainer getSummerLevel(int level) {
        int[][] mass = null;
        ArrayList<ContainerCells> containerCells = new ArrayList<>();

        if(level == 1) {
            mass = new int[][] {
                    {0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0},
                    {0, 6, 0, 0, 6},
                    {0, 6, 6, 0, 0},
                    {0, 0, 0, 0, 0}
            };
            containerCells.add(new ContainerCells(new StartCell(0, 0), new EndCell(1, 4)));
            containerCells.add(new ContainerCells(new StartCell(2, 2), new EndCell(4, 4)));
            containerCells.add(new ContainerCells(new StartCell(1, 3), new EndCell(3, 4)));
        }

        return new LevelContainer(mass, containerCells);
    }

    public LevelContainer getWinterLevel(int level) {
        int[][] mass = null;
        ArrayList<ContainerCells> containerCells = new ArrayList<>();

        if(level == 1) {
            mass = new int[][] {
                    {0, 0, 0, 0, 0},
                    {6, 0, 6, 6, 6},
                    {6, 0, 6, 0, 0},
                    {0, 0, 6, 6, 0},
                    {0, 0, 0, 0, 0}
            };
            containerCells.add(new ContainerCells(new StartCell(0, 0), new EndCell(2, 3)));
            containerCells.add(new ContainerCells(new StartCell(2, 3), new EndCell(0, 0)));
        }

        return new LevelContainer(mass, containerCells);
    }

    public Field getField() {
        return field;
    }
}
