package com.bvhloc.general.base.activity;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.bvhloc.general.base.BaseAction;

public abstract class BaseActivity extends AppCompatActivity implements BaseAction {

    protected Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        context = this;
        super.onCreate(savedInstanceState);
        initLayout();
        init();
    }

    protected void initLayout() {
        setContentView(getViewId());
    }

    public void init() {
        initView();
        initValue();
        initAction();
    }

    /**
     * Hide keyboard when click outside EditText
     *
     * @param event
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(
                            Context.INPUT_METHOD_SERVICE);
                    if (getCurrentFocus() != null)
                        if (imm != null) {
                            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                        }
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

}
