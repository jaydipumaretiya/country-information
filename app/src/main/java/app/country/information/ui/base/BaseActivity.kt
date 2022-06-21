package app.country.information.ui.base

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.country.information.R
import app.country.information.util.NetworkUtils

abstract class BaseActivity(layoutResID: Int) : AppCompatActivity(layoutResID) {

    lateinit var dialog: Dialog

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        setContent()
    }

    protected abstract fun setContent()

    val isNetworkConnected: Boolean
        get() {
            return if (!NetworkUtils.isNetworkConnected(this@BaseActivity)) {
                showErrorToast(getString(R.string.error_internet))
                false
            } else {
                true
            }
        }

    private fun showErrorToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    protected fun setLinearRecyclerView(
        recyclerView: RecyclerView,
        orientation: Int,
        reverseLayout: Boolean,
        hasFixedSize: Boolean,
        isNestedScrollingEnabled: Boolean
    ): RecyclerView {
        val linearLayoutManager = LinearLayoutManager(this, orientation, reverseLayout)
        recyclerView.setHasFixedSize(hasFixedSize)
        recyclerView.isNestedScrollingEnabled = isNestedScrollingEnabled
        recyclerView.layoutManager = linearLayoutManager
        return recyclerView
    }

    protected fun setGridRecyclerView(
        recyclerView: RecyclerView,
        orientation: Int,
        spanCount: Int,
        reverseLayout: Boolean,
        hasFixedSize: Boolean,
        isNestedScrollingEnabled: Boolean
    ): RecyclerView {
        val gridLayoutManager = GridLayoutManager(this, spanCount, orientation, reverseLayout)
        recyclerView.setHasFixedSize(hasFixedSize)
        recyclerView.isNestedScrollingEnabled = isNestedScrollingEnabled
        recyclerView.layoutManager = gridLayoutManager
        return recyclerView
    }

    fun showLoading() {
        dialog = Dialog(this@BaseActivity)
        val inflate = LayoutInflater.from(this@BaseActivity).inflate(R.layout.dialog_progress, null)
        dialog.setContentView(inflate)
        dialog.setCancelable(false)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

    fun hideLoading() {
        if (dialog.isShowing) {
            dialog.cancel()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}