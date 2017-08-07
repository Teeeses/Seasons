package com.explead.twoseasons.beans;

import android.content.Context;

import com.explead.twoseasons.ui.levels_ui.LevelsActivity;
import com.explead.twoseasons.utils.Utils;

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
            int easy_current_level = ((LevelsActivity)context).getPref().getInt(Utils.SUMMER_CURRENT_LEVEL, 1);
            installStatus(easy_current_level);
        }
        if(mode == Level.WINTER) {
            int medium_current_level = ((LevelsActivity)context).getPref().getInt(Utils.WINTER_CURRENT_LEVEL, 1);
            installStatus(medium_current_level);
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