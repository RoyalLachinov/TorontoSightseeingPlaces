package ca.com.toronto.model;


public class LocationsDetail {
    private final String title;
    private final double lat;
    private final double lng;

    public LocationsDetail(String title, Double lat, Double lng) {
        this.title = title;
        this.lat = lat;
        this.lng = lng;
    }

    public String getTitle() {
        return title;
    }

    public Double getLat() {
        return lat;
    }


    public Double getLng() {
        return lng;
    }


    @Override
    public String toString() {
        return "LocationsDetail{" +
                "title='" + title + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
