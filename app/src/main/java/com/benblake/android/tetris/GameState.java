package com.benblake.android.tetris;

import android.content.Context;
import android.graphics.Point;

import com.benblake.android.tetris.widgets.Block;
import com.benblake.android.tetris.widgets.BlockHolder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by benblake on 2017-05-29.
 */

public class GameState {
    private static GameState sGameState;

    private int mNx;
    private int mNy;
    private BlockHolder mBlockHolder = null;
    private List<Integer> gridState = null;
    private Brick mCurrentBrick = null;
    private Point mCurrentBrickLocation = null;
    private Context mContext = null;

    private GameState() {

    }

    public static GameState getInstance() {
        if (sGameState == null) {
            sGameState =  new GameState();
        }
        return sGameState;
    }

    public void initializeGrid(BlockHolder blockHolder, Context context) {
        mNx = blockHolder.getNx();
        mNy = blockHolder.getNy();
        mBlockHolder = blockHolder;
        mContext = context;
        gridState = new ArrayList<>(Collections.nCopies(mNx * mNy, Block.COLOR_BACKGROUND));

        for (int i = 0; i < gridState.size(); i++) {
            mBlockHolder.setBlockVisibility(i, gridState.get(i));
        }
    }

    public void reset() {
        gridState = new ArrayList<>(Collections.nCopies(mNx * mNy, Block.COLOR_BACKGROUND));

        for (int i = 0; i < gridState.size(); i++) {
            mBlockHolder.setBlockVisibility(i, gridState.get(i));
        }
    }

    public void setupNewBrick() {
        mCurrentBrick = new Brick(ThreadLocalRandom.current().nextInt(0, 7));
        mCurrentBrickLocation = mCurrentBrick.getStartPoint();
        updateBrickDisplay();
    }

    public void updateBrickDisplay() {
        List<Point> brickPoints = mCurrentBrick.getBrickPoints();
        for (Point p : brickPoints) {
            int index = toIndex(mCurrentBrickLocation.x + p.x, mCurrentBrickLocation.y + p.y);
            gridState.set(index, mCurrentBrick.getColor());
            mBlockHolder.setBlockVisibility(index, gridState.get(index));
        }
    }

    public void updateCompleteDisplay() {
        for (int i = 0; i < mNx; i++) {
            for (int j = 0; j < mNy; j++) {
                int index = toIndex(i, j);
                mBlockHolder.setBlockVisibility(index, gridState.get(index));
            }
        }
    }

    private void makeBrickInvisible() {
        List<Point> brickPoints = mCurrentBrick.getBrickPoints();
        for (Point p : brickPoints) {
            int index = toIndex(mCurrentBrickLocation.x + p.x, mCurrentBrickLocation.y + p.y);
            gridState.set(index, Block.COLOR_BACKGROUND);
            mBlockHolder.setBlockVisibility(index, gridState.get(index));
        }
    }

    public void moveBrickDown() {
        Point translation = new Point(mCurrentBrickLocation.x, mCurrentBrickLocation.y + 1);
        makeBrickInvisible();
        if (validConfiguration(translation, mCurrentBrick.getBrickPoints())) {
            mCurrentBrickLocation.set(translation.x, translation.y);
        } else if (brickAtTop()) {
            ((MainActivity) mContext).gameOver();
        } else {
            updateBrickDisplay();
            removeRows();
            setupNewBrick();
        }
        updateBrickDisplay();
    }

    public void moveBrickLeft() {
        Point translation = new Point(mCurrentBrickLocation.x - 1, mCurrentBrickLocation.y);
        makeBrickInvisible();
        if (validConfiguration(translation, mCurrentBrick.getBrickPoints())) {
            mCurrentBrickLocation.set(translation.x, translation.y);
        }
        updateBrickDisplay();
    }

    public void moveBrickRight() {
        Point translation = new Point(mCurrentBrickLocation.x + 1, mCurrentBrickLocation.y);
        makeBrickInvisible();
        if (validConfiguration(translation, mCurrentBrick.getBrickPoints())) {
            mCurrentBrickLocation.set(translation.x, translation.y);
        }
        updateBrickDisplay();
    }

    private void removeRows() {
        int row = mNy - 1;
        while (row > 0) {
            if (rowIsFull(row)) {
                moveRowsDown(row);
            } else if (rowIsEmpty(row)) {
                break;
            } else {
                row--;
            }
        }
        updateCompleteDisplay();
    }

    private boolean rowIsFull(int row) {
        for (int col = 0; col < mNx; col++) {
            if (gridState.get(toIndex(col, row)) == Block.COLOR_BACKGROUND) {
                return false;
            }
        }
        return true;
    }

    private boolean rowIsEmpty(int row) {
        for (int col = 0; col < mNx; col++) {
            if (gridState.get(toIndex(col, row)) != Block.COLOR_BACKGROUND) {
                return false;
            }
        }
        return true;
    }

    private void moveRowsDown(int row) {
        while (!rowIsEmpty(row)) {
            for (int col = 0; col < mNx; col++) {
                gridState.set(toIndex(col, row), gridState.get(toIndex(col, row - 1)));
            }
            row--;
        }
    }

    private boolean validConfiguration(Point newLocation, List<Point> brickPoints) {
        for (Point p : brickPoints) {
            int x = newLocation.x + p.x;
            int y = newLocation.y + p.y;

            if (x < 0 || x >= mNx) {
                return false;
            }

            if (y < 0 || y >= mNy) {
                return false;
            }

            if (gridState.get(toIndex(x, y)) != Block.COLOR_BACKGROUND) {
                return false;
            }
        }

        return true;
    }

    private boolean brickAtTop() {
        List<Point> brickPoints = mCurrentBrick.getBrickPoints();
        for (Point p : brickPoints) {
            int y = mCurrentBrickLocation.y + p.y;
            if (y == 0) {
                return true;
            }
        }
        return false;
    }

    public void rotateBrick() {
        List<Point> rotatedBrickPoints = mCurrentBrick.getRotatedBrickPoints();
        makeBrickInvisible();
        if (validConfiguration(mCurrentBrickLocation, rotatedBrickPoints)) {
            mCurrentBrick.rotate();
        }
        updateBrickDisplay();
    }

    private int toIndex(int i, int j) {
        return j * mNx + i;
    }
}
