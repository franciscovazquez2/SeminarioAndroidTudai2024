package ar.edu.unicen.seminario

import com.google.gson.annotations.SerializedName

data class ActivityMoviesDto (


        @SerializedName("id")
        val id : Int,
        @SerializedName("original_title")
        val original_title:String,
        @SerializedName("poster_path")
        val poster_path : String

    )

{
    fun toActivityMovies(): Movie {
        return Movie(
            id = id,
            title = original_title,
            img = "https://image.tmdb.org/t/p/original/"+ poster_path
            /*overview = overview,
            popularity = popularity,
            voteAverage = vote_average,
            voteCount = vote_count,
            adult = adult,
            backdropPath = backdrop_path*/
        )
    }
    /*
    fun toActivityMovies():Movie{
        return Movie(
            email=email,
            title=gender
        )
    }*/

}