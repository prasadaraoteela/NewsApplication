package com.test.news.model

import android.os.Bundle

/**
 * Created by Prasad Rao on 10-08-2020 19:39
 **/
data class Headline(
    val title: String,
    val description: String,
    val imageUrl: String,
    val date: String,
    val source: String,
    val page: Int = 1
)

private const val KEY_HEADLINE_TITLE = "headline_title"
private const val KEY_HEADLINE_DESCRIPTION = "headline_description"
private const val KEY_HEADLINE_IMAGE_URL = "headline_image_url"
private const val KEY_HEADLINE_PUBLISHED_DATE = "headline_published_date"
private const val KEY_HEADLINE_SOURCE = "headline_source"

fun Headline.toBundle(): Bundle {
    return Bundle().apply {
        putString(KEY_HEADLINE_TITLE, title)
        putString(KEY_HEADLINE_DESCRIPTION, description)
        putString(KEY_HEADLINE_IMAGE_URL, imageUrl)
        putString(KEY_HEADLINE_PUBLISHED_DATE, date)
        putString(KEY_HEADLINE_SOURCE, source)
    }
}

fun Bundle.toHeadline(): Headline {
    return Headline(
        title = getString(KEY_HEADLINE_TITLE, ""),
        description = getString(KEY_HEADLINE_DESCRIPTION, ""),
        imageUrl = getString(KEY_HEADLINE_IMAGE_URL, ""),
        date = getString(KEY_HEADLINE_PUBLISHED_DATE, ""),
        source = getString(KEY_HEADLINE_SOURCE, "")
    )
}