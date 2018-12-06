package com.example.cn.application.View;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Scroller;

public class SlidingView extends LinearLayout {

    private Scroller mScroller;
    private View leftview;
    private View rightview;

    public SlidingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOrientation(LinearLayout.HORIZONTAL);
        mScroller = new Scroller(getContext(), null, true);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        leftview = getChildAt(0);
        rightview = getChildAt(1);
    }

    float startX;
    float startY;
    float dx;
    float dy;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = ev.getX();
                startY = ev.getY();
                super.dispatchTouchEvent(ev);
                return true;
//                break;
            case MotionEvent.ACTION_MOVE:
                dx = ev.getX() - startX;
                dy = ev.getY() - startY;
                if (Math.abs(dx) - Math.abs(dy) > ViewConfiguration.getTouchSlop()) {
                    if(getScrollX() + (-dx)>rightview.getWidth()||getScrollX() + (-dx)<0){
                        return true;
                    }
                    this.scrollBy((int) -dx, 0);
                    startX = ev.getX();
                    startY = ev.getY();
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
                //仅仅只是把滑动的情况和参数描述和记录。
                //判断当前松开手是往左滑还是往右滑
                int offset = (getScrollX() / (float) rightview.getWidth()) > 0.5f ? rightview.getWidth() - getScrollX() : -getScrollX();
                mScroller.startScroll(getScrollX(), getScrollY(), offset, 0);
                invalidate();
                startX = 0;
                startY = 0;
                dx = 0;
                dy = 0;

                break;
        }


        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void computeScroll() {
//        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            this.scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }
}
