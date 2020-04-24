package com.bvhloc.general.utils.text;

import android.text.Html;
import android.text.Spanned;

/**
 * Created by Leon on 12/26/2016.
 */

public class HtmlColorProvider {

    public static Spanned getMulticolorText(String[] strings, int[] colors) {

        String[] colorStrings = new String[colors.length];
        for (int i = 0; i < colors.length; i++) {

            colorStrings[i] = "#" + Integer.toHexString(colors[i]).substring(2);
        }
        return getMulticolorText(strings, colorStrings);
    }

    public static Spanned getMulticolorText(String[] strings, String[] colors) {
        String multicolorText = "";

        for (int i = 0; i < strings.length; i++) {
            multicolorText += "<font color='" + colors[i] + "'>" + strings[i] + "</font>";
        }

        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(multicolorText,Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(multicolorText);
        }
        return result;
    }
}
