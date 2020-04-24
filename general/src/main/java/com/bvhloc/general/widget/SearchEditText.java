package com.bvhloc.general.widget;

import android.view.View;
import android.widget.EditText;

import com.bvhloc.general.base.Intermask;

public class SearchEditText {

    /**
     * Find this function in Youtrade project
     * */
    public static void setupClearablEditText(final EditText editText, final View btnClear, final OnClearCallback callback) {
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
                if (callback != null) {
                    callback.onCleared();
                }
            }
        });
        editText.addTextChangedListener(new Intermask.TextWatcher() {
            @Override
            public void onTextChanged(String text) {
                if (text.length() > 0) {
                    btnClear.setVisibility(View.VISIBLE);
                } else {
                    btnClear.setVisibility(View.GONE);
                }
            }
        });
    }

    public interface OnClearCallback {
        void onCleared();
    }
}
