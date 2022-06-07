package tahadeta.example.popularmovies.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.popularmovies.R

class PlanSliderItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.plan_slider_item_view, this)
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.PlanSliderItemView)

        val title = typedArray.getString(R.styleable.PlanSliderItemView_sliderItemTitle)
        val index = typedArray.getString(R.styleable.PlanSliderItemView_sliderItemIndex)
        val isChecked = typedArray.getBoolean(R.styleable.PlanSliderItemView_sliderItemIsChecked, false)

        typedArray.recycle()
        setTitle(title, isChecked)
        setIndex(index)
        setChecked(isChecked)
    }

    fun setTitle(cardTitle: String?, isChecked: Boolean) {
        val title: TextView = findViewById(R.id.cardTitle)
        title.text = cardTitle
        if (!isChecked) title.alpha = 0.2f
        else title.alpha = 1f
    }

    fun setIndex(cardIndex: String?) {
        val index: TextView = findViewById(R.id.index)
        index.text = cardIndex
    }

    fun setChecked(isChecked: Boolean) {
        val bullet: View = findViewById(R.id.bulletContainer)
        if (isChecked) bullet.visibility = View.VISIBLE else bullet.visibility = View.GONE
        val separator: View = findViewById(R.id.separator)

        if (isChecked) separator.visibility = View.VISIBLE else separator.visibility = View.GONE

        val title: TextView = findViewById(R.id.cardTitle)
        if (!isChecked) title.alpha = 0.2f
        else title.alpha = 1f
    }
}
