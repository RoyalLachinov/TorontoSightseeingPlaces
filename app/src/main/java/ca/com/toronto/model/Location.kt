package ca.com.toronto.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Royal_L on 23-Oct-17.
 */
data class Location(
    /**
     * @param lat
     * @return The lat
     */
    @SerializedName("lat")
    @Expose
    var lat: Double? = null,

    /**
     * @param lng
     * @return The lng
     */
    @SerializedName("lng")
    @Expose
    var lng: Double? = null
)