package com.example.mapa;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Mapa extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private TextView tvmostrarlatitud, tvmostrarlongitud;
    private double latitud, longitud;
    private int zoom;
    private String etiqueta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        tvmostrarlatitud = (TextView) findViewById(R.id.tv_mostrarlatitud);
        tvmostrarlongitud = (TextView) findViewById(R.id.tv_mostrarlongitud);

        Bundle bundle =this.getIntent().getExtras();
        if (bundle != null) {
            latitud = Double.parseDouble(bundle.getString("latitud"));
            longitud = Double.parseDouble(bundle.getString("longitud"));
            zoom = Integer.parseInt(bundle.getString("zoom"));
            etiqueta = bundle.getString("etiqueta");
            tvmostrarlatitud.setText(String.valueOf(latitud));
            tvmostrarlongitud.setText(String.valueOf(longitud));
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng lugar = new LatLng(latitud, longitud);
        mMap.addMarker(new MarkerOptions().position(lugar).title(etiqueta).icon(BitmapDescriptorFactory.fromResource(R.drawable.punterorojo)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lugar,zoom));
    }
}
