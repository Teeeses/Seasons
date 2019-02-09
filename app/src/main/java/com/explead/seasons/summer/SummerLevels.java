package com.explead.seasons.summer;

import com.explead.seasons.common.beans.LevelContainer;
import com.explead.seasons.common.logic.Cell;
import com.explead.seasons.common.logic.ContainerCells;
import com.explead.seasons.summer.logic.SummerCell;

import java.util.ArrayList;

/**
 * Created by develop on 17.08.2017.
 */

public class SummerLevels {

    private ArrayList<LevelContainer> levels = new ArrayList<>();

    public SummerLevels() {

        int[][] mass;
        ArrayList<ContainerCells> container;


        mass = new int[][] {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 6, 0, 0, 6},
                {0, 6, 6, 0, 0},
                {0, 0, 0, 0, 0}
        };
        container = new ArrayList<>();
        container.add(new ContainerCells(new SummerCell(0, 0), new SummerCell(1, 4), SummerCell.ColorCube.RED));
        container.add(new ContainerCells(new SummerCell(2, 2), new SummerCell(4, 4), SummerCell.ColorCube.BLUE));
        container.add(new ContainerCells(new SummerCell(1, 3), new SummerCell(3, 4), SummerCell.ColorCube.GREEN));
        levels.add(new LevelContainer(mass, container));

