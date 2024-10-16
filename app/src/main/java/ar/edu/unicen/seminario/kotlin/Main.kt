package ar.edu.unicen.seminario.kotlin

/* variables y tipos:
   const val  --> constante (se asigna en tiempo de compilacion)
   val --> valor que no cambia (es como un final, pero se asigna en tiempo de ejecucion)
   var --> variable que se puede reasignar (puede cambiar de valor)
   ? --> tipo nulleable ( String? -->puede ser null)
   String Char Boolean Number(padre de)--> Int Long Float Double (todos empiezan con mayuscula)
   Any? (object) Unit (void) Nothing(nunca puede ser asignado, no retornaria nada)
   formato:
   val/var : name : Type = value
   val : name = value (kotlin comprende el tipo de variable que se asigna)

   syso:
   print( "hello" + name ) || print("hello" $name)


 */


fun main() {

    var nombre: String? = "Panchito"
    //nombre = "Susana"
    println("Hello $nombre")

    //listas
    val lista = ArrayList<Int>()
    lista.add(1)
    lista.add(2)
    println("list $lista")
    //lista solo lectura (no se le puede hacer add)
    val listaAbreviada = listOf(1, 2, 3)
    println("Listof $listaAbreviada")
    //lista mutable (si se puede hacer add)
    var listaAbreviadaMutable = mutableListOf(1, 2, 3)
    listaAbreviadaMutable.add(4)
    println("listaAbreviadaMutable $listaAbreviadaMutable")

    //pares
    val par = Pair("Panchito",33)
    println(par)

    //control
    var edad : Int = 15
    if(edad > 5){
        println("$edad es mayor a 5")
    }else{
        println("$edad es menor o igual a 5")
    }
    //switch
    when(edad){
        1-> println("el valor es 1")
        2-> println("el valor es 2")
        5-> println("el valor es 5")
        else-> println("no es ni 1,2,5")
    }
    //while
    var valor : Int = 4
    while(valor > 0){
        print(valor)
        valor--
    }

    //for por rango incluyendo .. y sin incluir "until"
    for(i in 1..5){
        println("el valor de i es $i")
    }

    for (i in 1 until 5){
        println("el valor de i es $i")
    }

    //llamar a funcion sumar
    println("llamando a funcion sumar ${sumar(1)}")
    //llamar a funcion anonima promedio
    var numbers = setOf(1,2,3,4)
    println("promedio de la lista es ${numbers.promedio()}")

}

//funciones

fun sumar(a:Int,b:Int=5):Int {
    return a +b
}

//funciones extendidas (como una funcion anonima)
fun Set<Int>.promedio():Double{
    var suma = 0
    for(element in this){
        suma+=element
    }
    return suma.toDouble()/this.size
}