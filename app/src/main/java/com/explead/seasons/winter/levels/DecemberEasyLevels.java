package com.explead.seasons.winter.levels;

import com.explead.seasons.common.beans.LevelContainer;
import com.explead.seasons.common.logic.ContainerCells;
import com.explead.seasons.winter.logic.WinterCell;

import java.util.ArrayList;

public class DecemberEasyLevels {

    private ArrayList<LevelContainer> levels = new ArrayList<>();

    public DecemberEasyLevels() {

        int[][] mass;
        ArrayList<ContainerCells> containerCells;

        mass = new int[][] {
                {'0','0','x','x','x'},
                {'0','0','0','x','x'},
                {'x','0','0','0','x'},
                {'x','x','0','0','0'},
                {'x','x','x','0','0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(0, 0), new WinterCell(3, 4), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(0, 1), new WinterCell(4, 4), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'0','0','0','0','0'},
                {'x','x','x','x','0'},
                {'0','0','0','x','0'},
                {'x','x','0','x','0'},
                {'0','0','0','0','0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(0, 0), new WinterCell(4, 1), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(2, 0), new WinterCell(4, 0), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'0','0','0','0','0'},
                {'0','x','x','x','0'},
                {'0','0','0','x','0'},
                {'x','0','x','x','0'},
                {'x','0','0','0','0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(2, 2), new WinterCell(2, 1), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(2, 1), new WinterCell(2, 2), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'0','0','0','0','x'},
                {'0','x','x','0','x'},
                {'0','x','0','0','0'},
                {'0','x','x','x','0'},
                {'0','x','0','0','0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(4, 0), new WinterCell(4, 2), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(3, 0), new WinterCell(2, 2), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'0','0','0','0','0'},
                {'x','0','x','x','x'},
                {'x','0','x','0','0'},
                {'0','0','x','x','0'},
                {'0','0','0','0','0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(0, 0), new WinterCell(2, 3), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(2, 3), new WinterCell(0, 0), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'x','x','0','0','0'},
                {'x','0','0','x','0'},
                {'0','0','0','0','0'},
                {'0','x','0','0','x'},
                {'0','0','0','x','x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(4, 1), new WinterCell(0, 2), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(0, 3), new WinterCell(4, 0), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'0','0','0','0','x'},
                {'0','x','x','0','x'},
                {'0','x','0','0','0'},
                {'0','x','0','x','x'},
                {'0','0','0','x','x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(2, 2), new WinterCell(4, 0), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(2, 4), new WinterCell(0, 1), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'0','0','0','0','x'},
                {'0','x','x','x','x'},
                {'0','0','x','0','x'},
                {'x','0','0','0','0'},
                {'x','x','0','0','x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(3, 4), new WinterCell(0, 3), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(0, 3), new WinterCell(3, 4), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'0','0','0','0','0'},
                {'0','0','0','x','0'},
                {'x','x','0','x','x'},
                {'0','0','0','0','0'},
                {'0','0','0','x','0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(1, 4), new WinterCell(4, 4), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(4, 4), new WinterCell(1, 4), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'0','0','0','0','x'},
                {'0','x','0','x','x'},
                {'0','0','0','0','0'},
                {'x','x','x','0','0'},
                {'0','0','0','0','0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(1, 0), new WinterCell(4, 3), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(1, 2), new WinterCell(4, 0), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'x','0','x','0','x'},
                {'0','0','0','0','0'},
                {'x','0','x','0','x'},
                {'0','0','0','0','x'},
                {'0','0','x','0','0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(4, 3), new WinterCell(1, 4), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(0, 1), new WinterCell(4, 4), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'0','0','0','0','0'},
                {'x','0','x','0','0'},
                {'0','0','x','0','0'},
                {'0','0','0','0','0'},
                {'0','0','x','x','x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(4, 0), new WinterCell(4, 1), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(4, 1), new WinterCell(4, 0), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'0','0','0','0','0'},
                {'0','0','0','x','x'},
                {'0','x','0','x','0'},
                {'0','0','0','0','0'},
                {'x','x','0','x','x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(0, 4), new WinterCell(4, 2), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(4, 2), new WinterCell(0, 4), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'x','x','x','x','x','x','x'},
                {'x','x','x','x','x','x','x'},
                {'x','0','x','x','x','0','x'},
                {'0','0','0','0','0','0','0'},
                {'x','x','x','0','x','0','0'},
                {'x','x','x','x','x','x','x'},
                {'x','x','x','x','x','x','x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(2, 1), new WinterCell(4, 6), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(4, 3), new WinterCell(3, 6), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'x','0','0','0','x'},
                {'0','0','0','x','x'},
                {'0','x','0','0','0'},
                {'0','0','0','0','x'},
                {'x','x','0','x','x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(2, 4), new WinterCell(4, 2), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(0, 3), new WinterCell(2, 2), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'x','x','x','x','x','x'},
                {'x','0','0','x','x','0'},
                {'0','0','0','0','x','0'},
                {'0','x','0','0','0','0'},
                {'0','x','x','0','0','0'},
                {'x','x','x','x','x','x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(4, 0), new WinterCell(2, 3), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(1, 5), new WinterCell(2, 2), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'0','0','x','0','0'},
                {'0','0','0','0','0'},
                {'x','0','x','x','0'},
                {'0','0','0','x','0'},
                {'x','0','0','x','0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(3, 0), new WinterCell(4, 1), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(4, 4), new WinterCell(4, 2), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'x','x','0','x','0'},
                {'0','x','0','0','0'},
                {'0','0','0','0','x'},
                {'x','0','0','0','0'},
                {'0','0','x','0','x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(3, 1), new WinterCell(0, 2), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(2, 3), new WinterCell(4, 1), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'x','x','x','0','x','x','x'},
                {'x','0','0','0','0','x','x'},
                {'0','0','x','0','x','x','x'},
                {'0','0','0','0','0','0','0'},
                {'x','x','x','0','x','0','0'},
                {'x','x','0','0','0','0','x'},
                {'x','x','x','0','x','x','x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(5, 2), new WinterCell(6, 3), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(1, 4), new WinterCell(5, 2), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'0','0','x','x','0','x'},
                {'0','0','0','x','0','x'},
                {'x','0','0','x','0','x'},
                {'0','0','0','0','0','0'},
                {'x','x','0','0','x','x'},
                {'x','0','0','x','x','x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(5, 1), new WinterCell(3, 0), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(0, 4), new WinterCell(3, 4), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'x','x','0','0','0','x'},
                {'0','0','0','x','0','0'},
                {'x','0','0','0','0','0'},
                {'x','x','0','0','0','x'},
                {'x','0','0','0','0','0'},
                {'x','0','0','0','x','x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(4, 1), new WinterCell(5, 3), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(4, 5), new WinterCell(4, 4), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'0','x','x','0','0','x'},
                {'0','0','0','0','0','0'},
                {'0','x','x','x','x','x'},
                {'0','x','x','x','0','x'},
                {'0','0','x','0','0','0'},
                {'x','0','0','0','0','x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(0, 3), new WinterCell(4, 0), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(0, 4), new WinterCell(4, 5), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'x','x','0','0','x','x'},
                {'x','x','0','0','x','x'},
                {'0','x','0','0','x','0'},
                {'0','x','x','0','0','0'},
                {'0','0','x','0','0','0'},
                {'0','0','0','0','0','x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(4, 1), new WinterCell(1, 2), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(2, 5), new WinterCell(2, 2), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'0','0','0','x','0','0'},
                {'0','x','0','x','0','0'},
                {'0','0','0','0','0','0'},
                {'0','0','0','x','x','x'},
                {'x','0','0','0','0','0'},
                {'x','0','0','x','0','0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(5, 4), new WinterCell(0, 5), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(5, 5), new WinterCell(2, 5), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'0','0','0','x','0','0'},
                {'0','0','0','0','0','0'},
                {'0','x','0','x','0','0'},
                {'0','0','0','0','0','x'},
                {'x','0','0','x','0','0'},
                {'x','x','x','x','0','0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(0, 4), new WinterCell(0, 5), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(0, 5), new WinterCell(0, 4), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'0','x','0','0','0'},
                {'0','x','x','0','0'},
                {'0','0','0','0','x'},
                {'x','0','0','0','0'},
                {'0','0','x','0','0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(0, 2), new WinterCell(4, 0), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(4, 4), new WinterCell(0, 0), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'0','0','0','x','x','x'},
                {'0','0','0','0','0','0'},
                {'x','0','0','0','0','0'},
                {'0','0','0','0','x','x'},
                {'0','x','x','0','0','x'},
                {'x','x','x','0','0','0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(0, 0), new WinterCell(1, 5), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(1, 0), new WinterCell(2, 5), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'0','0','0','x','x','x'},
                {'0','0','x','x','0','0'},
                {'0','0','0','0','0','0'},
                {'0','x','0','x','0','x'},
                {'0','0','0','0','0','0'},
                {'x','0','0','x','0','0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(1, 5), new WinterCell(2, 5), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(0, 2), new WinterCell(4, 5), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'0','0','0','0','0','x'},
                {'x','0','x','x','0','x'},
                {'0','0','0','x','0','x'},
                {'x','0','0','0','0','0'},
                {'0','0','0','x','x','x'},
                {'0','0','0','0','0','x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(3, 5), new WinterCell(3, 4), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(2, 0), new WinterCell(5, 4), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'0','0','0','0','x','x','0'},
                {'0','x','x','0','0','0','0'},
                {'0','x','0','0','0','x','x'},
                {'0','0','0','x','0','x','x'},
                {'0','0','0','0','0','0','x'},
                {'x','0','x','0','0','0','0'},
                {'x','0','0','0','x','x','x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(0, 6), new WinterCell(4, 2), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(5, 6), new WinterCell(5, 4), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new int[][] {
                {'x','x','x','0','0','0'},
                {'0','0','x','0','x','0'},
                {'0','0','0','0','0','0'},
                {'x','0','x','0','x','x'},
                {'0','0','0','0','0','x'},
                {'0','0','z','0','x','x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(5, 3), new WinterCell(4, 0), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(4, 4), new WinterCell(2, 0), WinterCell.ColorCube.BLUE));
        levels.add(new LevelContainer(mass, containerCells));
    }

    public ArrayList<LevelContainer> getLevels() {
        return levels;
    }
}