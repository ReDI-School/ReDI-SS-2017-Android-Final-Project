package org.redi_school.bigben.entities;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by admin on 13/07/2017.
 */

public class Location {
    double lat;
    double lon;
    public LatLng toLatLng(){
        return new LatLng(lat, lon);
    }
}
