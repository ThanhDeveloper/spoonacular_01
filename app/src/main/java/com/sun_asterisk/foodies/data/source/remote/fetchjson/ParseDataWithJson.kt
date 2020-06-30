package com.sun_asterisk.foodies.data.source.remote.fetchjson

import com.sun_asterisk.foodies.data.model.ProductEntry
import com.sun_asterisk.foodies.data.model.RecipesEntry
import com.sun_asterisk.foodies.data.model.RecipesRelatedEntry
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class ParseDataWithJson {

    @Throws(Exception::class)
    fun getJsonFromUrl(urlString: String?): String? {
        val url = URL(urlString)
        val httpURLConnection = url.openConnection() as HttpURLConnection
        httpURLConnection.apply {
            connectTimeout = TIME_OUT
            readTimeout = TIME_OUT
            requestMethod = METHOD_GET
            connect()
        }
        val bufferedReader = BufferedReader(InputStreamReader(url.openStream()))
        val stringBuilder = StringBuilder()
        var line: String?
        while ( bufferedReader.readLine().also { line = it } != null) {
            stringBuilder.append(line)
        }
        bufferedReader.close()
        httpURLConnection.disconnect()
        return stringBuilder.toString()
    }

    fun parseJsonToData(keyEntity: String, jsonObject: JSONObject?): Any {
        val data = mutableListOf<Any>()
        try {
            val jsonArray = jsonObject?.getJSONArray(keyEntity)
            for (i in 0 until (jsonArray?.length() ?: 0)) {
                val jsonObjects = jsonArray?.getJSONObject(i)
                val item = ParseDataWithJson().parseJsonToObject(keyEntity, jsonObjects)
                item?.let { data.add(it) }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return data
    }

    fun parseJsonToData(keyEntity: String, jsonObjectArray: JSONArray?): Any {
        val data = mutableListOf<Any>()
        try {
            for (i in 0 until (jsonObjectArray?.length() ?: 0)) {
                val jsonObjects = jsonObjectArray?.getJSONObject(i)
                val item = ParseDataWithJson().parseJsonToObject(keyEntity, jsonObjects)
                item?.let { data.add(it) }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return data
    }

    private fun parseJsonToObject(keyEntity: String, jsonObject: JSONObject?) : Any? =
        try {
            jsonObject?.let {
                when(keyEntity) {
                    RecipesEntry.OBJECT -> ParseJson().recipesParseJson(jsonObject)
                    ProductEntry.OBJECT -> ParseJson().productParseJson(jsonObject)
                    RecipesRelatedEntry.OBJECT -> ParseJson().recipesRelatedParseJson(jsonObject)
                    else -> null
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
            null
        }

    companion object {
        private const val TIME_OUT = 15000
        private const val METHOD_GET = "GET"
    }
}
