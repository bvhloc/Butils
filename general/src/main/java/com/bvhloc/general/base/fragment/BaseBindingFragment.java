package com.bvhloc.general.base.fragment;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;

public abstract class BaseBindingFragment extends BaseFragment {

    protected Serializable dataSerializable;

    protected static final String ARG_DATA_OBJECT = "ARG_DATA_OBJECT";

    protected static Bundle getArguments(Serializable data) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_DATA_OBJECT, data);
        return args;
    }

    protected abstract void onCreateBinding(ViewDataBinding binding);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, getViewId(), container, false);
        rootView = binding.getRoot();
        rootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        onCreateBinding(binding);
        initView();
        if (getArguments() != null) {
            dataSerializable = getArguments().getSerializable(ARG_DATA_OBJECT);
        }
        return rootView;
    }
}
