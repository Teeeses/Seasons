package com.explead.seasons.winter.logic;

import com.explead.seasons.common.logic.Direction;

public class WinterArrow extends Cell {

    private int id;
    private Direction direction;

    public WinterArrow(int x, int y, int id) {
        super(x, y);
        this.id = id;
        findDirection();
    }

    public void findDirection() {
        switch (id) {
            case 1:
                direction = Direction.U;
                break;
            case 2:
                direction = Direction.R;
                break;
            case 3:
                direction = Direction.D;
                break;
            case 4:
                direction = Direction.L;
                break;
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public int getId() {
        return id;
    }

    public char gtNameId() {
        return direction.name().charAt(0);
    }
}
