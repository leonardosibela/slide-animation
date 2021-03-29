package com.sibela.slideanimation

import android.view.View
import android.view.animation.AnimationUtils
import androidx.interpolator.view.animation.FastOutSlowInInterpolator

fun View.slideUpAlpha(animTime: Long, startOffset: Long) {
    val slideUpAlpha = AnimationUtils.loadAnimation(context, R.anim.fade_slide_up).apply {
        duration = animTime
        interpolator = FastOutSlowInInterpolator()
        this.startOffset = startOffset
    }
    startAnimation(slideUpAlpha)
}