package ar.edu.unicen.seminario

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
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
    }

    suspend fun getMovies():Movie?{
        return withContext(Dispatchers.IO){
            val response = moviesApi.getMovies()
            val activityMovies: Movie? = response.body()?.toActivityMovies()
            return@withContext activityMovies
        }
    }*/
    suspend fun getMovies(): List<Movie>? {
        return withContext(Dispatchers.IO){
            try{
                val response = moviesApi.getMovies()
                //val activityMovies: List<Movie>? = response.body()?.map{it.toActivityMovies()}
                val moviesResponse = response.body()
                val activityMovies: List<Movie>? =moviesResponse?.results?.map{it.toActivityMovies()}
                return@withContext activityMovies
            }catch (e : Exception){
                //Log.e("MoviesError", "Error fetching movies: ${e.message}", e)
                return@withContext null
            }
        }
    }


}