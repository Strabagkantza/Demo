package com.isolina.demo.ui.fragments.publications.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.isolina.demo.databinding.ItemPublicationBinding
import com.isolina.demo.domain.models.Publication

class PublicationItemAdapter(private val onClickListener: (Publication) -> Unit) :
    ListAdapter<Publication, PublicationItemAdapter.ViewHolder>(DiffutilCallbackStore) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPublicationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val publication = getItem(position)
        holder.bind(publication)
        holder.itemView.setOnClickListener { onClickListener(publication) }
    }

    class ViewHolder(private val binding: ItemPublicationBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(publication: Publication) {
              binding.title.text = publication.publicationName
        }
    }

}


private object DiffutilCallbackStore: DiffUtil.ItemCallback<Publication>(){
    override fun areItemsTheSame(oldItem: Publication, newItem: Publication): Boolean =
        oldItem.publicationId == newItem.publicationId

    override fun areContentsTheSame(oldItem: Publication, newItem: Publication): Boolean =
        oldItem == newItem
}