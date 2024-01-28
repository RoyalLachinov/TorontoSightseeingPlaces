package ca.com.toronto

import ca.com.toronto.activities.RetrofitMaps
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val ROOT_URL = "https://maps.googleapis.com/maps/"

object ApiClient {

    /**
     * Get Retrofit Instance
     */
    private fun getRetrofitInstance(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
        return Retrofit.Builder()
            .baseUrl(ROOT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    /**
     * Get API Service
     *
     * @return API Service
     */
    fun getMapsApiService(): RetrofitMaps {
        return getRetrofitInstance().create(RetrofitMaps::class.java)
    }
}