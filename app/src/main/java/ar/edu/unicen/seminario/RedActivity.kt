package ar.edu.unicen.seminario

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import ar.edu.unicen.seminario.databinding.ActivityRedBinding

class RedActivity: AppCompatActivity() {

    private lateinit var binding : ActivityRedBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.navegarAzul.setOnClickListener {
            val intent = Intent(this,BlueActivity::class.java)

            startActivity(intent)
        }

        //como hereda de AcppComparActivity tiene acceso al intent que lo creo (main)
        val parametro = intent.getIntExtra("counter",0)
        binding.titleRed.text = parametro.toString()
    }
}