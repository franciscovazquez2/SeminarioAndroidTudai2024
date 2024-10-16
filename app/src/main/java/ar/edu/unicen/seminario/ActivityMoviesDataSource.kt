package ar.edu.unicen.seminario

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ActivityMoviesDataSource @Inject constructor (
    private val moviesApi : MoviesApi
) {

    suspend fun getMovies(): List<Movie>? {
        val apikey = "f1ad05a4e1942824ef667ee4c2b7d180"
        return withContext(Dispatchers.IO){
            try{
                val response = moviesApi.getMovies(apikey)
                //val activityMovies: List<Movie>? = response.body()?.map{it.toActivityMovies()}
                val moviesResponse = response.body()
                val activityMovies: List<Movie>? =moviesResponse?.results?.map{it.toActivityMovies()}
                return@withContext activityMovies
            }catch (e : Exception){
                Log.e("MoviesError", "Error fetching movies: ${e.message}", e)
                return@withContext null
            }
        }
    }

}