package ar.edu.unicen.seminario

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {
    /*
    * Devuelve listado de peliculas y se envia la clave de validacion por @Query params.
    */
    @GET("movie/popular")
    suspend fun getMovies(
        @Query("api_key") apikey: String
    ):Response<ActivityListMoviesDto>
    /*
    * Devuelve listado de los generos segun su id */
    @GET("genre/movie/list")
    suspend fun getGenres(
        @Query("api_key") apiKey: String
    ): Response<GenreListDto>

}

