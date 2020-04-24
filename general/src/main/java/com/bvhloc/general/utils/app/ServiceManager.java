package com.bvhloc.general.utils.app;

import android.app.ActivityManager;
import android.content.Context;

/**
 * Created by Leon on 8/31/2016.
 */
public class ServiceManager {

    private Context context;

    public ServiceManager(Context context) {
        this.context = context;
    }

    public boolean isServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
