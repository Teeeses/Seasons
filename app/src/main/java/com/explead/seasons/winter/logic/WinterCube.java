package com.explead.seasons.winter.logic;

import com.explead.seasons.common.logic.ColorMember;
import com.explead.seasons.common.logic.Direction;
import com.explead.seasons.winter.interfaces.OnMoveCubeCallback;
import com.explead.seasons.winter.interfaces.OnMoveCubeListener;

public class WinterCube extends Cell {

    private OnMoveCubeListener onMoveListener;
    private WinterInsideCube insideCube;

    private Direction direction;
    private Direction lastDirection;
    private int lastX, lastY;

    //Есть ли движение
    private boolean MOVE = false;
    private OnMoveCubeCallback onMoveCubeCallback;

    public WinterCube(int x, int y) {
        super(x, y);
    }

    public WinterCube(WinterCube cube) {
        super(cube.getX(), cube.getY());
        this.color = cube.getColor();
    }

    public void create(ColorMember color, WinterInsideCube insideCube) {
        this.color = color;
        this.insideCube = insideCube;
    }

    public WinterInsideCube getInsideCube() {
        return insideCube;
    }

    public void move() {
        if(lastDirection == Direction.U) {
            if(lastX != x)
                onMoveListener.onUp(lastX, x);
        } else if(lastDirection == Direction.R) {
            if(lastY != y)
                onMoveListener.onRight(lastY, y);
        } else if(lastDirection == Direction.D) {
            if(lastX != x)
                onMoveListener.onDown(lastX, x);
        } else if(lastDirection == Direction.L) {
            if(lastY != y)
                onMoveListener.onLeft(lastY, y);
        }
    }

    public boolean isTruePlace() {
        return x == insideCube.getX() && y == insideCube.getY();
    }

    public boolean isCoordinate(int x, int y) {
        return this.x == x && this.y == y;
    }

    public void setOnMoveListener(OnMoveCubeListener onMoveListener) {
        this.onMoveListener = onMoveListener;
    }

    public void setLastCoordinate() {
        lastX = x;
        lastY = y;
    }

    public void setCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void onFirstMove() {
        onMoveCubeCallback.onFirstMove();
    }

    public void setOnMoveCubeCallback(OnMoveCubeCallback onMoveCubeCallback) {
        this.onMoveCubeCallback = onMoveCubeCallback;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setLastDirection() {
        this.lastDirection = direction;
    }

    public void setMOVE(boolean MOVE) {
        this.MOVE = MOVE;
    }

    public boolean getMOVE() {
        return MOVE;
    }
}
