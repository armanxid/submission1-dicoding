package com.example.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "DATA"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getParcelableExtra<User>(EXTRA_DATA) as User
        Log.d("detail data", data.company)

        val tvName: TextView = findViewById(R.id.tv_detail_name)
        val tvUsername: TextView = findViewById(R.id.tv_detail_username)
        val imgAvatar: ImageView = findViewById(R.id.img_detail_avatar)
        val tvCompany: TextView = findViewById(R.id.tv_detail_company)
        val tvLocation: TextView = findViewById(R.id.tv_detail_location)
        val tvRepository: TextView = findViewById(R.id.tv_detail_repository)
        val tvFollowing: TextView = findViewById(R.id.tv_detail_following)
        val tvFollowers: TextView = findViewById(R.id.tv_detail_followers)

        tvName.text = data.name
        tvUsername.text = data.username
        data.avatar.let { imgAvatar.setImageResource(it) }
        tvCompany.text = data.company
        tvLocation.text = data.location
        tvRepository.text = data.repository
        tvFollowing.text = data.following
        tvFollowers.text = data.followers
    }
}