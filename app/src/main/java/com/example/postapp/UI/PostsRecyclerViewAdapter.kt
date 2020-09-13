package com.example.postapp.UI

class PostsRecyclerViewAdapter (val postList: List<String>){
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
            holder.rowView.tvPosts.text = postList[position]
        }
        class NamesViewHolder(val rowView: View) : RecyclerView.ViewHolder(rowView)
    }
}