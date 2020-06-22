package com.sun_asterisk.foodies.utils

import com.sun_asterisk.foodies.BuildConfig

object Constant {
    const val BASE_URL = "https://api.spoonacular.com/recipes/random?"
    const val BASE_NUMBER = "number=10"
    const val BASE_API_KEY = "&apiKey=" + BuildConfig.API_KEY
}
