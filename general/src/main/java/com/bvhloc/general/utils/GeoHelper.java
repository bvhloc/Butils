package com.bvhloc.general.utils;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

//import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;

public class GeoHelper {
//
//    private Context context;
//
//    public GeoHelper(Context context) {
//        this.context = context;
//    }
//
//    public String getAddress(double latitude, double longitude) {
//
//        return getAddress(latitude, longitude, false);
//    }
//
//    public String getAddress(double latitude, double longitude, boolean onlyVN) {
//
//        StringBuilder result = new StringBuilder();
//        try {
//            Geocoder geocoder = new Geocoder(context, Locale.getDefault());
//            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
//            if (addresses.size() > 0) {
//                Address address = addresses.get(0);
//                if (onlyVN) {
//                    if (!address.getCountryCode().equals("VN")) {
//                        return "";
//                    }
//                }
//                if (address.getMaxAddressLineIndex() == 0) {
//                    result.append(address.getAddressLine(0));
//                } else {
//                    for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
//                        if (i == address.getMaxAddressLineIndex() - 1) {
//                            result.append(address.getAddressLine(i));
//                            break;
//                        }
//                        result.append(address.getAddressLine(i)).append(", ");
//                    }
//                }
////                result.append(address.getAddressLine(0)).append(", ");
////                result.append(address.getSubLocality()).append(", ");
////                result.append(address.getLocality()).append(", ");
////                result.append(address.getCountryName());
//            }
//        } catch (IOException e) {
//            Log.e("tag", e.getMessage());
//        }
//
//        return result.toString();
//    }
//
//    public String getAddress(LatLng latlng) {
//
//        return getAddress(latlng, false);
//    }
//
//    public String getAddress(LatLng latlng, boolean onlyVN) {
//
//        return getAddress(latlng.latitude, latlng.longitude, onlyVN);
//    }
//
//    public float getRoadDistance(LatLng source, LatLng destination) {
//
//        Location loc1 = new Location("");
//        loc1.setLatitude(source.latitude);
//        loc1.setLongitude(source.longitude);
//
//        Location loc2 = new Location("");
//        loc2.setLatitude(destination.latitude);
//        loc2.setLongitude(destination.longitude);
//
//        return loc1.distanceTo(loc2); //distance in meters
//    }
//
//    public static double getDistance(LatLng source, LatLng destination) {
//        int Radius = 6371;// radius of earth in Km
//        double lat1 = source.latitude;
//        double lat2 = destination.latitude;
//        double lon1 = source.longitude;
//        double lon2 = destination.longitude;
//        double dLat = Math.toRadians(lat2 - lat1);
//        double dLon = Math.toRadians(lon2 - lon1);
//        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
//                + Math.cos(Math.toRadians(lat1))
//                * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
//                * Math.sin(dLon / 2);
//        double c = 2 * Math.asin(Math.sqrt(a));
//        double valueResult = Radius * c;
//        double km = valueResult / 1;
//        DecimalFormat newFormat = new DecimalFormat("####");
//        int kmInDec = Integer.valueOf(newFormat.format(km));
//        double meter = valueResult % 1000;
//        int meterInDec = Integer.valueOf(newFormat.format(meter));
//        Log.i("Radius Value", "" + valueResult + " KM " + kmInDec
//                + " Meter   " + meterInDec);
//
//        return Radius * c;
//    }
//
//    public static float getDirection(LatLng origins, LatLng destination) {
//
//        return locationFromLatLng(origins).bearingTo(locationFromLatLng(destination));
//    }
//
//    public static Location locationFromLatLng(LatLng latlng) {
//
//        Location location = new Location(LocationManager.GPS_PROVIDER);
//        location.setLatitude(latlng.latitude);
//        location.setLongitude(latlng.longitude);
//        return location;
//    }
}
