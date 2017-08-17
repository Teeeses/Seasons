package com.explead.twoseasons.utils.levels;

import com.explead.twoseasons.beans.LevelContainer;
import com.explead.twoseasons.logic.elements.ContainerCells;
import com.explead.twoseasons.logic.elements.EndCell;
import com.explead.twoseasons.logic.elements.StartCell;

import java.util.ArrayList;

/**
 * Created by develop on 17.08.2017.
 */

public class WinterLevels {

    private ArrayList<LevelContainer> levels = new ArrayList<>();

    public WinterLevels() {

        int[][] mass;
        ArrayList<ContainerCells> containerCells;

        mass = new int[][] {
                {0, 0, 0, 0, 0},
                {6, 0, 6, 6, 6},
                {6, 0, 6, 0, 0},
                {0, 0, 6, 6, 0},
                {0, 0, 0, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(0, 0), new EndCell(2, 3)));
        containerCells.add(new ContainerCells(new StartCell(2, 3), new EndCell(0, 0)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {0, 0, 0, 0, 0},
                {6, 0, 6, 0, 0},
                {0, 0, 6, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 6, 6, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(4, 0), new EndCell(4, 1)));
        containerCells.add(new ContainerCells(new StartCell(4, 1), new EndCell(4, 0)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {0, 0, 0, 0, 6},
                {0, 6, 0, 0, 0},
                {6, 6, 0, 6, 0},
                {6, 6, 0, 6, 0},
                {6, 0, 0, 6, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(4, 4), new EndCell(4, 1)));
        containerCells.add(new ContainerCells(new StartCell(4, 1), new EndCell(4, 4)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 6, 0},
                {6, 6, 0, 6, 6},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 6, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(1, 4), new EndCell(4, 4)));
        containerCells.add(new ContainerCells(new StartCell(4, 4), new EndCell(1, 4)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {6, 6, 6, 6, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 6, 6, 6, 6, 0},
                {6, 6, 0, 0, 0, 0},
                {6, 6, 0, 0, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(5, 2), new EndCell(4, 2)));
        containerCells.add(new ContainerCells(new StartCell(4, 2), new EndCell(5, 2)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {0, 6, 0, 6, 0},
                {0, 6, 0, 6, 0},
                {0, 6, 0, 6, 0},
                {0, 6, 0, 0, 0},
                {0, 0, 0, 0, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(0, 0), new EndCell(0, 4)));
        containerCells.add(new ContainerCells(new StartCell(0, 4), new EndCell(0, 0)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {6, 6, 6, 0, 0, 0, 0},
                {6, 6, 6, 0, 6, 6, 0},
                {0, 0, 6, 0, 6, 6, 0},
                {6, 0, 6, 6, 6, 6, 0},
                {0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 6, 6},
                {6, 6, 6, 6, 6, 6, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(2, 0), new EndCell(2, 3)));
        containerCells.add(new ContainerCells(new StartCell(2, 3), new EndCell(2, 0)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {0, 0, 0, 0, 0},
                {6, 0, 6, 6, 0},
                {0, 0, 6, 0, 0},
                {0, 6, 6, 0, 0},
                {0, 0, 0, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(0, 0), new EndCell(2, 3)));
        containerCells.add(new ContainerCells(new StartCell(2, 3), new EndCell(0, 0)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 6, 6, 6, 0, 6},
                {0, 6, 0, 6, 0, 0},
                {0, 0, 0, 6, 6, 0},
                {0, 0, 6, 6, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(2, 4), new EndCell(2, 2)));
        containerCells.add(new ContainerCells(new StartCell(2, 2), new EndCell(2, 4)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {0, 0, 0, 6, 6, 6},
                {0, 0, 6, 6, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 6, 0, 6, 0, 6},
                {0, 0, 0, 0, 0, 0},
                {6, 0, 0, 6, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(1, 5), new EndCell(0, 2)));
        containerCells.add(new ContainerCells(new StartCell(0, 2), new EndCell(1, 5)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 0, 0, 6, 6, 6},
                {0, 6, 0, 0, 6, 0, 0},
                {0, 6, 0, 0, 6, 0, 6},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 6, 0, 6, 6, 6},
                {6, 0, 0, 0, 0, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(1, 6), new EndCell(6, 6)));
        containerCells.add(new ContainerCells(new StartCell(6, 6), new EndCell(1, 6)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 6, 6, 6, 6},
                {6, 0, 0, 0, 6, 6},
                {0, 0, 6, 0, 0, 0},
                {0, 6, 6, 6, 6, 0},
                {0, 0, 6, 0, 0, 0},
                {6, 0, 0, 0, 6, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(0, 0), new EndCell(2, 3)));
        containerCells.add(new ContainerCells(new StartCell(2, 3), new EndCell(0, 0)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 6, 6},
                {0, 6, 0, 6, 0},
                {0, 0, 0, 0, 0},
                {6, 6, 0, 6, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(0, 4), new EndCell(4, 2)));
        containerCells.add(new ContainerCells(new StartCell(4, 2), new EndCell(0, 4)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {0, 0, 0, 6, 0, 0},
                {0, 6, 0, 6, 6, 0},
                {0, 6, 0, 6, 0, 0},
                {0, 6, 0, 6, 0, 6},
                {0, 0, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(0, 4), new EndCell(5, 0)));
        containerCells.add(new ContainerCells(new StartCell(5, 0), new EndCell(0, 4)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {0, 0, 0, 0, 6},
                {6, 6, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {6, 6, 0, 6, 0},
                {6, 0, 0, 6, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(2, 0), new EndCell(4, 4)));
        containerCells.add(new ContainerCells(new StartCell(4, 4), new EndCell(2, 0)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 6, 6, 6, 6, 6, 6, 6, 0},
                {0, 6, 0, 0, 0, 0, 0, 0, 0},
                {0, 6, 0, 6, 6, 6, 6, 6, 6},
                {0, 6, 0, 6, 0, 0, 0, 6, 0},
                {0, 6, 0, 6, 0, 0, 6, 6, 0},
                {0, 6, 0, 0, 0, 0, 0, 6, 0},
                {0, 6, 6, 6, 6, 6, 6, 6, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(0, 0), new EndCell(4, 8)));
        containerCells.add(new ContainerCells(new StartCell(4, 8), new EndCell(0, 0)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {0, 0, 0, 6, 0, 0, 0, 0, 0},
                {0, 6, 0, 6, 0, 0, 0, 0, 0},
                {0, 6, 6, 6, 0, 0, 0, 0, 0},
                {0, 6, 6, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 6, 0},
                {0, 0, 0, 0, 0, 0, 6, 6, 0},
                {6, 0, 6, 6, 6, 6, 6, 0, 0},
                {6, 0, 0, 0, 6, 0, 0, 0, 6},
                {6, 6, 6, 0, 0, 0, 6, 6, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(1, 2), new EndCell(5, 5)));
        containerCells.add(new ContainerCells(new StartCell(5, 5), new EndCell(1, 2)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {0, 0, 0, 6, 0},
                {0, 6, 0, 6, 0},
                {0, 6, 0, 6, 0},
                {0, 6, 0, 0, 0},
                {0, 0, 0, 0, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(0, 0), new EndCell(0, 4)));
        containerCells.add(new ContainerCells(new StartCell(0, 4), new EndCell(0, 0)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {0, 0, 0, 0, 6, 6, 6, 6},
                {0, 6, 6, 0, 0, 0, 0, 0},
                {0, 0, 6, 0, 0, 6, 0, 0},
                {6, 0, 6, 0, 6, 6, 6, 0},
                {6, 0, 0, 0, 6, 0, 0, 0},
                {6, 6, 6, 0, 6, 0, 6, 6},
                {6, 6, 0, 0, 6, 0, 0, 6},
                {6, 6, 0, 6, 6, 6, 6, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(7, 2), new EndCell(6, 6)));
        containerCells.add(new ContainerCells(new StartCell(6, 6), new EndCell(7, 2)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {6, 6, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 6, 6, 6},
                {0, 0, 6, 0, 6, 0, 6, 0, 0},
                {0, 0, 6, 0, 6, 0, 6, 0, 6},
                {0, 0, 6, 0, 6, 0, 6, 0, 6},
                {0, 0, 6, 0, 6, 0, 6, 0, 6},
                {0, 0, 6, 0, 6, 0, 6, 0, 6},
                {0, 0, 6, 6, 6, 0, 0, 0, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(7, 3), new EndCell(3, 8)));
        containerCells.add(new ContainerCells(new StartCell(3, 8), new EndCell(7, 3)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 6, 0, 6, 0, 6, 0, 0},
                {6, 6, 0, 6, 0, 6, 0, 0},
                {0, 0, 0, 6, 0, 6, 0, 0},
                {0, 6, 6, 6, 0, 6, 0, 0},
                {0, 6, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 6, 6, 6},
                {6, 6, 6, 0, 0, 0, 0, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(1, 0), new EndCell(7, 6)));
        containerCells.add(new ContainerCells(new StartCell(7, 6), new EndCell(1, 0)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 6, 6, 6, 6, 6, 6, 6, 6},
                {0, 0, 0, 0, 0, 0, 0, 0, 6},
                {0, 6, 0, 6, 6, 6, 6, 0, 6},
                {0, 6, 0, 6, 6, 6, 6, 0, 6},
                {0, 6, 0, 6, 6, 6, 6, 0, 6},
                {0, 6, 0, 0, 0, 0, 0, 0, 6},
                {0, 6, 6, 0, 0, 0, 6, 6, 6},
                {0, 0, 0, 0, 0, 0, 0, 6, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(0, 8), new EndCell(8, 6)));
        containerCells.add(new ContainerCells(new StartCell(8, 6), new EndCell(0, 8)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 6, 6, 6, 6},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 6, 0},
                {0, 6, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 6, 6, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(0, 1), new EndCell(1, 5)));
        containerCells.add(new ContainerCells(new StartCell(1, 5), new EndCell(0, 1)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 0, 0, 0},
                {6, 6, 0, 6, 0},
                {0, 6, 0, 6, 0},
                {0, 0, 0, 0, 0},
                {6, 6, 6, 6, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(0, 0), new EndCell(4, 4)));
        containerCells.add(new ContainerCells(new StartCell(4, 4), new EndCell(0, 0)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {6, 0, 0, 0, 0, 0, 0},
                {0, 0, 6, 0, 6, 0, 0},
                {6, 6, 6, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 6, 0},
                {0, 6, 0, 0, 6, 6, 0},
                {0, 6, 0, 6, 6, 0, 0},
                {0, 0, 0, 6, 0, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(1, 0), new EndCell(6, 4)));
        containerCells.add(new ContainerCells(new StartCell(6, 4), new EndCell(1, 0)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 0},
                {6, 0, 0, 0, 6, 0, 0},
                {0, 0, 0, 0, 6, 0, 6},
                {0, 6, 6, 6, 6, 0, 6},
                {0, 0, 0, 0, 0, 0, 0},
                {6, 6, 6, 6, 6, 6, 0},
                {6, 6, 6, 6, 6, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(0, 0), new EndCell(6, 5)));
        containerCells.add(new ContainerCells(new StartCell(6, 5), new EndCell(0, 0)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 0, 6, 0, 0, 0},
                {0, 6, 0, 6, 6, 6, 0},
                {6, 6, 0, 0, 0, 6, 0},
                {0, 0, 0, 6, 0, 0, 0},
                {0, 6, 0, 0, 0, 6, 0},
                {0, 6, 6, 6, 6, 6, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(1, 0), new EndCell(0, 4)));
        containerCells.add(new ContainerCells(new StartCell(0, 4), new EndCell(1, 0)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 6, 0, 6, 6, 0},
                {6, 0, 0, 6, 0, 6, 6, 0},
                {0, 0, 6, 6, 0, 6, 6, 0},
                {0, 0, 0, 0, 0, 6, 6, 0},
                {0, 6, 0, 6, 0, 6, 6, 0},
                {0, 6, 0, 6, 0, 6, 6, 0},
                {0, 6, 0, 0, 0, 6, 6, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(7, 7), new EndCell(7, 4)));
        containerCells.add(new ContainerCells(new StartCell(7, 4), new EndCell(7, 7)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {6, 0, 0, 0, 0, 0, 6},
                {6, 0, 0, 0, 0, 6, 6},
                {6, 0, 6, 0, 0, 0, 6},
                {0, 0, 6, 0, 6, 0, 6},
                {0, 0, 6, 0, 6, 0, 0},
                {0, 6, 6, 0, 6, 6, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(4, 1), new EndCell(0, 5)));
        containerCells.add(new ContainerCells(new StartCell(0, 5), new EndCell(4, 1)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 0, 0, 0, 6, 6},
                {0, 6, 6, 6, 0, 0, 0},
                {0, 0, 6, 0, 0, 0, 0},
                {6, 6, 6, 0, 0, 6, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 6, 0, 0, 0, 6, 0},
                {0, 6, 6, 0, 6, 6, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(6, 0), new EndCell(6, 6)));
        containerCells.add(new ContainerCells(new StartCell(6, 6), new EndCell(6, 0)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 0, 0, 6, 6},
                {6, 0, 0, 0, 0, 0},
                {6, 6, 0, 0, 0, 6},
                {0, 0, 0, 6, 0, 0},
                {0, 6, 0, 6, 6, 0},
                {0, 0, 0, 0, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(0, 0), new EndCell(3, 4)));
        containerCells.add(new ContainerCells(new StartCell(3, 4), new EndCell(0, 0)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {6, 6, 6, 6, 0, 6, 6},
                {6, 0, 0, 0, 0, 6, 6},
                {6, 0, 0, 0, 0, 0, 6},
                {6, 6, 0, 0, 0, 0, 6},
                {6, 0, 0, 0, 6, 0, 6},
                {6, 6, 6, 0, 6, 6, 6},
                {6, 6, 6, 6, 6, 6, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(4, 1), new EndCell(4, 5)));
        containerCells.add(new ContainerCells(new StartCell(4, 5), new EndCell(4, 1)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 0, 0, 0, 0},
                {0, 6, 6, 6, 0, 6},
                {0, 6, 6, 6, 0, 6},
                {0, 0, 0, 6, 0, 6},
                {6, 6, 0, 0, 0, 0},
                {6, 0, 0, 6, 6, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(3, 0), new EndCell(5, 5)));
        containerCells.add(new ContainerCells(new StartCell(5, 5), new EndCell(3, 0)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {6, 0, 0, 0, 0, 0, 0, 0, 6},
                {6, 0, 6, 6, 6, 6, 6, 0, 6},
                {6, 0, 6, 0, 0, 0, 6, 0, 6},
                {0, 0, 6, 6, 0, 0, 6, 0, 0},
                {0, 0, 0, 6, 6, 0, 6, 6, 0},
                {6, 6, 0, 6, 6, 0, 0, 0, 0},
                {6, 6, 0, 6, 6, 6, 0, 0, 6},
                {6, 0, 0, 0, 0, 6, 0, 0, 6},
                {6, 6, 6, 6, 0, 0, 0, 6, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(2, 3), new EndCell(3, 7)));
        containerCells.add(new ContainerCells(new StartCell(3, 7), new EndCell(2, 3)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 6, 0, 0, 0, 6, 6},
                {0, 0, 0, 0, 0, 6, 6, 6},
                {0, 6, 0, 0, 0, 0, 0, 6},
                {0, 0, 0, 0, 0, 0, 0, 6},
                {6, 0, 0, 0, 0, 0, 0, 6},
                {6, 0, 0, 6, 0, 0, 0, 6},
                {6, 0, 0, 6, 0, 6, 0, 6},
                {6, 6, 6, 6, 6, 6, 6, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(6, 4), new EndCell(6, 6)));
        containerCells.add(new ContainerCells(new StartCell(6, 6), new EndCell(6, 4)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {6, 6, 6, 0, 0, 0, 6, 6, 6},
                {6, 0, 0, 0, 0, 0, 0, 6, 6},
                {6, 0, 0, 0, 6, 0, 0, 0, 6},
                {6, 0, 0, 0, 0, 0, 0, 0, 6},
                {0, 0, 6, 6, 6, 6, 0, 0, 6},
                {0, 6, 6, 6, 0, 0, 0, 0, 6},
                {0, 0, 0, 6, 0, 6, 6, 0, 6},
                {6, 0, 0, 0, 0, 0, 6, 0, 6},
                {6, 6, 6, 6, 6, 0, 0, 0, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(3, 3), new EndCell(7, 1)));
        containerCells.add(new ContainerCells(new StartCell(7, 1), new EndCell(3, 3)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {6, 6, 6, 6, 6, 6, 6, 6, 6},
                {6, 0, 0, 0, 0, 0, 0, 0, 6},
                {6, 0, 0, 0, 0, 0, 0, 0, 0},
                {6, 0, 0, 0, 0, 0, 0, 6, 6},
                {6, 0, 0, 0, 0, 0, 0, 0, 6},
                {6, 6, 0, 0, 0, 0, 0, 0, 6},
                {6, 0, 0, 0, 0, 0, 0, 0, 0},
                {6, 0, 0, 6, 0, 0, 0, 0, 6},
                {6, 6, 6, 6, 6, 6, 6, 6, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(2, 8), new EndCell(6, 8)));
        containerCells.add(new ContainerCells(new StartCell(6, 8), new EndCell(2, 8)));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {6, 6, 6, 6, 6, 6, 6, 6, 6, 6},
                {6, 6, 6, 0, 0, 0, 6, 6, 6, 6},
                {6, 0, 0, 0, 0, 0, 0, 0, 0, 6},
                {6, 0, 0, 6, 0, 0, 0, 0, 0, 6},
                {6, 0, 0, 6, 0, 0, 0, 0, 6, 6},
                {6, 6, 0, 0, 0, 6, 0, 0, 6, 6},
                {6, 0, 0, 0, 6, 6, 0, 0, 0, 6},
                {6, 0, 0, 0, 0, 0, 0, 6, 6, 6},
                {6, 6, 0, 0, 0, 6, 6, 6, 6, 6},
                {6, 6, 6, 6, 6, 6, 6, 6, 6, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new StartCell(8, 4), new EndCell(6, 8)));
        containerCells.add(new ContainerCells(new StartCell(6, 8), new EndCell(8, 4)));
        levels.add(new LevelContainer(mass, containerCells));
    }

    public ArrayList<LevelContainer> getLevels() {
        return levels;
    }
}
