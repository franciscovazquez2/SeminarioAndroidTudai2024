package ar.edu.unicen.seminario

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ar.edu.unicen.seminario.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding//lateinit posterga la inicializacion de la variable
    private val viewModel by viewModels<MoviesViewModel>()//correcta implementacion para el MainModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)//binding ahora tiene acceso a todas las variables de MainActivity

        setContentView(binding.root)//esta definido en la carpeta res

        /*
        binding.buttonCargar.setOnClickListener{ viewModel.increment()
        }//counter++ //binding.title.text=counter.toString()

        viewModel.counter.observe(this){//observa mientras el ciclo de vida se encuentre vivo, sino se cancela
            valor->binding.title.text = valor.toString() //actualizo el valor de contador (observo los cambios)
        }*/

        viewModel.loading.observe(this){ loading->
            if(loading){
                binding.title.visibility= View.INVISIBLE
                binding.progressBar.visibility=View.VISIBLE
                binding.buttonCargar.isEnabled=false
            }else{
                binding.title.visibility= View.VISIBLE
                binding.progressBar.visibility=View.INVISIBLE
                binding.buttonCargar.isEnabled=true
            }
        }

        viewModel.movies.observe(this) { movies ->
            binding.activityId.text= movies?.id.toString()
            binding.activityName.text=movies?.title.toString()
            // Comprueba si la lista no es nula y no está vacía
            /*val firstMovie = movies?.firstOrNull()
            if (firstMovie != null) {
                binding.activityId.text = firstMovie.id.toString()
                binding.activityName.text = firstMovie.title.toString()
            }*/
        }


        binding.buttonCargar.setOnClickListener{ viewModel.getMovies()
        }

    }

}

/*
* Bundle y parcelables: datos clave valor que se pueden persistir entre estados de la aplicacion
* utilizados para no perder informacion ante minimizacion,rotacion o cambio de formato en aplicacion
* onSaveInstanceState(outState:Bundle)
*
* CONTEXT: clase abstracta que nos provee android , regula acceso y modificacion de elementos, permisos, etc
*
*
 ----------VARIABLE Y METODOS NECESARIOS PARA MANTENER ESTADO(reemplazado por LiveData y MutableLiveData)----------------
    private var counter : Int = 0

    /*salvar estado para cuando android destruya*/
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counter",counter)
    }
    /*recuperar estado*/
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        counter = savedInstanceState.getInt("counter")//tomar el dato
        binding.title.text=counter.toString();
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity","pause")
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity","start")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity","destroy")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity","resume")
    }
 ----------------------------------------------------------------------------------------------------

    /*navegacion entre pantallas se logra con Intent*/
    binding.navegarRed.setOnClickListener{
        val intent = Intent(this,RedActivity::class.java)
        intent.putExtra("counter",counter)//intent permite pasar bundle /si no es primitivo debe ser parcelable
        startActivity(intent)//manda un mensaje a la activity que quiere iniciar
    }
 */

