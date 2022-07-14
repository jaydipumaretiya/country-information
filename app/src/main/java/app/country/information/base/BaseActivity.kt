package app.country.information.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 *  Base Activity for the entire app
 */
abstract class BaseActivity : AppCompatActivity() {

    /**
     *  Provides layout id to be inflated
     */
    @LayoutRes
    abstract fun layoutId(): Int

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        //Uncomment this line to have font enabled textviews
        //LayoutInflaterCompat.setFactory2(layoutInflater, LillyLayoutInflater(delegate))
        super.onCreate(savedInstanceState)
        title = ""
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
}