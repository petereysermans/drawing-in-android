package com.eysermans.customcomponent;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.NonNull;

/**
 * Created by peter on 29/12/2017.
 */

public class PixelDensityCanvas {

    private Resources resources;
    private Canvas canvas;

    public PixelDensityCanvas(Resources resources, Canvas canvas) {
        this.resources = resources;
        this.canvas = canvas;
    }

    public void drawCircle(
            float cx,
            float cy,
            float radius,
            Paint paint) {
        canvas.drawCircle(convertToDp(cx), convertToDp(cy), convertToDp(radius), paint);
    }

    public  void drawRoundedRect(
            float left,
            float top,
            float right,
            float bottom,
            float cornerRadius,
            Paint paint) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            canvas.drawRoundRect(
                    convertToDp(left),
                    convertToDp(top),
                    convertToDp(right),
                    convertToDp(bottom),
                    cornerRadius,
                    cornerRadius,
                    paint);
        } else {
            drawRect(left, top, right, bottom, paint);
        }
    }

    public void drawText(String text, float x, float y, Paint paint) {
        canvas.drawText(text, convertToDp(x), convertToDp(y), paint);
    }

    public void drawRect(
            float left,
            float top,
            float right,
            float bottom,
            Paint paint) {
        canvas.drawRect(
                convertToDp(left),
                convertToDp(top),
                convertToDp(right),
                convertToDp(bottom),
                paint);
    }

    public void drawLine(
            float startX,
            float startY,
            float stopX,
            float stopY,
            @NonNull Paint paint) {

        canvas.drawLine(
                convertToDp(startX),
                convertToDp(startY),
                convertToDp(stopX),
                convertToDp(stopY),
                paint);
    }

    public float convertToDp(float pixels) {
        return pixels * getDensity();
    }

    private float getDensity() {
        return resources.getDisplayMetrics().density;
    }
}
