package com.eysermans.customcomponent.components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.eysermans.customcomponent.PixelDensityCanvas;

/**
 * Created by peter on 28/12/2017.
 */

public class CustomComponent extends View {

    public CustomComponent(Context context) {
        super(context);
    }

    public CustomComponent(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomComponent(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawDashedLine(canvas);
    }

    private void drawText(Canvas canvas) {
        PixelDensityCanvas dpCanvas = new PixelDensityCanvas(getResources(), canvas);

        Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        // Paint textPaint = new Paint();
        textPaint.setColor(getResources().getColor(android.R.color.black));
        textPaint.setTextSize(dpCanvas.convertToDp(14));
        Typeface currentTypeFace = textPaint.getTypeface();
        Typeface bold = Typeface.create(currentTypeFace, Typeface.BOLD);
        textPaint.setTypeface(bold);

        dpCanvas.drawText("Drawing in Android", 20, 20, textPaint);
    }

    private void drawDashedLine(Canvas canvas) {
        this.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        Paint paint = new Paint();
        paint.setColor(getResources().getColor(android.R.color.black));
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setPathEffect(new DashPathEffect(new float[] { 50, 50 }, 0));

        PixelDensityCanvas dpCanvas = new PixelDensityCanvas(getResources(), canvas);
        dpCanvas.drawLine(50, 0, 50,200, paint);
    }

    private void drawRoundedRect(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(android.R.color.black));

        PixelDensityCanvas dpCanvas = new PixelDensityCanvas(getResources(), canvas);
        dpCanvas.drawRoundedRect(10, 10, 100,100, 20, paint);
    }

    private void drawRect(Canvas canvas) {

        Paint paint = new Paint();
        paint.setColor(getResources().getColor(android.R.color.black));

        PixelDensityCanvas dpCanvas = new PixelDensityCanvas(getResources(), canvas);
        dpCanvas.drawRect(10, 10, 100,100, paint);
    }

    private void drawCircle(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(android.R.color.black));

        PixelDensityCanvas dpCanvas = new PixelDensityCanvas(getResources(), canvas);
        dpCanvas.drawCircle(20, 20, 20, paint);
    }

    private void drawLine(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(android.R.color.black));
        paint.setStrokeWidth(20);

        PixelDensityCanvas dpCanvas = new PixelDensityCanvas(getResources(), canvas);
        dpCanvas.drawLine(50, 0, 50,200, paint);
    }
}
