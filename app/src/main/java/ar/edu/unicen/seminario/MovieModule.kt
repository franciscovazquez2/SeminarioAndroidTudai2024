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
    /*
    @Singleton
    @Provides
    fun providesRetroFit(): Retrofit {
            val apiKey = "f1ad05a4e1942824ef667ee4c2b7d180"  // Coloca tu API key aquí
            val apiKeyInterceptor = Interceptor { chain ->
                val originalRequest: Request = chain.request()
                val originalUrl = originalRequest.url()

                // Agregar la API key como parámetro de consulta
                val urlWithApiKey = originalUrl.newBuilder()
                    .addQueryParameter("api_key", apiKey)
                    .build()

                // Crear la nueva solicitud con la API key añadida
                val requestWithApiKey = originalRequest.newBuilder()
                    .url(urlWithApiKey)
                    .build()

                chain.proceed(requestWithApiKey)
            }

            // Crear OkHttpClient con el interceptor que añade la API key
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(apiKeyInterceptor)
                .build()

            // Crear Retrofit con OkHttpClient personalizado
            return Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/movie/popular")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
    }*/

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