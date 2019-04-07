package com.explead.seasons.common.beans;

import com.explead.seasons.winter.levels.DecemberEasyLevels;
import com.explead.seasons.winter.levels.DecemberHardLevels;
import com.explead.seasons.winter.levels.JanuaryEasyLevels;
import com.explead.seasons.winter.levels.JanuaryHardLevels;

import java.util.ArrayList;

public class AllLevels {

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
