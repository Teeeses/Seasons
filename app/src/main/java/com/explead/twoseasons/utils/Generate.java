package com.explead.twoseasons.utils;

import android.util.Log;

import com.explead.twoseasons.beans.LevelContainer;
import com.explead.twoseasons.logic.elements.ContainerCells;
import com.explead.twoseasons.logic.elements.EndCell;
import com.explead.twoseasons.logic.elements.Field;
import com.explead.twoseasons.logic.elements.StartCell;

import java.util.ArrayList;

/**
 * Created by develop on 17.08.2017.
 */

public class Generate {

    public static LevelContainer generate(int size) {
        ArrayList<ContainerCells> containerCells;

        int mass[][] = new int[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                mass[i][j] = randomWallOrEmpty();
            }
        }

        int a = random(0, size);
        int b = random(0, size);
        StartCell startCell = new StartCell(a, b);

        EndCell endCell;
        int c;
        int d;
        do {
            c = random(0, size);
            d = random(0, size);
            endCell = new EndCell(c, d);
        } while (endCell.equals(startCell));


        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(a, b), new EndCell(c, d)));
        containerCells.add(new ContainerCells(new StartCell(c, d), new EndCell(a, b)));

        writeField(mass, containerCells);

        return new LevelContainer(mass, containerCells);
    }

    public static int random(int a, int b) {
        return a + (int) (Math.random() * b);
    }

    public static int randomWallOrEmpty() {
        int value = 0;
        if(random(0, 2) == 0) {
            value = Field.EMPTY_CELL;
        } else if(random(0, 2) == 1) {
            value = Field.WALL_CELL;
        }
        return value;
    }

    public static void writeField(int[][] mass, ArrayList<ContainerCells> container) {
        for(int i = 0; i < mass.length; i++) {
            for(int j = 0; j < mass.length; j++) {
                System.out.print(mass[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println("x: " + container.get(0).getStartCell().getX() + " y: " + container.get(0).getEndCell().getY());
        System.out.println("x: " + container.get(1).getStartCell().getX() + " y: " + container.get(1).getEndCell().getY());
        System.out.println();
        System.out.println();
    }

    public static void check(int[][] mass, ArrayList<ContainerCells> containerCells) {

    }

    private void moveRight(Field field) {
        for(int i = 0; i < field.getSizeField(); i++) {
            int wallY = field.getSizeField();
            int numberChanges = 0;
            for(int j = field.getSizeField()-1; j >= 0; j--) {
                int value = field.getField()[i][j];
                if(value == Field.WALL_CELL) {
                    wallY = j;
                    numberChanges = 0;
                } else if(value != 0 && value < Field.WALL_CELL) {
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
                }
            }
        }
    }

    private void moveLeft(Field field) {
        for(int i = 0; i < field.getSizeField(); i++) {
            int wallY = -1;
            int numberChanges = 0;
            for(int j = 0; j < field.getSizeField(); j++) {
                int value = field.getField()[i][j];
                if(value == Field.WALL_CELL) {
                    wallY = j;
                    numberChanges = 0;
                } else if(value != 0 && value < Field.WALL_CELL) {
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
                }
            }
        }
    }

    private void moveUp(Field field) {
        for(int i = 0; i < field.getSizeField(); i++) {
            int wallY = -1;
            int numberChanges = 0;
            for(int j = 0; j < field.getSizeField(); j++) {
                int value = field.getField()[j][i];
                if(value == Field.WALL_CELL) {
                    wallY = j;
                    numberChanges = 0;
                } else if(value != 0 && value < Field.WALL_CELL) {
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

                }
            }
        }
    }

    private void moveDown(Field field) {
        for(int i = 0; i < field.getSizeField(); i++) {
            int wallY = field.getSizeField();
            int numberChanges = 0;
            for(int j = field.getSizeField() - 1; j >= 0; j--) {
                int value = field.getField()[j][i];
                if(value == Field.WALL_CELL) {
                    wallY = j;
                    numberChanges = 0;
                } else if(value != 0 && value < Field.WALL_CELL) {
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
                }
            }
        }
    }
}
