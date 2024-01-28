package ca.com.toronto.activities

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.com.toronto.ApiClient
import ca.com.toronto.model.PlacesList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val PROXIMITY_RADIUS = 5000
class MapsViewModel: ViewModel() {
    private val _locationsLiveData = MutableLiveData<PlacesList>()
    val locationsLiveData = _locationsLiveData

    fun initializeRetrofitClient(type: String, coordinates: String) {

        val call: Call<PlacesList> = ApiClient.getMapsApiService().getNearbyPlaces(
            type, coordinates, PROXIMITY_RADIUS
        )
        call.enqueue(object : Callback<PlacesList> {
            override fun onResponse(call: Call<PlacesList>, response: Response<PlacesList>) {
                try {
                    _locationsLiveData.value = response.body()
                } catch (e: Exception) {
                    Log.d("onResponse", "There is an error")
                    e.printStackTrace()
                }
            }
            override fun onFailure(call: Call<PlacesList>, t: Throwable) {
                Log.d("onFailure", t.toString())
            }
        })
    }
}