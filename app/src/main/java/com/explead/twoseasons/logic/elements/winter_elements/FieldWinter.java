package com.explead.twoseasons.logic.elements.winter_elements;

import com.explead.twoseasons.logic.elements.Cell;
import com.explead.twoseasons.logic.elements.ContainerCells;
import com.explead.twoseasons.logic.elements.EmptyCell;
import com.explead.twoseasons.logic.elements.WallCell;

import java.util.ArrayList;

/**
 * Created by Александр on 09.07.2017.
 */

public class FieldWinter {

    public static final int EMPTY_CELL = 0, WALL_CELL = 6;

    private int[][] field;
    private ArrayList<ContainerCells> actionCells;
    private ArrayList<EmptyCell> emptyCells = new ArrayList<>();
    private ArrayList<WallCell> wallCells = new ArrayList<>();

    public FieldWinter(int[][] field, ArrayList<ContainerCells> actionCells) {
        this.field = field;
        this.actionCells = actionCells;
        findCells();
        setIds(this.actionCells);
        addActionCellsOnField(this.actionCells);
    }

    private void setIds(ArrayList<ContainerCells> actionCells) {
        for(int i = 0; i < actionCells.size(); i++) {
            actionCells.get(i).getStartCell().setId(i);
            actionCells.get(i).getEndCell().setId(i);
        }
    }

    /**
     * Добавляем стартовые клетки на поле
     * Прибавляем +1 для того, что бы отличить пустые клетки от активной клетки с индексом 0
     */
    public void addActionCellsOnField(ArrayList<ContainerCells> actionCells) {
        for (int i = 0; i < actionCells.size(); i++) {
            int id = actionCells.get(i).getStartCell().getId();
            Cell cell = actionCells.get(i).getStartCell();
            field[cell.getY()][cell.getX()] = id + 1;
        }
    }

    public void findCells() {
        for(int i = 0; i < field.length; i++) {
            for(int j = 0; j < field.length; j++) {
                if(field[i][j] == WALL_CELL) {
                    wallCells.add(new WallCell(j, i));
                }
                if(field[i][j] != WALL_CELL) {
                    emptyCells.add(new EmptyCell(j, i));
                }
            }
        }
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

}
