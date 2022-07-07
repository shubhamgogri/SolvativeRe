package com.shubham.solvative.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.shubham.solvative.controller.Appcontroller;
import com.shubham.solvative.model.Artwork;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AllArtwork {

    ArrayList<Artwork> artworks = new ArrayList<>();
    RequestQueue requestQueue;

    private static String url = "https://api.artic.edu/api/v1/artworks?page=1&limit=5";

    public List<Artwork> getAllArtworks(com.shubham.solvative.data.AsyncResponse asyncResponse){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray data = (JSONArray) response.get("data");

                            for (int i = 0; i < data.length(); i++) {
                                JSONObject object = data.getJSONObject(i);
                                Artwork artwork = new Artwork();
                                String artist_title = object.getString("artist_title");
                                artwork.setTitle(artist_title);

                                int artist_id = object.getInt("artist_id");
                                artwork.setArtist_id(artist_id);

                                artwork.setFiscal_year(String.valueOf(object.get("fiscal_year")));

                                artwork.setArtist_display(object.getString("artist_display"));

                                artworks.add(artwork);
                                Log.d("TAG", "onResponse: " + artwork.toString());

                            }

//                            Log.d("TAG", "onResponse: object request" + data);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (asyncResponse != null){
                            asyncResponse.processFinished(artworks);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Appcontroller.getInstance().addToRequestQueue(jsonObjectRequest);

        return artworks;
    }

}
