package com.example.mylearningapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        //View Initialisations
        viewInIt()


        val firstText: TextInputEditText = findViewById(R.id.first_text)
        val secondText: TextInputEditText = findViewById(R.id.second_text)


        //on click
        findViewById<Button>(R.id.login_button).setOnClickListener {
            val userNameText = firstText.text.toString()
            val userPassword = secondText.text.toString()

            if (userNameText.isBlank()) {
                showToast(this, "Enter UserName")
            } else if (userPassword.isBlank()) {
                showToast(this, "Enter Password")
            } else if ((userNameText == "Ashwathi").not()) {
                showToast(this, "Enter Valid UserName")
            } else if ((userPassword == "1234").not()) {
                showToast(this, "Enter Valid Password")
            } else {
                val intent = Intent(this, RecyclerViewActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun viewInIt() {
        val outerBox: LinearLayout = findViewById(R.id.outer_box)
        val outerBoxText: TextView = findViewById(R.id.outer_box_text)
        val firstTextBox: TextInputLayout = findViewById(R.id.first_text_box)
        val secondTextBox: TextInputLayout = findViewById(R.id.second_text_box)
    }

    private fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}