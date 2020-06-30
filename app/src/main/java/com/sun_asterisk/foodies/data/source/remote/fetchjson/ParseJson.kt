package com.sun_asterisk.foodies.data.source.remote.fetchjson

import com.sun_asterisk.foodies.data.model.*
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

    fun recipesRelatedParseJson(jsonObject: JSONObject) =
        RecipesRelated(
            name = jsonObject.getString(RecipesRelatedEntry.TITTLE),
            image = jsonObject.getString(RecipesRelatedEntry.IMAGE),
            like = jsonObject.getInt(RecipesRelatedEntry.LIKE)
        )
}
