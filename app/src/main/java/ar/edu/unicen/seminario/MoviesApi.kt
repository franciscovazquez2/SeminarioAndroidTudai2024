package ar.edu.unicen.seminario

import retrofit2.Response
import retrofit2.http.GET

interface MoviesApi {


    @GET("popular")
    suspend fun getMovies():Response<ActivityListMoviesDto>

    /*
    @GET("activity")
    suspend fun getMovies():Response<List<ActivityMoviesDto>>

    @GET("?results=100")
    suspend fun getMovies():Response<ActivityListMoviesDto>
    */
}

