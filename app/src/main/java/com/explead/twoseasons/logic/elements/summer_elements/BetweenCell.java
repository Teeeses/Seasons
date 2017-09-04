package com.explead.twoseasons.logic.elements.summer_elements;

import com.explead.twoseasons.logic.elements.Cell;

/**
 * Created by develop on 04.09.2017.
 */

public class BetweenCell extends Cell {

    private int id;

    public BetweenCell(int x, int y) {
        super(x, y);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
