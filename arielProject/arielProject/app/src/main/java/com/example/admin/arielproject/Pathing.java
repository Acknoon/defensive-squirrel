package com.example.admin.arielproject;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Pathing {


    private float cx, cy;
    private float radius;
    private int screenWidth, screenHeight;
    private Point[] arrPoint;

    public Pathing(int w, int h) {
        screenWidth = w;
        screenHeight = h;
        radius = w/6;
        cx = screenWidth / 2;
        cy = screenHeight / 2;
        arrPoint = new Point[360];
        float alfa = 0;
        float dalfa = (float)(2 * Math.PI / arrPoint.length);
        double a, b;
        for (int i = 0; i < arrPoint.length; i++) {
            alfa += dalfa;
            a = Math.cos(alfa)*radius + cx;
            b = Math.sin(alfa)*radius + cy;
            arrPoint[i] = new Point((int)a, (int) b);
        }
    }
    public void draw(Canvas canvas) {
        Paint paint = new Paint(Color.BLUE);
        for (int i = 0; i < arrPoint.length; i++)
        {
            canvas.drawCircle(arrPoint[i].x, arrPoint[i].y, 3, paint);
        }
    }
    public Point[] getArrPoint(){
        return arrPoint;
    }

    public int getDestination(float xT, float yT) {
        double x, y;
        double a = (yT-cy)/(xT-cx);
        double alpha =Math.atan(a);
        x = radius * Math.cos(alpha);
        y = radius * Math.sin(alpha);
        x = x + cx;
        y = y + cy;
        Point p = new Point((int)x, (int)y);
        double minD = Double.MAX_VALUE;
        int ind = 0;
        for(int i = 0; i < arrPoint.length; i++)
        {
            if (getDistance(arrPoint[i],p) < minD )
            {
                minD = getDistance(arrPoint[i],p);
                ind = i;
            }
        }
        return ind;
    }
    public double getDistance(Point p1, Point p2)
    {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
}