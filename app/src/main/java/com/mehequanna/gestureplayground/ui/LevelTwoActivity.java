package com.mehequanna.gestureplayground.ui;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.mehequanna.gestureplayground.R;
import com.mehequanna.gestureplayground.util.DetectGestures;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LevelTwoActivity extends AppCompatActivity implements View.OnTouchListener {
    @Bind(R.id.chicken1) ImageView mChicken1;
    @Bind(R.id.chicken2) ImageView mChicken2;
    @Bind(R.id.chicken3) ImageView mChicken3;
    @Bind(R.id.chicken4) ImageView mChicken4;
    @Bind(R.id.chicken5) ImageView mChicken5;
    @Bind(R.id.chicken6) ImageView mChicken6;
    @Bind(R.id.winTextView) TextView mWinTextView;
    @Bind(R.id.mainVideoView) VideoView mDoubleTapVideoView;

    private GestureDetector mChicken1GestureDetector;
    private GestureDetector mChicken2GestureDetector;
    private GestureDetector mChicken3GestureDetector;
    private GestureDetector mChicken4GestureDetector;
    private GestureDetector mChicken5GestureDetector;
    private GestureDetector mChicken6GestureDetector;

    MediaPlayer blue;
    MediaPlayer brown;
    MediaPlayer pink;
    MediaPlayer red;
    MediaPlayer white;
    MediaPlayer yellow;

    private int mChicken1Count;
    private int mChicken2Count;
    private int mChicken3Count;
    private int mChicken4Count;
    private int mChicken5Count;
    private int mChicken6Count;

    private GestureDetector mVideoGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_two);
        ButterKnife.bind(this);

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.doubletap);
        mDoubleTapVideoView.setVideoURI(uri);
        mDoubleTapVideoView.start();

        blue = MediaPlayer.create(this, R.raw.blue);
        brown = MediaPlayer.create(this, R.raw.brown);
        pink = MediaPlayer.create(this, R.raw.pink);
        red = MediaPlayer.create(this, R.raw.red);
        white = MediaPlayer.create(this, R.raw.white);
        yellow = MediaPlayer.create(this, R.raw.yellow);

        mChicken2.setVisibility(View.INVISIBLE);
        mChicken3.setVisibility(View.INVISIBLE);
        mChicken4.setVisibility(View.INVISIBLE);
        mChicken5.setVisibility(View.INVISIBLE);
        mChicken6.setVisibility(View.INVISIBLE);

        mChicken1Count = 0;
        mChicken2Count = 0;
        mChicken3Count = 0;
        mChicken4Count = 0;
        mChicken5Count = 0;
        mChicken6Count = 0;

        mChicken1GestureDetector = new GestureDetector(this, new DetectGestures() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                if (mChicken1Count == 0) {
                    rotateImage(mChicken1);
                    mChicken1.setVisibility(View.INVISIBLE);
                    yellow.start();
                    mChicken2.setVisibility(View.VISIBLE);
                } else if (mChicken1Count >= 1) {
                    scaleImage(mChicken1);
                    mChicken1.setVisibility(View.INVISIBLE);
                    yellow.start();
                }
                mChicken1Count += 1;
                winCheck();
                return true;
            }
        });

        mChicken2GestureDetector = new GestureDetector(this, new DetectGestures() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                if (mChicken2Count == 0) {
                    scaleImage(mChicken2);
                    mChicken2.setVisibility(View.INVISIBLE);
                    white.start();
                    mChicken3.setVisibility(View.VISIBLE);
                } else if (mChicken2Count >= 1) {
                    fadeOutImage(mChicken2);
                    mChicken2.setVisibility(View.INVISIBLE);
                    white.start();
                }
                mChicken2Count += 1;
                winCheck();
                return true;
            }
        });

        mChicken3GestureDetector = new GestureDetector(this, new DetectGestures() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
               if (mChicken3Count == 0) {
                    fadeOutImage(mChicken3);
                    red.start();
                    mChicken3.setVisibility(View.INVISIBLE);
                    mChicken4.setVisibility(View.VISIBLE);
               } else if (mChicken3Count >= 1) {
                   rotateImage(mChicken3);
                   mChicken3.setVisibility(View.INVISIBLE);
                   red.start();
               }
                mChicken3Count += 1;
                winCheck();
                return true;
            }
        });

        mChicken4GestureDetector = new GestureDetector(this, new DetectGestures() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                if (mChicken4Count == 0) {
                    rotateImage(mChicken4);
                    pink.start();
                    mChicken4.setVisibility(View.INVISIBLE);
                    mChicken5.setVisibility(View.VISIBLE);
                } else if (mChicken4Count >= 1) {
                    scaleImage(mChicken4);
                    pink.start();
                    mChicken4.setVisibility(View.INVISIBLE);
                }
                mChicken4Count += 1;
                winCheck();
                return true;
            }
        });

        mChicken5GestureDetector = new GestureDetector(this, new DetectGestures() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
               if (mChicken5Count == 0) {
                    scaleImage(mChicken5);
                    brown.start();
                    mChicken5.setVisibility(View.INVISIBLE);
                    mChicken6.setVisibility(View.VISIBLE);
               } else if (mChicken5Count >= 1) {
                   fadeOutImage(mChicken5);
                   brown.start();
                   mChicken5.setVisibility(View.INVISIBLE);
               }
                mChicken5Count += 1;
                winCheck();
                return true;
            }
        });

        mChicken6GestureDetector = new GestureDetector(this, new DetectGestures() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                if (mChicken6Count == 0) {
                    fadeOutImage(mChicken6);
                    blue.start();
                    mChicken1.setVisibility(View.VISIBLE);
                    mChicken2.setVisibility(View.VISIBLE);
                    mChicken3.setVisibility(View.VISIBLE);
                    mChicken4.setVisibility(View.VISIBLE);
                    mChicken5.setVisibility(View.VISIBLE);
                } else if (mChicken6Count >= 1) {
                    rotateImage(mChicken6);
                    blue.start();
                    mChicken6.setVisibility(View.INVISIBLE);
                }
                mChicken6Count += 1;
                winCheck();
                return true;
            }
        });

        mVideoGestureDetector = new GestureDetector(this, new DetectGestures() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                mDoubleTapVideoView.stopPlayback();
                mDoubleTapVideoView.setVisibility(View.GONE);
                return true;
            }
        });

        mChicken1.setOnTouchListener(this);
        mChicken2.setOnTouchListener(this);
        mChicken3.setOnTouchListener(this);
        mChicken4.setOnTouchListener(this);
        mChicken5.setOnTouchListener(this);
        mChicken6.setOnTouchListener(this);
        mDoubleTapVideoView.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
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

        if (view == mChicken6) {
            mChicken6GestureDetector.onTouchEvent(motionEvent);
            return true;
        }

        if (view == mDoubleTapVideoView) {
            mVideoGestureDetector.onTouchEvent(motionEvent);
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

    public void winCheck() {
        if (mChicken1.getVisibility() >= 4 && mChicken2.getVisibility() >= 4 && mChicken3.getVisibility() >= 4 && mChicken4.getVisibility() >= 4 && mChicken5.getVisibility() >= 4 && mChicken6.getVisibility() >= 4) {
            mWinTextView.setText(R.string.great_job);

            Animation winAnimation = AnimationUtils.loadAnimation(
                    getApplicationContext(), R.anim.win_scale_fade_animation);
            mWinTextView.startAnimation(winAnimation);

        } else {
            Log.d("logs", "winCheck: Not Yet");
        }
    }

}
