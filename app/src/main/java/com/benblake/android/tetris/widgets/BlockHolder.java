package com.benblake.android.tetris.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import com.benblake.android.tetris.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by benblake on 2017-05-29.
 */

public class BlockHolder extends View {
    private int mNx;
    private int mNy;
    private int mBlockSize;
    private Context mContext = null;
    private List<Block> mBlocks = null;

    public BlockHolder(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.BlockHolder,
                0, 0);

        try {
            mNx = typedArray.getInteger(R.styleable.BlockHolder_nx, 1);
            mNy = typedArray.getInteger(R.styleable.BlockHolder_ny, 1);
            mBlockSize = typedArray.getInteger(R.styleable.BlockHolder_blockSize, 20);
        } finally {
            typedArray.recycle();
        }

        mContext = context;

        setupBlocks();
    }

    @Override
    public void onDraw(Canvas canvas) {
        for (Block b : mBlocks) {
            b.draw(canvas);
        }
    }

    private void setupBlocks() {
        mBlocks = new ArrayList<>();
        for (int j = 0; j < mNy; j++) {
            for (int i = 0; i < mNx; i++) {
                int color = ((i + j) % 2 == 0) ? Block.COLOR_NAVY_BLUE : Block.COLOR_RED;
                mBlocks.add(new Block(mContext, color, i * mBlockSize, j * mBlockSize, mBlockSize));
            }
        }
    }

    public void setBlockVisibility(int index, int visibility) {
        mBlocks.get(index).setBlockVisibility(visibility);
        invalidate();
    }

    public int getNx() {
        return mNx;
    }

    public int getNy() {
        return mNy;
    }
}
