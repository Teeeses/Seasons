package com.explead.twoseasons.logic.controllers;

import com.explead.twoseasons.beans.LevelContainer;
import com.explead.twoseasons.logic.elements.Cell;
import com.explead.twoseasons.logic.elements.ContainerCells;
import com.explead.twoseasons.logic.elements.Field;

import java.util.ArrayList;

/**
 * Created by Александр on 09.07.2017.
 */

public class SummerController extends Modes {

    public interface OnControllerListener {
        void onChangePath(ArrayList<ArrayList<Cell>> result);
    }

    private boolean action = false;

    private OnControllerListener onControllerListener;

    private ArrayList<ArrayList<Cell>> paths = new ArrayList<>();

    public SummerController(int level) {
        level = 1;
        LevelContainer container = getSummerLevel(level);
        field = new Field(container.getField(), container.getCells());
        createPaths();
    }

    private void createPaths() {
        for(int i = 0; i < field.getSizeField(); i++) {
            paths.add(new ArrayList<Cell>());
        }
    }

    public void setOnControllerListener(OnControllerListener onControllerListener) {
        this.onControllerListener = onControllerListener;
    }

    public void up(int x, int y) {
        action = false;
    }

    public void move(int x, int y) {
        if(action) {

        }
    }

    public void down(int x, int y) {
        Cell obj = new Cell(x, y);
        ArrayList<ContainerCells> actionCells = field.getActionCells();
        for(int i = 0; i < actionCells.size(); i++) {
            Cell startCell = actionCells.get(i).getStartCell();
            Cell endCell = actionCells.get(i).getEndCell();
            int id = actionCells.get(i).getId();
            if(startCell.equals(obj) || endCell.equals(obj)) {
                action = true;
                paths.get(id).add(startCell);
                onControllerListener.onChangePath(paths);
            }
        }
    }
}
