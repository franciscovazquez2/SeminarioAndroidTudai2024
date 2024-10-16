package ar.edu.unicen.seminario

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel//ya provee la interfaz precargada
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val savedStatedHandle:SavedStateHandle//similar a bundle(guarda datos y se recuperan con metodos
): ViewModel() {

    //private val _counter = MutableLiveData<Int>(0)//valor que va a variar
    private val _counter = MutableLiveData(savedStatedHandle["counter"] ?:0)//reemplaza al de arriba
    val counter : LiveData<Int> = _counter//desde afuera se pueden subscribir al counter y recibir el valor actualizado cada vez que cambie
    //loader
    private val _loading = MutableLiveData<Boolean>()
    val loading : LiveData<Boolean> get()= _loading

    fun increment(){


        viewModelScope.launch{//scope de la corrutina
            withContext(Dispatchers.Default){//dispatcher que ejecuta tareas costosas sin bloquear UI
                Thread.sleep(2000)//simular operacion costosa
            }
            withContext(Dispatchers.Main){//ejecuta en UI cuando termine el anterior
                _counter.value = _counter.value?.plus(1)
                savedStatedHandle["counter"]=_counter.value//guarda el valor
                _loading.value=false
            }
        }



    }
}



/*
*livedata - mutablelivedata (patron observer)
 */