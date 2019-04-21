package com.explead.seasons.common.beans;

/**
 * Created by develop on 30.01.2017.
 */

public class ButtonLevel {

    private int number;

    public static final int STATUS_OPEN = 1, STATUS_CURRENT = 2, STATUS_CLOSE = 3;
    private int status;
    private boolean easyCompleted;
    private boolean hardCompleted;

    public ButtonLevel(int number) {
        this.number = number;
    }

    public void installStatus(int current, boolean easyCompleted, boolean hardCompleted) {
        this.easyCompleted = easyCompleted;
        this.hardCompleted = hardCompleted;
        if(number == current) {
            status = STATUS_CURRENT;
        }
        if(number > current) {
            status = STATUS_CLOSE;
        }
        if(number < current) {
            status = STATUS_OPEN;
        }
    }

    public boolean isEasyCompleted() {
        return easyCompleted;
    }

    public boolean isHardCompleted() {
        return hardCompleted;
    }

    public int getStatus() {
        return status;
    }

    public int getNumber() {
        return number;
    }
}