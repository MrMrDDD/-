package com.example.cn.application.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ProgressView extends View {


    Paint mPaint;
    Path mPath;
    int dx;
    int dy;
    int ProgressLen = 300;


    public ProgressView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        mPath = new Path();

    }

    public ProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.reset();
        int originY = 1000;//起始的点
        if (dy < originY + 150 / 2) {
            dy += 5;
        }
        mPath.moveTo(-ProgressLen + dx, originY - dy);

        int halfWaveLength = ProgressLen / 2;
        for (int i = -ProgressLen; i < getWidth() + ProgressLen; i += ProgressLen) {
            //相对绘制二阶贝塞尔曲线(相对于自己的起始点--也即是上一个曲线的终点  的距离dx1)
            mPath.rQuadTo(halfWaveLength / 2, -150 / 2, halfWaveLength, 0);
            mPath.rQuadTo(halfWaveLength / 2, 150 / 2, halfWaveLength, 0);

        }
        //颜色填充
        //画一个封闭的空间
        mPath.lineTo(getWidth(), getHeight());
        mPath.lineTo(0, getHeight());
        mPath.close();
        canvas.drawPath(mPath, mPaint);
//        canvas.drawCircle(getWidth()/2,getWidth()/2,getWidth()/2,mPaint);




    }
}
