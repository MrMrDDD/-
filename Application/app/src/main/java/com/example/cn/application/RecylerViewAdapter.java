package com.example.cn.application;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RecylerViewAdapter extends RecyclerView.Adapter<RecylerViewAdapter.ViewHodler> implements ItemMoveCallBack {

    Context mContext;
    DragCallback mDragCallback;
    List<String> list = new ArrayList<>();

    public RecylerViewAdapter(Context context, DragCallback mDragCallback) {
        this.mContext = context;
        this.mDragCallback = mDragCallback;
        for (int i = 0; i < 30; i++) {
            list.add("数据标号：" + i);
        }
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item, viewGroup,false);


        return new ViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHodler viewHodler, int i) {

        viewHodler.tv.setText(list.get(i));
        viewHodler.image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    mDragCallback.dragViewHodler(viewHodler);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public boolean ItemMoveing(int from, int to) {
        notifyItemMoved(from, to);
        Collections.swap(list, from, to);
        return true;
    }

    @Override
    public boolean RemoveItem(int position) {
        notifyItemRemoved(position);
        list.remove(position);
        return true;
    }

    class ViewHodler extends RecyclerView.ViewHolder {

        ImageView image;
        TextView tv;

        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            tv = itemView.findViewById(R.id.tv);
        }
    }

}
