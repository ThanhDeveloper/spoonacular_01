package com.sun_asterisk.foodies.data.source.remote.fetchjson

import com.sun_asterisk.foodies.data.model.Product
import com.sun_asterisk.foodies.data.model.ProductEntry
import com.sun_asterisk.foodies.data.model.Recipes
import com.sun_asterisk.foodies.data.model.RecipesEntry
import org.json.JSONObject

class ParseJson {

    fun recipesParseJson(jsonObject: JSONObject) =
        Recipes(
            name = jsonObject.getString(RecipesEntry.TITTLE),
            image = jsonObject.getString(RecipesEntry.IMAGE)
        )

    fun productParseJson(jsonObject: JSONObject) =
        Product(
            name = jsonObject.getString(ProductEntry.TITTLE),
            image = jsonObject.getString(ProductEntry.IMAGE)
        )
}
