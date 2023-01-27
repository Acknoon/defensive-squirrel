package com.example.admin.arielproject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

public class Squirrel {

    private int start = 0, destination = 0;
    private float centerX, centerY;
    private float radius;
    private int size = 30;

    public Squirrel(Point[] a) {
        radius = size;
        centerX = a[start].x;
        centerY = a[start].y;

        for (int i=0; i < a.length; i++) {
            if (a[i].x == centerX && a[i].y == centerY)
                start = i;
        }
    }

    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawCircle(centerX, centerY, radius, paint);
    }

    public void step(int indexA, int indexB, Point[] a) {
        int d = indexB - indexA;
        if (Math.abs(d) <= 180 && d < 0) {
            while (indexA == indexB){
                indexA++;
                a
            }
        }
    }
}
