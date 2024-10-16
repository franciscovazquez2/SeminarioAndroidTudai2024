package ar.edu.unicen.seminario

import javax.inject.Inject


class ActivityMoviesRepository @Inject constructor(
    private val activityMoviesDataSource: ActivityMoviesDataSource
) {

    suspend fun getMovies():ActivityMovie? {
        return activityMoviesDataSource.getMovies()
    }
}