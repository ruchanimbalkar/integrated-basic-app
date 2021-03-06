package com.example.rucha.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("deprecation")
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;
    private static final int CAPImage_REQUEST_CODE = 100;
    private LocationManager locationManager;

    ImageView resultphoto;
    private Uri fileUri;
    private String chosenProvider;
    Location location;
    public boolean k = false;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        Button click = (Button) findViewById(R.id.cbutton);


        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        chosenProvider = locationManager.getBestProvider(criteria, false);
        try {
            location = locationManager.getLastKnownLocation(chosenProvider);
        } catch (SecurityException E) {
            E.printStackTrace();
        }
        if (location != null) {
            onLocationChanged(location);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(chosenProvider, 400, 1, this);
    }




    @Override
    public void onMapReady(GoogleMap googleMap) {

        if (k==false) {
            mMap = googleMap;

            // Add a marker in Sydney and move the camera

            LatLng sydney = new LatLng(47.2483960, -122.4382950);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Itrajectory ").snippet("Itrajectory is the coolest"));
      /*  Polyline line = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(47.2464440, -122.4395990), new LatLng(47.2448112, -122.4376078))
                .width(5)
                .color(Color.RED));
        Polyline line2 = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(47.2464440, -122.4395990), new LatLng(47.2448112, -122.4376078))
                .width(5)
                .color(Color.RED));
*/
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            mMap.setMyLocationEnabled(true);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15));

        }

        else
        {
            mMap = googleMap;

            // Add a marker in Sydney and move the camera

            LatLng sydney = new LatLng(47.2483960, -122.4382950);
            mMap.addMarker(new MarkerOptions().position(sydney).title(" ").snippet(""));
      /*  Polyline line = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(47.2464440, -122.4395990), new LatLng(47.2448112, -122.4376078))
                .width(5)
                .color(Color.RED));
        Polyline line2 = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(47.2464440, -122.4395990), new LatLng(47.2448112, -122.4376078))
                .width(5)
                .color(Color.RED));
*/
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            mMap.setMyLocationEnabled(true);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15));


        }
    }
    public void onCamclick(View v)
    {
        // create Intent to take a picture and return control to the calling application
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(intent, CAPImage_REQUEST_CODE);
    }

    public void addtextmemory(View v)
    {

        //EditText a = (EditText)findViewById(R.id.TFusername);
        //String str =a.getText().toString();
            k = true;
           Intent i = new Intent(MapsActivity.this, display.class);
                /*i.putExtra("Username",str); We will put username here*/


    }



    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Maps Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.rucha.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Maps Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.rucha.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    @Override
    public void onLocationChanged(Location location) {
            int lat = (int) (location.getLatitude());
            int lng = (int)  (location.getLongitude());
            String str = getCurrentTimeStamp();

        String url="http://url.com";
        URL object= null;

        try {
            object = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) object.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        try {
            con.setRequestMethod("POST");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }

        JSONObject latitude = new JSONObject();
        JSONObject longitude =new JSONObject();
        JSONObject time =new JSONObject();

        try {
            latitude.put("Lat",lat);
            longitude.put("long",lng);
            time.put("time",str);

            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
            wr.flush();

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //display what returns the POST request

        StringBuilder sb = new StringBuilder();
        try {
            int HttpResult = con.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }

                br.close();

                System.out.println("" + sb.toString());

            } else {
                System.out.println(con.getResponseMessage());
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

/*
            String url="http://url.com";
            URL object=new URL(url);

            HttpURLConnection con = (HttpURLConnection) object.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestMethod("POST");

            JSONObject toSend   = new JSONObject();
        try {
        toSend.put("Lat",lat);
        toSend.put("Long",lng);
        toSend.put("timeStamp", str);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        OutputStreamWriter wr= new OutputStreamWriter(con.getOutputStream());
*/


        StringBuilder testB = new StringBuilder();

        String http = "http://android.schoolportal.gr/Service.svc/SaveValues";

        HttpURLConnection urlConnection=null;
        try {
            URL url2 = new URL(http);
            urlConnection = (HttpURLConnection) url2.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setUseCaches(false);
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);
            urlConnection.setRequestProperty("Content-Type","application/json");

            urlConnection.setRequestProperty("Host", "android.schoolportal.gr");
            urlConnection.connect();

            //Create JSONObject here
            JSONObject jsonParam = new JSONObject();
            jsonParam.put("ID", "25");
            jsonParam.put("description", "Real");
            jsonParam.put("enable", "true");
            OutputStreamWriter out = new   OutputStreamWriter(urlConnection.getOutputStream());
            out.write(jsonParam.toString());
            out.close();

            int HttpResult =urlConnection.getResponseCode();
            if(HttpResult ==HttpURLConnection.HTTP_OK){
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        urlConnection.getInputStream(),"utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    testB.append(line + "\n");
                }
                br.close();

                System.out.println(""+testB.toString());

            }else{
                System.out.println(urlConnection.getResponseMessage());
            }
        } catch (MalformedURLException e) {

            e.printStackTrace();
        }
        catch (IOException e) {

            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(urlConnection!=null)
                urlConnection.disconnect();
        }

    }


    public static String getCurrentTimeStamp(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTimeStamp = dateFormat.format(new Date());

        return currentTimeStamp;
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(this, "Enabled new provider" + provider, Toast.LENGTH_SHORT).show(); //Pop-up
    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(this, "Disabled new provider" + provider, Toast.LENGTH_SHORT).show(); //Pop-up
    }
}
