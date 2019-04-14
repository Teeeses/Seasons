package com.explead.seasons.common.beans;

import com.explead.seasons.winter.levels.DecemberEasyLevels;
import com.explead.seasons.winter.levels.DecemberHardLevels;
import com.explead.seasons.winter.levels.JanuaryEasyLevels;
import com.explead.seasons.winter.levels.JanuaryHardLevels;

import java.util.ArrayList;

public class AllLevels {

    public enum Month {
        DECEMBER(12, 31), JANUARY(1, 31);

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
        EASY, HARD;
    }

    private ArrayList<LevelContainer> decemberEasyLevels;
    private ArrayList<LevelContainer> decemberHardLevels;

    private ArrayList<LevelContainer> januaryEasyLevels;
    private ArrayList<LevelContainer> januaryHardLevels;

    public AllLevels() {
        decemberEasyLevels = new DecemberEasyLevels().getLevels();
        decemberHardLevels = new DecemberHardLevels().getLevels();

        januaryEasyLevels = new JanuaryEasyLevels().getLevels();
        januaryHardLevels = new JanuaryHardLevels().getLevels();
    }

    public LevelContainer get(int level, Month month, Complication complication) {
        LevelContainer container = null;
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

    public ArrayList<LevelContainer> getDecemberEasyLevels() {
        return decemberEasyLevels;
    }

    public void setDecemberEasyLevels(ArrayList<LevelContainer> decemberEasyLevels) {
        this.decemberEasyLevels = decemberEasyLevels;
    }

    public ArrayList<LevelContainer> getDecemberHardLevels() {
        return decemberHardLevels;
    }

    public void setDecemberHardLevels(ArrayList<LevelContainer> decemberHardLevels) {
        this.decemberHardLevels = decemberHardLevels;
    }

    public ArrayList<LevelContainer> getJanuaryEasyLevels() {
        return januaryEasyLevels;
    }

    public void setJanuaryEasyLevels(ArrayList<LevelContainer> januaryEasyLevels) {
        this.januaryEasyLevels = januaryEasyLevels;
    }

    public ArrayList<LevelContainer> getJanuaryHardLevels() {
        return januaryHardLevels;
    }

    public void setJanuaryHardLevels(ArrayList<LevelContainer> januaryHardLevels) {
        this.januaryHardLevels = januaryHardLevels;
    }
}
