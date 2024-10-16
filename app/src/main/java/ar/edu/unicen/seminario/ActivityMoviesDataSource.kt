package ar.edu.unicen.seminario

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import javax.inject.Inject

class ActivityMoviesDataSource @Inject constructor (
    private val moviesApi : MoviesApi
) {

    /*suspend fun getMovies(): List<ActivityMovie>? {
        return withContext(Dispatchers.IO) {
            try {
                val response = moviesApi.getMovies()
                // Verifica si la respuesta es exitosa y si tiene un cuerpo
                if (response.isSuccessful && response.body() != null) {
                    // Mapea la lista de MovieDto (results) a una lista de ActivityMovie
                    response.body()?.results?.map { movieDto ->
                        movieDto.toActivityMovie()
                    }
                } else {
                    // Devuelve null si la respuesta no es exitosa
                    null
                }
            }catch (e: Exception) {
            Log.e("MoviesRepository", "Error fetching movies", e)
            null
            }
        }
    }*/

    suspend fun getMovies():ActivityMovie?{
        return withContext(Dispatchers.IO){
            val response = moviesApi.getMovies()
            val activityMovies: ActivityMovie? = response.body()?.toActivityMovies()
            return@withContext activityMovies
        }
    }


}