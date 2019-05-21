package com.example.greficroot.chatapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class NoSwipeViewPage extends ViewPager {
    private boolean swipeAbility = false;
    public NoSwipeViewPage(@NonNull Context context) {
        super(context);
    }
    public NoSwipeViewPage(Context context, AttributeSet attrs){
        super(context, attrs);
    }
    public void setSwipeAbility(boolean b){
        this.swipeAbility = b;
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if(swipeAbility) return super.onInterceptTouchEvent(event);
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(swipeAbility) return super.onTouchEvent(event);
        return false;
    }

}