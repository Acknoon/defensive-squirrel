package com.example.admin.arielproject;

import android.content.Context;
import android.graphics.Canvas;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class CustomView extends View
{
    private Pathing path;
    private float ballGrow = 0.05f;
    private Squirrel squirrel;
    private Ball ball;
    private int wScreen, hScreen;
    private Context context;
    private int ind;
    CountDownTimer timer;
    public CustomView(Context context) {
        super(context);
        this.context = context;
        timer = new CountDownTimer(20000000, 20) {
            @Override
            public void onTick(long l) {
                invalidate();

            }

            @Override
            public void onFinish() {
                timer.start();
            }
        }.start();


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float ex = event.getX();
        float ey = event.getY();
        switch ( event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                ind = path.getDestination(ex, ey);
                //Toast.makeText(context.getApplicationContext(),"" + ind,  Toast.LENGTH_LONG).show();
                squirrel.startMove(ind);
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        path.draw(canvas);
        squirrel.draw(canvas);
        squirrel.step(path.getArrPoint());
        ball.draw(canvas);
        ball.move();
        ball.setGrow(ballGrow);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        wScreen = w;
        hScreen = h;
        path = new Pathing(wScreen, hScreen);
        squirrel = new Squirrel(path.getArrPoint());
        ball = new Ball(wScreen, hScreen);

    }
}