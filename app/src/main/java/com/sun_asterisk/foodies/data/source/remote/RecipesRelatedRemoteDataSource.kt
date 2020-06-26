package com.sun_asterisk.foodies.data.source.remote

import com.sun_asterisk.foodies.data.model.RecipesRelated
import com.sun_asterisk.foodies.data.model.RecipesRelatedEntry
import com.sun_asterisk.foodies.data.source.datasource.RecipesRelatedDataSource
import com.sun_asterisk.foodies.data.source.remote.base_url.BaseUrl
import com.sun_asterisk.foodies.data.source.remote.fetchjson.GetJsonFromURL

class RecipesRelatedRemoteDataSource : RecipesRelatedDataSource.Remote {

    override fun getRecipesRelatedInfo(ingredientName: String?, listener: OnFetchDataJsonListener<List<RecipesRelated>?>) {
        GetJsonFromURL(RecipesRelatedEntry.OBJECT, listener).execute(BaseUrl.baseUrlRecipesRelated(ingredientName))
    }

    companion object {
        private var instance: RecipesRelatedDataSource.Remote? = null
        fun getInstance() =
            instance ?: RecipesRelatedRemoteDataSource().also { instance = it }
    }
}
