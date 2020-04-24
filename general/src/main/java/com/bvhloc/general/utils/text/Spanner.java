package com.bvhloc.general.utils.text;

import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.widget.TextView;

public class Spanner {

    public static void setMultipleClick(TextView textView, String text, CharSequence[] charSequences, ClickableSpan[] clickableSpans) {

        SpannableString spannableString = new SpannableString(text);

        for (int i = 0; i < charSequences.length; i++) {
            CharSequence s = charSequences[i];
            int sStart = text.indexOf(String.valueOf(s));
            int sEnd = sStart + s.length();
            spannableString.setSpan(clickableSpans[i], sStart, sEnd, 0);
//            spannableString.setSpan(new ForegroundColorSpan(Color.BLUE), sStart, sEnd, 0);
//            spannableString.setSpan(new UnderlineSpan(), sStart, sEnd, 0);
        }

        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString, TextView.BufferType.SPANNABLE);
    }
}
