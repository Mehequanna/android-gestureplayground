package com.mehequanna.gestureplayground.ui;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.mehequanna.gestureplayground.R;
import com.mehequanna.gestureplayground.util.DetectGestures;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LevelOneActivity extends AppCompatActivity implements View.OnTouchListener {
    @Bind(R.id.chicken0) ImageView mChicken0;
    @Bind(R.id.chicken1) ImageView mChicken1;
    @Bind(R.id.chicken2) ImageView mChicken2;
    @Bind(R.id.chicken3) ImageView mChicken3;
    @Bind(R.id.chicken4) ImageView mChicken4;
    @Bind(R.id.chicken5) ImageView mChicken5;

    private GestureDetector mChicken0GestureDetector;
    private GestureDetector mChicken1GestureDetector;
    private GestureDetector mChicken2GestureDetector;
    private GestureDetector mChicken3GestureDetector;
    private GestureDetector mChicken4GestureDetector;
    private GestureDetector mChicken5GestureDetector;

    MediaPlayer blue;
    MediaPlayer brown;
    MediaPlayer pink;
    MediaPlayer red;
    MediaPlayer white;
    MediaPlayer yellow;

    private int mChicken0Count;
    private int mChicken1Count;
    private int mChicken2Count;
    private int mChicken3Count;
    private int mChicken4Count;
    private int mChicken5Count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);
        ButterKnife.bind(this);

        blue = MediaPlayer.create(this, R.raw.bluef);
        brown = MediaPlayer.create(this, R.raw.brownf);
        pink = MediaPlayer.create(this, R.raw.pinkf);
        red = MediaPlayer.create(this, R.raw.redf);
        white = MediaPlayer.create(this, R.raw.whitef);
        yellow = MediaPlayer.create(this, R.raw.yellowf);

        mChicken1.setVisibility(View.INVISIBLE);
        mChicken2.setVisibility(View.INVISIBLE);
        mChicken3.setVisibility(View.INVISIBLE);
        mChicken4.setVisibility(View.INVISIBLE);
        mChicken5.setVisibility(View.INVISIBLE);

        mChicken0.setOnTouchListener(this);
        mChicken1.setOnTouchListener(this);
        mChicken2.setOnTouchListener(this);
        mChicken3.setOnTouchListener(this);
        mChicken4.setOnTouchListener(this);
        mChicken5.setOnTouchListener(this);

        mChicken0Count = 0;
        mChicken1Count = 0;
        mChicken2Count = 0;
        mChicken3Count = 0;
        mChicken4Count = 0;
        mChicken5Count = 0;

        mChicken0GestureDetector = new GestureDetector(this, new DetectGestures() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {

                if (mChicken0Count == 0) {
                    rotateImage(mChicken0);
                    mChicken0.setVisibility(View.INVISIBLE);
                    yellow.start();
                    mChicken1.setVisibility(View.VISIBLE);
                    mChicken0Count += 1;
                } else if (mChicken0Count == 1) {
                    scaleImage(mChicken0);
                    mChicken0.setVisibility(View.INVISIBLE);
                    yellow.start();
                }

                return true;
            }
        });

        mChicken1GestureDetector = new GestureDetector(this, new DetectGestures() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                if (mChicken1Count == 0) {
                    scaleImage(mChicken1);
                    mChicken1.setVisibility(View.INVISIBLE);
                    white.start();
                    mChicken2.setVisibility(View.VISIBLE);
                    mChicken1Count += 1;
                } else if (mChicken1Count == 1) {
                    fadeOutImage(mChicken1);
                    mChicken1.setVisibility(View.INVISIBLE);
                    white.start();
                }

                return true;
            }
        });

        mChicken2GestureDetector = new GestureDetector(this, new DetectGestures() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                fadeOutImage(mChicken2);
                red.start();
                mChicken2.setVisibility(View.INVISIBLE);

                mChicken3.setVisibility(View.VISIBLE);
                return true;
            }
        });

        mChicken3GestureDetector = new GestureDetector(this, new DetectGestures() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                rotateImage(mChicken3);
                pink.start();
                mChicken3.setVisibility(View.INVISIBLE);

                mChicken4.setVisibility(View.VISIBLE);
                return true;
            }
        });

        mChicken4GestureDetector = new GestureDetector(this, new DetectGestures() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                scaleImage(mChicken4);
                brown.start();
                mChicken4.setVisibility(View.INVISIBLE);

                mChicken5.setVisibility(View.VISIBLE);
                return true;
            }
        });

        mChicken5GestureDetector = new GestureDetector(this, new DetectGestures() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                fadeOutImage(mChicken5);
                blue.start();

                mChicken0.setVisibility(View.VISIBLE);
                mChicken1.setVisibility(View.VISIBLE);
                mChicken2.setVisibility(View.VISIBLE);
                mChicken3.setVisibility(View.VISIBLE);
                mChicken4.setVisibility(View.VISIBLE);
                return true;
            }
        });

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == mChicken0) {
            mChicken0GestureDetector.onTouchEvent(motionEvent);
            return true;
        }

        if (view == mChicken1) {
            mChicken1GestureDetector.onTouchEvent(motionEvent);
            return true;
        }

        if (view == mChicken2) {
            mChicken2GestureDetector.onTouchEvent(motionEvent);
            return true;
        }

        if (view == mChicken3) {
            mChicken3GestureDetector.onTouchEvent(motionEvent);
            return true;
        }

        if (view == mChicken4) {
            mChicken4GestureDetector.onTouchEvent(motionEvent);
            return true;
        }

        if (view == mChicken5) {
            mChicken5GestureDetector.onTouchEvent(motionEvent);
            return true;
        }

            return false;
    }

    public void scaleImage(View view) {
        Animation scaleAnimation = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.scale_animation);
        view.startAnimation(scaleAnimation);
    }

    public void rotateImage(View view) {
        Animation rotateAnimation = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.rotate_animation);
        view.startAnimation(rotateAnimation);
    }

    public void fadeOutImage(View view) {
        Animation fadeOutAnimation = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.fade_out_animation);
        view.startAnimation(fadeOutAnimation);
    }

}
