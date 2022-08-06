package com.rex1997.akb_maps.ui.maps;

import android.media.Image;
import android.provider.MediaStore;

import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.firestore.GeoPoint;
import com.google.gson.annotations.SerializedName;

public class WisataModel {

    @SerializedName("name")
    public String name;
    @SerializedName("address")
    public String address;
    @SerializedName("geoPoint")
    public GeoPoint geoPoint;
    @SerializedName("image")
    public String image;

    public WisataModel(String name, String address, GeoPoint geoPoint, String image) {
        this.name = name;
        this.address = address;
        this.geoPoint = geoPoint;
        this.image = image;
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

    public String getImage() {
        return image;
    }
}
