package com.explead.seasons.common.beans;

import android.content.Context;

import com.explead.seasons.common.app.App;
import com.explead.seasons.common.utils.Utils;
import  com.explead.seasons.common.ui.LevelsActivity;

/**
 * Created by develop on 30.01.2017.
 */

public class ButtonLevel {

    private Context context;
    private int number;
    private int mode;

    public static final int STATUS_OPEN = 1, STATUS_CURRENT = 2, STATUS_CLOSE = 3;
    private int status;

    public ButtonLevel(Context context, int mode, int number) {
        this.context = context;
        this.mode = mode;
        this.number = number;
        findStatus();
    }

    public void findStatus() {
        if(mode == Level.SUMMER) {
            int summer_current_level = ((LevelsActivity)context).getPref().getInt(Utils.SUMMER_CURRENT_LEVEL, 1);
            summer_current_level = App.getWinterLevels().size();
            installStatus(summer_current_level);
        }
        if(mode == Level.WINTER) {
            //int winter_current_level = ((LevelsActivity)context).getPref().getInt(Utils.WINTER_CURRENT_LEVEL, 1);
            int winter_current_level = App.getWinterLevels().size();
            installStatus(winter_current_level);
        }
    }

    private void installStatus(int current) {
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

    public int getMode() {
        return mode;
    }
}