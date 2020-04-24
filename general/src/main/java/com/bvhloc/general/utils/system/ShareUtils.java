package com.bvhloc.general.utils.system;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.ShareCompat;

/**
 * Created by thongphm on 2019-07-23
 */
public class ShareUtils {

    public static void shareUrl(Context context, String url) {
        ShareCompat.IntentBuilder.from((Activity) context)
                .setType("text/plain")
                .setText(url)
                .startChooser();
    }
}
