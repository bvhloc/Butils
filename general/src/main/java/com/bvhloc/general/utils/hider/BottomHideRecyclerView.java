package com.bvhloc.general.utils.hider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class BottomHideRecyclerView extends RecyclerView {

    protected boolean isCannotScroll() {
        return !canScrollVertically(1);
    }

    public BottomHideRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                detectEndReach();
            }
        });
    }

    private void detectEndReach() {
        if (isCannotScroll()) {
            if (endReachListener != null) {
                endReachListener.onEndReach();
            }
        }
    }

    private EndReachListener endReachListener;

    public void setEndReachListener(EndReachListener endReachListener) {
        this.endReachListener = endReachListener;
        detectEndReach();
    }
}
