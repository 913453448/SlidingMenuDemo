package com.cisetech.slidingmenu.slidingmenudemo.drawerlayout;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;

import com.cisetech.slidingmenu.slidingmenudemo.R;

/**
 * DrawerLayout
 */
public class DrawerLayoutActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_drawer_layout);
        initViews();

    }

    private void initViews() {
        mDrawerLayout= (DrawerLayout) findViewById(R.id.id_drawerlayout);
        /**
         * 设置右边menu打开的方式为手势不可以打开，即关闭状态
         */
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.RIGHT);
        /**
         * 设置menu打开后content的颜色，颜色的alpha从0-1
         */
        //mDrawerLayout.setScrimColor(Color.BLACK);
        mDrawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                /**
                 * 设置右边menu打开的方式为手势不可以打开，即关闭状态
                 */
                mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.RIGHT);
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }
    public void OpenRightMenu(View view){
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED, Gravity.RIGHT);
        mDrawerLayout.openDrawer(Gravity.RIGHT);
    }
}
