package ar.edu.unicen.seminario

import javax.inject.Inject

/* Actúa como intermediario entre el ActivityMoviesDataSource y el ViewModel*/

class ActivityMoviesRepository @Inject constructor(
    private val activityMoviesDataSource: ActivityMoviesDataSource
) {

    suspend fun getMovies():List<Movie>? {
        return activityMoviesDataSource.getMovies()
    }
}