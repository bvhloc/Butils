package com.bvhloc.general.base;

import android.text.Editable;

public class Intermask {

//    public static abstract class OnTabSelectedListener implements TabLayout.OnTabSelectedListener {
//
//        @Override
//        public void onTabSelected(TabLayout.Tab tab) {
//            onTabSelected(tab.getPosition());
//        }
//
//        @Override
//        public void onTabUnselected(TabLayout.Tab tab) {
//
//        }
//
//        @Override
//        public void onTabReselected(TabLayout.Tab tab) {
//
//        }
//
//        public abstract void onTabSelected(int position);
//    }

    public static abstract class TextWatcher implements android.text.TextWatcher {

        private String lastChange;

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            String change = editable.toString();
            if (!change.equals(lastChange)) {
                onTextChanged(editable.toString());
            }
            lastChange = change;
        }

        public abstract void onTextChanged(String text);
    }

//    public static abstract class SwipeListener implements SwipeLayout.SwipeListener {
//
//        @Override
//        public void onStartClose(SwipeLayout layout) {
//
//        }
//
//        @Override
//        public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {
//
//        }
//
//        @Override
//        public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {
//
//        }
//    }
}
