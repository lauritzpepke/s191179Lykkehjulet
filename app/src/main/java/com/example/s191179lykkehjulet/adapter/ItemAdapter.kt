package com.example.s191179lykkehjulet.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.s191179lykkehjulet.R
import com.example.s191179lykkehjulet.model.Category


//MANGLER OPRYDNING
/**
 * adapter for RecyclerView i Mainactivity. Viser category data object
 */
class ItemAdapter() : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private val category = listOf<Category>(
        Category(R.string.category1),
        Category(R.string.category2),
        Category(R.string.category3),
        Category(R.string.category4),
        Category(R.string.category5))

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object.
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = category.size

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = category
        holder.textView.text = toString()
    }
}
