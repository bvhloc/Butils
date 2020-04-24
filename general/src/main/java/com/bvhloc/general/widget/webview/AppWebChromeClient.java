package com.bvhloc.general.widget.webview;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
/**
 * Use to link WebView's loading with ProgressBar in layout
 * Prefer "Youtrade Project" or on internet for guide
 * */
public class AppWebChromeClient extends WebChromeClient {
    private ProgressBar progressBar;

    public AppWebChromeClient(ProgressBar progressBar) {
        this.progressBar = progressBar;
        progressBar.setMax(100);
    }

    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);
        if (newProgress != 100) {
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setProgress(newProgress);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}