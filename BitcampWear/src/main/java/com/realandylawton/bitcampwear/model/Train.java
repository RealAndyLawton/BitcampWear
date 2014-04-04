package com.realandylawton.bitcampwear.model;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import com.realandylawton.bitcampwear.util.JsonAssetsLoader;
import java.io.IOException;
import java.util.List;

/**
 * Created by realandylawton on 4/4/14.
 */
public class Train {

    public static List<Train> getTrainList(Context context)  {

        JsonAssetsLoader jsonLoader = new JsonAssetsLoader(context);
        try {
            TrainsResponse trainsResponse = jsonLoader.parseFromJsonFile("trains.json", TrainsResponse.class);
            return trainsResponse.getTrains();
        } catch (IOException e) {
            // crap!
        }

        return null;

    }

    @SerializedName("DestinationName")
    protected String destinationName;
    @SerializedName("LocationName")
    protected String locationName;
    @SerializedName("Line")
    protected String line;
    @SerializedName("Min")
    protected String minutes;


    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
