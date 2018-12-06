package com.example.cn.application;

import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class ItemTouchCallBack extends ItemTouchHelper.Callback {
    ItemMoveCallBack ItemMoveCallBack;

    public ItemTouchCallBack(ItemMoveCallBack ItemMoveCallBack) {
        this.ItemMoveCallBack = ItemMoveCallBack;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {

        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        //我要监听的swipe侧滑方向是哪个方向
//        int swipeFlags = 0;
        int swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;


        int flags = makeMovementFlags(dragFlags, swipeFlags);
        return flags;
    }

//    @Override
//    public boolean isLongPressDragEnabled() {
//        return true;
//    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        boolean flag = ItemMoveCallBack.ItemMoveing(viewHolder.getAdapterPosition(), viewHolder1.getAdapterPosition());
        return flag;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ItemMoveCallBack.RemoveItem(viewHolder.getAdapterPosition());
    }

    @Override
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
        if (actionState!=ItemTouchHelper.ACTION_STATE_IDLE)
        {
            viewHolder.itemView.setBackgroundColor(Color.DKGRAY);
        }
    }

    @Override
    public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        viewHolder.itemView.setBackgroundColor(Color.WHITE);
        viewHolder.itemView.setAlpha(1);
        viewHolder.itemView.setScaleX(1);
        viewHolder.itemView.setScaleY(1);
        super.clearView(recyclerView, viewHolder);
    }

    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        if(actionState==ItemTouchHelper.ACTION_STATE_SWIPE)
        {
            float scal=1-Math.abs(dX)/viewHolder.itemView.getWidth();
            viewHolder.itemView.setAlpha(scal);
            viewHolder.itemView.setScaleX(scal);
            viewHolder.itemView.setScaleY(scal);
        }

//        if(Math.abs(dX)<=viewHolder.itemView.getWidth()/2)
//        {
//            viewHolder.itemView.setTranslationX(-0.5f*viewHolder.itemView.getWidth());
//        }else
//        {
//            viewHolder.itemView.setTranslationX(dX);
//        }

        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }
}
