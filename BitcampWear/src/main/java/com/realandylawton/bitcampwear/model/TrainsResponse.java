package com.realandylawton.bitcampwear.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by realandylawton on 4/4/14.
 */
public class TrainsResponse {

    @SerializedName("Trains")
    protected List<Train> trains;

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }
}
