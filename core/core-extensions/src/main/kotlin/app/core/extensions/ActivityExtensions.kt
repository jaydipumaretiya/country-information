package app.core.extensions

import android.app.Activity
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

/**
 *  Helper method to log debug events to logcat
 */
fun Activity.log(msg: String) {
//    if (BuildConfig.DEBUG) {
        Log.d(this.javaClass.simpleName, msg)
//    }
}

fun Activity.toast(msg: String) {
//    if (BuildConfig.DEBUG) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
//    }
}

/**
 *  Helper method to get device screen width
 */
fun Activity.screenWidth(): Int {
    val metrics: DisplayMetrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(metrics)
    return metrics.widthPixels
}

/**
 *  Helper method to get device screen height
 */
fun Activity.screenHeight(): Int {
    val metrics: DisplayMetrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(metrics)
    return metrics.heightPixels
}

/**
 * Hide Keyboard
 */
fun Activity.hideKeyboard() {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(findViewById<View>(android.R.id.content).windowToken, 0)
}

/**
 * EditText AfterChanged method
 */
fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })
}

/**
 * Helper method used in activity to replace a Fragment
 */
fun AppCompatActivity.replaceFragment(
    fragment: Fragment, frameId: Int, tag: String?,
    isAddToBackStack: Boolean = false
) {
    supportFragmentManager.transact {
        replace(frameId, fragment, tag)
        if (isAddToBackStack) addToBackStack(tag)
    }
}

/**
 * Helper method used in activity to replace a Fragment
 */
fun AppCompatActivity.addFragment(
    fragment: Fragment, frameId: Int, tag: String?,
    isAddToBackStack: Boolean = false
) {
    supportFragmentManager.transact {
        add(frameId, fragment, tag)
        if (isAddToBackStack) addToBackStack(tag)
    }
}


private inline fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
    beginTransaction().apply { action() }.commit()
}

