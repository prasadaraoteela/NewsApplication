package com.test.news.headlines

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.test.news.R
import com.test.news.ui.hide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_headlines.*
import kotlinx.android.synthetic.main.content_headlines.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HeadlinesActivity : AppCompatActivity() {

    private val headlinesViewModel: HeadlinesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_headlines)

        setSupportActionBar(toolbar)

        val headlinesListAdapter = HeadlinesListAdapter()
        headlinesListView.adapter = headlinesListAdapter
//        headlinesViewModel.observeHeadlines(1, 10).observe(this, Observer { result ->
//            when (result) {
//                is Result.Loading -> progressBar.show()
//                is Result.Failure -> layoutContainer.showSnackBar(result.error)
//                is Result.Success -> {
//                    progressBar.hide()
//                    headlinesListAdapter.submitList(result.data)
//                }
//            }
//        })
        lifecycleScope.launch {
            headlinesViewModel.observeHeadlines().collectLatest { pagingData ->
                progressBar.hide()
                headlinesListAdapter.submitData(pagingData)
            }
        }
    }
}