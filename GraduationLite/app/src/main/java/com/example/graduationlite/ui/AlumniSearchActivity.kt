package com.example.graduationlite.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.graduationlite.R

class AlumniSearchActivity : AppCompatActivity() {

    private lateinit var alumniAdapter: AlumniAdapter
    private lateinit var alumniList: MutableList<Alumni>
    private lateinit var searchEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alumni_search)

        searchEditText = findViewById(R.id.search_edit_text)
        val searchButton = findViewById<Button>(R.id.search_button)
        val alumniRecyclerView = findViewById<RecyclerView>(R.id.alumni_recycler_view)

        alumniList = mutableListOf()
        alumniAdapter = AlumniAdapter(this, alumniList)
        alumniRecyclerView.adapter = alumniAdapter
        alumniRecyclerView.layoutManager = LinearLayoutManager(this)

        searchButton.setOnClickListener {
            val query = searchEditText.text.toString().toLowerCase(Locale.ROOT)
            searchAlumni(query)
        }
    }

    private fun searchAlumni(query: String) {

    }
}