package ca.com.toronto.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Royal_L on 23-Oct-17.
 */
class Photos(
    /**
     * @param height
     * @return The height
     */
    @SerializedName("height")
    @Expose
    var height: Int? = null,

    /**
     * @param htmlAttributions
     * @return The html_attributions
     */
    @SerializedName("html_attributions")
    @Expose
    var htmlAttributions: List<String> = ArrayList(),

    /**
     * @param photoReference
     * @return The photo_reference
     */
    @SerializedName("photo_reference")
    @Expose
    var photoReference: String? = null,

    /**
     * @param width
     *  @return The width
     */
    @SerializedName("width")
    @Expose
    var width: Int? = null
)