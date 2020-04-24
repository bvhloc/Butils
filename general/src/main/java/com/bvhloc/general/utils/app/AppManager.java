package com.bvhloc.general.utils.app;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Leon on 10/31/2016.
 */

public class AppManager {

    public static void restartApp(Context context) {

        Intent intent = context.getApplicationContext().getPackageManager()
                .getLaunchIntentForPackage(context.getApplicationContext().getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    public static void backToHome(Context context) {

        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(startMain);
    }
}
