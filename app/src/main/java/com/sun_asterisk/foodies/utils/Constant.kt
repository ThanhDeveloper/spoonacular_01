package com.sun_asterisk.foodies.utils

import com.sun_asterisk.foodies.BuildConfig

object Constant {
    const val BASE_URL = "https://api.spoonacular.com/"
    const val BASE_NUMBER = "number=10"
    const val BASE_API_KEY = "&apiKey=" + BuildConfig.API_KEY
    const val BASE_QUERY = "query=vegetable&"
    const val BASE_PRODUCT_SEARCH = "food/products/search?"
    const val BASE_RECIPES_RANDOM = "recipes/random?"
}
