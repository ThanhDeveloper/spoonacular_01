package com.sun_asterisk.foodies.data.source.remote.fetchjson

import android.os.AsyncTask
import com.sun_asterisk.foodies.data.model.RecipesRelatedEntry
import com.sun_asterisk.foodies.data.source.remote.OnFetchDataJsonListener
import org.json.JSONArray
import org.json.JSONObject

class GetJsonFromURL<T> constructor(
    private val keyEntity: String,
    private val listener: OnFetchDataJsonListener<T>
) : AsyncTask<String?, Void?, Any?>() {

    private var exception: Exception? = null

    override fun doInBackground(vararg params: String?): Any? {
        try {
            val parseDataWithJson = ParseDataWithJson()
            val objectJson = parseDataWithJson.getJsonFromUrl(params[0]).toString()
            if(!objectJson.isBlank()) {
                return when (keyEntity) {
                    RecipesRelatedEntry.OBJECT -> {
                        val jsonArray = JSONArray(objectJson)
                        ParseDataWithJson().parseJsonToData(keyEntity, jsonArray)
                    }
                    else -> {
                        val jsonObject = JSONObject(objectJson)
                        ParseDataWithJson().parseJsonToData(keyEntity, jsonObject)
                    }
                }
            }
        } catch (e: Exception) {
            exception = e
        }
        return null
    }

    override fun onPostExecute(data: Any?) {
        super.onPostExecute(data)
        if (data != null) {
            @Suppress("UNCHECKED_CAST")
            listener.onSuccess(data as T)
        } else {
            exception?.let(listener::onError)
        }
    }
}
