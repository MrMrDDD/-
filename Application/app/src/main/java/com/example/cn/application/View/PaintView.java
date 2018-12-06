package com.example.cn.application.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PaintView extends View {
    Paint mPaint;
    String text = "测试文字";

    public PaintView(Context context) {
        this(context, null);
    }

    public PaintView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PaintView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();

    }




    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int top = 100;
        int baselineX = 0;
        mPaint.setTextSize(200);
        mPaint.setTextAlign(Paint.Align.LEFT);

        mPaint.setColor(Color.BLUE);
        canvas.drawLine(0, top, 2000, top, mPaint);

        mPaint.setColor(Color.RED);
        Paint.FontMetrics fontMetrics=mPaint.getFontMetrics();

        float baselineY=top-(fontMetrics.top);
        canvas.drawText(text,baselineX,baselineY,mPaint);
    }
}
