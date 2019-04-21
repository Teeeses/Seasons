package com.explead.seasons.common.utils;

import android.content.res.AssetManager;
import android.graphics.Typeface;

/**
 * Created by Александр on 09.07.2017.
 */

public class Utils {

    public final static String SUMMER_CURRENT_LEVEL = "summer_current_level";

    public final static String DECEMBER_EASY = "december_easy";
    public final static String DECEMBER_HARD = "december_hard";
    public final static String JANUARY_EASY = "january_easy";
    public final static String JANUARY_HARD = "january_hard";

    public static final String APP_PREFERENCES = "mysettings";

    public static Typeface getTypeFaceLevel(AssetManager manager) {
        return Typeface.createFromAsset(manager,"fonts/level_personal.ttf");
    }

    public static Typeface getTypeGecko(AssetManager manager) {
        return Typeface.createFromAsset(manager,"fonts/gecko.ttf");
    }

}
