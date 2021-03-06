package com.example.pongbelike;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.Image;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GameScreen extends AppCompatActivity  {
    private ImageView bar;
    private ImageView ball;
    private ConstraintLayout root;
    private final String DEBUG_TAG = "GAMESCREEN_TOUCH";
    private String barMove;
    private Handler handler;
    // private String ballMove = "fw";
    private float ballSpeedX;
    private float ballSpeedY;
    private int score;
    private int rightX;
    private int topY;
    private int leftX;
    private int bottomY;
    private boolean flag = true;



    /*
    public void xCheck(ImageView im) {
        if (im.getX() > 1030)
            ballMove = "bk";
        else if (im.getX() < 0)
            ballMove = "fw";
    }

     */

    private Runnable ballRun = new Runnable() {
        @Override
        public void run() {
            if (flag) {
                // xCheck(ball);
           /* if (ballMove.equals("fw")) {
               ball.setX(ball.getX() + 6f);
           }

            */
                if (ball.getX() < 0) {
                    flag = false;
                    fate();
                    // handler.removeCallbacks(ballRun);
                /* // try to write working code
                // to stop ballRun from executing
                // in this if block */
                    // getMainLooper().quit();


                }
                if ((ballSpeedX > 100 || ballSpeedX < -100) && ((ball.getX() > rightX) || isCollisionDetected(ball, bar))) {
                    ballSpeedX *= -1;
                } else if ((ballSpeedX < 100 || ballSpeedX > -100) && ((ball.getX() > rightX) || isCollisionDetected(ball, bar))) {
                    ballSpeedX *= (-1 * (Math.random() * 0.14 + 1));
                }

                if ((ballSpeedY > 100 || ballSpeedY < -100) && ((ball.getY() > bottomY + bar.getHeight() / 2.7f) || (ball.getY() < 0) || isCollisionDetected(ball, bar))) {
                    ballSpeedY *= -1;
                } else if ((ballSpeedY < 100 || ballSpeedY > -100) && ((ball.getY() > bottomY + bar.getHeight() / 2.7f) || (ball.getY() < 0) || isCollisionDetected(ball, bar))) {
                    ballSpeedY *= (-1 * (Math.random() * 0.14 + 1));
                }

                if (isCollisionDetected(bar, ball)) score++;
                // Log.d(DEBUG_TAG,"" + ballSpeedX);
                // Log.d(DEBUG_TAG, "" + score);


            /*
            // Might be useful later ???
            else if (ball.getX() < 0)
                ballSpeed *= 1.5;

             */
                //else if (ballMove.equals("bk")) {
                ball.setX(ball.getX() + ballSpeedX);
                ball.setY(ball.getY() + ballSpeedY);
                //}
                handler.postDelayed(this, 30);
            }
        }
    };

    private void fate() {
        Intent intent = new Intent(this, FateActivity.class);
        startActivity(intent);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (flag) {
                float y = 0f;
                if (barMove.equals("DownU")) {
                    y = -30f;
                } else if (barMove.equals("DownD")) {
                    y = 30f;
                }

                if (bar.getY() + (bar.getHeight() / 2.0f) > bottomY) {
                    y = -30f;
                } else if (bar.getY() < topY) {
                    y = 30f;
                }
                Log.d("BALL_SPEED", "" + bottomY);
                bar.setY(bar.getY() + y);
                y = 0f;
                handler.postDelayed(this, 30);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game_screen);
        bar = findViewById(R.id.bar);
        ball = findViewById(R.id.ball);
        root = (ConstraintLayout) findViewById(R.id.cons);
        ballSpeedX = 9f;
        ballSpeedY = 4f;
        score = 0;
        handler = new Handler(Looper.myLooper());
        handler.post(ballRun);

        ViewTreeObserver viewTreeObserver = root.getViewTreeObserver();
        if(viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    // int[] coords = {0, 0};
                    // root.getLocationOnScreen(coords);
                    Display display = getWindowManager().getDefaultDisplay();
                    Point size = new Point();
                    display.getSize(size);
                    topY = 0;
                    bottomY = size.y - bar.getHeight();
                    Log.d("STUPID","" + size.y);
                    leftX = 0;
                    rightX = size.x - ball.getWidth();
                    root.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        }

    }

    public boolean isCollisionDetected(View v1, View v2) {

        if (v1 == null || v2 == null) {
            Log.e(DEBUG_TAG, "Views must not be null");
            throw new IllegalArgumentException("Views must not be null");
        }

        Rect r1 = new Rect();
        v1.getHitRect(r1);
        Rect r2 = new Rect();
        v2.getHitRect(r2);
        return Rect.intersects(r1, r2);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        int action = event.getAction();

        if (action == MotionEvent.ACTION_DOWN && event.getY() <= bar.getY()) {
                Log.d(DEBUG_TAG, "DownU");
                Log.d(DEBUG_TAG,"" + bar.getY());
                barMove = "DownU";
            handler.post(runnable);
                return true;
        } else if (action == MotionEvent.ACTION_DOWN && event.getY() > bar.getY()) {
            Log.d(DEBUG_TAG, "DownD");
            Log.d(DEBUG_TAG,"" + bar.getY());
            barMove = "DownD";
            handler.post(runnable);
            return true;
        }
        else if (action == MotionEvent.ACTION_MOVE) {
            Log.d(DEBUG_TAG,"Move");
            barMove = "Move";
            handler.removeCallbacks(runnable);
            return true;
        } else if (action == MotionEvent.ACTION_UP) {
        Log.d(DEBUG_TAG,"Up");
        barMove = "Up";
        handler.removeCallbacks(runnable);
        return true;
        }
        else {
            return super.onTouchEvent(event);
        }
    }



    public void moveUp(View view) {
        float y = bar.getY();
        ball.setX(ball.getX() - 6f);
        Log.d(DEBUG_TAG,"" + ball.getX());
    }



}