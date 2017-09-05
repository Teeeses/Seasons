package com.explead.twoseasons.logic.controllers;

import com.explead.twoseasons.app.App;
import com.explead.twoseasons.beans.LevelContainer;
import com.explead.twoseasons.logic.elements.Cell;
import com.explead.twoseasons.logic.elements.EmptyCell;
import com.explead.twoseasons.logic.elements.summer_elements.BetweenCell;
import com.explead.twoseasons.logic.elements.summer_elements.FieldSummer;

import java.util.ArrayList;

/**
 * Created by Александр on 09.07.2017.
 */

public class SummerController extends BaseController {

    public interface OnControllerListener {
        void onAddCellOnPath(Cell cell);
    }

    private FieldSummer field;

    private OnControllerListener onControllerListener;

    private ArrayList<Cell> path;

    public SummerController(int level) {
        this.level = level;
        LevelContainer container = App.getSummerLevels().get(level-1);
        field = new FieldSummer(container.getField(), container.getCells());
    }

    public void startPath(int x, int y) {
        path = new ArrayList<>();
        path.add(field.getWorkingField()[x][y].getCopy());
    }

    public void addingCell(int x, int y) {
        if(field.getWorkingField()[x][y] instanceof EmptyCell) {
            Cell lastCell = path.get(path.size() - 1);
            if (x == lastCell.getX()) {
                int difference = Math.abs(y - lastCell.getY());
                if (difference == 1) {
                    addOnPath(x, y, lastCell);
                }
            } else if (y == lastCell.getY()) {
                int difference = Math.abs(x - lastCell.getX());
                if (difference == 1) {
                    addOnPath(x, y, lastCell);
                }
            }
        }
    }

    private void addOnPath(int x, int y, Cell lastCell) {
            BetweenCell betweenCell = new BetweenCell(x, y);
            betweenCell.setId(lastCell.getId());
            path.add(betweenCell);

            onControllerListener.onAddCellOnPath(betweenCell);
    }

    public void setOnControllerListener(OnControllerListener onControllerListener) {
        this.onControllerListener = onControllerListener;
    }

    public FieldSummer getField() {
        return field;
    }
}
