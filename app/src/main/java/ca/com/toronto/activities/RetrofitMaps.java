package ca.com.toronto.activities;

/**
 * Created by Royal_L on 23-Oct-17.
 */


import ca.com.toronto.model.Places;
import ca.com.toronto.model.PlacesList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface  RetrofitMaps {

    /*
  * Retrofit get annotation with our URL
  * And our method that will return us details of student.
  */
    @GET("api/place/nearbysearch/json?sensor=true&key=AIzaSyA0GQi6hFA25lU8mfhJxLvMugJ_gw-ZrMo")
    Call<PlacesList> getNearbyPlaces(@Query("type") String type, @Query("location") String location, @Query("radius") int radius);
}
