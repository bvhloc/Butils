package com.bvhloc.general.utils.hider;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
