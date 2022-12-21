package com.isolina.demo.ui.fragments.issues.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.isolina.demo.R
import com.isolina.demo.databinding.ItemIssueBinding
import com.isolina.demo.domain.models.Issue

class IssueItemAdapter(private val onClickListener: (Issue) -> Unit) :
    ListAdapter<Issue, IssueItemAdapter.ViewHolder>(DiffutilCallbackStore) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemIssueBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val issue = getItem(position)
        holder.bind(issue)
        holder.itemView.setOnClickListener { onClickListener(issue) }
    }

    class ViewHolder(private val binding: ItemIssueBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(issue: Issue) {
            binding.title.text = issue.issueName
            val image = if (issue.isForSale) R.drawable.ic_buy else R.drawable.ic_download
            binding.image.setImageResource(image)
        }
    }

}


private object DiffutilCallbackStore: DiffUtil.ItemCallback<Issue>(){
    override fun areItemsTheSame(oldItem: Issue, newItem: Issue): Boolean =
        oldItem.issueId == newItem.issueId

    override fun areContentsTheSame(oldItem: Issue, newItem: Issue): Boolean =
        oldItem == newItem
}