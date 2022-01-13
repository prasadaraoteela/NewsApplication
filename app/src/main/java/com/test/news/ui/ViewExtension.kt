package com.test.news.ui

import android.view.View
import android.widget.ProgressBar
import com.google.android.material.snackbar.Snackbar

/**
 * Created by Prasad Rao on 10-08-2020 20:16
 **/
fun ProgressBar.show() {
  visibility = View.VISIBLE
}

fun ProgressBar.hide() {
  visibility = View.GONE
}

fun View.showSnackBar(message: String) {
  Snackbar.make(this, message, Snackbar.LENGTH_SHORT).show()
}