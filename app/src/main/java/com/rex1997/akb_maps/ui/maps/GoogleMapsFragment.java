package com.rex1997.akb_maps.ui.maps;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.GeoPoint;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.rex1997.akb_maps.R;

public class GoogleMapsFragment extends Fragment {

    private final static String TAG = "Google Maps API";

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private final OnMapReadyCallback callback = googleMap -> {

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Data");

        db.collection("WisataBandung")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            WisataModel wisata = document.toObject(WisataModel.class);
                            String name = wisata.getName();
                            String address = wisata.getAddress();
                            GeoPoint geoPoint = wisata.getGeoPoint();
                            double lat = geoPoint.getLatitude(); //convert from geopoint to latitude
                            double lng = geoPoint.getLongitude(); //convert from geopoint to longitude
                            LatLng latLng = new LatLng(lat, lng);

                            googleMap.addMarker(new MarkerOptions()
                                    .position(latLng)
                                    .title(name)
                                    .snippet(address));

                            Log.d(TAG, document.getId() + " => " + document.getData());
                        }
                    } else {
                        Log.d(TAG, "Error getting documents: ", task.getException());
                    }
                });
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_google_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}