package app.base

import android.app.Dialog
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class BaseActivity : AppCompatActivity() {

    @LayoutRes
    abstract fun layoutId(): Int

    lateinit var dialog: Dialog

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
    }

    protected fun setLinearRecyclerView(
        recyclerView: RecyclerView,
        orientation: Int = RecyclerView.VERTICAL,
        reverseLayout: Boolean = false,
        hasFixedSize: Boolean = false,
        isNestedScrollingEnabled: Boolean = false
    ): RecyclerView {
        val linearLayoutManager = LinearLayoutManager(this, orientation, reverseLayout)
        recyclerView.setHasFixedSize(hasFixedSize)
        recyclerView.isNestedScrollingEnabled = isNestedScrollingEnabled
        recyclerView.layoutManager = linearLayoutManager
        return recyclerView
    }

    protected fun setGridRecyclerView(
        recyclerView: RecyclerView,
        orientation: Int = RecyclerView.VERTICAL,
        spanCount: Int = 2,
        reverseLayout: Boolean = false,
        hasFixedSize: Boolean = false,
        isNestedScrollingEnabled: Boolean = false
    ): RecyclerView {
        val gridLayoutManager = GridLayoutManager(this, spanCount, orientation, reverseLayout)
        recyclerView.setHasFixedSize(hasFixedSize)
        recyclerView.isNestedScrollingEnabled = isNestedScrollingEnabled
        recyclerView.layoutManager = gridLayoutManager
        return recyclerView
    }

    fun showLoading() {
//        dialog = Dialog(this@BaseActivity)
//        val inflate = LayoutInflater.from(this@BaseActivity).inflate(R.layout.dialog_progress, null)
//        dialog.setContentView(inflate)
//        dialog.setCancelable(false)
//        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        dialog.show()
    }

    fun hideLoading() {
//        if (dialog.isShowing) {
//            dialog.cancel()
//        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}