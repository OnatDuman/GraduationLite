package com.example.graduationlite

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.graduationlite.ui.SignIn
import com.example.graduationlite.ui.theme.GraduationLiteTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin)

        this.auth = Firebase.auth
    }
    fun signIn(view: View) {
        val email = findViewById<EditText>(R.id.et_email).text.toString()
        val password = findViewById<EditText>(R.id.editTextPassword).text.toString()

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    val intent = Intent(this, SignIn::class.java)
                    startActivity(intent)
                } else {

                    Toast.makeText(baseContext, "Giriş yaparken bir hata oluştu.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GraduationLiteTheme {
        Greeting("Android")
    }
}