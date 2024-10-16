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

    @Singleton
    @Provides
    fun providesRetroFit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/movie/")//"https://randomuser.me/api/?results=100"
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesMoviesApi(retrofit: Retrofit):MoviesApi{
        return retrofit.create(MoviesApi::class.java)
    }
}