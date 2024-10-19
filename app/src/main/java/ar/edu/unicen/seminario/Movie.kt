package ar.edu.unicen.seminario

/*Representa la estructura del contenido de cada Pelicula*/

class Movie (
    val title: String,
    val id : Int,
    val img : String,
    val overview : String,
    val voteAverage : Double,
    val genre_ids : List<Int>
    )
{
    fun getGenres(): String {
        return if (genre_ids.isNotEmpty()) {
            "Géneros: " + genre_ids.joinToString(", ") { it.toString() }
        } else {
            "Géneros no disponibles"
        }
    }
}