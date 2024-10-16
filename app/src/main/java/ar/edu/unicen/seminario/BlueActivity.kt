package ar.edu.unicen.seminario

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ar.edu.unicen.seminario.databinding.ActivityBlueBinding

class BlueActivity: AppCompatActivity() {

    private lateinit var binding : ActivityBlueBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBlueBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.navegarMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            //combinacion de flag que permite desapilar y volver al main inicial
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)

        }

    }
}