package com.sun_asterisk.foodies.screen.home.layout_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun_asterisk.foodies.R

class IngredientsAdapter(private val ingredient: MutableList<Ingredient> = mutableListOf()) :
    RecyclerView.Adapter<IngredientViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        val itemview: View =
            LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return IngredientViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        holder.bindData(ingredient[position])
    }

    override fun getItemCount() = ingredient.size
}
