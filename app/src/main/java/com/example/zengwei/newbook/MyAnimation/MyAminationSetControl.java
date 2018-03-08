package com.example.zengwei.newbook.MyAnimation;

import android.view.animation.Animation;

/**
 * 类创建时间为： zengwei on 2018/1/13.
 */

public class MyAminationSetControl {
    public MyAminationSetControl(Animation animation, final MyAnimListener myAnimListener){
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                myAnimListener.MyAnimListenerstart();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                myAnimListener.MyAnimListenerend();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
