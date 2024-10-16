package ar.edu.unicen.seminario

import javax.inject.Inject


class ActivityMoviesRepository @Inject constructor(
    private val activityMoviesDataSource: ActivityMoviesDataSource
) {
    /*
    suspend fun getMovies():Movie? {
        return activityMoviesDataSource.getMovies()
    }*/

    suspend fun getMovies():List<Movie>? {
        return activityMoviesDataSource.getMovies()
    }
}