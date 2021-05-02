package com.example.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)



        val voltar = findViewById<Button>(R.id.btVoltar)

        voltar.setOnClickListener {
            val intent = Intent(this@ProfileActivity,
                    MainActivity::class.java)
            startActivity(intent)
        }


    }


}