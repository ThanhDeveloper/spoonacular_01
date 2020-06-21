package com.sun_asterisk.foodies.screen.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sun_asterisk.foodies.R
import com.sun_asterisk.foodies.screen.home.layout_adapter.Ingredient
import com.sun_asterisk.foodies.screen.home.layout_adapter.IngredientsAdapter
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCarousel()
        initIngredientsRecyclerView()
    }

    private fun initCarousel() {
        val carouselImages = resources.obtainTypedArray(R.array.carousel_images)
        val imageListener =
            ImageListener { position, imageView ->
                imageView.setImageResource(
                    carouselImages.getResourceId(position, 0)
                )
            }
        carouselView.apply {
            setImageListener(imageListener)
            pageCount = carouselImages.length()
        }
    }

    private fun initIngredientsRecyclerView() {
        val ingredientsText = resources.getStringArray(R.array.ingredient_names)
        val ingredientsImages = resources.obtainTypedArray(R.array.ingredient_images)
        val ingredientList = mutableListOf<Ingredient>()
        for (i in ingredientsText.indices) {
            ingredientList.add(
                Ingredient(
                    ingredientsImages.getResourceId(i, 0),
                    ingredientsText[i]
                )
            )
        }
        val ingredientsAdapter = IngredientsAdapter(ingredientList)
        recyclerIngredients.adapter = ingredientsAdapter
    }
}
