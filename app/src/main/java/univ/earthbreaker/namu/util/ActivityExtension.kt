package univ.earthbreaker.namu.util

import android.app.Activity

fun Activity.finishSafely() {
    if (!isFinishing) finish()
}
