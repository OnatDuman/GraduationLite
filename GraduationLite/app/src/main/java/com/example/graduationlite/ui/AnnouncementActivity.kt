package com.example.graduationlite.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.graduationlite.R

class AnnouncementActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var addAnnouncementButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_announcement)


        recyclerView = findViewById(R.id.recyclerview_announcements)
        addAnnouncementButton = findViewById(R.id.button_add_announcement)

        addAnnouncementButton.setOnClickListener {
        }

    }
}