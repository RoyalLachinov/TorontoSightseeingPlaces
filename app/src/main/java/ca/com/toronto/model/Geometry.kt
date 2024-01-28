package ca.com.toronto.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Royal_L on 23-Oct-17.
 */
data class Geometry(
    /**
     * @param [location]
     * @return The location
     */
    @SerializedName("location")
    @Expose
    var location: Location? = null
)
