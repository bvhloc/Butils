package com.bvhloc.general.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ViewFlipper;

public class CheckFlipper extends ViewFlipper {

    public CheckFlipper(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        final int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            final int finalI = i;
            getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextDisplay = finalI == childCount - 1 ? 0 : finalI + 1;
                    setDisplayedChild(nextDisplay);
                    if (onCheckedChangeListener != null) {
                        onCheckedChangeListener.onCheckedChanged(CheckFlipper.this, isChecked(), nextDisplay);
                    }
                }
            });
        }
    }

    public boolean isChecked() {
        return getDisplayedChild() != 0;
    }

    public void setChecked(boolean isChecked) {
        setDisplayedChild(isChecked ? 1 : 0);
    }

    private OnCheckedChangeListener onCheckedChangeListener;

    public interface OnCheckedChangeListener {

        void onCheckedChanged(View view, boolean isChecked, int displayedIndex);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListener = onCheckedChangeListener;
    }
}