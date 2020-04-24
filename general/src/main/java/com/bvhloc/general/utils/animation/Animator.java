package com.bvhloc.general.utils.animation;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;

/**
 * Created by Leon on 9/30/2016.
 */

public class Animator {

    public static Animation blinkAnimation() {

        Animation blinkAnimation = new AlphaAnimation(1, 0); // Change alpha from fully visible to invisible
        blinkAnimation.setDuration(300); // duration - half a second
        blinkAnimation.setStartOffset(200);
        blinkAnimation.setInterpolator(new LinearInterpolator()); // do not alter animation rate
        blinkAnimation.setRepeatCount(Animation.INFINITE); // Repeat animation infinitely
        blinkAnimation.setRepeatMode(Animation.REVERSE); // Reverse animation at the end so the button will fade back in
        return blinkAnimation;
    }
}
