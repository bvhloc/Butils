package com.bvhloc.general.base.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;

public abstract class BaseBindingActivity extends BaseActivity {

    @Override
    protected void initLayout() {
        ViewDataBinding binding = DataBindingUtil.setContentView(this, getViewId());
        onCreateBinding(binding);
    }

    protected abstract void onCreateBinding(ViewDataBinding binding);
}
