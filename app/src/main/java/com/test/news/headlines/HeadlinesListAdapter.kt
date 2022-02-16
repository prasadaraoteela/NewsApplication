package com.test.news.headlines

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.news.R
import com.test.news.details.HeadlineDetailsActivity
import com.test.news.model.Headline
import com.test.news.model.toBundle
import kotlinx.android.synthetic.main.list_item_headline.view.*

/**
 * Created by Prasad Rao on 11-08-2020 11:43
 **/
class HeadlinesListAdapter :
    PagingDataAdapter<Headline, HeadlinesListAdapter.ViewHolder>(HeadlineDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_headline, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val headlineTitle: TextView = itemView.labelHeadlineTitle
        private val headlineSource: TextView = itemView.labelHeadlineSource
        private val headlinePublishedDate: TextView = itemView.labelHeadlineDate
        private val headlineImage: ImageView = itemView.imageHeadline
        fun bindTo(headline: Headline?) {
            headline?.let {
                headlineTitle.text = headline.title
                headlineSource.text = headline.source
                headlinePublishedDate.text = headline.date
                Glide.with(itemView.context)
                    .load(headline.imageUrl)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(headlineImage)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, HeadlineDetailsActivity::class.java)
                    intent.putExtras(headline.toBundle())
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    class HeadlineDiffCallback : DiffUtil.ItemCallback<Headline>() {
        override fun areItemsTheSame(oldItem: Headline, newItem: Headline): Boolean {
            return oldItem.title == newItem.title && oldItem.description == newItem.description
        }

        override fun areContentsTheSame(oldItem: Headline, newItem: Headline): Boolean {
            return oldItem == newItem
        }
    }
}