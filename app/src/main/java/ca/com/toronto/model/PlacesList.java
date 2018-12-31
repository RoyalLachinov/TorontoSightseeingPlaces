package ca.com.toronto.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Royal_L on 22-Oct-17.
 */

public class PlacesList {

    @SerializedName("results")
    @Expose
    private ArrayList<Places> placesList = new ArrayList<>();

    public ArrayList<Places> getPlacesList() {
        return placesList;
    }

    public void setPlacesList(ArrayList<Places> placesList) {
        this.placesList = placesList;
    }

}
