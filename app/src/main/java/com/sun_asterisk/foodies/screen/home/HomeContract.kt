package com.sun_asterisk.foodies.screen.home

import com.sun_asterisk.foodies.data.model.Recipes
import com.sun_asterisk.foodies.utils.BasePresenter

class HomeContract {
    /**
     * View
     */
    interface View {
        fun onGetRecipesSuccess(info: MutableList<Recipes>?)
        fun onGetRecipesError(exception: Exception?)
    }

    /**
     * Presenter
     */
    interface Presenter : BasePresenter<View> {
        fun getRecipes()
    }
}
