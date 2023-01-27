package com.example.admin.arielproject;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class CustomView extends View
{
    private Pathing path;
    private Squirrel squirrel;
    private int wScreen, hScreen;
    private Context context;
    public CustomView(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float ex = event.getX();
        float ey = event.getY();
        switch ( event.getAction())
        {
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        path.draw(canvas);
        squirrel.draw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        wScreen = w;
        hScreen = h;
        path = new Pathing(wScreen, hScreen);
        squirrel = new Squirrel(path.getArrPoint());

    }
}