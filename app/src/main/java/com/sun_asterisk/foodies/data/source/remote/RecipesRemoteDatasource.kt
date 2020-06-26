package com.sun_asterisk.foodies.data.source.remote

import com.sun_asterisk.foodies.data.model.Recipes
import com.sun_asterisk.foodies.data.model.RecipesEntry
import com.sun_asterisk.foodies.data.source.datasource.RecipesDataSource
import com.sun_asterisk.foodies.data.source.remote.base_url.BaseUrl
import com.sun_asterisk.foodies.data.source.remote.fetchjson.GetJsonFromURL

class RecipesRemoteDataSource : RecipesDataSource.Remote {

    override fun getRecipesInfo(listener: OnFetchDataJsonListener<MutableList<Recipes>>) {
        GetJsonFromURL(RecipesEntry.OBJECT, listener).execute(BaseUrl.baseRecipesUrl)
    }

    companion object {
        private var instance: RecipesDataSource.Remote? = null
        fun getInstance() =
            instance ?: RecipesRemoteDataSource().also { instance = it }
    }
}
