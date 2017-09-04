package com.explead.twoseasons.logic.elements.summer_elements;

import com.explead.twoseasons.logic.elements.Cell;
import com.explead.twoseasons.logic.elements.ContainerCells;
import com.explead.twoseasons.logic.elements.EmptyCell;
import com.explead.twoseasons.logic.elements.EndCell;
import com.explead.twoseasons.logic.elements.StartCell;
import com.explead.twoseasons.logic.elements.WallCell;

import java.util.ArrayList;

/**
 * Created by develop on 04.09.2017.
 */

public class FieldSummer {

    public static final int EMPTY_CELL = 0, WALL_CELL = 6;

    private int[][] field;
    private Cell[][] workingField;

    public FieldSummer(int[][] field, ArrayList<ContainerCells> actionCells) {
        this.field = field;
        setIds(actionCells);
        createWorkingField(actionCells);
    }

    private void createWorkingField(ArrayList<ContainerCells> actionCells) {
        workingField = new Cell[field.length][field.length];
        for(int i = 0; i < field.length; i++) {
            for(int j = 0; j < field.length; j++) {
                if(field[i][j] == WALL_CELL) {
                    WallCell cell = new WallCell(j, i);
                    workingField[i][j] = cell;
                }
                if(field[i][j] != WALL_CELL) {
                    EmptyCell cell = new EmptyCell(j, i);
                    workingField[i][j] = cell;
                }
            }
        }
        addActionCellsOnField(actionCells);
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
    private void addActionCellsOnField(ArrayList<ContainerCells> actionCells) {
        for (int i = 0; i < actionCells.size(); i++) {
            StartCell startCell = actionCells.get(i).getStartCell();
            EndCell endCell = actionCells.get(i).getEndCell();
            workingField[startCell.getY()][startCell.getX()] = startCell;
            workingField[endCell.getY()][endCell.getX()] = endCell;
        }
    }

    public Cell[][] getWorkingField() {
        return workingField;
    }

    public int getSizeField() {
        return field.length;
    }
}
