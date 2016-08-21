package com.cisetech.slidingmenu.slidingmenudemo.classicalmenu;

import android.graphics.Canvas;
import android.util.Log;
import android.view.animation.Interpolator;

import com.cisetech.slidingmenu.slidingmenudemo.R;
import com.cisetech.slidingmenu.slidinglibrary.SlidingMenu.*;
public class CustomSlideAnimation extends CustomAnimation {
	
	private static Interpolator interp = new Interpolator() {
		@Override
		public float getInterpolation(float t) {
			t=t-1.0f;
			Log.e("CustomSlide", "t-1.0f-------->"+t);
			float result=t * t * t + 1.0f;
			Log.e("CustomSlide", "t * t * t + 1.0f-------->"+t * t * t + 1.0f);
			return result;
		}		
	};

	public CustomSlideAnimation() {
		// see the class CustomAnimation for how to attach 
		// the CanvasTransformer to the SlidingMenu
		super(R.string.anim_slide, new CanvasTransformer() {
			@Override
			public void transformCanvas(Canvas canvas, float percentOpen) {
				canvas.translate(0, canvas.getHeight()*(1-interp.getInterpolation(percentOpen)));
			}			
		});
	}

}
