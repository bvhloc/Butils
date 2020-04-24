package com.bvhloc.general.base.activity;

import android.app.ProgressDialog;
import android.graphics.drawable.ColorDrawable;
import android.widget.ProgressBar;

public abstract class BaseLoadingActivity extends BaseBindingActivity {

    protected boolean isLoading;
    protected ProgressDialog progressDialog;

    public void showLoading(String message) {

        try {

            dismissLoading();
            isLoading = true;
            progressDialog = ProgressDialog.show(this, null, message, true, false);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void showLoading() {
        try {

            //        progressDialog = ProgressDialog.show(this, null, getString(R.string.dialog_loading), true, false);
            dismissLoading();
            if (!isFinishing()) {

                isLoading = true;
                progressDialog = new ProgressDialog(this);
                if (progressDialog.getWindow() != null)
                    progressDialog.getWindow().setBackgroundDrawable(new
                            ColorDrawable(android.graphics.Color.TRANSPARENT));
                progressDialog.setIndeterminate(true);
                progressDialog.setCancelable(false);
                progressDialog.show();
                progressDialog.setContentView(new ProgressBar(this));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void dismissLoading() {
        try {

            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            isLoading = false;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
