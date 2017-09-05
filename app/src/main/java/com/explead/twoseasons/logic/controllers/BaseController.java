package com.explead.twoseasons.logic.controllers;

import com.explead.twoseasons.beans.LevelContainer;
import com.explead.twoseasons.logic.elements.ContainerCells;
import com.explead.twoseasons.logic.elements.EndCell;
import com.explead.twoseasons.logic.elements.winter_elements.FieldWinter;
import com.explead.twoseasons.logic.elements.StartCell;

import java.util.ArrayList;

/**
 * Created by Александр on 09.07.2017.
 */

public class BaseController {

    public interface OnGameListener {
        void onWin();
    }

    protected  int level;

    protected OnGameListener onGameListener;

    public void setOnGameListener(OnGameListener onGameListener) {
        this.onGameListener = onGameListener;
    }

    public int getLevel() {
        return level;
    }
}
