package com.cisetech.slidingmenu.slidingmenudemo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cisetech.slidingmenu.slidingmenudemo.classicalmenu.ClassicalMenuActivity;
import com.cisetech.slidingmenu.slidingmenudemo.drawerlayout.DrawerLayoutActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends ListActivity {
    private List<String> titls;
    private ArrayAdapter<String> adapter;
    private Class classes[]=new Class[]{
            SimpleMenuActivtiy.class,
            ClassicalMenuActivity.class,
            DrawerLayoutActivity.class
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titls= Arrays.asList(getResources().getStringArray(R.array.titls));
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,titls);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent=new Intent(this,classes[position]);
        intent.putExtra("title",titls.get(position));
        startActivity(intent);
    }
}
