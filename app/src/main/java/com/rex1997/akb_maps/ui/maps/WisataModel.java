package com.rex1997.akb_maps.ui.maps;

import com.google.firebase.firestore.GeoPoint;
import com.google.gson.annotations.SerializedName;

/*
Created at 03/06/2022
Created by Bina Damareksa (NIM: 10121702; Class: AKB-7)
*/

public class WisataModel {

    @SerializedName("name")
    public String name;
    @SerializedName("address")
    public String address;
    @SerializedName("geoPoint")
    public GeoPoint geoPoint;

    public WisataModel(String name, String address, GeoPoint geoPoint) {
        this.name = name;
        this.address = address;
        this.geoPoint = geoPoint;
    }

    public WisataModel(){

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public GeoPoint getGeoPoint() {
        return geoPoint;
    }
}
