package app.core.util

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import app.core.util.enums.AppStart

object AppStartUtils {

    /**
     * The app version code (not the version name!) that was used on the last
     * start of the app.
     */
    private const val LAST_APP_VERSION = "last_app_version"
    private const val INTRODUCTION = "Introduction"

    /**
     * Finds out started for the first time (ever or in the current version).<br></br>
     * <br></br>
     * Note: This method is **not idempotent** only the first call will
     * determine the proper result. Any subsequent calls will only return
     * [AppStart.NORMAL] until the app is started again. So you might want
     * to consider caching the result!
     *
     * @return the type of app start
     */
    fun checkAppStart(context: Context): AppStart {
        val pInfo: PackageInfo
        val sharedPreferences = context.getSharedPreferences(INTRODUCTION, Context.MODE_PRIVATE)
        var appStart = AppStart.NORMAL
        try {
            pInfo = context.packageManager.getPackageInfo(context.packageName, 0)
            val lastVersionCode = sharedPreferences.getLong(LAST_APP_VERSION, -1L)
            val currentVersionCode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                pInfo.longVersionCode
            } else {
                pInfo.versionCode.toLong()
            }
            appStart = checkAppStart(currentVersionCode, lastVersionCode)
        } catch (e: PackageManager.NameNotFoundException) {
            Log.w(
                "App Start",
                "Unable to determine current app version from pacakge manager. Defensively assuming normal app start."
            )
        }
        return appStart
    }

    private fun checkAppStart(currentVersionCode: Long, lastVersionCode: Long): AppStart {
        return when {
            lastVersionCode == -1L -> AppStart.FIRST_TIME
            lastVersionCode < currentVersionCode -> AppStart.FIRST_TIME_VERSION
            lastVersionCode > currentVersionCode -> {
                Log.w(
                    "App Start", "Current version code (" + currentVersionCode
                            + ") is less then the one recognized on last startup ("
                            + lastVersionCode
                            + "). Defensively assuming normal app start."
                )
                AppStart.NORMAL
            }
            else -> AppStart.NORMAL
        }
    }

    fun updateVersionAppStart(context: Context) {
        val sharedPreferences = context.getSharedPreferences(INTRODUCTION, Context.MODE_PRIVATE)
        try {
            val pInfo = context.packageManager.getPackageInfo(context.packageName, 0)
            val currentVersionCode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                pInfo.longVersionCode
            } else {
                pInfo.versionCode.toLong()
            }
            // Update version in preferences
            sharedPreferences.edit().putLong(LAST_APP_VERSION, currentVersionCode).apply()
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
    }
}
