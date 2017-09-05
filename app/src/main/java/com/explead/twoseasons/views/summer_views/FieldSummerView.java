package com.explead.twoseasons.views.summer_views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.explead.twoseasons.logic.elements.Cell;
import com.explead.twoseasons.logic.elements.EmptyCell;
import com.explead.twoseasons.logic.elements.EndCell;
import com.explead.twoseasons.logic.elements.StartCell;
import com.explead.twoseasons.logic.elements.summer_elements.FieldSummer;
import com.explead.twoseasons.logic.elements.WallCell;

import java.util.ArrayList;

/**
 * Created by Александр on 09.07.2017.
 */

public class FieldSummerView extends RelativeLayout {

    public interface OnActionField {
        void onUpPath(int x, int y);
        void onMove(int x, int y);
        void onStartPath(int x, int y);
    }

    private CellSummerView[][] cellSummerViews;

    private ArrayList<CellSummerView> addingCells = new ArrayList<>();

    private OnActionField onActionField;
    private Context context;

    private float size;
    private float sizeCell;
    private FieldSummer field;

    public FieldSummerView(Context context) {
        super(context);
        init(context);
    }

    public FieldSummerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FieldSummerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
    }

    public void setOnTouch() {
        this.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        final int x = (int) (event.getX() / (size/field.getSizeField()));
                        final int y = (int) (event.getY() / (size/field.getSizeField()));
                        if(findCellView(x, y)) {
                            onActionField.onStartPath(x, y);
                        }
                        break;
                    }
                    case MotionEvent.ACTION_MOVE: {
                        final int x = (int) (event.getX() / (size/field.getSizeField()));
                        final int y = (int) (event.getY() / (size/field.getSizeField()));
                        onActionField.onMove(x, y);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        final int x = (int) (event.getX() / (size/field.getSizeField()));
                        final int y = (int) (event.getY() / (size/field.getSizeField()));
                        onActionField.onUpPath(x, y);
                        break;
                    }
                    default:
                        break;
                }
                return true;
            }
        });
    }

    public void setOnActionField(OnActionField onActionField) {
        this.onActionField = onActionField;
    }

    /**
     * Создаем поле игры
     * @param size - размер поля
     * @param field - данные для построения
     */
    public void createField(float size, FieldSummer field) {
        this.size = size;
        this.field = field;

        cellSummerViews = new CellSummerView[field.getSizeField()][field.getSizeField()];

        RelativeLayout.LayoutParams params = new LayoutParams((int)size, (int)size);
        params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        this.setLayoutParams(params);

        sizeCell = size/field.getSizeField();

        Cell[][] workingField = field.getWorkingField();

        for(int i = 0; i < field.getSizeField(); i++) {
            for(int j = 0; j < field.getSizeField(); j++) {
                if(workingField[i][j] instanceof WallCell) {
                    CellWallSummerView cell = new CellWallSummerView(context);
                    cell.setDate(sizeCell, workingField[i][j]);
                    cellSummerViews[i][j] = cell;
                    this.addView(cell);
                } else if(workingField[i][j] instanceof EmptyCell) {
                    CellEmptySummerView cell = new CellEmptySummerView(context);
                    cell.setDate(sizeCell, workingField[i][j]);
                    cellSummerViews[i][j] = cell;
                    this.addView(cell);
                } else if(workingField[i][j] instanceof EndCell) {
                    CellEndSummerView cell = new CellEndSummerView(context, workingField[i][j].getId());
                    cell.setDate(sizeCell, workingField[i][j]);
                    cellSummerViews[i][j] = cell;
                    this.addView(cell);
                } else if(workingField[i][j] instanceof StartCell) {
                    CellStartSummerView cell = new CellStartSummerView(context, workingField[i][j].getId());
                    cell.setDate(sizeCell, workingField[i][j]);
                    cellSummerViews[i][j] = cell;
                    this.addView(cell);
                }
            }
        }
    }

    public void onAddCellOnPath(Cell cell) {
        CellBetweenSummerView betweenSummerView = new CellBetweenSummerView(context, cell.getId());
        betweenSummerView.setDate(sizeCell, cell);
        addingCells.add(betweenSummerView);
        this.addView(betweenSummerView);
    }


    private boolean findCellView(int x, int y) {
        if(cellSummerViews[x][y] instanceof CellStartSummerView || cellSummerViews[x][y] instanceof CellEndSummerView) {
            return true;
        }
        return false;
    }

}
