package com.explead.seasons.winter.interfaces;

import com.explead.seasons.winter.logic.WinterCube;

public interface OnActionMoveCubeListener {
    void onNotMove();
    void onGoOnCell();
    void onArrow();
    void onCubeOnPlace(WinterCube cube);
}
