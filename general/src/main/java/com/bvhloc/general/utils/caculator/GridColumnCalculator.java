package com.bvhloc.general.utils.caculator;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;

/**
 * Created by Leon on 20/06/2017.
 */

public class GridColumnCalculator {

    @SuppressWarnings("UnnecessaryLocalVariable")
    public static int getColumn(Context context, int columnWidth) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (dpWidth / columnWidth);
        return noOfColumns;
    }

    public static int getColummWidth(Context context, int column) {

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        return width / column;
    }

    public static LinearLayout.LayoutParams getSquareLayoutParams(Context context, int column) {

        int width = getColummWidth(context, column);
        return new LinearLayout.LayoutParams(width, width);
    }
}
