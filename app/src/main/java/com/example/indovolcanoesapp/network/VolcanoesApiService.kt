package com.example.indovolcanoesapp.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://indonesia-public-static-api.vercel.app/api/"

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface VolcanoesApiService{
    @GET(value = "volcanoes")
    suspend fun getVolcanoes() : List<Volcanoes>
}

object VolcanoesApi{
    val retrofitService : VolcanoesApiService by lazy {
        retrofit.create(VolcanoesApiService::class.java)
    }
}