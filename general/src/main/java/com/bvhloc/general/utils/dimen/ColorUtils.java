package com.bvhloc.general.utils.dimen;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by Leon on 5/11/2016.
 */
public class ColorUtils {

    public static int getColorFromTheme(Context context, int attr){

        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = context.getTheme();
        theme.resolveAttribute(attr, typedValue, true);
        return typedValue.data;
    }
}
