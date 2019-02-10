package com.explead.seasons.winter.logic;

import android.util.Log;

import com.explead.seasons.common.app.App;
import com.explead.seasons.common.beans.LevelContainer;
import com.explead.seasons.common.logic.Cell;
import com.explead.seasons.common.logic.ContainerCells;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Александр on 09.07.2017.
 */

public class FieldWinter {

    public interface OnControllerListener {
        void onWin();
    }

    private OnControllerListener onControllerListener;

    private static final int EMPTY_CELL = 0, WALL_CELL = 6;

    private int level;
    private WinterCell[][] field;
    private ArrayList<WinterCube> cubes = new ArrayList<>();

    public FieldWinter(int level) {
        this.level = level;
        LevelContainer container = App.getWinterLevels().get(level - 1);
        createField(container.getCopyField());
        addActionCellsOnField(container.getCopyCells());
    }

    private void createField(int[][] mass) {
        field = new WinterCell[mass.length][mass.length];
        for(int i = 0; i < mass.length; i++) {
            for(int j = 0; j < mass.length; j++) {
                WinterCell cell = new WinterCell(i, j);
                if(mass[i][j] == WALL_CELL) {
                    cell.makeWall();
                }
                if(mass[i][j] == EMPTY_CELL) {
                    cell.makeEmpty();
                }
                field[i][j] = cell;
            }
        }
    }

    /**
     * Добавляем стартовые клетки на поле
     * Прибавляем +1 для того, что бы отличить пустые клетки от активной клетки с индексом 0
     */
    private void addActionCellsOnField(ArrayList<ContainerCells> actionCells) {
        for (int i = 0; i < actionCells.size(); i++) {
            Cell cell = actionCells.get(i).getOneCell();
            Cell insideCell = actionCells.get(i).getTwoCell();
            Cell.ColorCube color = actionCells.get(i).getColor();
            WinterCube winterCube = new WinterCube(cell.getX(), cell.getY());
            WinterInsideCube winterInsideCube = new WinterInsideCube(insideCell.getX(), insideCell.getY(), color);
            winterCube.create(color, winterInsideCube);

            cubes.add(winterCube);
        }
    }


    public void moveRight() {
        Log.d("TAG", "RIGHT");

        Collections.sort(cubes, WinterCubeComparators.RIGHT);

        for(int i = 0; i < cubes.size(); i++) {
            WinterCube cube = cubes.get(i);
            int x = cube.getX();
            int y = cube.getY();
            loop:
            while(field[x][y].getPurpose() == WinterCell.PurposeCell.EMPTY && y < field.length-1) {
                y++;
                if(field[x][y].getPurpose() == WinterCell.PurposeCell.WALL) {
                    y--;
                    break;
                } else {
                    for(int k = i-1; k >= 0; k--){
                        if(cubes.get(k).isCoordinate(x, y)) {
                            y--;
                            break loop;
                        }
                    }
                }
            }
            cube.right(x, y);
        }
        checkWin();
    }

    public void moveLeft() {
        Log.d("TAG", "LEFT");

        Collections.sort(cubes, WinterCubeComparators.LEFT);

        for(int i = 0; i < cubes.size(); i++) {
            WinterCube cube = cubes.get(i);
            int x = cube.getX();
            int y = cube.getY();
            loop:
            while(field[x][y].getPurpose() == WinterCell.PurposeCell.EMPTY && y > 0) {
                y--;
                if(field[x][y].getPurpose() == WinterCell.PurposeCell.WALL) {
                    y++;
                    break;
                } else {
                    for(int k = i-1; k >= 0; k--){
                        if(cubes.get(k).isCoordinate(x, y)) {
                            y++;
                            break loop;
                        }
                    }
                }
            }
            cube.left(x, y);
        }
        checkWin();
    }

    public void moveUp() {
        Log.d("TAG", "UP");

        Collections.sort(cubes, WinterCubeComparators.UP);

        for(int i = 0; i < cubes.size(); i++) {
            WinterCube cube = cubes.get(i);
            int x = cube.getX();
            int y = cube.getY();
            loop:
            while(field[x][y].getPurpose() == WinterCell.PurposeCell.EMPTY && x > 0) {
                x--;
                if(field[x][y].getPurpose() == WinterCell.PurposeCell.WALL) {
                    x++;
                    break;
                } else {
                    for(int k = i-1; k >= 0; k--){
                        if(cubes.get(k).isCoordinate(x, y)) {
                            x++;
                            break loop;
                        }
                    }
                }
            }
            cube.up(x, y);
        }
        checkWin();
    }

    public void moveDown() {
        Log.d("TAG", "DOWN");

        Collections.sort(cubes, WinterCubeComparators.DOWN);

        for(int i = 0; i < cubes.size(); i++) {
            WinterCube cube = cubes.get(i);
            int x = cube.getX();
            int y = cube.getY();
            loop:
            while(field[x][y].getPurpose() == WinterCell.PurposeCell.EMPTY && x < field.length-1) {
                x++;
                if(field[x][y].getPurpose() == WinterCell.PurposeCell.WALL) {
                    x--;
                    break;
                } else {
                    for(int k = i-1; k >= 0; k--){
                        if(cubes.get(k).isCoordinate(x, y)) {
                            x--;
                            break loop;
                        }
                    }
                }
            }
            cube.down(x, y);
        }
        checkWin();
    }

    public void checkWin() {
        boolean value = true;
        for (int i = 0; i < cubes.size(); i++) {
            WinterCube cube = cubes.get(i);
            if(!cube.isTruePlace()) {
                value = false;
            }
        }
        if(value) {
            onControllerListener.onWin();
        }
    }

    public int getLevel() {
        return level;
    }

    public WinterCell[][] getField() {
        return field;
    }

    public ArrayList<WinterCube> getCubes() {
        return cubes;
    }

    public int getSizeField() {
        return field.length;
    }

    public void setOnControllerListener(OnControllerListener onControllerListener) {
        this.onControllerListener = onControllerListener;
    }

}
