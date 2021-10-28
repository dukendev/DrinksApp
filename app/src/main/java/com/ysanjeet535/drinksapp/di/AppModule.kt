package com.ysanjeet535.drinksapp.di

import com.ysanjeet535.drinksapp.data.DrinksRepository
import com.ysanjeet535.drinksapp.data.remote.DrinksApi
import com.ysanjeet535.drinksapp.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideApi(): DrinksApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DrinksApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(drinksApi: DrinksApi) : DrinksRepository{
        return DrinksRepository(drinksApi = drinksApi)
    }
}