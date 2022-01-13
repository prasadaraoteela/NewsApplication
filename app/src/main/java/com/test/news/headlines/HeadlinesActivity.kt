package com.test.news.headlines

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.test.news.R
import com.test.news.ui.hide
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_headlines.*
import kotlinx.android.synthetic.main.content_headlines.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class HeadlinesActivity : DaggerAppCompatActivity() {

  @Inject
  lateinit var factory: HeadlinesViewModelFactory

  private lateinit var headlinesViewModel: HeadlinesViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_headlines)

    setSupportActionBar(toolbar)

    headlinesViewModel = ViewModelProvider(this, factory).get(HeadlinesViewModel::class.java)

    val headlinesListAdapter = HeadlinesListAdapter()
    headlinesListView.adapter = headlinesListAdapter

    lifecycleScope.launch {
      headlinesViewModel.observeHeadlines().collectLatest { pagingData ->
        progressBar.hide()
        headlinesListAdapter.submitData(pagingData)
      }
    }
  }
}