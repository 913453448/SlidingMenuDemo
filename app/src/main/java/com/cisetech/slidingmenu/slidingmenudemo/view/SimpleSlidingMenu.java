package com.cisetech.slidingmenu.slidingmenudemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;

import com.cisetech.slidingmenu.slidingmenudemo.R;
import com.nineoldandroids.view.ViewHelper;

/**
 * Author:Yqy
 * Date:2016-08-19
 * Desc:简单SlidingMenu
 * Company:cisetech
 */
public class SimpleSlidingMenu extends HorizontalScrollView {
    private View mMenu;
    private View mContent;
    private int mPaddingRight=dp2px(150);
    private int screenWidth;
    private int mMenuWidth;
    public SimpleSlidingMenu(Context context) {
        this(context, null);
    }

    public SimpleSlidingMenu(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SimpleSlidingMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        screenWidth=getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 当布局文件加载完毕的时候调用
     * 一般可以在这里初始化或者获取子控件
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mMenu = findViewById(R.id.id_simple_menu);
        mContent = findViewById(R.id.id_simple_content);
    }

    private boolean onece;
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (!onece) {
            if(mMenu!=null){
                mMenuWidth=mMenu.getLayoutParams().width=screenWidth-mPaddingRight;
                mContent.getLayoutParams().width=screenWidth;
            }
            onece = true;
        }
    }
    private int mScrimColor =  0x99000000;
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        if(l>mMenuWidth){
            l=mMenuWidth;
        }
        if(l<0){
            l=0;
        }
        super.onScrollChanged(l, t, oldl, oldt);
        float scale=l*1f/mMenuWidth;
        ViewHelper.setTranslationX(mMenu,l);
        final int baseAlpha = (mScrimColor & 0xff000000) >>> 24;
        final int imag = (int) (baseAlpha * (1-scale));
        final int color = imag << 24 | (mScrimColor & 0xffffff);

    }
    /**
     * 处理滑动事件
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        /**
         * 当抬起的时候，如果滑动距离大于menu的一半的时候自动打开
         * 反之自动关闭
         */
        if(ev.getAction()==MotionEvent.ACTION_UP){
            int scrollX = getScrollX();
            if(scrollX>=mMenuWidth/2){
                smoothScrollTo(mMenuWidth,0);
            }else{
                smoothScrollTo(0,0);
            }
            return true;
        }
        return super.onTouchEvent(ev);
    }

    /**
     * dp2px
     * @param value
     * @return px
     */
    public int dp2px(float value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getResources().getDisplayMetrics());
    }
}
