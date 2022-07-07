package com.shubham.solvative.data;

import com.shubham.solvative.model.Artwork;

import java.util.ArrayList;

public interface AsyncResponse {

    void processFinished(ArrayList<Artwork> artworkArrayList);
}
