package com.bvhloc.general;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

public class BToucher {

    private static float TOUCH_ALPHA = 0.5f;

    public static void addAlpha(final View view) {
        setTouch(view, new TouchCallback() {
            @Override
            public void onTouch() {
                view.setAlpha(TOUCH_ALPHA);
            }

            @Override
            public void onRelease() {
                view.setAlpha(1);
            }
        });
    }

    /**
     * This function work only on Android 5.0 and above;
     */
    public static void addElevation(final View view) {

        final float elevation = view.getElevation();
        setTouch(view, new TouchCallback() {
            @Override
            public void onTouch() {
                float touchElevation = 9f;
                if (elevation > touchElevation / 3) {
                    touchElevation = elevation * 3;
                }
                view.setElevation(touchElevation);
            }

            @Override
            public void onRelease() {
                view.setElevation(elevation);
            }
        });
    }

    private static Rect rect;

    private static void setTouch(View view, final TouchCallback callback) {
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    callback.onTouch();
                    rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    callback.onRelease();
                    if (rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                        // User moved inside bounds
                        v.performClick();
                    }
                } else {
                    if (rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                        // User moved inside bounds
                        callback.onTouch();
                    } else {
                        // User moved outside bounds
                        callback.onRelease();
                    }
                }
                return true;
            }
        });
    }

    private interface TouchCallback {

        void onTouch();

        void onRelease();
    }
}
