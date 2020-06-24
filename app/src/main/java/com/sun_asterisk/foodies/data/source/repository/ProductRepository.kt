package com.sun_asterisk.foodies.data.source.repository

import com.sun_asterisk.foodies.data.model.Product
import com.sun_asterisk.foodies.data.source.datasource.ProductDataSource
import com.sun_asterisk.foodies.data.source.remote.OnFetchDataJsonListener
import com.sun_asterisk.foodies.data.source.remote.ProductRemoteDatasource

class ProductRepository private constructor(private val remote: ProductDataSource.Remote) {

    private object Holder {
        val INSTANCE = ProductRepository(ProductRemoteDatasource.instance)
    }

    fun getProductInfo(listener: OnFetchDataJsonListener<MutableList<Product>>) {
        remote.getProductInfo(listener)
    }

    companion object {
        val instance: ProductRepository by lazy { Holder.INSTANCE }
    }
}
