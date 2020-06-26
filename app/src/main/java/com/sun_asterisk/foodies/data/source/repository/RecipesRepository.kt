package com.sun_asterisk.foodies.data.source.repository

import com.sun_asterisk.foodies.data.model.Recipes
import com.sun_asterisk.foodies.data.source.datasource.RecipesDataSource
import com.sun_asterisk.foodies.data.source.datasource.RecipesRelatedDataSource
import com.sun_asterisk.foodies.data.source.remote.OnFetchDataJsonListener

class RecipesRepository private constructor(private val remote: RecipesDataSource.Remote) {

    fun getRecipesInfo(listener: OnFetchDataJsonListener<MutableList<Recipes>>) {
        remote.getRecipesInfo(listener)
    }

    companion object {
        private var instance: RecipesRepository? = null
        fun getInstance(remote: RecipesDataSource.Remote) =
            instance ?: RecipesRepository(remote).also { instance = it }
    }
}
