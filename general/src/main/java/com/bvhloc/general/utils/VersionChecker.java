package com.bvhloc.general.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//import okhttp3.ResponseBody;

/**
 * Created by Leon on 11/28/2016.
 */

public class VersionChecker {
//
//    public static String getInstalledVersion(Context context) {
//        String version = "0.0.0.0";
//
//        try {
//            version = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
//        } catch (PackageManager.NameNotFoundException var3) {
//            var3.printStackTrace();
//        }
//
//        return version;
//    }
//
//    public static void check(final Context context, final VersionCallback callback) {
//
//        new AsyncTask<Void, Void, String>() {
//            @Override
//            protected String doInBackground(Void... params) {
//
//                boolean isAvailable = false;
//
//                OkHttpClient client = new OkHttpClient();
//                String res = String.format("https://play.google.com/store/apps/details?id=%s&hl=%s", new Object[]{context.getPackageName(), Locale.getDefault().getLanguage()});
//                URL url;
//                try {
//                    url = new URL(res);
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                    return null;
//                }
//
//                Request request = (new Request.Builder()).url(url).build();
//
//                ResponseBody body = null;
//
//                try {
//                    Response version = client.newCall(request).execute();
//                    body = version.body();
//                    BufferedReader recentChanges = new BufferedReader(new InputStreamReader(body.byteStream(), "UTF-8"));
//                    StringBuilder updateUrl = new StringBuilder();
//
//                    String line;
//                    while ((line = recentChanges.readLine()) != null) {
//                        if (line.contains("itemprop=\"softwareVersion\">")) {
//                            updateUrl.append(line);
//                            isAvailable = true;
//                        }
//                    }
//
//                    if (updateUrl.length() == 0) {
//                        Log.e("AppUpdater", "Cannot retrieve latest version. Is it configured properly?");
//                    }
//
//                    if (!isAvailable) {
//                        return null;
//                    }
//
//                    version.body().close();
//                    //noinspection UnnecessaryLocalVariable
//                    String source = updateUrl.toString();
//                    return source;
//
//                } catch (FileNotFoundException var17) {
//                    Log.e("AppUpdater", "App wasn\'t found in the provided source. Is it published?");
//                } catch (IOException var18) {
//                    return null;
//                } finally {
//                    if (body != null) {
//                        body.close();
//                    }
//
//                }
//
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(String source) {
//                super.onPostExecute(source);
//
//                if (source != null) {
//
//                    String installedVersion = getInstalledVersion(context);
//                    String lastestVersion = getLastestVersion(source);
//                    if (isUpToDate(installedVersion, lastestVersion)){
//                        callback.onUpToDate();
//                    }else {
//                        String recentChanges = getRecentChanges(source);
//                        callback.onNewVersionAvaiable(lastestVersion, recentChanges);
//                    }
//
//                } else {
//                    callback.onCheckingFail();
//                }
//            }
//        }.execute();
//    }
//
//    private static String getLastestVersion(String source) {
//
//        String version = "";
//
//        String[] splitPlayStore = source.split("itemprop=\"softwareVersion\">");
//        if (splitPlayStore.length > 1) {
//            splitPlayStore = splitPlayStore[1].split("(<)");
//            version = splitPlayStore[0].trim();
//        }
//
//        return version;
//    }
//
//    private static boolean isUpToDate(String installedVersion, String lastestVersion) {
//
//        String[] thisParts = installedVersion.split("\\.");
//        String[] thatParts = lastestVersion.split("\\.");
//        int length = Math.max(thisParts.length, thatParts.length);
//
//        for (int i = 0; i < length; ++i) {
//            int thisPart = i < thisParts.length ? Integer.parseInt(thisParts[i]) : 0;
//            int thatPart = i < thatParts.length ? Integer.parseInt(thatParts[i]) : 0;
//            if (thisPart < thatPart) {
//                return false;
//            }
//
//            if (thisPart > thatPart) {
//                return true;
//            }
//        }
//
//        return true;
//    }
//
//    private static String getRecentChanges(String source) {
//
//        String recentChanges = "";
//
//        String[] splitPlayStore = source.split("recent-change\">");
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 1; i < splitPlayStore.length; ++i) {
//            sb.append(splitPlayStore[i].split("(<)")[0]).append("\n");
//        }
//
//        recentChanges = sb.toString();
//
//        return recentChanges;
//    }
//
//    public interface VersionCallback {
//
//        void onUpToDate();
//
//        void onNewVersionAvaiable(String newVersion, String recentChanges);
//
//        void onCheckingFail();
//    }
}
