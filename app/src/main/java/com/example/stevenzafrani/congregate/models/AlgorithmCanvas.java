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
        //canvas.drawRect(0, 0, canvas.getWidth()/2, canvas.getHeight() /2, p);
        rectWidth = canvas.getWidth() / size;
        rectSpacing = rectWidth / 5;


        /**
         *  Each rectangles drawn need to be given left, top, right, and bottom displacements.
         *  rectSpacing: rectWidth / 5
         *  LEFT: (i*rectSpacing) + (i * rectWidth)
         *  TOP: ( - 250 to start)
         *  RIGHT: (20 - i) * canvas.getWidth()
         *  BOTTOM: 0
         *
         */

        for (int i = 0; i < size; i++) {
            Log.v(AlgorithmCanvas.class.getSimpleName(), "Drawing Rect " + i);
            canvas.drawRect(
                    (rectSpacing/2) + (i*rectWidth),
                    (canvas.getHeight()/2) - (valueArray[i]+10),
                    (rectSpacing/2) + (i*rectWidth) + (rectWidth - (rectSpacing/2)),
                    canvas.getHeight()/2,
                    p);
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
