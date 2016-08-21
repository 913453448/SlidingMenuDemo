package com.cisetech.slidingmenu.slidingmenudemo.classicalmenu;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cisetech.slidingmenu.slidingmenudemo.R;

/**
 * 经典SlidingMenu
 */
public class ClassicalMenuActivity extends ListActivity {
    private Class []classes=new Class[]{
            AttachExample.class,CustomScaleAnimation.class,
            CustomSlideAnimation.class,CustomZoomAnimation.class,
            ResponsiveUIActivity.class
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classical_menu);
        setTitle(getIntent().getStringExtra("title"));
        setListAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,classes){
            @Override
            public Object getItem(int position) {
                return classes[position].getSimpleName();
            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        startActivity(new Intent(this,classes[position]));
    }
}
