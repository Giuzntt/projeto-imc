package com.example.imc


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.imc.MainActivity.Companion.KEY_INTENT_DATA
import java.text.DecimalFormat


class DadosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dados)

        val df = DecimalFormat("#.00")
        val result = intent.getParcelableExtra<DataResult>(KEY_INTENT_DATA)
        val textView= findViewById<TextView>(R.id.tzResult)


        val imcResp = "IMC: " +   df.format(result?.resultado) + "\n"
        textView.text = imcResp
        
        val voltar = findViewById<Button>(R.id.btVoltarP)

        voltar.setOnClickListener {
            val intent = Intent(this@DadosActivity,
                    MainActivity::class.java)
            startActivity(intent)
        }
        }







}