package com.bvhloc.general.base.activity;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseBindingActivity extends BaseActivity {

    @Override
    protected void initLayout() {
        ViewDataBinding binding = DataBindingUtil.setContentView(this, getViewId());
        onCreateBinding(binding);
    }

    protected abstract void onCreateBinding(ViewDataBinding binding);
}
