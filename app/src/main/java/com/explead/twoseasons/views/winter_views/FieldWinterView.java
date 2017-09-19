package com.explead.twoseasons.views.winter_views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.explead.twoseasons.R;
import com.explead.twoseasons.logic.controllers.WinterController;
import com.explead.twoseasons.logic.elements.Cell;
import com.explead.twoseasons.logic.elements.ContainerCells;
import com.explead.twoseasons.logic.elements.EmptyCell;
import com.explead.twoseasons.logic.elements.winter_elements.FieldWinter;
import com.explead.twoseasons.logic.elements.StartCell;
import com.explead.twoseasons.logic.elements.WallCell;

import java.util.ArrayList;

/**
 * Created by Александр on 13.07.2017.
 */

public class FieldWinterView extends RelativeLayout {

    private Context context;

    private ArrayList<CellWinterView> actionViews = new ArrayList<>();

    private float size;
    private FieldWinter field;

    public FieldWinterView(Context context) {
        super(context);
        init(context);
    }

    public FieldWinterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FieldWinterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
    }

    public void onChange(Cell startCell, Cell newCell, String direction, WinterController controller) {
        for (int i = 0; i < actionViews.size(); i++) {
            CellWinterView view = actionViews.get(i);
            if (newCell.equals(view.getCell()) && view.getCell() instanceof StartCell) {
                view.setAnimationFromPointToPoint(startCell, newCell, direction, controller);
                return;
            }
        }
    }

    /**
     * Создаем поле игры
     * @param size  - размер поля
     * @param field - данные для построения
     */
    public void createField(float size, FieldWinter field) {
        this.size = size;
        this.field = field;

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams((int) size, (int) size);
        params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        this.setLayoutParams(params);

        float sizeCell = size / field.getSizeField();

        ArrayList<EmptyCell> emptyCells = field.getEmptyCells();
        for (int i = 0; i < emptyCells.size(); i++) {
            CellEmptyWinterView cellEmpty = new CellEmptyWinterView(context);
            cellEmpty.setDate(sizeCell, emptyCells.get(i));
            cellEmpty.setBackgroundColor(getColorEmptyCell(cellEmpty.getCell().getX(), cellEmpty.getCell().getY()));
            this.addView(cellEmpty);
        }

        ArrayList<WallCell> wallCells = field.getWallCells();
        for (int i = 0; i < wallCells.size(); i++) {
            CellWallWinterView cellWall = new CellWallWinterView(context);
            cellWall.setDate(sizeCell, wallCells.get(i));
            this.addView(cellWall);
        }

        ArrayList<ContainerCells> actionCells = field.getActionCells();
        for (int i = 0; i < actionCells.size(); i++) {
            CellEndWinterView cellEnd = new CellEndWinterView(context);
            cellEnd.setId(actionCells.get(i).getEndCell().getId());
            cellEnd.setDate(sizeCell, actionCells.get(i).getEndCell());
            actionViews.add(cellEnd);
            this.addView(cellEnd);
        }
        for(int i = 0; i < actionCells.size(); i++) {
            CellStartWinterView cellStart = new CellStartWinterView(context);
            cellStart.setId(actionCells.get(i).getStartCell().getId());
            cellStart.setDate(sizeCell, actionCells.get(i).getStartCell());
            actionViews.add(cellStart);
            this.addView(cellStart);
        }
    }

    private int getColorEmptyCell(int x, int y) {
        if((x + y) % 2 == 0) {
            return context.getResources().getColor(R.color.cell_light);
        }
        return context.getResources().getColor(R.color.cell_dark);
    }

    public void clearField() {
        actionViews = new ArrayList<>();
        this.removeAllViews();
    }
}