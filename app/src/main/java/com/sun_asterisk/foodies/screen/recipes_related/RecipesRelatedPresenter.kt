package com.sun_asterisk.foodies.screen.home

import com.sun_asterisk.foodies.data.model.RecipesRelated
import com.sun_asterisk.foodies.data.source.remote.OnFetchDataJsonListener
import com.sun_asterisk.foodies.data.source.repository.RecipesRelatedRepository

class RecipesRelatedPresenter(
    private val recipesRelatedRepository: RecipesRelatedRepository?
) : RecipesRelatedContract.Presenter {

    private var view: RecipesRelatedContract.View? = null

    override fun setView(view: RecipesRelatedContract.View?) {
        this.view = view
    }

    override fun getRecipesRelated(ingredientName: String?) {
        recipesRelatedRepository?.getRecipesRelatedInfo(ingredientName,
            object : OnFetchDataJsonListener<List<RecipesRelated>?> {
                override fun onSuccess(data: List<RecipesRelated>?) {
                    view?.onGetRecipesRelatedSuccess(data)
                }

                override fun onError(exception: java.lang.Exception) {
                    view?.onGetRecipesRelatedError(exception)
                }
            })
    }
}
