package com.sun_asterisk.foodies.data.source.repository

import com.sun_asterisk.foodies.data.model.RecipesRelated
import com.sun_asterisk.foodies.data.source.datasource.RecipesRelatedDataSource
import com.sun_asterisk.foodies.data.source.remote.OnFetchDataJsonListener
import com.sun_asterisk.foodies.data.source.remote.ProductRemoteDataSource
import com.sun_asterisk.foodies.data.source.remote.RecipesRelatedRemoteDataSource

class RecipesRelatedRepository private constructor(private val remote: RecipesRelatedDataSource.Remote) {

    fun getRecipesRelatedInfo(ingredientName: String?, listener: OnFetchDataJsonListener<List<RecipesRelated>?>) {
        remote.getRecipesRelatedInfo(ingredientName, listener)
    }

    companion object {
        private var instance: RecipesRelatedRepository? = null
        fun getInstance(remote: RecipesRelatedDataSource.Remote) =
            instance ?: RecipesRelatedRepository(remote).also { instance = it }
    }
}
