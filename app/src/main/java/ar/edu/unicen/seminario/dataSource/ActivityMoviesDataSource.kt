package ar.edu.unicen.seminario.dataSource

import ar.edu.unicen.seminario.movies.Movie
import ar.edu.unicen.seminario.movies.MoviesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ActivityMoviesDataSource @Inject constructor (
    private val moviesApi : MoviesApi
) {
    /* Realiza una llamada a la API de películas en un hilo de IO usando coroutines*/

    /* Devuelve una lista de peliculas, previamente consulta por los generos y los parsea para que la lista tenga
    * de pelicula contenga todos sus atributos definidos para poder leerse*/
    suspend fun getMovies(): List<Movie>? {
        val apikey = "f1ad05a4e1942824ef667ee4c2b7d180" /* Clave de validación API Movies */
        return withContext(Dispatchers.IO) {
            try {
                val genresMap = moviesApi.getGenres(apikey).body()?.genres?.associate { it.id to it.name }

                if (genresMap.isNullOrEmpty()) {
                    return@withContext null // devuelve null si no hay generos
                }
                val response = moviesApi.getMovies(apikey)
                val moviesResponse = response.body()
                val activityMovies: List<Movie>? = moviesResponse?.results?.map { it.toActivityMovies(genresMap) }

                return@withContext activityMovies
            } catch (e: Exception) {
                return@withContext null /* Si la llamada provoca algún error */
            }
        }
    }

}