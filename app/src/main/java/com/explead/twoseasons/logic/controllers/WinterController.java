package com.explead.twoseasons.logic.controllers;

import android.util.Log;

import com.explead.twoseasons.app.App;
import com.explead.twoseasons.beans.LevelContainer;
import com.explead.twoseasons.logic.elements.Cell;
import com.explead.twoseasons.logic.elements.ContainerCells;
import com.explead.twoseasons.logic.elements.winter_elements.FieldWinter;
import com.explead.twoseasons.logic.elements.StartCell;

import java.util.ArrayList;

/**
 * Created by Александр on 09.07.2017.
 */

public class WinterController extends BaseController {

    public static int NO_MOVE = 0, MOVE = 1, WIN = 2;
    private int status = NO_MOVE;

    private FieldWinter field;

    public interface OnControllerListener {
        void onChangeCell(Cell startCell, Cell newCell, String direction);
    }

    private OnControllerListener onControllerListener;

    public WinterController(int level) {
        this.level = level;
        LevelContainer container;
        container = App.getWinterLevels().get(level-1);
        field = new FieldWinter(container.getField(), container.getCells());
    }

    public void logicMove(final int start_x, final int start_y, final int end_x, final int end_y) {
        if(status == NO_MOVE) {
            int side1 = (start_x - end_x);
            int side2 = (start_y - end_y);
            int hypotenuse = (int) (Math.sqrt(Math.abs(side1 * side1) + Math.abs(side2 * side2)));
            double angle = (Math.asin((double) side2 / hypotenuse)) * 57.295f;
            if (hypotenuse > 50 && ((angle < 30 && angle > -30) || (angle > 60) || (angle < -60))) {
                if ((side1 <= 0 && side2 >= 0 && angle < 30) || (side1 <= 0 && side2 <= 0 && angle > -30)) {
                    moveRight();
                } else if ((side1 <= 0 && side2 >= 0 && angle > 60) || (side1 >= 0 && side2 >= 0 && angle > 60)) {
                    moveUp();
                } else if ((side1 >= 0 && side2 >= 0 && angle < 30) || (side1 >= 0 && side2 <= 0 && angle > -30)) {
                    moveLeft();
                } else if ((side1 >= 0 && side2 <= 0 && angle < -60) || (side1 <= 0 && side2 <= 0 && angle < -60)) {
                    moveDown();
                }
            }
            if (checkWin()) {
                onGameListener.onWin();
            }
        }
    }

    public boolean checkWin() {
        ArrayList<ContainerCells> actionCells = field.getActionCells();
        for(int i = 0; i < actionCells.size(); i++) {
            if(!actionCells.get(i).getStartCell().equals(actionCells.get(i).getEndCell())) {
                return false;
            }
        }
        status = WIN;
        return true;
    }

    public void setOnControllerListener(OnControllerListener onControllerListener) {
        this.onControllerListener = onControllerListener;
    }

    private void moveRight() {
        Log.d("TAG", "RIGHT");

        for(int i = 0; i < field.getSizeField(); i++) {
            int wallY = field.getSizeField();
            int numberChanges = 0;
            for(int j = field.getSizeField()-1; j >= 0; j--) {
                int value = field.getField()[i][j];
                if(value == FieldWinter.WALL_CELL) {
                    wallY = j;
                    numberChanges = 0;
                } else if(value != 0 && value < FieldWinter.WALL_CELL) {
                    int newCoordinate = wallY - 1 - numberChanges;

                    if(newCoordinate < 0)
                        newCoordinate = 0;
                    field.getField()[i][j] = 0;
                    field.getField()[i][newCoordinate] = value;

                    StartCell startCell = new StartCell(field.getActionCells().get(value-1).getStartCell().getY(), field.getActionCells().get(value-1).getStartCell().getX());
                    field.getActionCells().get(value-1).getStartCell().setX(newCoordinate);
                    field.getActionCells().get(value-1).getStartCell().setY(i);
                    StartCell newCell = new StartCell(i, newCoordinate);
                    numberChanges++;

                    onControllerListener.onChangeCell(startCell, newCell, "right");
                }
            }
        }
    }

