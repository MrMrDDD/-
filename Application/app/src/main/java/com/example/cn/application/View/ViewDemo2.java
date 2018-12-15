package com.example.cn.application.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ViewDemo2 extends ViewGroup {
    int OFFSET = 80;

    public ViewDemo2(Context context) {
        super(context);
    }

    public ViewDemo2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childview = getChildAt(i);
            LayoutParams layoutParams = childview.getLayoutParams();
            int childWidthSpec = getChildMeasureSpec(widthMeasureSpec, 0, layoutParams.width);
            int childHeightSpec = getChildMeasureSpec(heightMeasureSpec, 0, layoutParams.height);
            childview.measure(childWidthSpec, childHeightSpec);
        }
        int widthSpec = 0;
        int heightSpec = 0;
//        Width
        switch (widthMode) {
            case MeasureSpec.EXACTLY:
                widthSpec = widthSize;
                break;
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                for (int i = 0; i < getChildCount(); i++) {

                    View childView = getChildAt(i);
                    int childWidthSpec = i * OFFSET + childView.getMeasuredWidth();
                    widthSpec = Math.max(widthSpec, childWidthSpec);
                }


                break;
        }


//        Height

        switch (heightMode) {
            case MeasureSpec.EXACTLY:
                heightSpec = heightSize;
                break;
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                for (int i = 0; i < getChildCount(); i++) {

                    View childView = getChildAt(i);
                    int childwidthSpec = i * OFFSET + childView.getMeasuredWidth();
                    heightSpec += childView.getMeasuredHeight();

                }
                break;
        }

        setMeasuredDimension(widthSpec, heightSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int top = 0;
        int bottom = 0;
        int left = 0;
        int right = 0;
        int Childcount=getChildCount();
        for (int i = 0; i < Childcount; i++) {
            View view=getChildAt(i);
            left=i*OFFSET;
            right=left+view.getMeasuredWidth();
            bottom=top+view.getMeasuredHeight();
            view.layout(left,top,right,bottom);
            top+=view.getMeasuredHeight();
        }
    }
}
