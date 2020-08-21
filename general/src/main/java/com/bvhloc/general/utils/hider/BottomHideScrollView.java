package com.bvhloc.general.utils.hider;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.View;

public class BottomHideScrollView extends NestedScrollView {

    public BottomHideScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int x, int y, int oldx, int oldy) {
        super.onScrollChanged(x, y, oldx, oldy);
        detectEndReach();
    }

    private void detectEndReach() {

        int diff = getDiff();
        // if diff is zero, then the bottom has been reached
        if (diff <= 0) {
            if (endReachListener != null) {
                endReachListener.onEndReach();
            }
        }
    }

    protected int getDiff() {
        // We take the last son in the scrollview
        View view = getChildAt(getChildCount() - 1);
        return (view.getBottom() - (getHeight() + getScrollY()));
    }

    private EndReachListener endReachListener;

    public void setEndReachListener(EndReachListener endReachListener) {
        this.endReachListener = endReachListener;
        detectEndReach();
    }
}
