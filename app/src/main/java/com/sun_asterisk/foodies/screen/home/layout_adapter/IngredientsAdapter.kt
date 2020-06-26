package com.sun_asterisk.foodies.screen.home.layout_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun_asterisk.foodies.R
import com.sun_asterisk.foodies.data.model.Ingredient
import com.sun_asterisk.foodies.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.row_layout.view.*

class IngredientsAdapter(private val ingredient: MutableList<Ingredient> = mutableListOf()) :
    RecyclerView.Adapter<IngredientsAdapter.ViewHolder<Ingredient>>() {

    private var onItemClickListener: OnItemRecyclerViewClickListener<Ingredient>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<Ingredient> {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return ViewHolder(itemView, onItemClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder<Ingredient>, position: Int) {
        holder.bindData(ingredient[position])
    }

    override fun getItemCount() = ingredient.size

    fun registerItemRecyclerViewClickListener(
        onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<Ingredient>?) {
        onItemClickListener = onItemRecyclerViewClickListener
    }

    class ViewHolder<T>(
        itemView: View,
        onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<Ingredient>?
    ) : RecyclerView.ViewHolder(itemView) {

        private var item: Ingredient? = null

        init {
            itemView.setOnClickListener {
                item?.let {
                    onItemRecyclerViewClickListener?. onItemClickListener(it) }
            }
        }

        fun bindData(ingredient: Ingredient) {
            item = ingredient
            itemView.run {
                textIngredientName.text = ingredient.name
                imageIngredient.setImageResource(ingredient.imageResId)
            }
        }
    }
}
