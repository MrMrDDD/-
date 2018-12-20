package com.example.cn.application.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cn.application.R;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.viewholder> {

    Context context;
    List<String> list;
    public MyRecyclerViewAdapter(Context context,List<String> list)
    {
        this.context=context;
        this.list=list;
    }

    @Override
    public viewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(context).inflate(R.layout.item,null,false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(viewholder holder, int position) {

        holder.textView.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewholder extends RecyclerView.ViewHolder{


        TextView textView;
        public viewholder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv);
        }
    }
}
