package com.example.graduationlite.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import com.example.graduationlite.R

class MediaList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_list)
    }
    val file = File(getRealPathFromURI(mediaUri))
    val requestFile = ProgressRequestBody(file, "image/* video/*", this)
    val body = MultipartBody.Part.createFormData("media", file.name, requestFile)
    val apiService = ApiClient.getClient().create(ApiInterface::class.java)
    val call = apiService.uploadMedia(body)
    val intent = Intent(Intent.ACTION_GET_CONTENT)
    intent.type = "image/* video/*"
    startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_MEDIA_REQUEST)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_MEDIA_REQUEST && resultCode == RESULT_OK && data != null) {
            val mediaUri = data.data
            if (mediaUri != null) {

            }
        }
    }
    call.enqueue(object : Callback<MediaList> {
        override fun onResponse(call: Call<MediaList>, response: Response<MediaList>) {

        }

        override fun onFailure(call: Call<MediaList>, t: Throwable) {

        }
    })

}