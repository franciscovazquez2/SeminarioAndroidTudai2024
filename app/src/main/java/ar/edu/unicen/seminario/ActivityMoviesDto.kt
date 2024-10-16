package ar.edu.unicen.seminario

import com.google.gson.annotations.SerializedName

class ActivityMoviesDto (
val activity: String,
val type:String,
val accessibility: Double,
val participants:Int,
val price: Double,
val link: String,
val key:String
    /*
    @SerializedName("adult")
    val adult : Boolean,
    @SerializedName("backdrop_path")
    val backdrop_path : String,
    @SerializedName("id")
    val id : Int,
    @SerializedName("original_title")
    val original_title:String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity:Long,
    @SerializedName("vote_average")
    val vote_average: Float,
    @SerializedName("vote_count")
    val vote_count:Int*/
    )

{   /*
    fun toActivityMovie(): ActivityMovie {
        return ActivityMovie(
            id = id,
            title = original_title,
            overview = overview,
            popularity = popularity,
            voteAverage = vote_average,
            voteCount = vote_count,
            adult = adult,
            backdropPath = backdrop_path
        )
    }*/

    fun toActivityMovies():ActivityMovie{
        return ActivityMovie(
            id=participants,
            title=activity
        )
    }

}