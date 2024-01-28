package ca.com.toronto.retrofit.api

import ca.com.toronto.model.PlacesList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Royal_L on 22-Oct-17.
 */
interface ApiService {
    /*
    Retrofit get annotation with our URL
    And our method that will return us the List of PlacesList
    */
    @GET("json?")
    fun getMyJSON(
        @Query("location") location: String?,
        @Query("radius") radius: String?,
        @Query("types") types: String?,
        @Query("name") name: String?,
        @Query("key") key: String?
    ): Call<PlacesList?>?
}
