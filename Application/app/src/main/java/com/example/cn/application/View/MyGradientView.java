package com.example.cn.application.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.cn.application.R;


public class MyGradientView extends View {
    Paint mpaint;
    Bitmap bitmap;
    BitmapShader bitmapShader;
    int height;
    int width;

    public MyGradientView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mpaint = new Paint();
        mpaint.setAntiAlias(true);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.dl);
        bitmap = bitmapDrawable.getBitmap();
        width = bitmap.getWidth();
        height = bitmap.getHeight();


    }

    public MyGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mpaint.setShader(bitmapShader);

//        canvas.drawRect(new Rect(0, 0, 800, 800), mpaint);
        canvas.drawCircle(height / 2, height / 2, height / 2, mpaint);
    }
}
