package com.explead.twoseasons.logic.elements;

/**
 * Created by Александр on 09.07.2017.
 */

public class StartCell extends Cell {

    public StartCell(int x, int y) {
        super(y, x);
    }

    @Override
    public StartCell getCopy() {
        StartCell newCell = new StartCell(this.y, this.x);
        newCell.setId(this.id);
        return newCell;
    }
}
