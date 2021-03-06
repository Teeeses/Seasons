package com.explead.seasons.winter.logic;

import com.explead.seasons.common.app.App;
import com.explead.seasons.common.beans.AllLevels;
import com.explead.seasons.common.logic.Direction;
import com.explead.seasons.winter.interfaces.OnActionMoveCubeListener;
import com.explead.seasons.winter.interfaces.OnMoveCubeCallback;

import java.util.ArrayList;

/**
 * Created by Александр on 09.07.2017.
 */

public class FieldWinter implements OnMoveCubeCallback {

    public interface OnControllerListener {
        void onWin();
        void onFirstMove();
    }

    private OnControllerListener onControllerListener;

    private static final char EMPTY_CELL = '0', WALL_CELL = 'x';

    private int level;
    private WinterCell[][] field;
    private ArrayList<WinterMember> cubes = new ArrayList<>();

    private boolean isCanMove;

    public FieldWinter(int level, AllLevels.Month month, AllLevels.Complication complication) {
        this.level = level;
        this.isCanMove = true;
        LevelContainer container = App.getLevels().get(level - 1, month, complication);
        createField(container.getCopyField());
        addActionCellsOnField(container.getCopyCells());
    }

    private void createField(char[][] mass) {
        field = new WinterCell[mass.length][mass.length];
        for(int i = 0; i < mass.length; i++) {
            for(int j = 0; j < mass.length; j++) {
                WinterCell cell = new WinterCell(i, j);
                if(mass[i][j] == WALL_CELL) {
                    cell.makeWall();
                } else if(mass[i][j] == EMPTY_CELL) {
                    cell.makeEmpty();
                } else {
                    cell.makeArrow(mass[i][j]);
                }
                field[i][j] = cell;
            }
        }
    }

    /**
     * Добавляем стартовые клетки на поле
     * Прибавляем +1 для того, что бы отличить пустые клетки от активной клетки с индексом 0
     */
    private void addActionCellsOnField(ArrayList<ContainerCells> actionCells) {
        for (int i = 0; i < actionCells.size(); i++) {
            Cell cell = actionCells.get(i).getOneCell();
            Cell insideCell = actionCells.get(i).getTwoCell();
            Cell.ColorMember color = actionCells.get(i).getColor();
            WinterMember winterMember = new WinterMember(cell.getX(), cell.getY());
            winterMember.setOnMoveCubeCallback(this);
            WinterInsideCube winterInsideCube = new WinterInsideCube(insideCell.getX(), insideCell.getY(), color);
            winterMember.create(color, winterInsideCube);

            cubes.add(winterMember);
        }
    }

    private boolean canNextMove() {
        for(WinterMember cube: cubes) {
            if(cube.getMOVE()) {
                return false;
            }
        }
        return true;
    }

    private void setDirections(Direction direction) {
        for(WinterMember cube: cubes) {
            cube.setDirection(direction);
        }
    }

    private void setLastInfoCube() {
        for(WinterMember cube: cubes) {
            cube.setLastCoordinate();
            cube.setLastDirection();
        }
    }

    private void moveCubeAnimation() {
        for(WinterMember cube: cubes) {
            cube.move();
        }
    }

    public void move(Direction direction) {
        if(isCanMove) {
            if (canNextMove()) {
                setDirections(direction);
                while (!isEndMove()) {
                    setLastInfoCube();
                    for (WinterMember cube : cubes) {
                        moveCube(cube);
                    }
                    moveCubeAnimation();
                    installDirectionArrows();
                }
                checkWin();
            }
        }
    }

    private WinterCell getNextFieldCell(int x, int y, Direction direction) {
        WinterCell cell = null;
        if(direction == Direction.U) {
            if(x != 0) {
                cell = field[x-1][y];
            }
        } else if(direction == Direction.R) {
            if(y != field.length-1) {
                cell = field[x][y+1];
            }
        } else if(direction == Direction.D) {
            if(x != field.length-1) {
                cell = field[x+1][y];
            }
        } else if(direction == Direction.L) {
            if(y != 0) {
                cell = field[x][y-1];
            }
        }
        return cell;
    }

