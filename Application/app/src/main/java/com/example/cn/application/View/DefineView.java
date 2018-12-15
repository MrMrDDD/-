package com.example.cn.application.View;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class DefineView extends ViewGroup {
    int OFFSET = 80;

    public DefineView(Context context) {
        super(context);
    }

    public DefineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        以下部分获取测量的模式与值大小
//        MeasureSpec有32位值前两位为测量模式，后30位为大小
//        case MeasureSpec.EXACTLY:       ---> 精确值
//        case MeasureSpec.AT_MOST:       ---> match warp 值
//        case MeasureSpec.UNSPECIFIED:   ---> 最大值很少用，listview。。。

        int widthmode = MeasureSpec.getMode(widthMeasureSpec);
        int widthsize = MeasureSpec.getSize(widthMeasureSpec);
        int heightsize = MeasureSpec.getSize(heightMeasureSpec);
        int heightmode = MeasureSpec.getMode(heightMeasureSpec);

//        测量自已的大小
//        情况一：直接测量自已的大小
//        ViewGroup.onMeasure();
//        情况二：与子控件相关，测量子控件的大小
//        ViewGrop.getChildMeasureSpec()
        int childcount = getChildCount();
        for (int i = 0; i < childcount; i++) {

            View child = getChildAt(i);
            LayoutParams layoutParams = child.getLayoutParams();
            int childwidthSpec = getChildMeasureSpec(widthMeasureSpec, 0, layoutParams.width);
            int childheightSpec = getChildMeasureSpec(heightMeasureSpec, 0, layoutParams.height);
            child.measure(childwidthSpec, childheightSpec);

        }
        int widthSpec = 0;
        int heightSpec = 0;
//        子控件测量完就可以获取尺寸了
        switch (widthmode) {
            case MeasureSpec.EXACTLY:
                widthSpec = widthsize;
                break;
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                for (int i = 0; i < getChildCount(); i++) {
                    View child = getChildAt(i);
                    int childwidthSpec = i * OFFSET + child.getMeasuredWidth();
                    widthSpec = Math.max(widthSpec, childwidthSpec);
                }
                break;
        }

//        height部分
        switch (heightmode) {
            case MeasureSpec.EXACTLY:
                heightSpec = heightsize;
                break;
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                for (int i = 0; i < getChildCount(); i++) {
                    View child = getChildAt(i);
                    int childwidthSpec = i * OFFSET + child.getMeasuredWidth();
                    heightSpec += child.getHeight();
                }
                break;
        }


//        保存自已的尺寸
        setMeasuredDimension(widthSpec, heightSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

//        摆放View的位置
        int top = 0;
        int bottom = 0;
        int left = 0;
        int right = 0;
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View view = getChildAt(i);
            left = OFFSET * i;
            right = left + view.getMeasuredWidth();
            bottom = top + view.getMeasuredHeight();
            view.layout(left, top, right, bottom);
            top += view.getMeasuredHeight();
        }


    }
}
