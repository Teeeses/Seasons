package com.explead.twoseasons.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.explead.twoseasons.logic.elements.Cell;
import com.explead.twoseasons.logic.elements.ContainerCells;
import com.explead.twoseasons.logic.elements.EmptyCell;
import com.explead.twoseasons.logic.elements.Field;
import com.explead.twoseasons.logic.elements.StartCell;
import com.explead.twoseasons.logic.elements.WallCell;

import java.util.ArrayList;

/**
 * Created by Александр on 13.07.2017.
 */

public class WinterFieldView extends RelativeLayout {

    private Context context;

    private ArrayList<CellView> actionViews = new ArrayList<>();

    private float size;
    private Field field;

    public WinterFieldView(Context context) {
        super(context);
        init(context);
    }

    public WinterFieldView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public WinterFieldView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
    }

    public void onChange(Cell startCell, Cell newCell, String direction) {
        for (int i = 0; i < actionViews.size(); i++) {
            CellView view = actionViews.get(i);
            if (newCell.equals(view.getCell()) && view.getCell() instanceof StartCell) {
                view.setAnimationFromPointToPoint(startCell, newCell, direction);
                return;
            }
        }
    }

    /**
     * Создаем поле игры
     * @param size  - размер поля
     * @param field - данные для построения
     */
    public void createField(float size, Field field) {
        this.size = size;
        this.field = field;

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams((int) size, (int) size);
        params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        this.setLayoutParams(params);

        float sizeCell = size / field.getSizeField();

        ArrayList<EmptyCell> emptyCells = field.getEmptyCells();
        for (int i = 0; i < emptyCells.size(); i++) {
            CellEmptyView cellEmpty = new CellEmptyView(context);
            cellEmpty.setDate(sizeCell, emptyCells.get(i));
            cellEmpty.setAlpha(0.6f);
            this.addView(cellEmpty);
        }

        ArrayList<WallCell> wallCells = field.getWallCells();
        for (int i = 0; i < wallCells.size(); i++) {
            CellWallView cellWall = new CellWallView(context);
            cellWall.setDate(sizeCell, wallCells.get(i));
            this.addView(cellWall);
        }

        ArrayList<ContainerCells> actionCells = field.getActionCells();
        for (int i = 0; i < actionCells.size(); i++) {
            CellEndView cellEnd = new CellEndView(context);
            cellEnd.setId(actionCells.get(i).getId());
            cellEnd.setDate(sizeCell, actionCells.get(i).getEndCell());
            actionViews.add(cellEnd);
            this.addView(cellEnd);
        }
        for(int i = 0; i < actionCells.size(); i++) {
            CellStartView cellStart = new CellStartView(context);
            cellStart.setId(actionCells.get(i).getId());
            cellStart.setDate(sizeCell, actionCells.get(i).getStartCell());
            actionViews.add(cellStart);
            this.addView(cellStart);
        }
    }

    public void clearField() {
        actionViews = new ArrayList<>();
        this.removeAllViews();
    }
}