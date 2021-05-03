package com.example.imc


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        val textView2= findViewById<TextView>(R.id.tzChecar)
        //RESULTADO DO IMC
        val imcResp = getString(R.string.imc_dados) +   df.format(result?.resultado) + "\n"
        textView.text = imcResp
        //VARIAVEL QUE RECEBE O IMC E INDICA NA CHECAGEM
        val checarIMC = " " + result?.let { ChecaIMC(it.resultado)}
        textView2.text = checarIMC


        //Botao de voltar
        val voltar = findViewById<Button>(R.id.btVoltarP)


        voltar.setOnClickListener {
            val intent = Intent(this@DadosActivity,
                    MainActivity::class.java)
            startActivity(intent)


        }
        }

        //Checagem do IMC
        private fun ChecaIMC(n: Double): String {
            return when(n){
                in 00.0..19.5 -> getString(R.string.abaixodopeso)
                in 19.5..26.4 ->getString(R.string.pesoideal)
                in 26.4..31.0 ->getString(R.string.acimadopeso)
                else ->getString(R.string.obeso)
            }


        }






}