    private void installDirectionArrows() {
        for (WinterMember cube: cubes) {
            WinterCell winterCell = field[cube.getX()][cube.getY()];
            if(winterCell.getPurpose() == WinterCell.PurposeCell.ARROW) {
                Direction direction = winterCell.getDirection();
                cube.setDirection(direction);

                setDirectionNextCube(cube.getX(), cube.getY(), cube.getDirection());
            }
        }
    }

    private void setDirectionNextCube(int x, int y, Direction direction) {
        WinterCell cell = getNextFieldCell(x, y, direction);
        //Если такая клеткая существет
        if(cell != null) {
            WinterMember nextCube = isCubeOnPlace(cell.getX(), cell.getY());
            if(nextCube != null && nextCube.getDirection() == null) {
                nextCube.setDirection(direction);
                setDirectionNextCube(cell.getX(), cell.getY(), direction);
            }
        }
    }

    private void actionMoveCube(WinterMember cube, WinterMember cubeOnPlace, WinterCell cell,
                                OnActionMoveCubeListener onActionMoveCubeListener) {

        if (cell.getPurpose() == WinterCell.PurposeCell.WALL) {
            onActionMoveCubeListener.onNotMove();
        } else if(cubeOnPlace != null) {
            if(cubeOnPlace.getDirection() == null) {
                onActionMoveCubeListener.onNotMove();
            } else {
                onActionMoveCubeListener.onCubeOnPlace(cubeOnPlace);
            }
        } else {
            if(cell.getPurpose() == WinterCell.PurposeCell.EMPTY) {
                onActionMoveCubeListener.onGoOnCell();
            } else if(cell.getPurpose() == WinterCell.PurposeCell.ARROW) {
                if(cube.getDirection() == cell.getDirection()) {
                    onActionMoveCubeListener.onGoOnCell();
                } else {
                    onActionMoveCubeListener.onArrow();
                }
            }
        }
    }

    private void moveCube(final WinterMember cube) {

        WinterCell cell = getNextFieldCell(cube.getX(), cube.getY(), cube.getDirection());
        if(cell != null) {
            final int x = cell.getX();
            final int y = cell.getY();
            //null - если клетка свободна
            WinterMember cubeOnPlace = isCubeOnPlace(x, y);

            actionMoveCube(cube, cubeOnPlace, cell, new OnActionMoveCubeListener() {
                @Override
                public void onNotMove() {
                    cube.setDirection(null);
                }
                @Override
                public void onGoOnCell() {
                    cube.setCoordinate(x, y);
                    moveCube(cube);
                }

                @Override
                public void onArrow() {
                    cube.setCoordinate(x, y);
                    cube.setDirection(null);
                }

                @Override
                public void onCubeOnPlace(WinterMember cubeOnPlace) {
                    moveCube(cubeOnPlace);
                    moveCube(cube);
                }
            });
        } else {
            cube.setDirection(null);
        }
    }

    private WinterMember isCubeOnPlace(int x, int y) {
        for(WinterMember cube: cubes) {
            if(cube.getX() == x && cube.getY() == y) {
                return cube;
            }
        }
        return null;
    }

    private boolean isEndMove() {
        for(WinterMember cube: cubes) {
            if(cube.getDirection() != null) {
                return false;
            }
        }
        return true;
    }

    private void checkWin() {
        boolean value = true;
        for (int i = 0; i < cubes.size(); i++) {
            WinterMember cube = cubes.get(i);
            if(!cube.isTruePlace()) {
                value = false;
            }
        }
        if(value) {
            setCanMove(false);
            onControllerListener.onWin();
        }
    }

    @Override
    public void onFirstMove() {
        onControllerListener.onFirstMove();
    }

    public int getLevel() {
        return level;
    }

    public WinterCell[][] getField() {
        return field;
    }

    public ArrayList<WinterMember> getCubes() {
        return cubes;
    }

    public int getSizeField() {
        return field.length;
    }

    public void setOnControllerListener(OnControllerListener onControllerListener) {
        this.onControllerListener = onControllerListener;
    }

    public void setCanMove(boolean canMove) {
        isCanMove = canMove;
    }
}
