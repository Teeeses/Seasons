package com.explead.seasons.common.app;

import android.content.Context;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.explead.seasons.common.beans.AllLevels;

/**
 * Created by Александр on 09.07.2017.
 */

public class App extends MultiDexApplication {

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

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
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
