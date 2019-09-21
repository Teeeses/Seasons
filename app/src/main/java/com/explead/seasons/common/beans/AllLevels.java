package com.explead.seasons.common.beans;

import com.explead.seasons.common.logic.LevelField;
import com.explead.seasons.winter.levels.DecemberLevelEasy;
import com.explead.seasons.winter.levels.DecemberLevelHard;
import com.explead.seasons.winter.levels.JanuaryLevelEasy;
import com.explead.seasons.winter.levels.JanuaryLevelHard;

import java.util.ArrayList;

public class AllLevels {

    public enum Month {
        DECEMBER(12, 31), JANUARY(1, 31), MARCH(3, 31), APRIL(4, 30);

        private int id;
        private int dais;

        Month(int id, int dais) {
            this.id = id;
            this.dais = dais;
        }

        public int getId() {
            return id;
        }

        public int getDeis() {
            return dais;
        }
    }

    public enum Complication {
        EASY, HARD
    }

    private ArrayList<LevelField> decemberEasyLevels;
    private ArrayList<LevelField> decemberHardLevels;

    private ArrayList<LevelField> januaryEasyLevels;
    private ArrayList<LevelField> januaryHardLevels;

    public AllLevels() {
        decemberEasyLevels = new DecemberLevelEasy().getLevels();
        decemberHardLevels = new DecemberLevelHard().getLevels();

        januaryEasyLevels = new JanuaryLevelEasy().getLevels();
        januaryHardLevels = new JanuaryLevelHard().getLevels();
    }

    public LevelField get(int level, Month month, Complication complication) {
        LevelField container = null;
        if(complication == Complication.EASY) {
            if(month == Month.DECEMBER) {
                container = decemberEasyLevels.get(level);
            }
            if(month == Month.JANUARY) {
                container = januaryEasyLevels.get(level);
            }
        } else {
            if(month == Month.DECEMBER) {
                container =  decemberHardLevels.get(level);
            }
            if(month == Month.JANUARY) {
                container = januaryHardLevels.get(level);
            }
        }
        return container;
    }

    public ArrayList<LevelField> getDecemberEasyLevels() {
        return decemberEasyLevels;
    }

    public void setDecemberEasyLevels(ArrayList<LevelField> decemberEasyLevels) {
        this.decemberEasyLevels = decemberEasyLevels;
    }

    public ArrayList<LevelField> getDecemberHardLevels() {
        return decemberHardLevels;
    }

    public void setDecemberHardLevels(ArrayList<LevelField> decemberHardLevels) {
        this.decemberHardLevels = decemberHardLevels;
    }

    public ArrayList<LevelField> getJanuaryEasyLevels() {
        return januaryEasyLevels;
    }

    public void setJanuaryEasyLevels(ArrayList<LevelField> januaryEasyLevels) {
        this.januaryEasyLevels = januaryEasyLevels;
    }

    public ArrayList<LevelField> getJanuaryHardLevels() {
        return januaryHardLevels;
    }

    public void setJanuaryHardLevels(ArrayList<LevelField> januaryHardLevels) {
        this.januaryHardLevels = januaryHardLevels;
    }
}
