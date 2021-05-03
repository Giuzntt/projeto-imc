package com.example.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imc.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        with(binding){
            btCalcular.setOnClickListener {

                val peso  = tiePeso.text.toString()
                val altura = tieAltura.text.toString()

                if(peso.isBlank()){
                    tilPeso.error = getString(R.string.campo_obrigatorio)
                } else{
                    tilPeso.isErrorEnabled = false
                }
                if (altura.isBlank()){
                    tilAltura.error = getString(R.string.campo_obrigatorio)
                } else {
                    tilAltura.isErrorEnabled = false
                }



                if(peso.isNotBlank() && altura.isNotBlank()){
                    val res = peso.toDouble()/(altura.toDouble()*altura.toDouble())
                    val total = DataResult(
                            resultado = res
                    )
                    val intent = Intent(this@MainActivity,
                            DadosActivity::class.java)
                    intent.putExtra(KEY_INTENT_DATA, total )
                    startActivity(intent)

                }

                }





//            PROFILE
            btProfile.setOnClickListener {
                val intent = Intent(this@MainActivity,
                        ProfileActivity::class.java)
                startActivity(intent)
            }



        }


        }
        companion object{
            const val KEY_INTENT_DATA = "total"
        }






    }
