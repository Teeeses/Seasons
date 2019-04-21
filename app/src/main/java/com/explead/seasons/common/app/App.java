package com.explead.seasons.common.app;

import android.app.Application;

import com.explead.seasons.common.beans.AllLevels;
import com.explead.seasons.common.beans.LevelContainer;
import com.explead.seasons.summer.SummerLevels;

import java.util.ArrayList;

/**
 * Created by Александр on 09.07.2017.
 */

public class App extends Application{

    private static float widthScreen;
    private static float heightScreen;

    private static AllLevels levels;
    private static SaverSpref saverSpref;

    @Override
    public void onCreate() {
        super.onCreate();
        levels = new AllLevels();
        saverSpref = new SaverSpref(this);
    }

    public static SaverSpref getSaverSpref() {
        return saverSpref;
    }

    public static AllLevels getLevels() {
        return levels;
    }

    public static float getWidthScreen() {
        return widthScreen;
    }

    public static void setWidthScreen(float widthScreen) {
        App.widthScreen = widthScreen;
    }

    public static float getHeightScreen() {
        return heightScreen;
    }

    public static void setHeightScreen(float heightScreen) {
        App.heightScreen = heightScreen;
    }
}
