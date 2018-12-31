package ca.com.toronto.retrofit.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Royal_L on 22-Oct-17.
 */

public class RetrofitClient {

    /********
     * URLS
     *******/
//    private static final String ROOT_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670,151.1957&radius=500&types=food&name=cruise&key=AIzaSyA0GQi6hFA25lU8mfhJxLvMugJ_gw-ZrMo";
    private static final String ROOT_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/";

    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder().baseUrl(ROOT_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    /**
     * Get API Service
     *
     * @return API Service
     */
    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }
}
