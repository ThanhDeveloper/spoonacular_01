package com.sun_asterisk.foodies.data.source.repository

import com.sun_asterisk.foodies.data.model.Product
import com.sun_asterisk.foodies.data.source.datasource.ProductDataSource
import com.sun_asterisk.foodies.data.source.remote.OnFetchDataJsonListener
import com.sun_asterisk.foodies.data.source.remote.ProductRemoteDataSource

class ProductRepository private constructor(private val remote: ProductDataSource.Remote) {

    fun getProductInfo(listener: OnFetchDataJsonListener<MutableList<Product>>) {
        remote.getProductInfo(listener)
    }

    companion object {
        private var instance: ProductRepository? = null
        fun getInstance(remote: ProductDataSource.Remote) =
            instance ?: ProductRepository(remote).also { instance = it }
    }
}
