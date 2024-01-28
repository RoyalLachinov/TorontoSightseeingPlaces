package ca.com.toronto.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Royal_L on 23-Oct-17.
 */
data class OpeningHours(
    /**
     * @param openNow
     * @return The open_now
     */
    @SerializedName("open_now")
    @Expose
    var openNow: Boolean? = null,

    /**
     * @param weekdayText
     * @return The weekday_text
     */
    @SerializedName("weekday_text")
    @Expose
    var weekdayText: List<Any> = ArrayList()
)
