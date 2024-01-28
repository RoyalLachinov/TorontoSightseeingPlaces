package ca.com.toronto.retrofit.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Royal_L on 22-Oct-17.
 */
object RetrofitClient {
    /********
     * URLS
     */
    //    private static final String ROOT_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670,151.1957&radius=500&types=food&name=cruise&key=AIzaSyA0GQi6hFA25lU8mfhJxLvMugJ_gw-ZrMo";
    private const val ROOT_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/"
    private val retrofitInstance: Retrofit
        /**
         * Get Retrofit Instance
         */
        private get() = Retrofit.Builder().baseUrl(ROOT_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    val apiService: ApiService
        /**
         * Get API Service
         *
         * @return API Service
         */
        get() = retrofitInstance.create(ApiService::class.java)
}
