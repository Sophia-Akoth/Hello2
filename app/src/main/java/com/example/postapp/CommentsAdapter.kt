package com.example.postapp

import com.example.postapp.UI.PostItemOnclickListener

class CommentsAdapter(val postList: List<String>) {
    RecyclerView.Adapter<PostsRecyclerViewAdapter.NamesViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NamesViewHolder {
            var itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.row_name_item, parent, false)
            return NamesViewHolder(itemView)
        }
        override fun getItemCount(): Int {
            return postList.size
        }
        override fun onBindViewHolder(holder: NamesViewHolder, position: Int) {
            holder.rowView.tvPosts.Title = postList[position]
            holder.rowView.tvPosts.Body= postList[position]
            holder.rowView.tvPosts.comments = postList[position]

            PostItemOnclickListener.onItemClick(post)

        }
        class NamesViewHolder(val rowView: View) : RecyclerView.ViewHolder(rowView)
    }
}
}