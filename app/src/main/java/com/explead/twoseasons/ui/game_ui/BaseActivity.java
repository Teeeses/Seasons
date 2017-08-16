package com.explead.twoseasons.ui.game_ui;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import com.explead.twoseasons.utils.Utils;

/**
 * Created by develop on 16.08.2017.
 */

public class BaseActivity extends AppCompatActivity {

    protected SharedPreferences sPref;

    public void setCurrentWinterLevel(int currentLevel) {
        System.out.println("Сохранение нового текущего уровня");
        SharedPreferences.Editor editor = sPref.edit();
        if(currentLevel == sPref.getInt(Utils.WINTER_CURRENT_LEVEL, 1)) {
            editor.putInt(Utils.WINTER_CURRENT_LEVEL, currentLevel + 1);
        }
        editor.apply();
    }


    public SharedPreferences getPref() {
        return sPref;
    }
}
