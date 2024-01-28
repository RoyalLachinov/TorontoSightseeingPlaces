package ca.com.toronto.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Royal_L on 22-Oct-17.
 */
class Places(
    /**
     * @param geometry
     * @return The geometry
     */
    @SerializedName("geometry")
    @Expose
    var geometry: Geometry? = null,

    /**
     * @param icon
     * @return The icon
     */
    @SerializedName("icon")
    @Expose
    var icon: String? = null,

    /**
     * @param id
     * @return The id
     */
    @SerializedName("id")
    @Expose
    var id: String? = null,

    /**
     * @param name
     * @return The name
     */
    @SerializedName("name")
    @Expose
    var name: String? = null,

    /**
     * @param openingHours
     * @return The opening_hours
     */
    @SerializedName("opening_hours")
    @Expose
    var openingHours: OpeningHours? = null,

    /**
     * @param photos
     * @return The photos
     */
    @SerializedName("photos")
    @Expose
    var photos: List<Photos> = ArrayList(),

    /**
     * @param placeId
     * @return The place_id
     */
    @SerializedName("place_id")
    @Expose
    var placeId: String? = null,

    /**
     * @param rating
     * @return The rating
     */
    @SerializedName("rating")
    @Expose
    var rating: Double? = null,

    /**
     * @param reference
     * @return The reference
     */
    @SerializedName("reference")
    @Expose
    var reference: String? = null,

    /**
     * @param scope
     * @return The scope
     */
    @SerializedName("scope")
    @Expose
    var scope: String? = null,

    /**
     * @param types
     * @return The types
     */
    @SerializedName("types")
    @Expose
    var types: List<String> = ArrayList(),

    /**
     *
     * @param vicinity
     *  @return The vicinity
     */
    @SerializedName("vicinity")
    @Expose
    var vicinity: String? = null,

    /**
     * @param priceLevel
     * @return The price_level
     */
    @SerializedName("price_level")
    @Expose
    var priceLevel: Int? = null
)
