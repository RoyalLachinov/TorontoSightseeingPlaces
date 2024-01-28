package ca.com.toronto.activities

import ca.com.toronto.model.PlacesList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Royal_L on 23-Oct-17.
 */
interface RetrofitMaps {
    /**
     * Retrofit get annotation with our URL *And our method that will return us details of student.
     */
    @GET("api/place/nearbysearch/json?sensor=true&key=AIzaSyAYkOenoeRyWA3uF3wkAkPWUY9yV8uYtSY")
    fun getNearbyPlaces(
        @Query("type") type: String?,
        @Query("location") location: String?,
        @Query("radius") radius: Int
    ): Call<PlacesList>
}
