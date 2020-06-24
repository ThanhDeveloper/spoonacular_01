package com.sun_asterisk.foodies.screen.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.sun_asterisk.foodies.R
import com.sun_asterisk.foodies.data.model.Recipes
import com.sun_asterisk.foodies.data.source.RecipesRepository
import com.sun_asterisk.foodies.data.model.Ingredient
import com.sun_asterisk.foodies.screen.home.layout_adapter.IngredientsAdapter
import com.sun_asterisk.foodies.screen.home.layout_adapter.RecipesAdapter
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View {

    private val recipesAdapter by lazy { RecipesAdapter() }

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
        initData()
        recyclerRecipes.adapter = recipesAdapter
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
        carouselImages.recycle()
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
        ingredientsImages.recycle()
        val ingredientsAdapter = IngredientsAdapter(ingredientList)
        recyclerIngredients.adapter = ingredientsAdapter
    }

    override fun onGetRecipesSuccess(info: MutableList<Recipes>?) {
        info?.let { recipesAdapter.updateData(it) }
    }

    override fun onGetRecipesError(exception: Exception?) {
        Toast.makeText(this.context,exception.toString(),Toast.LENGTH_SHORT).show()
    }

    private fun initData() {
        val presenter = HomePresenter(RecipesRepository.instance)
        presenter.let {
            it.setView(this)
            it.onStart()
        }
    }
}
