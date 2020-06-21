package com.sun_asterisk.foodies.screen.home.layout_adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_layout.view.*

class IngredientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindData(ingredient: Ingredient) {
        itemView.run {
            textIngredientName.text = ingredient.name
            imageIngredient.setImageResource(ingredient.imageResId)
        }
    }
}
