package com.bvhloc.general.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ViewFlipper;

public class CheckFlipper extends ViewFlipper {

    public CheckFlipper(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                setDisplayedChild(isChecked() ? 0 : 1);
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(CheckFlipper.this, isChecked());
                }
            }
        });
    }

    public boolean isChecked() {
        return getDisplayedChild() == 1;
    }

    public void setChecked(boolean isChecked) {
        setDisplayedChild(isChecked ? 1 : 0);
    }

    private OnCheckedChangeListener onCheckedChangeListener;

    public interface OnCheckedChangeListener {

        void onCheckedChanged(View view, boolean isChecked);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListener = onCheckedChangeListener;
    }
}
