package com.bvhloc.general.utils.system;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class KeyboardController {

    @SuppressWarnings("ConstantConditions")
    public static void hideKeyboard(Context context) {

        View view = ((Activity) context).getCurrentFocus();
        if (view != null) {
            InputMethodManager inputManager =
                    (InputMethodManager) context.
                            getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public static void showKeyboard(Context context) {
        View view = ((Activity) context).getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }
    }
}
