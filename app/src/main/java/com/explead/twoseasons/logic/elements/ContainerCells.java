package com.explead.twoseasons.logic.elements;

/**
 * Created by Александр on 09.07.2017.
 */

public class ContainerCells {

    private StartCell startCell;
    private EndCell endCell;

    public ContainerCells(StartCell startCell, EndCell endCell) {
        this.startCell = startCell;
        this.endCell = endCell;
    }

    public void setStartCell(StartCell startCell) {
        this.startCell = startCell;
    }

    public void setEndCell(EndCell endCell) {
        this.endCell = endCell;
    }

    public StartCell getStartCell() {
        return startCell;
    }

    public EndCell getEndCell() {
        return endCell;
    }
}
