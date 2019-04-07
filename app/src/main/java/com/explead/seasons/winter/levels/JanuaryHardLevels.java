package com.explead.seasons.winter.levels;

import com.explead.seasons.common.beans.LevelContainer;
import com.explead.seasons.common.logic.ContainerCells;
import com.explead.seasons.winter.logic.WinterCell;

import java.util.ArrayList;

public class JanuaryHardLevels {

    private ArrayList<LevelContainer> levels = new ArrayList<>();

    public JanuaryHardLevels() {

        char[][] mass;
        ArrayList<ContainerCells> containerCells;

        mass = new char[][]{
                {'0', '0', '0', 'd', 'x'},
                {'0', '0', '0', '0', 'd'},
                {'x', 'x', 'x', '0', '0'},
                {'x', '0', '0', '0', '0'},
                {'x', 'x', '0', '0', 'x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(1, 0), new WinterCell(3, 2), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(0, 0), new WinterCell(4, 3), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(1, 1), new WinterCell(3, 4), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'0', '0', '0', 'd'},
                {'x', '0', '0', '0'},
                {'x', '0', '0', '0'},
                {'0', '0', 'u', '0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(1, 2), new WinterCell(0, 2), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(3, 1), new WinterCell(2, 1), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(3, 3), new WinterCell(0, 0), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'r', '0', '0', '0', '0'},
                {'0', '0', 'x', 'd', 'l'},
                {'0', '0', 'x', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', 'x', '0', '0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(3, 0), new WinterCell(4, 4), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(3, 4), new WinterCell(0, 4), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(3, 2), new WinterCell(2, 4), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'x', '0', '0', '0'},
                {'r', '0', '0', '0'},
                {'0', '0', '0', 'l'},
                {'0', '0', '0', 'x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(3, 1), new WinterCell(0, 3), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(3, 2), new WinterCell(0, 2), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(3, 0), new WinterCell(0, 1), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'x', 'x', 'x', 'x', 'x'},
                {'x', '0', 'd', 'x', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', 'x', 'x', '0', '0'},
                {'x', 'x', 'x', 'x', 'x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(3, 4), new WinterCell(2, 1), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(1, 4), new WinterCell(2, 2), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(2, 4), new WinterCell(2, 0), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'x', '0', '0', 'l', 'x'},
                {'0', '0', '0', '0', 'l'},
                {'0', '0', '0', '0', '0'},
                {'r', '0', '0', '0', '0'},
                {'x', 'r', '0', '0', '0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(4, 3), new WinterCell(1, 0), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(4, 2), new WinterCell(3, 4), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(4, 4), new WinterCell(2, 0), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'0', 'd', 'x', 'x', '0', 'd', 'x'},
                {'0', '0', 'd', '0', '0', '0', 'd'},
                {'x', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', 'x'},
                {'x', '0', '0', '0', '0', 'x', 'x'},
                {'x', 'x', '0', '0', 'u', 'x', 'x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(1, 0), new WinterCell(4, 5), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(0, 0), new WinterCell(5, 4), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(5, 1), new WinterCell(3, 6), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'0', '0', '0', 'd', '0'},
                {'0', 'x', '0', '0', 'l'},
                {'0', '0', '0', '0', '0'},
                {'r', '0', '0', 'x', '0'},
                {'0', 'u', '0', '0', '0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(4, 0), new WinterCell(1, 2), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(0, 4), new WinterCell(2, 1), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(2, 2), new WinterCell(0, 0), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'0', '0', 'd', 'x'},
                {'0', '0', '0', '0'},
                {'0', 'u', '0', 'l'},
                {'u', '0', '0', 'x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(3, 1), new WinterCell(0, 0), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(2, 2), new WinterCell(1, 0), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(3, 2), new WinterCell(2, 0), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'0', '0', 'x', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', 'x'},
                {'u', '0', '0', '0', '0'},
                {'0', '0', 'u', '0', '0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(2, 3), new WinterCell(3, 4), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(1, 2), new WinterCell(0, 4), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(2, 2), new WinterCell(4, 4), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'x', 'x', 'd', '0', 'l'},
                {'x', '0', '0', '0', '0'},
                {'0', '0', '0', '0', 'x'},
                {'0', '0', 'x', '0', '0'},
                {'x', 'x', 'x', '0', '0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(1, 2), new WinterCell(3, 4), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(1, 4), new WinterCell(4, 4), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(1, 3), new WinterCell(0, 3), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'0', 'r', '0', '0', '0'},
                {'0', '0', '0', '0', 'l'},
                {'r', '0', '0', '0', '0'},
                {'0', '0', 'x', '0', '0'},
                {'x', 'x', 'x', '0', 'u'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(2, 2), new WinterCell(1, 0), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(0, 4), new WinterCell(1, 2), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(0, 0), new WinterCell(1, 1), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'r', '0', '0', '0', 'x'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', 'x', 'u', '0', 'x'},
                {'0', '0', '0', '0', 'x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(2, 4), new WinterCell(3, 3), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(1, 4), new WinterCell(4, 3), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(2, 1), new WinterCell(4, 0), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'0', '0', '0', '0', '0'},
                {'0', 'x', 'x', '0', '0'},
                {'0', '0', 'x', 'u', '0'},
                {'x', '0', '0', '0', 'l'},
                {'r', '0', '0', '0', 'x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(4, 1), new WinterCell(2, 0), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(4, 2), new WinterCell(4, 3), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(4, 3), new WinterCell(0, 3), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'0', '0', '0', '0', '0'},
                {'0', 'x', '0', '0', '0'},
                {'0', 'x', 'r', '0', 'x'},
                {'u', '0', '0', '0', '0'},
                {'r', '0', '0', '0', '0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(4, 2), new WinterCell(0, 0), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(4, 1), new WinterCell(1, 0), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(4, 3), new WinterCell(0, 2), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'r', '0', '0', '0', '0'},
                {'0', 'x', 'd', '0', 'l'},
                {'0', '0', '0', '0', 'x'},
                {'0', 'r', '0', '0', '0'},
                {'0', 'x', '0', '0', '0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(4, 4), new WinterCell(3, 4), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(3, 4), new WinterCell(3, 2), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(4, 0), new WinterCell(4, 2), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'x', 'd', '0', '0', '0', 'l'},
                {'x', '0', '0', 'l', '0', '0'},
                {'0', '0', 'l', '0', '0', '0'},
                {'0', 'r', '0', '0', '0', 'x'},
                {'0', '0', '0', '0', 'x', 'x'},
                {'x', '0', '0', 'x', 'x', 'x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(4, 3), new WinterCell(0, 2), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(2, 5), new WinterCell(0, 4), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(3, 4), new WinterCell(0, 3), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'x', 'x', '0', '0', 'x'},
                {'r', '0', '0', '0', '0'},
                {'0', 'x', '0', '0', '0'},
                {'0', 'x', 'x', '0', 'u'},
                {'x', '0', '0', 'u', 'x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(3, 0), new WinterCell(0, 3), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(4, 1), new WinterCell(1, 4), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(2, 2), new WinterCell(1, 3), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'d', '0', 'x', 'd', '0'},
                {'0', '0', 'l', '0', '0'},
                {'0', '0', '0', 'l', '0'},
                {'r', '0', '0', '0', '0'},
                {'x', 'x', 'x', '0', 'u'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(0, 4), new WinterCell(0, 4), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(2, 0), new WinterCell(1, 0), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(1, 0), new WinterCell(2, 0), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'x', '0', '0', 'x', 'd', '0'},
                {'0', '0', '0', '0', '0', '0'},
                {'r', '0', '0', 'x', '0', 'x'},
                {'x', '0', 'x', 'x', 'x', 'x'},
                {'x', '0', '0', '0', '0', '0'},
                {'x', 'x', 'x', 'u', '0', '0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(5, 5), new WinterCell(0, 2), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(5, 4), new WinterCell(4, 5), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(1, 0), new WinterCell(0, 5), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'x', 'x', '0', '0', 'x', 'x', 'x'},
                {'x', 'x', '0', '0', '0', 'x', 'x'},
                {'x', '0', '0', 'r', '0', '0', '0'},
                {'0', '0', 'u', 'x', 'd', '0', '0'},
                {'0', '0', '0', 'l', '0', '0', 'x'},
                {'x', 'x', '0', '0', '0', 'x', 'x'},
                {'x', 'x', 'x', '0', '0', 'x', 'x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(2, 4), new WinterCell(6, 4), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(4, 2), new WinterCell(6, 3), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(3, 3), new WinterCell(3, 6), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'x', 'x', 'x', 'd', 'x', 'x'},
                {'0', '0', 'x', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0'},
                {'x', '0', '0', 'l', 'x', 'x'},
                {'x', '0', 'u', '0', '0', 'x'},
                {'x', 'u', 'x', '0', 'x', 'x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(5, 3), new WinterCell(1, 0), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(4, 4), new WinterCell(2, 2), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(4, 3), new WinterCell(3, 1), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'0', '0', '0', 'x', '0', 'x'},
                {'0', '0', '0', 'l', '0', '0'},
                {'x', 'x', 'u', 'x', 'x', '0'},
                {'x', 'x', '0', 'l', '0', '0'},
                {'0', '0', '0', 'x', 'x', 'x'},
                {'0', '0', '0', '0', 'x', 'x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(4, 0), new WinterCell(5, 3), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(5, 0), new WinterCell(0, 2), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(0, 4), new WinterCell(0, 0), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'0', '0', 'x', 'x', '0', 'x'},
                {'0', '0', '0', 'd', '0', '0'},
                {'x', '0', 'x', '0', 'x', '0'},
                {'x', '0', '0', '0', 'x', '0'},
                {'0', '0', 'x', 'x', 'x', '0'},
                {'x', 'u', '0', '0', '0', '0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(5, 2), new WinterCell(3, 1), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(5, 3), new WinterCell(3, 3), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(5, 4), new WinterCell(3, 2), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'0', '0', 'x', '0', '0'},
                {'0', '0', 'r', '0', '0'},
                {'x', '0', 'x', '0', 'x'},
                {'0', '0', 'l', '0', '0'},
                {'0', '0', 'x', '0', '0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(4, 3), new WinterCell(4, 0), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(3, 4), new WinterCell(4, 1), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(4, 4), new WinterCell(3, 0), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'x', 'x', 'r', '0', '0', '0', 'x'},
                {'x', '0', '0', 'x', 'x', 'd', 'x'},
                {'0', '0', '0', 'x', 'x', '0', 'x'},
                {'x', 'u', 'x', 'x', '0', '0', '0'},
                {'x', '0', 'x', 'x', '0', '0', '0'},
                {'r', '0', '0', 'x', 'x', 'x', 'x'},
                {'x', '0', '0', '0', 'l', 'x', 'x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(6, 3), new WinterCell(3, 5), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(6, 2), new WinterCell(2, 5), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(5, 2), new WinterCell(4, 5), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'x', 'x', '0', '0', 'x'},
                {'x', '0', '0', '0', 'x'},
                {'r', '0', '0', 'x', 'x'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', 'l', 'x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(3, 4), new WinterCell(3, 0), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(0, 2), new WinterCell(3, 1), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(0, 3), new WinterCell(0, 2), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'x', '0', '0', 'x', '0', '0', 'x'},
                {'0', '0', '0', 'd', '0', '0', 'x'},
                {'0', '0', '0', '0', '0', '0', 'x'},
                {'x', 'u', 'x', '0', '0', '0', 'x'},
                {'x', '0', '0', '0', 'x', '0', '0'},
                {'x', '0', '0', 'x', 'x', '0', '0'},
                {'0', '0', '0', 'r', '0', '0', '0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(3, 4), new WinterCell(3, 4), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(5, 2), new WinterCell(6, 2), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(5, 5), new WinterCell(0, 1), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'0', '0', 'x', '0', '0', 'x', 'x'},
                {'0', '0', '0', '0', '0', 'x', 'x'},
                {'r', '0', '0', 'x', '0', '0', '0'},
                {'x', '0', '0', 'd', '0', 'x', '0'},
                {'x', '0', 'x', '0', 'x', 'x', '0'},
                {'0', '0', 'r', '0', '0', '0', '0'},
                {'x', '0', 'x', '0', '0', '0', '0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(3, 2), new WinterCell(2, 2), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(3, 4), new WinterCell(5, 0), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(4, 3), new WinterCell(3, 1), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'0', '0', 'x', '0', '0', '0', '0'},
                {'0', '0', '0', '0', 'x', '0', '0'},
                {'0', '0', '0', '0', 'x', 'd', 'x'},
                {'u', 'x', 'x', 'd', 'x', '0', '0'},
                {'0', '0', '0', '0', 'x', '0', '0'},
                {'x', '0', '0', '0', 'l', '0', '0'},
                {'x', 'x', '0', '0', 'x', '0', '0'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(6, 2), new WinterCell(0, 3), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(4, 2), new WinterCell(4, 1), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(5, 2), new WinterCell(3, 6), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));

        mass = new char[][]{
                {'x', 'x', '0', '0', '0', 'l', '0', '0'},
                {'0', '0', '0', 'r', '0', '0', '0', '0'},
                {'0', '0', 'x', 'x', 'u', 'x', '0', '0'},
                {'0', '0', 'r', '0', '0', 'x', 'u', 'x'},
                {'x', 'd', 'x', '0', '0', 'l', '0', '0'},
                {'0', '0', 'x', 'd', 'x', 'x', '0', '0'},
                {'0', '0', '0', '0', 'l', '0', '0', '0'},
                {'0', '0', 'r', '0', '0', '0', 'x', 'x'}
        };
        containerCells = new ArrayList<>();
        containerCells.add(new ContainerCells(new WinterCell(7, 0), new WinterCell(4, 3), WinterCell.ColorCube.RED));
        containerCells.add(new ContainerCells(new WinterCell(5, 0), new WinterCell(2, 0), WinterCell.ColorCube.BLUE));
        containerCells.add(new ContainerCells(new WinterCell(6, 0), new WinterCell(3, 4), WinterCell.ColorCube.YELLOW));
        levels.add(new LevelContainer(mass, containerCells));
    }

    public ArrayList<LevelContainer> getLevels() {
        return levels;
    }
}
