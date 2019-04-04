package com.wassemann.kapitel5;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class SimpleDrawView extends View {
    private Paint paint;

    public SimpleDrawView(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = getWidth();
        float height = getHeight();
        float radius = Math.min(height, width) / 2;
        canvas.drawLine(0, 0, width, height, paint);
        canvas.drawLine(0, height, width, 0, paint);
        canvas.drawCircle(width / 2, height / 2, radius, paint);
        canvas.drawRect(0, 0, width, height, paint);
    }
}