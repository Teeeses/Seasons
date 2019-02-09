package com.explead.seasons.winter.ui.winter_views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.explead.seasons.R;
import com.explead.seasons.common.logic.ContainerCells;
import com.explead.seasons.winter.logic.EmptyCell;
import com.explead.seasons.winter.logic.WallCell;
import com.explead.seasons.winter.logic.WinterCell;
import com.explead.seasons.winter.logic.FieldWinter;
import com.explead.seasons.winter.ui.winter_views.cubes.CubeView;
import com.explead.seasons.winter.ui.winter_views.cubes.InsideCubeView;

import java.util.ArrayList;

/**
 * Created by Александр on 13.07.2017.
 */

public class FieldWinterView extends RelativeLayout {


    private Context context;

    private ArrayList<CubeView> actionViews = new ArrayList<>();

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

    public void startAnimation(WinterCell cell, WinterCell newCell, String direction) {
        for (int i = 0; i < actionViews.size(); i++) {
            CubeView view = actionViews.get(i);
            if (cell.equals(view.getCell())) {
                actionViews.get(i).getCell().setX(newCell.getX());
                actionViews.get(i).getCell().setY(newCell.getY());
                view.setAnimationFromPointToPoint(cell, newCell, direction);
                return;
            }
        }
    }

    /**
     * Создаем поле игры
     * @param size  - размер поля
     */
    public void createField(float size) {
        this.size = size;

        LayoutParams params = new LayoutParams((int) size, (int) size);
        params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        this.setLayoutParams(params);

        float sizeCell = size / field.getSizeField();

        ArrayList<EmptyCell> emptyCells = field.getEmptyCells();
        for (int i = 0; i < emptyCells.size(); i++) {
            EmptyCellView emptyCellView = new EmptyCellView(context);
            emptyCellView.setDate(sizeCell, emptyCells.get(i));
            emptyCellView.setBackgroundColor(getColorEmptyCell(emptyCellView.getCell().getX(), emptyCellView.getCell().getY()));
            this.addView(emptyCellView);
        }

        ArrayList<WallCell> wallCells = field.getWallCells();
        for (int i = 0; i < wallCells.size(); i++) {
            WallCellView wallCellView = new WallCellView(context);
            wallCellView.setDate(sizeCell, wallCells.get(i));
            this.addView(wallCellView);
        }

        ArrayList<ContainerCells> actionCells = field.getActionCells();
        for (int i = 0; i < actionCells.size(); i++) {
            ContainerCells container = actionCells.get(i);
            CubeView cubeView = new CubeView(context);
            cubeView.create(container.getColor());
            cubeView.setDate(sizeCell, (WinterCell) container.getOneCell());
            cubeView.setInsideCell((WinterCell) container.getTwoCell());

            InsideCubeView insideCubeView = new InsideCubeView(context);
            insideCubeView.create(container.getColor());
            insideCubeView.setDate(sizeCell, (WinterCell) actionCells.get(i).getTwoCell());

            this.addView(cubeView);
            this.addView(insideCubeView);

            actionViews.add(cubeView);
        }
    }

    private int getColorEmptyCell(int x, int y) {
        if((x + y) % 2 == 0) {
            return context.getResources().getColor(R.color.cell_light);
        }
        return context.getResources().getColor(R.color.cell_dark);
    }

    public boolean checkWin() {
        for(int i = 0; i < actionViews.size(); i++) {
            if(!(actionViews.get(i).getCell().equals(actionViews.get(i).getInsideCell()))) {
                return false;
            }
        }
        return true;
    }

    public void clearField() {
        actionViews = new ArrayList<>();
        this.removeAllViews();
    }

    public FieldWinter getController() {
        return field;
    }

    public void setController(int level) {
        field = new FieldWinter(level);
    }
}