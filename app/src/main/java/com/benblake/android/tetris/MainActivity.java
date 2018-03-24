package com.benblake.android.tetris;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.benblake.android.tetris.widgets.BlockHolder;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private BlockHolder mBlockHolder = null;
    private GameState mGameState = null;
    private Timer mMainTimer = null;
    private Button mStartButton = null;
    private Button mResetButton = null;
    private Button mLeftButton = null;
    private Button mRightButton = null;
    private Button mDownButton = null;
    private Button mRotateButton = null;
    private TextView mGameOverTextView = null;
    private ImageView mJoshFace = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBlockHolder = (BlockHolder) findViewById(R.id.block_holder);
        mGameState = GameState.getInstance();
        mGameState.initializeGrid(mBlockHolder, this);
        mStartButton = (Button) findViewById(R.id.button);
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
                mStartButton.setEnabled(false);
                mLeftButton.setEnabled(true);
                mRightButton.setEnabled(true);
                mDownButton.setEnabled(true);
                mRotateButton.setEnabled(true);
            }
        });

        mResetButton = (Button) findViewById(R.id.button2);
        mResetButton.setEnabled(false);
        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGameState.reset();
                mResetButton.setEnabled(false);
                mStartButton.setEnabled(true);
                mResetButton.setVisibility(View.INVISIBLE);
                mGameOverTextView.setVisibility(View.INVISIBLE);
                mJoshFace.setVisibility(View.INVISIBLE);
            }
        });

        mLeftButton = (Button) findViewById(R.id.button3);
        mLeftButton.setEnabled(false);
        mLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGameState.moveBrickLeft();
            }
        });

        mRightButton = (Button) findViewById(R.id.button4);
        mRightButton.setEnabled(false);
        mRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGameState.moveBrickRight();
            }
        });

        mDownButton = (Button) findViewById(R.id.button6);
        mDownButton.setEnabled(false);
        mDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGameState.moveBrickDown();
            }
        });

        mRotateButton = (Button) findViewById(R.id.button5);
        mRotateButton.setEnabled(false);
        mRotateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGameState.rotateBrick();
            }
        });

        mGameOverTextView = (TextView) findViewById(R.id.textView);

        mJoshFace = (ImageView) findViewById(R.id.josh_face);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        stopGame();
    }

    private void startGame() {
        mGameState.setupNewBrick();
        TimerTask mainTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mGameState.moveBrickDown();
                    }
                });
            }
        };
        mMainTimer = new Timer(true);
        mMainTimer.scheduleAtFixedRate(mainTask, 1000, 1000);
    }

    private void stopGame() {
        if (mMainTimer != null) {
            mMainTimer.cancel();
        }
    }

    public void gameOver() {
        stopGame();
        mGameOverTextView.setVisibility(View.VISIBLE);
        mResetButton.setEnabled(true);
        mResetButton.setVisibility(View.VISIBLE);
        mLeftButton.setEnabled(false);
        mRightButton.setEnabled(false);
        mDownButton.setEnabled(false);
        mRotateButton.setEnabled(false);
        mJoshFace.setVisibility(View.VISIBLE);
    }
}
