package com.cisetech.slidingmenu.slidingmenudemo.classicalmenu;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.cisetech.slidingmenu.slidinglibrary.SlidingMenu;
import com.cisetech.slidingmenu.slidingmenudemo.R;
import com.cisetech.slidingmenu.slidingmenudemo.SampleListFragment;

public class AttachExample extends FragmentActivity {

	private SlidingMenu menu;
	private SampleListFragment sampleListFragment;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setTitle(R.string.attach);

		// set the Above View
		sampleListFragment = new SampleListFragment();
		setContentView(R.layout.content_frame);
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.content_frame, sampleListFragment)
		.commit();

		// configure the SlidingMenu
		menu = new SlidingMenu(this);
		menu.setMode(SlidingMenu.LEFT);
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		menu.setShadowWidthRes(R.dimen.shadow_width);
		menu.setShadowDrawable(R.drawable.shadow);
		menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		menu.setFadeDegree(0.35f);
		menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		menu.setMenu(R.layout.menu_frame);
		menu.setBehindCanvasTransformer(new SlidingMenu.CanvasTransformer() {
			@Override
			public void transformCanvas(Canvas canvas, float percentOpen) {
			}
		});
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.menu_frame, new SampleListFragment())
		.commit();
	}

	@Override
	public void onBackPressed() {
		if (menu.isMenuShowing()) {
			menu.showContent();
		} else {
			super.onBackPressed();
		}
	}

}
