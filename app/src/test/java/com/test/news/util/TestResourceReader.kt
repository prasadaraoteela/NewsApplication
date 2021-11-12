package com.test.news.util

import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.test.news.data.source.network.dto.NetworkNews
import com.test.news.model.Headline

/**
 * Created by Prasad Rao on 11-08-2020 16:29
 **/
object TestResourceReader {

    fun readHeadlines(fileName: String): List<Headline> {
        readResource(fileName)?.let { data ->
            val parser = JsonParser()
            val type = object : TypeToken<MutableList<Headline>>() {}.type
            return Gson().fromJson(parser.parse(data), type)
        }
        return emptyList()
    }

    fun readNetworkNewsResponse(fileName: String): NetworkNews? {
        readResource(fileName)?.let { data ->
            val parser = JsonParser()
            return Gson().fromJson(parser.parse(data), NetworkNews::class.java)
        }
        return null
    }

    private fun readResource(fileName: String): String? {
        Thread.currentThread().contextClassLoader?.getResourceAsStream(fileName)?.use { stream ->
            return stream.readBytes().toString(Charsets.UTF_8)
        }
        return null
    }
}