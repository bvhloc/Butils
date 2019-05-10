package com.bvhloc.general.hider;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;

public class HorizontalHider extends BottomHider {

    public HorizontalHider(Context context, AttributeSet attrs) {
        super(context, attrs);
        int colors[] = {0x00000000, getSolidColor()};
        GradientDrawable drawable = new GradientDrawable(
                GradientDrawable.Orientation.LEFT_RIGHT, colors);
        setBackground(drawable);
    }
}