package com.cisetech.slidingmenu.slidingmenudemo.classicalmenu;

import android.graphics.Canvas;

import com.cisetech.slidingmenu.slidinglibrary.SlidingMenu.*;
import com.cisetech.slidingmenu.slidingmenudemo.R;

;


public class CustomScaleAnimation extends CustomAnimation {

        public CustomScaleAnimation() {
                super(R.string.anim_scale, new CanvasTransformer() {
                        @Override
                        public void transformCanvas(Canvas canvas, float percentOpen) {
                                canvas.scale(percentOpen, 1, 0, 0);
                        }
                });
        }

}
