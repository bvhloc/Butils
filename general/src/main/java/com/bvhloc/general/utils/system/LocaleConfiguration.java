package com.bvhloc.general.utils.system;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.Locale;
import java.util.StringTokenizer;

/**
 * Created by Leon on 6/1/2016.
 */
public class LocaleConfiguration {

    public static void update(Context context, String languageCode /*en,de,fr,it,es,nl,pt,ru,zh,pl,ko,ja*/) {

//        Locale locale = new Locale(languageCode);
//        Locale.setDefault(locale);
//        Configuration config = new Configuration();
//        config.locale = locale;
//        context.getResources().updateConfiguration(config,
//                context.getResources().getDisplayMetrics());

//        Activity activity = ((Activity)context);
//
//        Locale locale = new Locale(languageCode.toLowerCase());
//        Locale.setDefault(locale);
//        Configuration config = new Configuration();
//        config.locale = locale;
//        activity.getBaseContext().getResources().updateConfiguration(config, activity.getBaseContext().getResources().getDisplayMetrics());
//        activity.getApplicationContext().getResources().updateConfiguration(config, activity.getBaseContext().getResources().getDisplayMetrics());

        StringTokenizer tokenizer = new StringTokenizer(languageCode, "_");
        Locale locale = new Locale(tokenizer.nextToken(), tokenizer.nextToken());
        Resources res = context.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = locale;
        res.updateConfiguration(conf, dm);
    }
}
