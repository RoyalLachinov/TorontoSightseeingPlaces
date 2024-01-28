package ca.com.toronto.model

class LocationsDetail(val title: String, val lat: Double, val lng: Double) {

    override fun toString(): String {
        return "LocationsDetail{" +
                "title='" + title + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                '}'
    }
}
