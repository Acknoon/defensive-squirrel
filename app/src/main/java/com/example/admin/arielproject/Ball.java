package com.example.admin.arielproject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Ball
{
    private float cx, cy;
    private float radius;
    private float dx, dy;
    private int screenWidth, screenHeight;
    private int health;
    public Ball(int w, int h)
    {
        screenWidth = w;
        screenHeight = h;
        radius = (screenWidth/50);
        cx = screenWidth / 2;
        cy = screenHeight / 2;
        dx = 10;
        dy = 10;

    }
    public void draw(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawCircle(cx, cy, radius, paint);
    }
    public void setDy(float dyn)
    {
        dy=dyn;
    }
    public void setcy(float cyn)
    {
        cy=cyn;
    }
    public void setcx(float cxn)
    {
        cx=cxn;
    }
    public float getDY()
    {
        return dy;
    }
    public float getCx()
    {
        return cx;
    }
    public float getCy()
    {
        return cy;
    }
    public float getRadius()
    {
        return radius;
    }
    public void setGrow(float g) {
        radius= radius + g;
    }
    public boolean move() {
        cx += dx;
        cy += dy;
        if (cx <= radius) {
            cx = radius;
            dx = -dx;
        }
        if (cx >= screenWidth - radius) {
            cx = screenWidth - radius;
            dx = -dx;
        }
        if (cy <= radius) {
            cy = radius;
            dy = -dy;
        }
        if (cy >= screenHeight - radius) {
            cy = screenHeight - radius;
            dy = -dy;
        }
        if (cy >= screenHeight - radius)
            return false;
        return false;
    }
}

