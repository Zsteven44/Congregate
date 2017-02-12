package com.example.stevenzafrani.congregate.models;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.Log;


public class AlgorithmCanvas extends Drawable {
    int size;
    int valueArray[];

    private float scale = 0f; // something between 0 and 1

    public AlgorithmCanvas(int[] array) {
        this.valueArray = array;
        this.size = array.length;

    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        Log.v(AlgorithmCanvas.class.getSimpleName(), "Canvas Height: " + canvas.getHeight() + ", Canvas Width: " + canvas.getWidth());

        int rectWidth;
        int rectHeight;
        int rectSpacing;
        Paint p = new Paint();
        p.setColor(Color.BLACK);
        canvas.drawColor(Color.WHITE);
        rectWidth = canvas.getWidth() / size;
        rectSpacing = rectWidth / 5;


        for (int i = 0; i < size; i++) {
            Log.v(AlgorithmCanvas.class.getSimpleName(), "Drawing Rect " + i);
            canvas.drawRect(
                    (rectSpacing/2) + (i*rectWidth),
                    (canvas.getHeight()/2) - (valueArray[i]+10),
                    (rectSpacing/2) + (i*rectWidth) + (rectWidth - (rectSpacing/2)),
                    canvas.getHeight()/2,
                    p);
            canvas.drawText(Integer.toString(valueArray[i]),(rectWidth/2) + (i*rectWidth) - 4,(canvas.getHeight()/2) + 20,p);
        }

    }

    @Override
    public void setAlpha(int i) {

    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.OPAQUE;
    }
}
