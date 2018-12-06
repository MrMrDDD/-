package com.example.cn.application.View;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class WaveView extends View {
    Paint mPaint;
    private int waveLength = 400;
    private int dx;
    private int dy;
    Path mPath;
    public WaveView(Context context) {
        this(context, null);
    }

    public WaveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(5);
        mPath=new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.reset();
//        mPath.moveTo(400,400);
//        mPath.quadTo(500,100,600,400);
//        mPath.quadTo(700,700,800,400);
        int originY = 1000;//起始的点
        if(dy<originY + 150/2){
            dy += 5;
        }
        int halfWaveLength = waveLength/2;
        mPath.moveTo(-waveLength+dx, originY-dy);
        //屏幕的宽度里面放多少个波长
        for (int i = -waveLength; i < getWidth() + waveLength; i += waveLength) {
            //相对绘制二阶贝塞尔曲线(相对于自己的起始点--也即是上一个曲线的终点  的距离dx1)
            mPath.rQuadTo(halfWaveLength/2, -150/2, halfWaveLength, 0);
            mPath.rQuadTo(halfWaveLength/2, 150/2, halfWaveLength, 0);

        }
        //颜色填充
        //画一个封闭的空间
        mPath.lineTo(getWidth(), getHeight());
        mPath.lineTo(0, getHeight());
        mPath.close();
        canvas.drawPath(mPath,mPaint);


    }
    public void startAnimation(){
        ValueAnimator animator = ValueAnimator.ofInt(0,waveLength);
        animator.setDuration(1000);
        animator.setInterpolator(new LinearInterpolator());
        //无限循环
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                dx = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();
    }
}
