package com.example.cn.application.chenjinshi;

import android.app.ActionBar;
import android.app.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.cn.application.R;
import com.example.cn.application.adapter.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import static android.support.design.widget.TabLayout.*;

public class Main4Activity extends Activity {

    TabLayout tl_tab;
    RecyclerView recyclerView;
    List<String> list=new ArrayList<>();
    MyRecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        recyclerView=findViewById(R.id.rec);
        tl_tab = (TabLayout) findViewById(R.id.tl_tab);
        initTab();
        for (int i=0;i<20;i++)
        {
            list.add("TAB1"+i);
        }
        adapter=new MyRecyclerViewAdapter(this,list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));



    }
    private void initTab() {
        tl_tab.setTabMode(MODE_SCROLLABLE);
        tl_tab.addTab(tl_tab.newTab().setText("TAB1"));
        tl_tab.addTab(tl_tab.newTab().setText("TAB2"));
        tl_tab.addTab(tl_tab.newTab().setText("TAB#"));
        tl_tab.addOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(Tab tab) {
                list.clear();
                adapter.notifyDataSetChanged();
                for (int i=0;i<20;i++)
                {
                    list.add(tab.getText().toString()+i);
                }
                adapter.notifyDataSetChanged();


            }

            @Override
            public void onTabUnselected(Tab tab) {

            }

            @Override
            public void onTabReselected(Tab tab) {

            }
        });
    }
}