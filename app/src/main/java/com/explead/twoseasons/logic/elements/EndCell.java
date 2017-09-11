package com.explead.twoseasons.logic.elements;

/**
 * Created by Александр on 09.07.2017.
 */

public class EndCell extends Cell {

    public EndCell(int x, int y) {
        super(y, x);
    }

    @Override
    public EndCell getCopy() {
        EndCell newCell = new EndCell(this.y, this.x);
        newCell.setId(this.id);
        return newCell;
    }
}
