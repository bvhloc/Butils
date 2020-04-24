package com.bvhloc.general.utils.hider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class HorizontalHideScrollView extends BottomHideScrollView {

    public HorizontalHideScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected int getDiff() {
//        return super.getDiff();
        // We take the last son in the scrollview
        View view = getChildAt(getChildCount() - 1);
        return (view.getRight() - (getWidth() + getScrollX()));
    }
}
