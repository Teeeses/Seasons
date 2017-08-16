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

    protected  int level;

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
        } else if(level == 2) {
            mass = new int[][]{
                    {0, 0, 0, 0, 0},
                    {6, 0, 6, 0, 0},
                    {0, 0, 6, 0, 0},
                    {0, 0, 0, 0, 0},
                    {0, 0, 6, 6, 6}
            };
            containerCells.add(new ContainerCells(new StartCell(4, 0), new EndCell(4, 1)));
            containerCells.add(new ContainerCells(new StartCell(4, 1), new EndCell(4, 0)));
        } else if(level == 3) {
            mass = new int[][]{
                    {0, 0, 0, 0, 6},
                    {0, 6, 0, 0, 0},
                    {6, 6, 0, 6, 0},
                    {6, 6, 0, 6, 0},
                    {6, 0, 0, 6, 0}
            };
            containerCells.add(new ContainerCells(new StartCell(4, 4), new EndCell(4, 1)));
            containerCells.add(new ContainerCells(new StartCell(4, 1), new EndCell(4, 4)));
        } else if(level == 4) {
            mass = new int[][]{
                    {0, 0, 0, 0, 0},
                    {0, 0, 0, 6, 0},
                    {6, 6, 0, 6, 6},
                    {0, 0, 0, 0, 0},
                    {0, 0, 0, 6, 0}
            };
            containerCells.add(new ContainerCells(new StartCell(1, 4), new EndCell(4, 4)));
            containerCells.add(new ContainerCells(new StartCell(4, 4), new EndCell(1, 4)));
        } else if(level == 5) {
            mass = new int[][]{
                    {0, 0, 0, 0, 0, 0},
                    {6, 6, 6, 6, 0, 0},
                    {0, 0, 0, 0, 0, 0},
                    {0, 6, 6, 6, 6, 0},
                    {6, 6, 0, 0, 0, 0},
                    {6, 6, 0, 0, 0, 0}
            };
            containerCells.add(new ContainerCells(new StartCell(5, 2), new EndCell(4, 2)));
            containerCells.add(new ContainerCells(new StartCell(4, 2), new EndCell(5, 2)));
        } else if(level == 6) {
            mass = new int[][]{
                    {0, 6, 0, 6, 0},
                    {0, 6, 0, 6, 0},
                    {0, 6, 0, 6, 0},
                    {0, 6, 0, 0, 0},
                    {0, 0, 0, 0, 6}
            };
            containerCells.add(new ContainerCells(new StartCell(0, 0), new EndCell(0, 4)));
            containerCells.add(new ContainerCells(new StartCell(0, 4), new EndCell(0, 0)));
        } else if(level == 7) {
            mass = new int[][]{
                    {6, 6, 6, 0, 0, 0, 0},
                    {6, 6, 6, 0, 6, 6, 0},
                    {0, 0, 6, 0, 6, 6, 0},
                    {6, 0, 6, 6, 6, 6, 0},
                    {0, 0, 6, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 6, 6},
                    {6, 6, 6, 6, 6, 6, 6}
            };
            containerCells.add(new ContainerCells(new StartCell(2, 0), new EndCell(2, 3)));
            containerCells.add(new ContainerCells(new StartCell(2, 3), new EndCell(2, 0)));
        } else if(level == 8) {
            mass = new int[][]{
                    {0, 0, 0, 0, 0},
                    {6, 0, 6, 6, 0},
                    {0, 0, 6, 0, 0},
                    {0, 6, 6, 0, 0},
                    {0, 0, 0, 0, 0}
            };
            containerCells.add(new ContainerCells(new StartCell(0, 0), new EndCell(2, 3)));
            containerCells.add(new ContainerCells(new StartCell(2, 3), new EndCell(0, 0)));
        } else if(level == 9) {
            mass = new int[][]{
                    {0, 0, 0, 0, 0, 0},
                    {0, 6, 6, 6, 0, 6},
                    {0, 6, 0, 6, 0, 0},
                    {0, 0, 0, 6, 6, 0},
                    {0, 0, 6, 6, 0, 0},
                    {0, 0, 0, 0, 0, 0}
            };
            containerCells.add(new ContainerCells(new StartCell(2, 4), new EndCell(2, 2)));
            containerCells.add(new ContainerCells(new StartCell(2, 2), new EndCell(2, 4)));
        } else if(level == 10) {
            mass = new int[][]{
                    {0, 0, 0, 6, 6, 6},
                    {0, 0, 6, 6, 0, 0},
                    {0, 0, 0, 0, 0, 0},
                    {0, 6, 0, 6, 0, 6},
                    {0, 0, 0, 0, 0, 0},
                    {6, 0, 0, 6, 0, 0}
            };
            containerCells.add(new ContainerCells(new StartCell(1, 5), new EndCell(0, 2)));
            containerCells.add(new ContainerCells(new StartCell(0, 2), new EndCell(1, 5)));
        } else if(level == 11) {
            mass = new int[][] {
                    {0, 0, 0, 0, 6, 6, 6},
                    {0, 6, 0, 0, 6, 0, 0},
                    {0, 6, 0, 0, 6, 0, 6},
                    {0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 6, 0, 6, 6, 6},
                    {6, 0, 0, 0, 0, 0, 0}
            };
            containerCells.add(new ContainerCells(new StartCell(1, 6), new EndCell(6, 6)));
            containerCells.add(new ContainerCells(new StartCell(6, 6), new EndCell(1, 6)));
        } else if(level == 12) {
            mass = new int[][] {
                    {0, 0, 6, 6, 6, 6},
                    {6, 0, 0, 0, 6, 6},
                    {0, 0, 6, 0, 0, 0},
                    {0, 6, 6, 6, 6, 0},
                    {0, 0, 6, 0, 0, 0},
                    {6, 0, 0, 0, 6, 6}
            };
            containerCells.add(new ContainerCells(new StartCell(0, 0), new EndCell(2, 3)));
            containerCells.add(new ContainerCells(new StartCell(2, 3), new EndCell(0, 0)));
        } else if(level == 13) {
            mass = new int[][]{
                    {0, 0, 0, 0, 0},
                    {0, 0, 0, 6, 6},
                    {0, 6, 0, 6, 0},
                    {0, 0, 0, 0, 0},
                    {6, 6, 0, 6, 6}
            };
            containerCells.add(new ContainerCells(new StartCell(0, 4), new EndCell(4, 2)));
            containerCells.add(new ContainerCells(new StartCell(4, 2), new EndCell(0, 4)));
        } else if(level == 14) {
            mass = new int[][]{
                    {0, 0, 0, 6, 0, 0},
                    {0, 6, 0, 6, 6, 0},
                    {0, 6, 0, 6, 0, 0},
                    {0, 6, 0, 6, 0, 6},
                    {0, 0, 0, 0, 0, 6},
                    {0, 6, 0, 0, 0, 6}
            };
            containerCells.add(new ContainerCells(new StartCell(0, 4), new EndCell(5, 0)));
            containerCells.add(new ContainerCells(new StartCell(5, 0), new EndCell(0, 4)));
        } else if(level == 15) {
            mass = new int[][]{
                    {0, 0, 0, 0, 6},
                    {6, 6, 0, 0, 0},
                    {0, 0, 0, 0, 0},
                    {6, 6, 0, 6, 0},
                    {6, 0, 0, 6, 0}
            };
            containerCells.add(new ContainerCells(new StartCell(2, 0), new EndCell(4, 4)));
            containerCells.add(new ContainerCells(new StartCell(4, 4), new EndCell(2, 0)));
        } else if(level == 16) {
            mass = new int[][]{
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 6, 6, 6, 6, 6, 6, 6, 0},
                    {0, 6, 0, 0, 0, 0, 0, 0, 0},
                    {0, 6, 0, 6, 6, 6, 6, 6, 6},
                    {0, 6, 0, 6, 0, 0, 0, 6, 0},
                    {0, 6, 0, 6, 0, 0, 6, 6, 0},
                    {0, 6, 0, 0, 0, 0, 0, 6, 0},
                    {0, 6, 6, 6, 6, 6, 6, 6, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0}
            };
            containerCells.add(new ContainerCells(new StartCell(0, 0), new EndCell(4, 8)));
            containerCells.add(new ContainerCells(new StartCell(4, 8), new EndCell(0, 0)));
        } else if(level == 17) {
            mass = new int[][]{
                    {0, 0, 0, 6, 0, 0, 0, 0, 0},
                    {0, 6, 0, 6, 0, 0, 0, 0, 0},
                    {0, 6, 6, 6, 0, 0, 0, 0, 0},
                    {0, 6, 6, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 6, 0},
                    {0, 0, 0, 0, 0, 0, 6, 6, 0},
                    {6, 0, 6, 6, 6, 6, 6, 0, 0},
                    {6, 0, 0, 0, 6, 0, 0, 0, 6},
                    {6, 6, 6, 0, 0, 0, 6, 6, 6}
            };
            containerCells.add(new ContainerCells(new StartCell(1, 2), new EndCell(5, 5)));
            containerCells.add(new ContainerCells(new StartCell(5, 5), new EndCell(1, 2)));
        }  else if(level == 18) {
            mass = new int[][]{
                    {0, 0, 0, 6, 0},
                    {0, 6, 0, 6, 0},
                    {0, 6, 0, 6, 0},
                    {0, 6, 0, 0, 0},
                    {0, 0, 0, 0, 6}
            };
            containerCells.add(new ContainerCells(new StartCell(0, 0), new EndCell(0, 4)));
            containerCells.add(new ContainerCells(new StartCell(0, 4), new EndCell(0, 0)));
        } else if(level == 19) {
            mass = new int[][]{
                    {0, 0, 0, 0, 6, 6, 6, 6},
                    {0, 6, 6, 0, 0, 0, 0, 0},
                    {0, 0, 6, 0, 0, 6, 0, 0},
                    {6, 0, 6, 0, 6, 6, 6, 0},
                    {6, 0, 0, 0, 6, 0, 0, 0},
                    {6, 6, 6, 0, 6, 0, 6, 6},
                    {6, 6, 0, 0, 6, 0, 0, 6},
                    {6, 6, 0, 6, 6, 6, 6, 6}
            };
            containerCells.add(new ContainerCells(new StartCell(7, 2), new EndCell(6, 6)));
            containerCells.add(new ContainerCells(new StartCell(6, 6), new EndCell(7, 2)));
        } else if(level == 20) {
            mass = new int[][]{
                    {6, 6, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 6, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 6, 6, 6},
                    {0, 0, 6, 0, 6, 0, 6, 0, 0},
                    {0, 0, 6, 0, 6, 0, 6, 0, 6},
                    {0, 0, 6, 0, 6, 0, 6, 0, 6},
                    {0, 0, 6, 0, 6, 0, 6, 0, 6},
                    {0, 0, 6, 0, 6, 0, 6, 0, 6},
                    {0, 0, 6, 6, 6, 0, 0, 0, 6}
            };
            containerCells.add(new ContainerCells(new StartCell(7, 3), new EndCell(3, 8)));
            containerCells.add(new ContainerCells(new StartCell(3, 8), new EndCell(7, 3)));
        }

        return new LevelContainer(mass, containerCells);
    }

    public void setOnGameListener(OnGameListener onGameListener) {
        this.onGameListener = onGameListener;
    }

    public Field getField() {
        return field;
    }

    public int getLevel() {
        return level;
    }
}
