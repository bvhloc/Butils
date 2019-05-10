package com.bvhloc.general.hider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class HorizontalHideRecyclerView extends BottomHideRecyclerView {

    @Override
    protected boolean isCannotScroll() {
        return !canScrollHorizontally(1);
    }

    public HorizontalHideRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
}
