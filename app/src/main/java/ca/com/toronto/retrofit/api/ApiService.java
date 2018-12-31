package ca.com.toronto.retrofit.api;

import ca.com.toronto.model.PlacesList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Royal_L on 22-Oct-17.
 */

public interface ApiService {
    /*
    Retrofit get annotation with our URL
    And our method that will return us the List of PlacesList
    */
    @GET("json?")
    Call<PlacesList> getMyJSON(@Query("location") String location, @Query("radius") String radius, @Query("types") String types,
                               @Query("name") String name, @Query("key") String key);
}
