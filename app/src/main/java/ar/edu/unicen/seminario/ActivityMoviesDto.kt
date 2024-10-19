package ar.edu.unicen.seminario

import com.google.gson.annotations.SerializedName

data class ActivityMoviesDto (

    @SerializedName("id")
    val id : Int,
    @SerializedName("original_title")
    val original_title:String,
    @SerializedName("poster_path")
    val poster_path : String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("vote_average")
    val vote_average : Double,
    @SerializedName("genre_ids")
    val genre_ids : List<Int>
    )

{
    fun toActivityMovies(): Movie {
        return Movie(
            id = id,
            title = original_title,
            img = "https://image.tmdb.org/t/p/original/"+ poster_path,//ruta completa de la imagen
            overview = overview,
            voteAverage = vote_average,
            genre_ids=genre_ids
        )
    }

}