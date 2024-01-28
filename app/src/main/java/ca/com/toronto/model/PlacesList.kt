package ca.com.toronto.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Royal_L on 22-Oct-17.
 */
data class PlacesList(
    @SerializedName("results")
    val placesList: ArrayList<Places>
)
