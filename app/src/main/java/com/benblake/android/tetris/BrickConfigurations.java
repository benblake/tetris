package com.benblake.android.tetris;

import android.graphics.Point;

import com.benblake.android.tetris.widgets.Block;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by benblake on 2017-06-01.
 */

public class BrickConfigurations {

    public static final ArrayList<ArrayList<ArrayList<Point>>> BRICK_POINTS = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList(
                    new ArrayList<>(Arrays.asList(
                            new Point(0, 0),
                            new Point(1, 0),
                            new Point(2, 0),
                            new Point(1, -1)
                    )),
                    new ArrayList<>(Arrays.asList(
                            new Point(1, -1),
                            new Point(1, 0),
                            new Point(1, 1),
                            new Point(2, 0)
                    )),
                    new ArrayList<>(Arrays.asList(
                            new Point(0, 0),
                            new Point(1, 0),
                            new Point(2, 0),
                            new Point(1, 1)
                    )),
                    new ArrayList<>(Arrays.asList(
                            new Point(1, -1),
                            new Point(1, 0),
                            new Point(1, 1),
                            new Point(0, 0)
                    ))
            )),
            new ArrayList<>(Arrays.asList(
                    new ArrayList<>(Arrays.asList(
                            new Point(0, -1),
                            new Point(1, -1),
                            new Point(2, -1),
                            new Point(0, 0)
                    )),
                    new ArrayList<>(Arrays.asList(
                            new Point(0, -2),
                            new Point(1, -2),
                            new Point(1, -1),
                            new Point(1, 0)
                    )),
                    new ArrayList<>(Arrays.asList(
                            new Point(0, -1),
                            new Point(1, -1),
                            new Point(2, -1),
                            new Point(2, -2)
                    )),
                    new ArrayList<>(Arrays.asList(
                            new Point(1, -2),
                            new Point(1, -1),
                            new Point(1, 0),
                            new Point(2, 0)
                    ))
            )),
            new ArrayList<>(Arrays.asList(
                    new ArrayList<>(Arrays.asList(
                            new Point(0, -1),
                            new Point(1, -1),
                            new Point(2, -1),
                            new Point(2, 0)
                    )),
                    new ArrayList<>(Arrays.asList(
                            new Point(0, 0),
                            new Point(1, 0),
                            new Point(1, -1),
                            new Point(1, -2)
                    )),
                    new ArrayList<>(Arrays.asList(
                            new Point(0, -2),
                            new Point(0, -1),
                            new Point(1, -1),
                            new Point(2, -1)
                    )),
                    new ArrayList<>(Arrays.asList(
                            new Point(1, 0),
                            new Point(1, -1),
                            new Point(1, -2),
                            new Point(2, -2)
                    ))
            )),
            new ArrayList<>(Arrays.asList(
                    new ArrayList<>(Arrays.asList(
                            new Point(0, 0),
                            new Point(1, 0),
                            new Point(1, -1),
                            new Point(2, -1)
                    )),
                    new ArrayList<>(Arrays.asList(
                            new Point(2, 0),
                            new Point(2, -1),
                            new Point(1, -1),
                            new Point(1, -2)
                    ))
            )),
            new ArrayList<>(Arrays.asList(
                    new ArrayList<>(Arrays.asList(
                            new Point(0, -1),
                            new Point(1, -1),
                            new Point(1, 0),
                            new Point(2, 0)
                    )),
                    new ArrayList<>(Arrays.asList(
                            new Point(1, 0),
                            new Point(1, -1),
                            new Point(2, -1),
                            new Point(2, -2)
                    ))
            )),
            new ArrayList<>(Arrays.asList(
                    new ArrayList<>(Arrays.asList(
                            new Point(0, 0),
                            new Point(0, -1),
                            new Point(1, 0),
                            new Point(1, -1)
                    ))
            )),
            new ArrayList<>(Arrays.asList(
                    new ArrayList<>(Arrays.asList(
                            new Point(0, 0),
                            new Point(1, 0),
                            new Point(2, 0),
                            new Point(3, 0)
                    )),
                    new ArrayList<>(Arrays.asList(
                            new Point(1, -1),
                            new Point(1, 0),
                            new Point(1, 1),
                            new Point(1, 2)
                    ))
            ))
    ));

    public static final ArrayList<Point> BRICK_LOCATIONS = new ArrayList<>(Arrays.asList(
            new Point(3, 1),
            new Point(3, 1),
            new Point(3, 1),
            new Point(3, 1),
            new Point(3, 1),
            new Point(4, 1),
            new Point(3, 0)
    ));

    public static final ArrayList<Integer> BRICK_COLORS = new ArrayList<>(Arrays.asList(
            Block.COLOR_YELLOW,
            Block.COLOR_NAVY_BLUE,
            Block.COLOR_PURPLE,
            Block.COLOR_BABY_BLUE,
            Block.COLOR_GREEN,
            Block.COLOR_RED,
            Block.COLOR_ORANGE
    ));

}
