package com.explead.seasons.winter.logic;

import android.util.Log;

import com.explead.seasons.common.app.App;
import com.explead.seasons.common.beans.LevelContainer;
import com.explead.seasons.common.logic.Cell;
import com.explead.seasons.common.logic.ContainerCells;

import java.util.ArrayList;

/**
 * Created by Александр on 09.07.2017.
 */

public class FieldWinter {

    public interface OnControllerListener {
        void onChangeCell(WinterCell cell, WinterCell newCell, String direction);
    }

    private OnControllerListener onControllerListener;

    private static final int EMPTY_CELL = 0, WALL_CELL = 6;

    private int level;
    private int[][] field;
    private ArrayList<ContainerCells> actionCells;
    private ArrayList<EmptyCell> emptyCells = new ArrayList<>();
    private ArrayList<WallCell> wallCells = new ArrayList<>();

    public FieldWinter(int level) {
        this.level = level;
        LevelContainer container = App.getWinterLevels().get(level - 1);
        field = container.getCopyField();
        actionCells = container.getCopyCells();
        findCells();
        addActionCellsOnField(actionCells);
    }

    /**
     * Добавляем стартовые клетки на поле
     * Прибавляем +1 для того, что бы отличить пустые клетки от активной клетки с индексом 0
     */
    private void addActionCellsOnField(ArrayList<ContainerCells> actionCells) {
        for (int i = 0; i < actionCells.size(); i++) {
            Cell cell = actionCells.get(i).getOneCell();
            field[cell.getX()][cell.getY()] = i + 1;
        }
    }

    private void findCells() {
        for(int i = 0; i < field.length; i++) {
            for(int j = 0; j < field.length; j++) {
                if(field[i][j] == WALL_CELL) {
                    wallCells.add(new WallCell(i, j));
                }
                if(field[i][j] != WALL_CELL) {
                    emptyCells.add(new EmptyCell(i, j));
                }
            }
        }
    }


    public void moveRight() {
        Log.d("TAG", "RIGHT");

        for(int i = 0; i < field.length; i++) {
            int wallY = field.length;
            int numberChanges = 0;
            for(int j = field.length-1; j >= 0; j--) {
                int value = field[i][j];
                if(value == FieldWinter.WALL_CELL) {
                    wallY = j;
                    numberChanges = 0;
                } else if(value != 0 && value < FieldWinter.WALL_CELL) {
                    int newCoordinate = wallY - 1 - numberChanges;

                    if(newCoordinate < 0)
                        newCoordinate = 0;
                    field[i][j] = 0;
                    field[i][newCoordinate] = value;

                    WinterCell cell = new WinterCell(actionCells.get(value-1).getOneCell().getX(), actionCells.get(value-1).getOneCell().getY());
                    actionCells.get(value-1).getOneCell().setX(i);
                    actionCells.get(value-1).getOneCell().setY(newCoordinate);
                    WinterCell newCell = new WinterCell(i, newCoordinate);
                    numberChanges++;

                    onControllerListener.onChangeCell(cell, newCell, "right");
                }
            }
        }
    }

    public void moveLeft() {
        Log.d("TAG", "LEFT");

        for(int i = 0; i < field.length; i++) {
            int wallY = -1;
            int numberChanges = 0;
            for(int j = 0; j < field.length; j++) {
                int value = field[i][j];
                if(value == FieldWinter.WALL_CELL) {
                    wallY = j;
                    numberChanges = 0;
                } else if(value != 0 && value < FieldWinter.WALL_CELL) {
                    int newCoordinate = wallY + 1 + numberChanges;

                    if(newCoordinate > field.length-1)
                        newCoordinate = field.length - 1;
                    field[i][j] = 0;
                    field[i][newCoordinate] = value;

                    WinterCell cell = new WinterCell(actionCells.get(value-1).getOneCell().getX(), actionCells.get(value-1).getOneCell().getY());
                    actionCells.get(value-1).getOneCell().setX(i);
                    actionCells.get(value-1).getOneCell().setY(newCoordinate);
                    WinterCell newCell = new WinterCell(i, newCoordinate);
                    numberChanges++;

                    onControllerListener.onChangeCell(cell, newCell, "left");
                }
            }
        }
    }

    public void moveUp() {
        Log.d("TAG", "UP");

        for(int i = 0; i < field.length; i++) {
            int wallY = -1;
            int numberChanges = 0;
            for(int j = 0; j < field.length; j++) {
                int value = field[j][i];
                if(value == FieldWinter.WALL_CELL) {
                    wallY = j;
                    numberChanges = 0;
                } else if(value != 0 && value < FieldWinter.WALL_CELL) {
                    int newCoordinate = wallY + 1 + numberChanges;

                    if(newCoordinate > field.length-1)
                        newCoordinate = field.length-1;
                    field[j][i] = 0;
                    field[newCoordinate][i] = value;

                    WinterCell cell = new WinterCell(actionCells.get(value-1).getOneCell().getX(), actionCells.get(value-1).getOneCell().getY());
                    actionCells.get(value-1).getOneCell().setX(newCoordinate);
                    actionCells.get(value-1).getOneCell().setY(i);
                    WinterCell newCell = new WinterCell(newCoordinate, i);
                    numberChanges++;

                    onControllerListener.onChangeCell(cell, newCell, "up");
                }
            }
        }
    }



    public void moveDown() {
        Log.d("TAG", "DOWN");

        for(int i = 0; i < field.length; i++) {
            int wallY = field.length;
            int numberChanges = 0;
            for(int j = field.length - 1; j >= 0; j--) {
                int value = field[j][i];
                if(value == FieldWinter.WALL_CELL) {
                    wallY = j;
                    numberChanges = 0;
                } else if(value != 0 && value < FieldWinter.WALL_CELL) {
                    int newCoordinate = wallY - 1 - numberChanges;

                    if(newCoordinate < 0)
                        newCoordinate = 0;
                    field[j][i] = 0;
                    field[newCoordinate][i] = value;

                    WinterCell cell = new WinterCell(actionCells.get(value-1).getOneCell().getX(), actionCells.get(value-1).getOneCell().getY());
                    actionCells.get(value-1).getOneCell().setX(newCoordinate);
                    actionCells.get(value-1).getOneCell().setY(i);
                    WinterCell newCell = new WinterCell(newCoordinate, i);
                    numberChanges++;

                    onControllerListener.onChangeCell(cell, newCell, "down");
                }
            }
        }
    }


    public int getLevel() {
        return level;
    }

    public int[][] getField() {
        return field;
    }

    public ArrayList<EmptyCell> getEmptyCells() {
        return emptyCells;
    }

    public ArrayList<ContainerCells> getActionCells() {
        return actionCells;
    }

    public ArrayList<WallCell> getWallCells() {
        return wallCells;
    }

    public int getSizeField() {
        return field.length;
    }

    public void setOnControllerListener(OnControllerListener onControllerListener) {
        this.onControllerListener = onControllerListener;
    }

}
