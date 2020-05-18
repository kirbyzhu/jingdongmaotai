package tv.huan.myapplication.utils

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.provider.Settings

/**
 * Create by cml on 2020-05-15
 */
fun isAccessibilityServiceON(context: Context, className: String): Boolean {
    val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    val runningServices = activityManager.getRunningServices(100)
    if (runningServices.size < 0) {
        return false
    }
    for (i in runningServices.indices) {
        val service = runningServices[i].service
        if (service.className.contains(className)) {
            return true
        }
    }
    return false
}

fun goSettingForAccessibility(context: Context){
    val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
    context.startActivity(intent)
}