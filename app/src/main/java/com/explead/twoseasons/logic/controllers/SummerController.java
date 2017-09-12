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
        void onDeleteLastFromPath();
        void onDeleteAllPath();
        void onAddingPathOnField();
    }

    private boolean action = false;
    private FieldSummer field;

    private OnControllerListener onControllerListener;

    private ArrayList<Cell> path;

    private int readyIds = 0;
    private int numberIds;

    public SummerController(int level) {
        this.level = level;
        LevelContainer container = App.getSummerLevels().get(level-1);
        field = new FieldSummer(container.getCopyField(), container.getCopyCells());
        numberIds = container.getCells().size();
    }

    /**
     * Начинаем путь при прикосновении
     */
    public void startPath(int x, int y) {
        action = true;
        path = new ArrayList<>();
        Cell cell = field.getWorkingField()[y][x].getCopy();
        path.add(cell);
    }

    /**
     * Удаляем весь путь
     */
    public void endPath() {
        if(path != null) {
            path.clear();
            onControllerListener.onDeleteAllPath();
        }
        action = false;
    }

    /**
     * Проверка, достигли ли конечной точки
     */
    private void checkEndPath() {
        Cell last = path.get(path.size()-1);
        Cell pair = field.findCellFromPair(path.get(0));
        if(isNearCells(last, pair)) {
            if(!last.equals(pair)) {
                path.add(pair);
            }

            action = false;
            field.addingPathOnField(path);
            onControllerListener.onAddingPathOnField();
            readyIds++;

            checkWin();
        }
    }

    /**
     * Проверка, находятся ли летки рядом
     */
    private boolean isNearCells(Cell oneCell, Cell twoCell) {
        return ((Math.abs(oneCell.getX() - twoCell.getX()) == 1 && (Math.abs(oneCell.getY() - twoCell.getY()) == 0)) ||
                (Math.abs(oneCell.getY() - twoCell.getY()) == 1 && (Math.abs(oneCell.getX() - twoCell.getX()) == 0)));
    }

    /**
     * Главный алгоритм добавления, удаления и проверок
     */
    public void addingCell(int x, int y) {
        if(action) {
            removeFromPath(x, y);
            if (field.getWorkingField()[y][x] instanceof EmptyCell) {
                Cell lastCell = path.get(path.size() - 1);
                Cell cell = field.getWorkingField()[y][x];
                if (isNearCells(lastCell, cell)) {
                    addOnPath(x, y, lastCell);
                }
            }
            checkEndPath();
        }
    }

    /**
     * Удаляем клетку, если пошли назад
     */
    private void removeFromPath(int x, int y) {
        int size = howCellRemove(x, y);
        for(int i = 0; i < size; i++) {
            path.remove(path.size()-1);
            onControllerListener.onDeleteLastFromPath();
        }
    }

    /**
     * Сколько удалить клеток, до той на которой палец
     */
    private int howCellRemove(int x, int y) {
        int value = 0;
        for(int i = 0; i < path.size(); i++) {
            Cell cell = path.get(i);
            if(cell.getX() == x && cell.getY() == y) {
                value = path.size() - i - 1;
            }
        }
        return value;
    }

    /**
     * Добавить клетку
     */
    private void addOnPath(int x, int y, Cell lastCell) {
        BetweenCell betweenCell = new BetweenCell(x, y);
        betweenCell.setId(lastCell.getId());
        path.add(betweenCell);

        onControllerListener.onAddCellOnPath(betweenCell);
    }

    private void checkWin() {
        if(numberIds == readyIds) {
            onGameListener.onWin();
        }
    }

    public void setOnControllerListener(OnControllerListener onControllerListener) {
        this.onControllerListener = onControllerListener;
    }

    public FieldSummer getField() {
        return field;
    }
}
