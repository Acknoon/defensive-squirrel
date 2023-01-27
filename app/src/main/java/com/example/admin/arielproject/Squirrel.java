package com.example.admin.arielproject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

public class Squirrel {

    private int currInd = 30, destination = 0;
    private float centerX, centerY;
    private float radius;
    private int size = 30;
    private boolean inMove;
    private int indDest;
    private int delta = 1;

    public Squirrel(Point[] a) {
        radius = size;
        centerX = a[currInd].x;
        centerY = a[currInd].y;
        inMove = false;

    }

    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawCircle(centerX, centerY, radius, paint);
    }
    public void startMove(int iDestination) // incomplete dierection
    {
        indDest = iDestination;
        int d = indDest - currInd;
        if (Math.abs(d) > 180 && d < 0){
            delta = 1;
        } else {
            delta = -1;
        }
        inMove = true;
    }
    public void step(Point[] a)
    {
        if (inMove)
        {
            currInd = currInd + delta;
            if (delta == 1 && currInd == 359) {
                currInd = 0;
            }
            if ( delta == -1 && currInd == 0)
                currInd = 359;
            centerX = a[currInd].x;
            centerY = a[currInd].y;
            if (currInd == indDest)
                inMove = false;
        }
    }
}
