package com.example.s191179lykkehjulet.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.s191179lykkehjulet.R
import com.example.s191179lykkehjulet.data.GameViewModel
import com.example.s191179lykkehjulet.fragments.WordListDirections
import com.example.s191179lykkehjulet.model.Category



//MANGLER OPRYDNING
/**
 * adapter for RecyclerView i Mainactivity. Viser category data object
 */
class CategoryAdapter() : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    val category = listOf<Category>(
        Category(R.string.category1, R.drawable.sport),
        Category(R.string.category2, R.drawable.music),
        Category(R.string.category3, R.drawable.history),
        Category(R.string.category4, R.drawable.geography),
        Category(R.string.category5, R.drawable.biology)
    )

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object.
    class CategoryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val button: Button = view.findViewById(R.id.button_item)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount(): Int {
       return category.size
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val adapterLayout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        return CategoryViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {

        val item = category[position]

        holder.imageView.setImageResource(item.imageResourceId)
        holder.button.setText(item.StringResourceId)

        holder.button.setOnClickListener{

            //val categorygame = holder.button.text.toString()
            //navigate to next screen on click of any button
            val action = WordListDirections.actionWordListToFragmentWordGame(holder.button.text.toString())
            holder.view.findNavController().navigate(action)
        }
    }
}
