package ar.edu.unicen.seminario

import retrofit2.Response
import retrofit2.http.GET

interface MoviesApi {

    @GET("activity")
    suspend fun getMovies():Response<ActivityMoviesDto>
}