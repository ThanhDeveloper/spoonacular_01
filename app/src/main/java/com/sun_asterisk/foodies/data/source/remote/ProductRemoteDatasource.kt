package com.sun_asterisk.foodies.data.source.remote

import com.sun_asterisk.foodies.data.model.Product
import com.sun_asterisk.foodies.data.model.ProductEntry
import com.sun_asterisk.foodies.data.source.datasource.ProductDataSource
import com.sun_asterisk.foodies.data.source.remote.base_url.BaseUrl
import com.sun_asterisk.foodies.data.source.remote.fetchjson.GetJsonFromURL

class ProductRemoteDataSource : ProductDataSource.Remote {

    override fun getProductInfo(listener: OnFetchDataJsonListener<MutableList<Product>>) {
        GetJsonFromURL(ProductEntry.OBJECT, listener).execute(BaseUrl.baseProductUrl)
    }

    companion object {
        private var instance: ProductDataSource.Remote? = null
        fun getInstance() =
            instance ?: ProductRemoteDataSource().also { instance = it }
    }
}
