package com.benblake.android.tetris;

import android.graphics.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by benblake on 2017-05-30.
 */

public class Brick {
    private List<Point> mBlockConfiguration = null;
    private Point mBlockStartPoint = null;
    private int mColor;
    private int mRotationIndex = 0;
    private int mBrickIndex;

    public Brick(int index) {
        mBrickIndex = index;
        mColor = BrickConfigurations.BRICK_COLORS.get(mBrickIndex);
        mBlockConfiguration = new ArrayList<>(BrickConfigurations.BRICK_POINTS.get(mBrickIndex).get(mRotationIndex));
        mBlockStartPoint = new Point(BrickConfigurations.BRICK_LOCATIONS.get(mBrickIndex));
    }

    public int getColor() {
        return mColor;
    }

    public List<Point> getBrickPoints() {
        return mBlockConfiguration;
    }

    public Point getStartPoint() {
        return mBlockStartPoint;
    }

    public List<Point> getRotatedBrickPoints() {
        return BrickConfigurations.BRICK_POINTS.get(mBrickIndex).get((mRotationIndex + 1) % BrickConfigurations.BRICK_POINTS.get(mBrickIndex).size());
    }

    public void rotate() {
        mRotationIndex = (mRotationIndex + 1) % BrickConfigurations.BRICK_POINTS.get(mBrickIndex).size();
        mBlockConfiguration = new ArrayList<>(BrickConfigurations.BRICK_POINTS.get(mBrickIndex).get(mRotationIndex));
    }
}
