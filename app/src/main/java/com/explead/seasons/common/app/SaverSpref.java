package com.explead.seasons.common.app;

import android.content.Context;
import android.content.SharedPreferences;

import com.explead.seasons.common.beans.AllLevels;
import com.explead.seasons.common.utils.Utils;

import java.util.ArrayList;

public class SaverSpref {

    private Context context;
    private SharedPreferences sPref;

    public SaverSpref(Context context) {
        this.context = context;
        sPref = context.getSharedPreferences(Utils.APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    public void saveCurrentLevel(int currentLevel, AllLevels.Month month, AllLevels.Complication complication) {
        if(month == AllLevels.Month.DECEMBER) {
            if(complication == AllLevels.Complication.EASY) {
                setCurrentWinterLevel(currentLevel, Utils.DECEMBER_EASY);
            } else if(complication == AllLevels.Complication.HARD) {
                setCurrentWinterLevel(currentLevel, Utils.DECEMBER_HARD);
            }
        } else if(month == AllLevels.Month.JANUARY) {
            if(complication == AllLevels.Complication.EASY) {
                setCurrentWinterLevel(currentLevel, Utils.JANUARY_EASY);
            } else if(complication == AllLevels.Complication.HARD) {
                setCurrentWinterLevel(currentLevel, Utils.JANUARY_HARD);
            }
        }
    }

    public ArrayList<Integer> getArray(AllLevels.Month month, AllLevels.Complication complication) {
        ArrayList<Integer> array = new ArrayList<>();
        if(month == AllLevels.Month.DECEMBER) {
            if(complication == AllLevels.Complication.EASY) {
                array = getArrayFromString(sPref.getString(Utils.DECEMBER_EASY, "0"));
            } else if(complication == AllLevels.Complication.HARD) {
                array = getArrayFromString(sPref.getString(Utils.DECEMBER_HARD, "0"));
            }
        } else if(month == AllLevels.Month.JANUARY) {
            if(complication == AllLevels.Complication.EASY) {
                array = getArrayFromString(sPref.getString(Utils.JANUARY_EASY, "0"));
            } else if(complication == AllLevels.Complication.HARD) {
                array = getArrayFromString(sPref.getString(Utils.JANUARY_HARD, "0"));
            }
        }
        return array;
    }

    private void setCurrentWinterLevel(int currentLevel, String save) {
        System.out.println("Сохранение нового текущего уровня");
        SharedPreferences.Editor editor = sPref.edit();
        String str = sPref.getString(save, "0");
        if(!isLevelInArray(currentLevel, getArrayFromString(str))) {
            String newStr = addToString(currentLevel, str);
            editor.putString(save, newStr);
        }
        editor.apply();
    }

    private String addToString(int currentLevel, String str) {
        return str + "|" + Integer.toString(currentLevel);
    }

    private boolean isLevelInArray(int currentLevel, ArrayList<Integer> array) {
        return array.contains(currentLevel);
    }

    public boolean isLevelCompliated(AllLevels.Month month, int level) {
        return  isLevelInArray(level, getArray(month, AllLevels.Complication.EASY));
    }

    private ArrayList<Integer> getArrayFromString(String str) {
        String replaceStr = str.replaceAll("[^0-9]+", " ");
        ArrayList<Integer> array = new ArrayList<>();
        String[] list = replaceStr.trim().split(" ");
        for (String item : list) {
            array.add(Integer.parseInt(item));
        }
        return array;
    }

    public SharedPreferences getPref() {
        return sPref;
    }
}
