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


    @Override
    public void draw(@NonNull Canvas canvas) {
        Log.v(AlgorithmCanvas.class.getSimpleName(), "Canvas Height: " + canvas.getHeight() + ", Canvas Width: " + canvas.getWidth());
        Paint p = new Paint();
        p.setColor(Color.WHITE);
        canvas.drawColor(Color.BLACK);
        canvas.drawCircle( (canvas.getWidth() / 2), (canvas.getHeight() / 2), 20,p);

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
