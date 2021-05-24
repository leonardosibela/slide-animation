# Fande-in and translate animation

An example showing how to use animations using the [AnimationUtils](https://developer.android.com/reference/android/view/animation/AnimationUtils) class [loading an Animation object from a xml resource](https://developer.android.com/reference/android/view/animation/AnimationUtils#loadAnimation(android.content.Context,%20int)).

## XML Implementation

First we have to create our animation resource which in our case will be a fade animation (alpha animation) and a slide up animation (translate animation):

```xml
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android">

    <translate
        android:fromYDelta="100%"
        android:toYDelta="0%" />

    <alpha
        android:fromAlpha="0"
        android:toAlpha="1" />

</set>
```

On the translate animation we are defining that there will be a motion on the Y axis going from 100% (from the bottom of the object being animated) to 0% (to the current place where the object being animated is on the xml layout file).

## Code implementation

To animate a view android, we must create and [Animation](https://developer.android.com/reference/android/view/animation/Animation) object from our animation resource. In our example, we apply to this object the animation duration, a "FastOutSlowIn" interpolator and a startOffset (a value which allows for an adjustment of the Z ordering of the content being animated for the duration of the animation). In our case we wrap it all in a extension function of the [View](https://developer.android.com/reference/android/view/View) class.

```kotlin
fun View.slideUpAlpha(animTime: Long, startOffset: Long) {
    val slideUpAlpha = AnimationUtils.loadAnimation(context, R.anim.fade_slide_up).apply {
        duration = animTime
        interpolator = FastOutSlowInInterpolator()
        this.startOffset = startOffset
    }
    startAnimation(slideUpAlpha)
}
```

All we have to do next is to call our extension function passing the duranting and the offSet:

```kotlin
binding.helloWorld.slideUpAlpha(1_000, 0)
```
