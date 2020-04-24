package com.bvhloc.general.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import com.bvhloc.general.base.BaseAction;

public abstract class BaseFragment extends Fragment implements BaseAction {

    protected Context context;
//    private MainActivity mMainActivity;
    protected View rootView;

//    public MainActivity getMainActivity() {
//        return mMainActivity;
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
//        mMainActivity = (MainActivity) getActivity();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initValue();
        initAction();
    }

//    /**
//     * Get homeNavigator
//     */
//    public FragmentNavigator getFragmentNavigator() {
//        return ((BaseFragmentActivity) context).fragmentNavigator;
//    }
//
//    /**
//     * Get active fragment
//     *
//     * @return
//     */
//    protected Fragment getActiveFragment() {
//        return getFragmentNavigator().getActiveFragment();
//    }
//
//    /**
//     * Get previous fragment
//     *
//     * @return
//     */
//    protected Fragment getPreviousFragment() {
//        return getFragmentNavigator().getPreviousFragment();
//    }
//
//    public void showLoading() {
//        if (getActivity() == null)
//            return;
//        ((BaseLoadingActivity) getActivity()).showLoading();
//    }
//
//    public void dismissLoading() {
//        if (getActivity() == null)
//            return;
//        ((BaseLoadingActivity) getActivity()).dismissLoading();
//    }
//
//    protected void showConnectionFailToast() {
//        dismissLoading();
//        Toast.makeText(context, "ConnectionFail", Toast.LENGTH_LONG)
//                .show();
//    }

    protected void showShortToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT)
                .show();
    }

    protected void showLongToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG)
                .show();
    }

//    protected void showErrorDialog(String message) {
//        dismissLoading();
//        new AlertDialog.Builder(context)
//                .setMessage(message)
//                .setPositiveButton(R.string.Close, null)
//                .show();
//    }
}
