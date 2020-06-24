package com.sun_asterisk.foodies.screen.home

import com.sun_asterisk.foodies.data.model.Recipes
import com.sun_asterisk.foodies.data.source.RecipesRepository
import com.sun_asterisk.foodies.data.source.remote.OnFetchDataJsonListener

class HomePresenter internal constructor(private val repository: RecipesRepository?) :
    HomeContract.Presenter {

    private var view: HomeContract.View? = null

    override fun onStart() {
        getRecipes()
    }

    override fun setView(view: HomeContract.View?) {
        this.view = view
    }

    override fun getRecipes() {
        repository?.getRecipesInfo(object : OnFetchDataJsonListener<MutableList<Recipes>> {

            override fun onSuccess(data: MutableList<Recipes>) {
                view?.onGetRecipesSuccess(data)
            }

            override fun onError(exception: java.lang.Exception) {
                view?.onGetRecipesError(exception)
            }
        })
    }
}
