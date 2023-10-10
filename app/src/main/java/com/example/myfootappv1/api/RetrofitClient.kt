package com.example.myfootappv1.api

import android.content.Context
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        return chain.proceed(request)
    }

}

object RetrofitClient {
    private const val BASE_URL = "http://10.0.2.2:8080/"

    private lateinit var client : Retrofit

    fun getClient(context : Context) : Retrofit{
        if (!this::client.isInitialized) {
            client = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return client
    }

    private val okHttpClient : OkHttpClient by lazy {
        OkHttpClient().newBuilder()
            .addInterceptor(RequestInterceptor)
            .build()
    }
}