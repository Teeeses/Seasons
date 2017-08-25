package com.explead.twoseasons.utils;

import android.util.Log;
import android.widget.Toast;

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

    private static int LEFT = 0, UP = 1, RIGHT = 2, DOWN = 3;

    public static LevelContainer generate(int size) {
        LevelContainer container = createField(size);

        int[][] mass = container.getField();
        StartCell a = container.getCells().get(0).getStartCell();
        StartCell b = container.getCells().get(1).getStartCell();
        mass[a.getX()][a.getY()] = 1;
        mass[b.getX()][b.getY()] = 2;
        EndCell aa = container.getCells().get(0).getEndCell();
        EndCell bb = container.getCells().get(1).getEndCell();

        writeField(mass);

        checkV(mass, aa, bb, DOWN, 0);

        return createField(size);
    }

    private static  LevelContainer createField(int size) {
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

        mass[a][b] = 0;
        mass[c][d] = 0;

        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(a, b), new EndCell(c, d)));
        containerCells.add(new ContainerCells(new StartCell(c, d), new EndCell(a, b)));

        return new LevelContainer(mass, containerCells);
    }



    private static int random(int a, int b) {
        return a + (int) (Math.random() * b);
    }

    private static int randomWallOrEmpty() {
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
        System.out.println("x: " + container.get(0).getStartCell().getX() + " y: " + container.get(0).getEndCell().getY());
        System.out.println("x: " + container.get(1).getStartCell().getX() + " y: " + container.get(1).getEndCell().getY());
        System.out.println();
    }

    public static void writeField(int[][] mass) {
        for(int i = 0; i < mass.length; i++) {
            for(int j = 0; j < mass.length; j++) {
                System.out.print(mass[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void checkV(int[][] mass, EndCell a, EndCell b, int direction, int number) {
        number++;
        if(checkWin(mass, a, b) || number == 20) {
            System.out.println("КОНЕЦ");
            return;
        }
        //if(direction == UP) {
            moveDown(mass, a, b);
            checkG(mass, a, b, direction, number);

            moveUp(mass, a, b);
            checkG(mass, a, b, direction, number);
        /*} else if(direction == DOWN) {
            moveUp(mass, a, b);
            checkG(mass, a, b, direction, number);

            moveDown(mass, a, b);
            checkG(mass, a, b, direction, number);
        }*/
    }

    public static void checkG(int[][] mass, EndCell a, EndCell b, int direction, int number) {
        number++;
        if(checkWin(mass, a, b) || number == 20) {
            System.out.println("КОНЕЦ");
            return;
        }
        //if(direction == LEFT) {
            moveRight(mass, a, b);
            checkV(mass, a, b, direction, number);

            moveLeft(mass, a, b);
            checkV(mass, a, b, direction, number);
        /*} else if(direction == RIGHT) {
            moveLeft(mass, a, b);
            checkV(mass, a, b, direction, number);

            moveRight(mass, a, b);
            checkV(mass, a, b, direction, number);
        }*/
    }

    private static void moveRight(int[][] mass, EndCell a, EndCell b) {
        for(int i = 0; i < mass.length; i++) {
            int wallY = mass.length;
            int numberChanges = 0;
            for(int j = mass.length-1; j >= 0; j--) {
                int value = mass[i][j];
                if(value == Field.WALL_CELL) {
                    wallY = j;
                    numberChanges = 0;
                } else if(value != 0 && value < Field.WALL_CELL) {
                    int newCoordinate = wallY - 1 - numberChanges;

                    if(newCoordinate < 0)
                        newCoordinate = 0;
                    mass[i][j] = 0;
                    mass[i][newCoordinate] = value;

                }
            }
        }
        checkWin(mass, a, b);
    }

    private static void moveLeft(int[][] mass, EndCell a, EndCell b) {
        for(int i = 0; i < mass.length; i++) {
            int wallY = -1;
            int numberChanges = 0;
            for(int j = 0; j < mass.length; j++) {
                int value = mass[i][j];
                if(value == Field.WALL_CELL) {
                    wallY = j;
                    numberChanges = 0;
                } else if(value != 0 && value < Field.WALL_CELL) {
                    int newCoordinate = wallY + 1 + numberChanges;

                    if(newCoordinate > mass.length-1)
                        newCoordinate = mass.length - 1;
                    mass[i][j] = 0;
                    mass[i][newCoordinate] = value;

                    numberChanges++;
                }
            }
        }
        checkWin(mass, a, b);
    }

    private static void moveUp(int[][] mass, EndCell a, EndCell b) {
        for(int i = 0; i < mass.length; i++) {
            int wallY = -1;
            int numberChanges = 0;
            for(int j = 0; j < mass.length; j++) {
                int value = mass[j][i];
                if(value == Field.WALL_CELL) {
                    wallY = j;
                    numberChanges = 0;
                } else if(value != 0 && value < Field.WALL_CELL) {
                    int newCoordinate = wallY + 1 + numberChanges;

                    if(newCoordinate > mass.length-1)
                        newCoordinate = mass.length-1;
                    mass[j][i] = 0;
                    mass[newCoordinate][i] = value;

                    numberChanges++;

                }
            }
        }
        checkWin(mass, a, b);
    }

    private static void moveDown(int[][] mass, EndCell a, EndCell b) {
        for(int i = 0; i < mass.length; i++) {
            int wallY = mass.length;
            int numberChanges = 0;
            for(int j = mass.length - 1; j >= 0; j--) {
                int value = mass[j][i];
                if(value == Field.WALL_CELL) {
                    wallY = j;
                    numberChanges = 0;
                } else if(value != 0 && value < Field.WALL_CELL) {
                    int newCoordinate = wallY - 1 - numberChanges;

                    if(newCoordinate < 0)
                        newCoordinate = 0;
                    mass[j][i] = 0;
                    mass[newCoordinate][i] = value;

                    numberChanges++;
                }
            }
        }

        checkWin(mass, a, b);
    }

    private static boolean checkWin(int[][] mass, EndCell a, EndCell b) {
        boolean win = false;
        if(mass[a.getX()][a.getY()] == 1 && mass[b.getX()][b.getY()] == 2) {
            System.out.println("AAAAAAAAAAAAAA WIN");
            win = true;
        }

        return win;
    }
}
