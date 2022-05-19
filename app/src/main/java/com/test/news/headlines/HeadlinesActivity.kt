package com.test.news.headlines

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.test.news.databinding.ActivityHeadlinesBinding
import com.test.news.ui.hide
import com.test.news.ui.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HeadlinesActivity : AppCompatActivity() {

    private val binding: ActivityHeadlinesBinding by viewBinding(ActivityHeadlinesBinding::inflate)

    private val headlinesViewModel: HeadlinesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(binding.toolbar)

        val headlinesListAdapter = HeadlinesListAdapter()
        binding.headlinesContentLayout.headlinesListView.adapter = headlinesListAdapter
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
                binding.headlinesContentLayout.progressBar.hide()
                headlinesListAdapter.submitData(pagingData)
            }
        }
    }
}