        /*
        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 6, 6, 0},
                {0, 0, 0, 0, 0, 6, 6, 0},
                {0, 0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 6, 0},
                {0, 0, 0, 0, 6, 0, 6, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 6, 6}
        };
        container = new ArrayList<>();
        container.add(new ContainerCells(new SummerCell(1, 3), new SummerCell(7, 0), SummerCell.ColorCube.RED));
        container.add(new ContainerCells(new SummerCell(1, 4), new SummerCell(6, 4), SummerCell.ColorCube.BLUE));
        container.add(new ContainerCells(new SummerCell(2, 3), new SummerCell(3, 6), SummerCell.ColorCube.YELLOW));
        container.add(new ContainerCells(new SummerCell(6, 0), new SummerCell(6, 6), SummerCell.ColorCube.GREEN));
        levels.add(new LevelContainer(mass, container));


        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 6, 6, 6, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 6, 6, 6, 0, 0, 6},
                {0, 0, 0, 0, 0, 0, 0, 6}
        };
        container = new ArrayList<>();
        container.add(new ContainerCells(new StartCell(1, 1), new EndCell(3, 6)));
        container.add(new ContainerCells(new StartCell(1, 6), new EndCell(4, 2)));
        container.add(new ContainerCells(new StartCell(0, 3), new EndCell(6, 5)));
        container.add(new ContainerCells(new StartCell(4, 6), new EndCell(7, 0)));
        container.add(new ContainerCells(new StartCell(6, 1), new EndCell(6, 6)));
        levels.add(new LevelContainer(mass, container));


        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 6, 0, 0, 0},
                {0, 6, 6, 0, 6, 0, 0, 0},
                {0, 0, 0, 0, 6, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {6, 6, 0, 0, 0, 0, 0, 0}
        };
        container = new ArrayList<>();
        container.add(new ContainerCells(new StartCell(0, 0), new EndCell(5, 6)));
        container.add(new ContainerCells(new StartCell(1, 6), new EndCell(6, 1)));
        container.add(new ContainerCells(new StartCell(2, 1), new EndCell(7, 7)));
        container.add(new ContainerCells(new StartCell(2, 2), new EndCell(3, 7)));
        container.add(new ContainerCells(new StartCell(5, 1), new EndCell(7, 3)));
        levels.add(new LevelContainer(mass, container));


        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        container = new ArrayList<>();
        container.add(new ContainerCells(new StartCell(1, 1), new EndCell(8, 8)));
        container.add(new ContainerCells(new StartCell(0, 5), new EndCell(7, 3)));
        container.add(new ContainerCells(new StartCell(8, 0), new EndCell(1, 7)));
        container.add(new ContainerCells(new StartCell(4, 3), new EndCell(8, 6)));
        container.add(new ContainerCells(new StartCell(8, 5), new EndCell(8, 7)));
        levels.add(new LevelContainer(mass, container));


        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        container = new ArrayList<>();
        container.add(new ContainerCells(new StartCell(0, 0), new EndCell(6, 0)));
        container.add(new ContainerCells(new StartCell(1, 0), new EndCell(1, 5)));
        container.add(new ContainerCells(new StartCell(3, 1), new EndCell(3, 6)));
        container.add(new ContainerCells(new StartCell(5, 0), new EndCell(5, 5)));
        levels.add(new LevelContainer(mass, container));

        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 6, 0, 0, 0, 0, 0},
                {0, 0, 0, 6, 0, 0, 0}
        };
        container = new ArrayList<>();
        container.add(new ContainerCells(new StartCell(1, 1), new EndCell(1, 5)));
        container.add(new ContainerCells(new StartCell(6, 0), new EndCell(2, 4)));
        container.add(new ContainerCells(new StartCell(3, 3), new EndCell(2, 6)));
        container.add(new ContainerCells(new StartCell(5, 0), new EndCell(5, 5)));
        levels.add(new LevelContainer(mass, container));


        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        container = new ArrayList<>();
        container.add(new ContainerCells(new StartCell(2, 1), new EndCell(4, 7)));
        container.add(new ContainerCells(new StartCell(4, 1), new EndCell(6, 7)));
        container.add(new ContainerCells(new StartCell(6, 1), new EndCell(2, 7)));
        container.add(new ContainerCells(new StartCell(2, 4), new EndCell(6, 4)));
        container.add(new ContainerCells(new StartCell(4, 4), new EndCell(8, 4)));
        levels.add(new LevelContainer(mass, container));


        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        container = new ArrayList<>();
        container.add(new ContainerCells(new StartCell(1, 1), new EndCell(1, 7)));
        container.add(new ContainerCells(new StartCell(3, 0), new EndCell(3, 6)));
        container.add(new ContainerCells(new StartCell(3, 2), new EndCell(3, 4)));
        container.add(new ContainerCells(new StartCell(7, 0), new EndCell(0, 7)));
        container.add(new ContainerCells(new StartCell(4, 0), new EndCell(4, 6)));
        levels.add(new LevelContainer(mass, container));

        mass = new int[][] {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };
        container = new ArrayList<>();
        container.add(new ContainerCells(new StartCell(5, 0), new EndCell(0, 5)));
        container.add(new ContainerCells(new StartCell(2, 2), new EndCell(2, 5)));
        container.add(new ContainerCells(new StartCell(0, 4), new EndCell(4, 4)));
        levels.add(new LevelContainer(mass, container));

        mass = new int[][] {
                {6, 6, 6, 0, 0, 0, 0, 0, 6},
                {6, 6, 6, 0, 0, 0, 0, 0, 6},
                {6, 6, 6, 0, 0, 0, 0, 0, 6},
                {0, 0, 0, 0, 0, 0, 0, 0, 6},
                {0, 0, 0, 0, 0, 0, 0, 0, 6},
                {0, 0, 0, 0, 0, 0, 0, 6, 6},
                {6, 6, 6, 0, 0, 0, 0, 6, 6},
                {6, 6, 6, 0, 0, 0, 0, 6, 6},
                {6, 6, 6, 0, 0, 0, 6, 6, 6}
        };
        container = new ArrayList<>();
        container.add(new ContainerCells(new StartCell(3, 2), new EndCell(5, 2)));
        container.add(new ContainerCells(new StartCell(4, 1), new EndCell(4, 7)));
        container.add(new ContainerCells(new StartCell(1, 4), new EndCell(7, 5)));
        container.add(new ContainerCells(new StartCell(1, 5), new EndCell(7, 4)));
        container.add(new ContainerCells(new StartCell(1, 6), new EndCell(7, 6)));
        levels.add(new LevelContainer(mass, container));


        mass = new int[][] {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 6, 0},
                {0, 0, 6, 0, 0, 0},
                {6, 0, 0, 0, 0, 6},
                {6, 0, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };
        container = new ArrayList<>();
        container.add(new ContainerCells(new StartCell(5, 0), new EndCell(4, 4)));
        container.add(new ContainerCells(new StartCell(1, 1), new EndCell(3, 2)));
        container.add(new ContainerCells(new StartCell(4, 2), new EndCell(4, 5)));
        levels.add(new LevelContainer(mass, container));

        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 0},
                {0, 6, 0, 0, 0, 0, 0},
                {0, 6, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        container = new ArrayList<>();
        container.add(new ContainerCells(new StartCell(4, 3), new EndCell(1, 4)));
        container.add(new ContainerCells(new StartCell(2, 5), new EndCell(3, 2)));
        container.add(new ContainerCells(new StartCell(4, 2), new EndCell(4, 5)));
        container.add(new ContainerCells(new StartCell(0, 2), new EndCell(4, 4)));
        levels.add(new LevelContainer(mass, container));

        mass = new int[][] {
                {0, 0, 0, 6, 6, 0, 0, 0},
                {0, 6, 0, 0, 0, 0, 6, 0},
                {0, 6, 6, 0, 0, 0, 0, 0},
                {0, 6, 6, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 6, 6, 6, 6, 6}
        };
        container = new ArrayList<>();
        container.add(new ContainerCells(new StartCell(6, 0), new EndCell(5, 6)));
        container.add(new ContainerCells(new StartCell(6, 1), new EndCell(2, 4)));
        container.add(new ContainerCells(new StartCell(4, 1), new EndCell(2, 6)));
        container.add(new ContainerCells(new StartCell(2, 3), new EndCell(6, 4)));
        levels.add(new LevelContainer(mass, container));

        mass = new int[][] {
                {0, 0, 0, 6, 6, 6, 6, 6},
                {0, 0, 0, 0, 0, 0, 0, 6},
                {0, 0, 6, 6, 6, 0, 6, 6},
                {0, 0, 0, 0, 0, 0, 6, 6},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 6, 6, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 6, 6, 6, 6}
        };
        container = new ArrayList<>();
        container.add(new ContainerCells(new StartCell(3, 2), new EndCell(2, 5)));
        container.add(new ContainerCells(new StartCell(5, 6), new EndCell(1, 1)));
        container.add(new ContainerCells(new StartCell(5, 1), new EndCell(1, 6)));
        container.add(new ContainerCells(new StartCell(4, 3), new EndCell(6, 0)));
        levels.add(new LevelContainer(mass, container));

        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 6},
                {0, 0, 0, 0, 0, 0, 0, 6},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 6, 6, 6, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 6, 6, 6, 6, 0},
                {0, 6, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        container = new ArrayList<>();
        container.add(new ContainerCells(new StartCell(1, 1), new EndCell(6, 6)));
        container.add(new ContainerCells(new StartCell(4, 0), new EndCell(2, 7)));
        container.add(new ContainerCells(new StartCell(5, 1), new EndCell(1, 5)));
        container.add(new ContainerCells(new StartCell(0, 3), new EndCell(4, 6)));
        levels.add(new LevelContainer(mass, container));

        mass = new int[][] {
                {6, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 6, 6, 0, 0, 6, 0},
                {0, 6, 6, 0, 0, 6, 6, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 6, 6, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 6, 6, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 6}
        };
        container = new ArrayList<>();
        container.add(new ContainerCells(new StartCell(3, 1), new EndCell(0, 4)));
        container.add(new ContainerCells(new StartCell(5, 2), new EndCell(1, 5)));
        container.add(new ContainerCells(new StartCell(5, 0), new EndCell(4, 5)));
        container.add(new ContainerCells(new StartCell(0, 3), new EndCell(6, 5)));
        levels.add(new LevelContainer(mass, container));

        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 6, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 6, 6},
                {0, 0, 6, 6, 0, 0, 6, 6},
                {0, 0, 6, 6, 0, 0, 0, 6},
                {6, 0, 0, 0, 0, 0, 0, 6}
        };
        container = new ArrayList<>();
        container.add(new ContainerCells(new StartCell(4, 3), new EndCell(7, 6)));
        container.add(new ContainerCells(new StartCell(6, 6), new EndCell(3, 4)));
        container.add(new ContainerCells(new StartCell(2, 1), new EndCell(0, 7)));
        container.add(new ContainerCells(new StartCell(5, 5), new EndCell(2, 2)));
        container.add(new ContainerCells(new StartCell(6, 0), new EndCell(2, 6)));
        levels.add(new LevelContainer(mass, container));

        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 6},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 6, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        container = new ArrayList<>();
        container.add(new ContainerCells(new StartCell(1, 7), new EndCell(1, 5)));
        container.add(new ContainerCells(new StartCell(4, 4), new EndCell(1, 6)));
        container.add(new ContainerCells(new StartCell(6, 1), new EndCell(0, 7)));
        container.add(new ContainerCells(new StartCell(3, 3), new EndCell(5, 4)));
        container.add(new ContainerCells(new StartCell(0, 1), new EndCell(4, 6)));
        levels.add(new LevelContainer(mass, container));

        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 6, 6, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 6, 6},
                {0, 0, 0, 0, 0, 0, 6, 6}
        };
        container = new ArrayList<>();
        container.add(new ContainerCells(new StartCell(7, 2), new EndCell(0, 7)));
        container.add(new ContainerCells(new StartCell(6, 5), new EndCell(2, 4)));
        container.add(new ContainerCells(new StartCell(5, 2), new EndCell(3, 5)));
        container.add(new ContainerCells(new StartCell(4, 7), new EndCell(6, 4)));
        container.add(new ContainerCells(new StartCell(3, 7), new EndCell(6, 2)));
        levels.add(new LevelContainer(mass, container));

        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 6, 0, 0, 0, 6, 6, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 6, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 6, 0, 0, 0}
        };
        container = new ArrayList<>();
        container.add(new ContainerCells(new StartCell(1, 7), new EndCell(7, 7)));
        container.add(new ContainerCells(new StartCell(0, 8), new EndCell(4, 7)));
        container.add(new ContainerCells(new StartCell(3, 0), new EndCell(3, 7)));
        container.add(new ContainerCells(new StartCell(1, 4), new EndCell(5, 7)));
        container.add(new ContainerCells(new StartCell(2, 1), new EndCell(8, 4)));
        levels.add(new LevelContainer(mass, container));

        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 6, 0, 0, 0, 0, 0, 0},
                {0, 6, 0, 6, 6, 6, 6, 0},
                {0, 0, 0, 0, 0, 6, 0, 0},
                {0, 0, 6, 6, 0, 6, 0, 0},
                {0, 0, 6, 6, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        container = new ArrayList<>();
        container.add(new ContainerCells(new StartCell(1, 6), new EndCell(5, 4)));
        container.add(new ContainerCells(new StartCell(3, 1), new EndCell(6, 5)));
        container.add(new ContainerCells(new StartCell(5, 0), new EndCell(4, 7)));
        container.add(new ContainerCells(new StartCell(4, 0), new EndCell(6, 6)));
        levels.add(new LevelContainer(mass, container));

        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 6, 6},
                {0, 6, 0, 0, 6, 0, 0, 0},
                {0, 6, 0, 0, 6, 0, 0, 0},
                {0, 0, 0, 6, 6, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        container = new ArrayList<>();
        container.add(new ContainerCells(new StartCell(6, 1), new EndCell(3, 5)));
        container.add(new ContainerCells(new StartCell(1, 2), new EndCell(6, 5)));
        container.add(new ContainerCells(new StartCell(1, 6), new EndCell(6, 3)));
        container.add(new ContainerCells(new StartCell(3, 1), new EndCell(6, 6)));
        levels.add(new LevelContainer(mass, container));

        mass = new int[][] {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };
        container = new ArrayList<>();
        container.add(new ContainerCells(new StartCell(4, 1), new EndCell(1, 4)));
        container.add(new ContainerCells(new StartCell(1, 1), new EndCell(4, 4)));
        container.add(new ContainerCells(new StartCell(1, 0), new EndCell(2, 4)));
        container.add(new ContainerCells(new StartCell(3, 3), new EndCell(5, 3)));
        levels.add(new LevelContainer(mass, container));

        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 6, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        container = new ArrayList<>();
        container.add(new ContainerCells(new StartCell(3, 1), new EndCell(6, 7)));
        container.add(new ContainerCells(new StartCell(0, 0), new EndCell(3, 5)));
        container.add(new ContainerCells(new StartCell(0, 1), new EndCell(7, 7)));
        container.add(new ContainerCells(new StartCell(1, 5), new EndCell(5, 2)));
        levels.add(new LevelContainer(mass, container));

        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 6, 6, 0},
                {0, 0, 0, 0, 0, 6, 6, 0},
                {0, 0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 6, 0},
                {0, 0, 0, 0, 6, 0, 6, 0},
                {0, 0, 0, 0, 0, 0, 6, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        container = new ArrayList<>();
        container.add(new ContainerCells(new StartCell(7, 0), new EndCell(1, 3)));
        container.add(new ContainerCells(new StartCell(2, 3), new EndCell(3, 6)));
        container.add(new ContainerCells(new StartCell(1, 4), new EndCell(6, 4)));
        container.add(new ContainerCells(new StartCell(6, 0), new EndCell(7, 6)));
        levels.add(new LevelContainer(mass, container));

        mass = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 6, 6, 6, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 6, 6, 6, 0, 6, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        container = new ArrayList<>();
        container.add(new ContainerCells(new StartCell(1, 6), new EndCell(4, 3)));
        container.add(new ContainerCells(new StartCell(0, 3), new EndCell(6, 5)));
        container.add(new ContainerCells(new StartCell(6, 1), new EndCell(6, 7)));
        container.add(new ContainerCells(new StartCell(1, 1), new EndCell(3, 6)));
        container.add(new ContainerCells(new StartCell(7, 0), new EndCell(4, 6)));
        levels.add(new LevelContainer(mass, container));

        */
    }

    public ArrayList<LevelContainer> getLevels() {
        return levels;
    }
}
