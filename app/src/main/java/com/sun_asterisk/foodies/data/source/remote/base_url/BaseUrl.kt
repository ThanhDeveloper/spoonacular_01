package com.sun_asterisk.foodies.data.source.remote.base_url

import com.sun_asterisk.foodies.utils.Constant

object BaseUrl {
        const val baseRecipesUrl =
            Constant.BASE_URL + Constant.BASE_RECIPES_RANDOM + Constant.BASE_NUMBER + Constant.BASE_API_KEY
        const val baseProductUrl = Constant.BASE_URL +
                Constant.BASE_PRODUCT_SEARCH + Constant.BASE_QUERY + Constant.BASE_NUMBER + Constant.BASE_API_KEY
        fun baseUrlRecipesRelated(keyValues: String?) =
            Constant.BASE_URL + Constant.KEY_FIND_BY_INGREDIENT + keyValues + "&" + Constant.BASE_NUMBER + Constant.BASE_API_KEY
}
