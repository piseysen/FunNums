package com.funnums.funnums.uihelpers;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by austinbaird on 11/19/17.
 */

public class HUDSquare {


    float TEXT_SIZE = 45;

    int BORDER = 10;
    int MARGIN = 10;
    int OFFSET = 50;

    private String msg, value;           /*Character/variable/operand inside the tile*/
    private boolean used;           /*//Tile is marked as used if it part of the expression*/

    //Used as coordinates when drawing rectangle (Later on they can be erased
    //for now they make the code easier to read)
    float left, top, right, bottom;

    public float x, y, length;
    // Constructor:
    public HUDSquare(float x, float y, float tileLength,  String msg, String value) {

        this.x = x;
        this.y = y-MARGIN;
        this.length = tileLength;
        this.msg = msg;
        this.value = value;

        //distance of the left side of rectangular from left side of canvas.
        left = x-tileLength/2;
        //Distance of bottom side of rectangle from the top side of canvas
        top = this.y-TEXT_SIZE/2 - MARGIN;
        //distance of the right side of rectangular from left side of canvas.
        right = x + tileLength/2;
        //Distance of the top side of rectangle from top side of canvas
        bottom = this.y + TEXT_SIZE*2 - MARGIN- BORDER - BORDER/2;

        used = false;
    }

    //Getter methods
    public String getValue() {
        return value;
    }

    public boolean isUsed(){ return used; }

    public float getLeft(){ return left; }

    public float getTop(){ return top; }

    public float getRight(){ return right; }

    public void setValue(String newVal){
        value = newVal;
    }

    //Setter methods
    public void setUsed(boolean used){ this.used = used; }




    public void draw(Canvas canvas, Paint paint) {


        // border
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        canvas.drawRect(left, top, right, bottom, paint);




        // fill
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawRect(left, top, right, bottom, paint);

        //Draw Current
        paint.setColor(Color.argb(255, 255, 0, 0));
        paint.setTextSize(TEXT_SIZE);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(msg, x , y + MARGIN, paint);
        canvas.drawText(value,  x , y+OFFSET + MARGIN, paint);


        //draw the rectangle (tile)
        //paint.setColor(Color.argb(255, 245, 228, 118));
        //canvas.drawRect(left, top, right, bottom, paint);

        //draw the value of the number in the center of the rectangle (tile)
        //paint.setColor(Color.argb(100, 100, 100, 100));
        //paint.setTextSize(TEXT_SIZE);
        //paint.setTextAlign(Paint.Align.CENTER);

        //Draw Tile text
        //canvas.drawText(value, x + (length / 2), y + (length / 2) + (TEXT_SIZE / 2), paint);
    }

    public void drawNoLabel(Canvas canvas, Paint paint){
        // border
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        canvas.drawRect(left, top, right, bottom, paint);




        // fill
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawRect(left, top, right, bottom, paint);

        //Draw Current
        paint.setColor(Color.argb(255, 255, 0, 0));
        paint.setTextSize(TEXT_SIZE);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(value, x , y + MARGIN*2, paint);
    }
}