package com.bvhloc.general.base.activity;


import androidx.fragment.app.Fragment;

import com.bvhloc.general.base.FragmentNavigator;

public abstract class BaseFragmentActivity extends BaseLoadingActivity {

    public FragmentNavigator fragmentNavigator;

    /**
     * Setup root fragment
     *
     * @param rootFragment
     */
    protected void setupRootFragment(Fragment rootFragment, int rootId) {
        fragmentNavigator = new FragmentNavigator(getSupportFragmentManager(), rootId);
        fragmentNavigator.setOnStackChanged(new FragmentNavigator.onStackChanged() {
                                                @Override
                                                public void onChanged(Fragment fragment) {

                                                }
                                            }
        );
        fragmentNavigator.setRootFragment(rootFragment);
    }

    @Override
    public void onBackPressed() {
        // Go back to MainFragment if press back at LoginFragment
//        if (homeNavigator.getActiveFragment() instanceof LoginFragment) {
//            homeNavigator.goToRoot();
//        } else {
        super.onBackPressed();
//        }
    }
}
