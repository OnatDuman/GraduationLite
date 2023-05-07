package com.example.graduationlite.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.graduationlite.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference


class Profile : AppCompatActivity() {

        private lateinit var auth: FirebaseAuth
        private lateinit var database: DatabaseReference
        private lateinit var storage: FirebaseStorage

        private lateinit var profileImage: ImageView
        private lateinit var nameTextView: TextView
        private lateinit var emailTextView: TextView
        private lateinit var graduateYearTextView: TextView
        private lateinit var currentJobTextView: TextView
        private lateinit var countryTextView: TextView
        private lateinit var cityTextView: TextView
        private lateinit var universityTextView: TextView
        private lateinit var degreeTextView: TextView
        private lateinit var majorTextView: TextView

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_profile)


            auth = FirebaseAuth.getInstance()
            database = FirebaseDatabase.getInstance().reference
            storage = FirebaseStorage.getInstance()


            profileImage = findViewById(R.id.profile_image)
            nameTextView = findViewById(R.id.name_textview)
            emailTextView = findViewById(R.id.email_textview)
            graduateYearTextView = findViewById(R.id.graduate_year_textview)
            currentJobTextView = findViewById(R.id.current_job_textview)
            countryTextView = findViewById(R.id.country_textview)
            cityTextView = findViewById(R.id.city_textview)
            universityTextView = findViewById(R.id.university_textview)
            degreeTextView = findViewById(R.id.degree_textview)
            majorTextView = findViewById(R.id.major_textview)


            loadProfileData()
        }

        private fun loadProfileData() {

            val userId = auth.currentUser?.uid
            if (userId != null) {
                database.child("users").child(userId).addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val user = snapshot.getValue(User::class.java)
                        if (user != null) {
                            // Set the UI elements with the profile data
                            nameTextView.text = "${user.firstName} ${user.lastName}"
                            emailTextView.text = user.email
                            graduateYearTextView.text = user.graduateYear
                            currentJobTextView.text = user.currentJob
                            countryTextView.text = user.country
                            cityTextView.text = user.city
                            universityTextView.text = user.university
                            degreeTextView.text = user.degree
                            majorTextView.text = user.major


                            val imageRef = storage.reference.child("users/$userId/profile.jpg")
                            GlideApp.with(this@ProfileActivity)
                                .load(imageRef)
                                .placeholder(R.drawable.placeholder)
                                .error(R.drawable.error)
                                .into(profileImage)
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.e("ProfileActivity", "Error loading user data: ${error.message}")
                    }
                })
            }
        }
    }