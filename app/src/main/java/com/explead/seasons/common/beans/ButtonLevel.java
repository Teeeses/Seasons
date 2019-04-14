package com.explead.seasons.common.beans;

import android.content.Context;

import com.explead.seasons.common.app.App;
import com.explead.seasons.common.utils.Utils;
import  com.explead.seasons.common.ui.LevelsActivity;

/**
 * Created by develop on 30.01.2017.
 */

public class ButtonLevel {

    private int number;

    public static final int STATUS_OPEN = 1, STATUS_CURRENT = 2, STATUS_CLOSE = 3;
    private int status;

    public ButtonLevel(int number) {
        this.number = number;
    }

    public void installStatus(int current) {
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

    public int getStatus() {
        return status;
    }

    public int getNumber() {
        return number;
    }
}