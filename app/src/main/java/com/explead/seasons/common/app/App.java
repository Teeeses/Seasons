package com.explead.seasons.common.app;

import android.app.Application;

import com.explead.seasons.common.beans.LevelContainer;
import com.explead.seasons.summer.SummerLevels;
import com.explead.seasons.winter.WinterLevels;

import java.util.ArrayList;

/**
 * Created by Александр on 09.07.2017.
 */

public class App extends Application{

    private static float widthScreen;
    private static float heightScreen;

    private static ArrayList<LevelContainer> winterLevels;
    private static ArrayList<LevelContainer> summerLevels;

    @Override
    public void onCreate() {
        super.onCreate();
        winterLevels = new WinterLevels().getLevels();
        summerLevels = new SummerLevels().getLevels();
    }

    public static ArrayList<LevelContainer> getWinterLevels() {
        return winterLevels;
    }

    public static ArrayList<LevelContainer> getSummerLevels() {
        return summerLevels;
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
