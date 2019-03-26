package com.explead.seasons.winter;

import com.explead.seasons.common.beans.LevelContainer;
import com.explead.seasons.common.logic.ContainerCells;

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
        containerCells.add(new ContainerCells(new WinterCell(0, 0), new WinterCell(2, 3), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(2, 3), new WinterCell(0, 0), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(4, 0), new WinterCell(3, 0), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {0, 0, 0, 0, 6},
                {0, 6, 0, 0, 0},
                {6, 6, 0, 6, 0},
                {6, 6, 0, 6, 0},
                {6, 0, 0, 6, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(4, 4), new WinterCell(4, 1), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(4, 1), new WinterCell(4, 4), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 6, 6, 6, 0},
                {0, 0, 0, 6, 0},
                {6, 0, 6, 6, 0},
                {6, 0, 0, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(2, 1), new WinterCell(2, 2), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(2, 2), new WinterCell(2, 1), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));


        mass = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 6, 0},
                {6, 6, 0, 6, 6},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 6, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(1, 4), new WinterCell(4, 4), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(4, 4), new WinterCell(1, 4), WinterCell.ColorCube.BLUE));
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
        containerCells.add(new ContainerCells(new WinterCell(2, 0), new WinterCell(2, 3), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(2, 3), new WinterCell(2, 0), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {0, 0, 0, 0, 6},
                {6, 6, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {6, 6, 0, 6, 0},
                {6, 0, 0, 6, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(2, 0), new WinterCell(4, 4), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(4, 4), new WinterCell(2, 0), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(0, 0), new WinterCell(4, 1), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {0, 0, 6, 6, 6},
                {0, 0, 0, 0, 6},
                {6, 0, 0, 6, 6},
                {0, 0, 0, 0, 0},
                {6, 6, 0, 0, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(1, 3), new WinterCell(3, 4), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(3, 4), new WinterCell(1, 3), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {0, 0, 0, 0, 6},
                {0, 6, 6, 6, 6},
                {0, 0, 6, 0, 6},
                {6, 0, 0, 0, 0},
                {6, 6, 0, 0, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(0, 3), new WinterCell(3, 4), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(3, 4), new WinterCell(0, 3), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {6, 0, 6, 0, 0},
                {6, 0, 0, 0, 0},
                {0, 0, 0, 6, 0},
                {6, 6, 0, 6, 6},
                {6, 0, 0, 6, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(4, 1), new WinterCell(2, 4), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(2, 4), new WinterCell(4, 1), WinterCell.ColorCube.BLUE));
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
        containerCells.add(new ContainerCells(new WinterCell(5, 2), new WinterCell(4, 2), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(4, 2), new WinterCell(5, 2), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {0, 0, 0, 6, 0},
                {0, 6, 0, 6, 0},
                {0, 6, 0, 6, 0},
                {0, 6, 0, 0, 0},
                {0, 0, 0, 0, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(0, 0), new WinterCell(0, 4), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(0, 4), new WinterCell(0, 0), WinterCell.ColorCube.BLUE));
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
        containerCells.add(new ContainerCells(new WinterCell(2, 4), new WinterCell(2, 2), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(2, 2), new WinterCell(2, 4), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {0, 0, 0, 0, 0},
                {6, 0, 6, 0, 0},
                {0, 0, 6, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 6, 6, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(4, 0), new WinterCell(4, 1), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(4, 1), new WinterCell(4, 0), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {0, 0, 0, 0, 0},
                {6, 6, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 6, 0, 6, 0},
                {0, 6, 0, 6, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(0, 0), new WinterCell(4, 2), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(4, 2), new WinterCell(0, 0), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {6, 0, 0, 0, 0},
                {0, 0, 0, 6, 0},
                {6, 0, 0, 0, 0},
                {0, 0, 6, 0, 0},
                {6, 6, 6, 6, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(1, 0), new WinterCell(3, 0), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(3, 0), new WinterCell(1, 0), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {0, 6, 6, 6, 0},
                {0, 6, 0, 6, 0},
                {0, 6, 0, 6, 0},
                {0, 6, 0, 0, 0},
                {0, 0, 0, 0, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(0, 0), new WinterCell(0, 4), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(0, 4), new WinterCell(0, 0), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {0, 0, 0, 0, 0},
                {6, 0, 6, 6, 0},
                {0, 0, 6, 0, 0},
                {0, 6, 6, 0, 0},
                {0, 0, 0, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(0, 0), new WinterCell(2, 3), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(2, 3), new WinterCell(0, 0), WinterCell.ColorCube.BLUE));
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
        containerCells.add(new ContainerCells(new WinterCell(0, 0), new WinterCell(4, 8), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(4, 8), new WinterCell(0, 0), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 0, 0, 0},
                {6, 6, 0, 6, 0},
                {0, 6, 0, 6, 0},
                {0, 0, 0, 0, 0},
                {6, 6, 6, 6, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(0, 0), new WinterCell(4, 4), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(4, 4), new WinterCell(0, 0), WinterCell.ColorCube.BLUE));
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
        containerCells.add(new ContainerCells(new WinterCell(0, 4), new WinterCell(5, 0), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(5, 0), new WinterCell(0, 4), WinterCell.ColorCube.BLUE));
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
        containerCells.add(new ContainerCells(new WinterCell(1, 5), new WinterCell(0, 2), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(0, 2), new WinterCell(1, 5), WinterCell.ColorCube.BLUE));
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
        containerCells.add(new ContainerCells(new WinterCell(0, 0), new WinterCell(2, 3), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(2, 3), new WinterCell(0, 0), WinterCell.ColorCube.BLUE));
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
        containerCells.add(new ContainerCells(new WinterCell(7, 2), new WinterCell(6, 6), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(6, 6), new WinterCell(7, 2), WinterCell.ColorCube.BLUE));
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
        containerCells.add(new ContainerCells(new WinterCell(0, 0), new WinterCell(6, 5), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(6, 5), new WinterCell(0, 0), WinterCell.ColorCube.BLUE));
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
        containerCells.add(new ContainerCells(new WinterCell(1, 0), new WinterCell(0, 4), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(0, 4), new WinterCell(1, 0), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 6, 0, 6, 0},
                {6, 0, 0, 6, 0, 6, 0},
                {0, 0, 6, 6, 0, 6, 0},
                {0, 0, 0, 0, 0, 6, 0},
                {0, 6, 0, 6, 0, 6, 0},
                {0, 6, 0, 0, 0, 6, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(6, 6), new WinterCell(6, 4), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(6, 4), new WinterCell(6, 6), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 6, 0, 0, 0, 6},
                {0, 0, 0, 0, 0, 6, 6},
                {0, 6, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {6, 0, 0, 0, 0, 0, 0},
                {6, 0, 0, 6, 0, 0, 0},
                {6, 0, 0, 6, 0, 6, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(6, 4), new WinterCell(6, 6), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(6, 6), new WinterCell(6, 4), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {6, 0, 0, 0, 0, 0},
                {6, 6, 0, 0, 6, 0},
                {0, 6, 0, 6, 6, 0},
                {0, 0, 0, 0, 6, 0},
                {6, 0, 6, 0, 0, 0},
                {6, 0, 0, 0, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(2, 0), new WinterCell(0, 1), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(0, 1), new WinterCell(2, 0), WinterCell.ColorCube.BLUE));
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
        containerCells.add(new ContainerCells(new WinterCell(0, 8), new WinterCell(8, 6), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(8, 6), new WinterCell(0, 8), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 0, 0, 6},
                {0, 0, 0, 0, 0},
                {6, 0, 0, 0, 0},
                {0, 0, 0, 6, 0},
                {6, 6, 0, 6, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(3, 0), new WinterCell(3, 4), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(3, 4), new WinterCell(3, 0), WinterCell.ColorCube.BLUE));
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
        containerCells.add(new ContainerCells(new WinterCell(1, 6), new WinterCell(6, 6), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(6, 6), new WinterCell(1, 6), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 6, 6},
                {0, 6, 0, 6, 0},
                {0, 0, 0, 0, 0},
                {6, 6, 0, 6, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(0, 4), new WinterCell(4, 2), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(4, 2), new WinterCell(0, 4), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][]{
                {0, 0, 0, 6, 0, 0, 0, 0},
                {0, 6, 0, 6, 0, 0, 0, 0},
                {0, 6, 6, 6, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 6, 0},
                {0, 0, 0, 0, 0, 6, 6, 0},
                {6, 0, 6, 6, 6, 6, 0, 0},
                {6, 0, 0, 0, 6, 0, 0, 6},
                {6, 6, 6, 0, 0, 0, 6, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(1, 2), new WinterCell(4, 4), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(4, 4), new WinterCell(1, 2), WinterCell.ColorCube.BLUE));
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
        containerCells.add(new ContainerCells(new WinterCell(1, 0), new WinterCell(7, 6), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(7, 6), new WinterCell(1, 0), WinterCell.ColorCube.BLUE));
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
        containerCells.add(new ContainerCells(new WinterCell(0, 1), new WinterCell(1, 5), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(1, 5), new WinterCell(0, 1), WinterCell.ColorCube.BLUE));
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
        containerCells.add(new ContainerCells(new WinterCell(4, 1), new WinterCell(0, 5), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(0, 5), new WinterCell(4, 1), WinterCell.ColorCube.BLUE));
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
        containerCells.add(new ContainerCells(new WinterCell(0, 0), new WinterCell(3, 4), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(3, 4), new WinterCell(0, 0), WinterCell.ColorCube.BLUE));
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
        containerCells.add(new ContainerCells(new WinterCell(3, 0), new WinterCell(5, 5), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(5, 5), new WinterCell(3, 0), WinterCell.ColorCube.BLUE));
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
        containerCells.add(new ContainerCells(new WinterCell(7, 3), new WinterCell(3, 8), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(3, 8), new WinterCell(7, 3), WinterCell.ColorCube.BLUE));
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
        containerCells.add(new ContainerCells(new WinterCell(1, 0), new WinterCell(6, 4), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(6, 4), new WinterCell(1, 0), WinterCell.ColorCube.BLUE));
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
        containerCells.add(new ContainerCells(new WinterCell(6, 0), new WinterCell(6, 6), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(6, 6), new WinterCell(6, 0), WinterCell.ColorCube.BLUE));
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
        containerCells.add(new ContainerCells(new WinterCell(2, 3), new WinterCell(5, 6), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(3, 7), new WinterCell(4, 2), WinterCell.ColorCube.BLUE));
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
        containerCells.add(new ContainerCells(new WinterCell(3, 3), new WinterCell(7, 1), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(7, 1), new WinterCell(3, 3), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {6, 6, 0, 0, 0, 6, 6, 6},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 6, 0, 0, 0, 0, 0},
                {0, 0, 6, 0, 0, 0, 0, 6},
                {6, 0, 0, 0, 6, 0, 0, 6},
                {0, 0, 0, 6, 6, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 6, 6},
                {6, 0, 0, 0, 6, 6, 6, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(7, 3), new WinterCell(5, 7), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(5, 7), new WinterCell(7, 3), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));


        /*
        Новые уровни -->
         */

        mass = new int[][] {
                {0, 6, 0, 0, 0},
                {0, 6, 0, 0, 0},
                {0, 0, 0, 6, 6},
                {0, 0, 0, 0, 0},
                {0, 0, 6, 6, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(0, 0), new WinterCell(2, 0), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(4, 4), new WinterCell(0, 2), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 6, 0, 0, 0},
                {0, 6, 6, 0, 0},
                {0, 0, 0, 0, 6},
                {6, 0, 0, 0, 0},
                {0, 0, 6, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(0, 2), new WinterCell(0, 0), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(4, 4), new WinterCell(4, 0), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {6, 6, 6, 0, 0, 0, 0},
                {6, 6, 0, 0, 6, 6, 0},
                {6, 6, 6, 0, 0, 6, 0},
                {0, 0, 6, 0, 0, 6, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {6, 0, 0, 0, 6, 0, 0},
                {0, 0, 6, 0, 0, 0, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(6, 0), new WinterCell(6, 3), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(1, 2), new WinterCell(6, 1), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {6, 0, 6, 6, 6, 0, 0},
                {0, 0, 6, 0, 0, 0, 0},
                {0, 6, 6, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 6, 6, 0, 6, 6, 6},
                {0, 0, 0, 0, 0, 6, 0},
                {0, 0, 6, 0, 0, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(0, 1), new WinterCell(3, 0), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(1, 1), new WinterCell(6, 0), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 0, 6, 6, 0, 6},
                {0, 6, 0, 0, 6, 0, 0},
                {0, 6, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 6, 6, 0},
                {0, 0, 0, 0, 0, 6, 0},
                {6, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 0, 6, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(6, 0), new WinterCell(3, 3), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(0, 5), new WinterCell(0, 2), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 6, 0, 0, 0, 6, 6},
                {0, 0, 0, 6, 0, 0, 0},
                {6, 6, 0, 0, 0, 6, 0},
                {6, 6, 0, 6, 0, 6, 6},
                {6, 6, 0, 0, 0, 6, 0},
                {0, 0, 0, 6, 0, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(3, 6), new WinterCell(0, 6), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(5, 6), new WinterCell(6, 4), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {6, 0, 0, 0, 6, 6, 6},
                {0, 0, 6, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {6, 6, 0, 0, 6, 6, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 6, 0, 0, 6, 6},
                {6, 0, 0, 0, 0, 0, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(1, 5), new WinterCell(6, 1), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(6, 5), new WinterCell(2, 1), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 0, 6, 0, 0, 0},
                {0, 6, 0, 6, 0, 0, 0},
                {0, 0, 0, 0, 0, 6, 0},
                {6, 6, 0, 0, 6, 6, 0},
                {6, 6, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 6},
                {0, 6, 6, 6, 6, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(6, 5), new WinterCell(4, 2), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(6, 6), new WinterCell(1, 4), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 6, 0, 6, 0, 0, 6, 0},
                {0, 0, 0, 0, 0, 6, 0, 0},
                {0, 0, 6, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 6, 0, 0, 0},
                {0, 6, 0, 0, 0, 0, 6, 0},
                {0, 0, 6, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 6, 0, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(7, 3), new WinterCell(3, 3), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(7, 5), new WinterCell(2, 0), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 6, 0, 0, 0},
                {6, 0, 0, 0, 0, 0},
                {0, 0, 0, 6, 6, 0},
                {6, 6, 0, 6, 6, 0},
                {6, 0, 0, 6, 6, 0},
                {0, 0, 0, 6, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(5, 4), new WinterCell(2, 0), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(5, 5), new WinterCell(5, 0), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 6, 0, 0, 0},
                {0, 6, 6, 0, 0},
                {0, 0, 6, 0, 6},
                {6, 0, 0, 0, 0},
                {0, 0, 0, 6, 6}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(4, 0), new WinterCell(0, 0), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(3, 4), new WinterCell(0, 3), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {6, 0, 6, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 6, 0},
                {6, 0, 6, 6, 0},
                {0, 0, 0, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(2, 0), new WinterCell(4, 1), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(1, 0), new WinterCell(1, 3), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 0, 6, 0, 0},
                {0, 6, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 6, 6, 6},
                {6, 0, 0, 0, 0, 0},
                {6, 0, 0, 6, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(5, 5), new WinterCell(0, 5), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(5, 4), new WinterCell(2, 5), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 0, 0, 0, 0},
                {6, 0, 0, 6, 6, 0},
                {0, 0, 0, 0, 6, 0},
                {0, 0, 6, 0, 0, 0},
                {6, 0, 0, 0, 0, 0},
                {0, 0, 6, 0, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(5, 5), new WinterCell(0, 2), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(0, 0), new WinterCell(0, 5), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {6, 0, 6, 6, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 6, 6, 0, 0},
                {0, 0, 0, 6, 0, 6},
                {6, 6, 0, 6, 0, 0},
                {0, 0, 0, 6, 6, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(5, 0), new WinterCell(0, 5), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(5, 1), new WinterCell(5, 2), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 6, 0, 0, 0, 0},
                {0, 0, 6, 0, 6, 0, 0},
                {0, 0, 0, 0, 6, 0, 0},
                {6, 0, 6, 6, 6, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 6, 0, 6, 0, 6, 0},
                {0, 0, 0, 6, 0, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(0, 0), new WinterCell(4, 2), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(0, 1), new WinterCell(4, 0), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 6},
                {0, 0, 6, 0, 0, 0, 0, 0},
                {0, 6, 6, 0, 6, 0, 0, 0},
                {0, 0, 0, 6, 6, 0, 0, 0},
                {0, 0, 6, 6, 6, 0, 0, 0},
                {6, 0, 0, 0, 6, 0, 0, 0},
                {6, 6, 6, 0, 0, 0, 6, 0},
                {6, 0, 0, 0, 0, 0, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(3, 2), new WinterCell(5, 6), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(2, 3), new WinterCell(7, 3), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 6, 6, 6, 6, 6, 6, 0, 0},
                {0, 0, 6, 0, 0, 6, 0, 0, 0},
                {6, 0, 0, 0, 0, 6, 0, 6, 0},
                {0, 0, 0, 0, 0, 0, 0, 6, 0},
                {6, 0, 0, 6, 0, 6, 0, 6, 0},
                {0, 0, 0, 0, 0, 0, 0, 6, 0},
                {0, 0, 0, 0, 0, 0, 0, 6, 0},
                {0, 0, 0, 6, 0, 6, 0, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(4, 0), new WinterCell(2, 6), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(8, 4), new WinterCell(3, 1), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {6, 6, 6, 6, 6, 6, 6, 6, 6},
                {0, 0, 0, 0, 6, 6, 6, 6, 6},
                {0, 6, 6, 0, 6, 6, 0, 6, 0},
                {0, 6, 0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 6, 0},
                {0, 0, 6, 0, 6, 0, 0, 6, 0},
                {6, 0, 6, 6, 6, 6, 6, 6, 0},
                {0, 0, 0, 0, 6, 0, 0, 0, 0},
                {0, 0, 6, 0, 0, 0, 6, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(5, 3), new WinterCell(5, 0), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(2, 6), new WinterCell(1, 0), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 6, 0, 0, 6, 0},
                {0, 0, 6, 6, 6, 0, 6, 0},
                {0, 6, 6, 0, 0, 0, 6, 0},
                {0, 0, 6, 6, 0, 6, 6, 0},
                {0, 0, 0, 0, 0, 0, 6, 0},
                {6, 0, 0, 0, 6, 0, 6, 0},
                {6, 6, 6, 0, 6, 0, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(3, 3), new WinterCell(3, 4), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(3, 5), new WinterCell(5, 5), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 6, 6, 0, 0, 6, 6, 0},
                {0, 0, 6, 6, 0, 0, 6, 0},
                {6, 6, 6, 0, 0, 0, 6, 0},
                {0, 0, 0, 0, 6, 0, 6, 0},
                {0, 6, 0, 0, 6, 0, 0, 0},
                {0, 6, 6, 6, 6, 6, 6, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(2, 1), new WinterCell(3, 3), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(2, 0), new WinterCell(5, 2), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));


        mass = new int[][] {
                {0, 0, 6, 0, 0, 6, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 6, 0, 0, 0},
                {6, 6, 0, 6, 0, 6, 0},
                {0, 0, 0, 6, 0, 6, 0},
                {0, 0, 0, 6, 6, 6, 0},
                {6, 0, 0, 0, 0, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(4, 4), new WinterCell(1, 6), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(3, 4), new WinterCell(6, 6), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {0, 6, 0, 6, 6, 6, 6, 6},
                {0, 0, 0, 0, 6, 6, 6, 6},
                {6, 0, 6, 0, 6, 6, 6, 6},
                {0, 0, 0, 0, 0, 6, 6, 0},
                {0, 0, 0, 6, 6, 6, 0, 0},
                {6, 0, 0, 0, 6, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 6, 0, 0, 0, 0}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(0, 0), new WinterCell(3, 7), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(0, 2), new WinterCell(0, 0), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));
    }

    public ArrayList<LevelContainer> getLevels() {
        return levels;
    }
}
