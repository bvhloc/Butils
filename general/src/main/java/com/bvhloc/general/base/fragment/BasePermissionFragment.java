package com.bvhloc.general.base.fragment;

import com.bvhloc.general.base.activity.BasePermissionActivity;

public abstract class BasePermissionFragment extends BaseBindingFragment {

    protected BasePermissionActivity getPermisstionActivity() {
        return (BasePermissionActivity) getActivity();
    }
}
