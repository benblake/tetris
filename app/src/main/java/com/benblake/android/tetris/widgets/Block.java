package com.benblake.android.tetris.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by benblake on 2017-05-28.
 * Class to describe widget for single Tetris block
 */

public class Block extends View {
    public static final int COLOR_INVISIBLE  = 0;
    public static final int COLOR_BABY_BLUE  = Color.CYAN;
    public static final int COLOR_GREEN      = Color.GREEN;
    public static final int COLOR_NAVY_BLUE  = Color.BLUE;
    public static final int COLOR_ORANGE     = Color.LTGRAY;
    public static final int COLOR_PURPLE     = Color.MAGENTA;
    public static final int COLOR_RED        = Color.RED;
    public static final int COLOR_YELLOW     = Color.YELLOW;
    public static final int COLOR_BACKGROUND = Color.BLACK;

    private static final int ALPHA_INVISIBLE = 0;
    private static final int ALPHA_VISIBLE = 255;

    private int mColor;
    private int mAlpha;
    private int mLeftStart;
    private int mTopStart;
    private int mSize;
    private Paint mPaint;

    public Block(Context context, int color, int leftStart, int topStart, int size) {
        super(context);
        mColor = color;
        mAlpha = ALPHA_INVISIBLE;
        mLeftStart = leftStart;
        mTopStart = topStart;
        mSize = size;
        mPaint = new Paint();
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(mColor);
        mPaint.setAlpha(mAlpha);
        canvas.drawRect(mLeftStart, mTopStart, mLeftStart + mSize, mTopStart + mSize, mPaint);
    }

    public void setBlockVisibility(int visibility) {
        switch (visibility) {
            default:
            case COLOR_INVISIBLE:
                super.setVisibility(View.INVISIBLE);
                mAlpha = ALPHA_INVISIBLE;
                break;
            case COLOR_BABY_BLUE:
                super.setVisibility(View.VISIBLE);
                mColor = COLOR_BABY_BLUE;
                mAlpha = ALPHA_VISIBLE;
                break;
            case COLOR_GREEN:
                super.setVisibility(View.VISIBLE);
                mColor = COLOR_GREEN;
                mAlpha = ALPHA_VISIBLE;
                break;
            case COLOR_NAVY_BLUE:
                super.setVisibility(View.VISIBLE);
                mColor = COLOR_NAVY_BLUE;
                mAlpha = ALPHA_VISIBLE;
                break;
            case COLOR_ORANGE:
                super.setVisibility(View.VISIBLE);
                mColor = COLOR_ORANGE;
                mAlpha = ALPHA_VISIBLE;
                break;
            case COLOR_PURPLE:
                super.setVisibility(View.VISIBLE);
                mColor = COLOR_PURPLE;
                mAlpha = ALPHA_VISIBLE;
                break;
            case COLOR_RED:
                super.setVisibility(View.VISIBLE);
                mColor = COLOR_RED;
                mAlpha = ALPHA_VISIBLE;
                break;
            case COLOR_YELLOW:
                super.setVisibility(View.VISIBLE);
                mColor = COLOR_YELLOW;
                mAlpha = ALPHA_VISIBLE;
                break;
            case COLOR_BACKGROUND:
                super.setVisibility(View.VISIBLE);
                mColor = COLOR_BACKGROUND;
                mAlpha = ALPHA_VISIBLE;
                break;
        }
    }
}
