package com.cisetech.slidingmenu.slidingmenudemo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cisetech.slidingmenu.slidingmenudemo.classicalmenu.BirdGridFragment;

/**
 * SimpleMenuActivity
 */
public class SimpleMenuActivtiy extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        setTitle(getIntent().getStringExtra("title"));
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.id_simple_menu,new SampleListFragment());
        ft.replace(R.id.id_simple_content,new BirdGridFragment());
        ft.commit();
    }
}
