package com.example.graduationlite.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.graduationlite.R

class AlumniAdapter(
    private val context: Context,
    private val alumniList: MutableList<Alumni>
) : RecyclerView.Adapter<AlumniAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fullNameTextView: TextView = itemView.findViewById(R.id.full_name_text_view)
        val graduationYearTextView: TextView = itemView.findViewById(R.id.graduation_year_text_view)
        val profileImageView: ImageView = itemView.findViewById(R.id.profile_image_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.alumni_list_item, parent, false)
        return ViewHolder(view)
    }