    private void moveLeft() {
        Log.d("TAG", "LEFT");

        for(int i = 0; i < field.getSizeField(); i++) {
            int wallY = -1;
            int numberChanges = 0;
            for(int j = 0; j < field.getSizeField(); j++) {
                int value = field.getField()[i][j];
                if(value == FieldWinter.WALL_CELL) {
                    wallY = j;
                    numberChanges = 0;
                } else if(value != 0 && value < FieldWinter.WALL_CELL) {
                    int newCoordinate = wallY + 1 + numberChanges;

                    if(newCoordinate > field.getSizeField()-1)
                        newCoordinate = field.getSizeField() - 1;
                    field.getField()[i][j] = 0;
                    field.getField()[i][newCoordinate] = value;

                    StartCell startCell = new StartCell(field.getActionCells().get(value-1).getStartCell().getY(), field.getActionCells().get(value-1).getStartCell().getX());
                    field.getActionCells().get(value-1).getStartCell().setX(newCoordinate);
                    field.getActionCells().get(value-1).getStartCell().setY(i);
                    StartCell newCell = new StartCell(i, newCoordinate);
                    numberChanges++;

                    onControllerListener.onChangeCell(startCell, newCell, "left");
                }
            }
        }
    }

    private void moveUp() {
        Log.d("TAG", "UP");

        for(int i = 0; i < field.getSizeField(); i++) {
            int wallY = -1;
            int numberChanges = 0;
            for(int j = 0; j < field.getSizeField(); j++) {
                int value = field.getField()[j][i];
                if(value == FieldWinter.WALL_CELL) {
                    wallY = j;
                    numberChanges = 0;
                } else if(value != 0 && value < FieldWinter.WALL_CELL) {
                    int newCoordinate = wallY + 1 + numberChanges;

                    if(newCoordinate > field.getSizeField()-1)
                        newCoordinate = field.getSizeField()-1;
                    field.getField()[j][i] = 0;
                    field.getField()[newCoordinate][i] = value;

                    StartCell startCell = new StartCell(field.getActionCells().get(value-1).getStartCell().getY(), field.getActionCells().get(value-1).getStartCell().getX());
                    field.getActionCells().get(value-1).getStartCell().setX(i);
                    field.getActionCells().get(value-1).getStartCell().setY(newCoordinate);
                    StartCell newCell = new StartCell(newCoordinate, i);
                    numberChanges++;

                    onControllerListener.onChangeCell(startCell, newCell, "up");
                }
            }
        }
    }

    private void moveDown() {
        Log.d("TAG", "DOWN");

        for(int i = 0; i < field.getSizeField(); i++) {
            int wallY = field.getSizeField();
            int numberChanges = 0;
            for(int j = field.getSizeField() - 1; j >= 0; j--) {
                int value = field.getField()[j][i];
                if(value == FieldWinter.WALL_CELL) {
                    wallY = j;
                    numberChanges = 0;
                } else if(value != 0 && value < FieldWinter.WALL_CELL) {
                    int newCoordinate = wallY - 1 - numberChanges;

                    if(newCoordinate < 0)
                        newCoordinate = 0;
                    field.getField()[j][i] = 0;
                    field.getField()[newCoordinate][i] = value;

                    StartCell startCell = new StartCell(field.getActionCells().get(value-1).getStartCell().getY(), field.getActionCells().get(value-1).getStartCell().getX());
                    field.getActionCells().get(value-1).getStartCell().setX(i);
                    field.getActionCells().get(value-1).getStartCell().setY(newCoordinate);
                    StartCell newCell = new StartCell(newCoordinate, i);
                    numberChanges++;

                    onControllerListener.onChangeCell(startCell, newCell, "down");
                }
            }
        }
    }

    public FieldWinter getField() {
        return field;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
