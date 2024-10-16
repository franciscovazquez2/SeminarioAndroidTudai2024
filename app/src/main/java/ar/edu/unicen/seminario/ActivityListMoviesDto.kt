package ar.edu.unicen.seminario

import com.google.gson.annotations.SerializedName

class ActivityListMoviesDto(
    @SerializedName("page") val page: Int,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("results") val results: List<ActivityMoviesDto> // Lista de películas
)
{

}