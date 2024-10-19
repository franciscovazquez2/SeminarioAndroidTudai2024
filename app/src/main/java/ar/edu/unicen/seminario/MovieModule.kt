package ar.edu.unicen.seminario

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MovieModule {

    /* Provee una instancia de Retrofit con la URL base de la API de The Movie DB y el convertidor Gson*/
    @Singleton
    @Provides
    fun providesRetroFit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    /* Provee una instancia de MoviesApi generada a partir de Retrofit */
    @Provides
    fun providesMoviesApi(retrofit: Retrofit):MoviesApi{
        return retrofit.create(MoviesApi::class.java)
    }
}