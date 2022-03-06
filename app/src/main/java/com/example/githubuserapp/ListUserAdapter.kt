package com.example.githubuserapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListUserAdapter(private val listUser : ArrayList<User>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View, view2: View) : RecyclerView.ViewHolder(itemView) {
        var imgAvatar: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvUsername: TextView = itemView.findViewById(R.id.tv_user_username)
        var tvName: TextView = itemView.findViewById(R.id.tv_user_name)
        var tvCompany: TextView = view2.findViewById(R.id.tv_detail_company)
        var tvLocation: TextView = view2.findViewById(R.id.tv_detail_location)
        var tvRepository: TextView = view2.findViewById(R.id.tv_detail_repository)
        var tvFollowing: TextView = view2.findViewById(R.id.tv_detail_following)
        var tvFollowers: TextView = view2.findViewById(R.id.tv_detail_followers)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_user, parent, false)
        val view2: View = LayoutInflater.from(parent.context).inflate(R.layout.activity_detail, parent, false)
        return ListViewHolder(view, view2)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (username, name, avatar, company, location, repository, follower, following) = listUser[position]
        holder.imgAvatar.setImageResource(avatar)
        holder.tvUsername.text = username
        holder.tvName.text = name
        holder.tvCompany.text = company
        holder.tvLocation.text = location
        holder.tvRepository.text = repository
        holder.tvFollowers.text = follower
        holder.tvFollowing.text = following

        holder.itemView.setOnClickListener{ onItemClickCallback.onItemClicked(listUser[holder.adapterPosition]) }

    }

    override fun getItemCount(): Int = listUser.size

    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }
}

