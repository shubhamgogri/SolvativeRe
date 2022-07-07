package com.shubham.solvative.model;

public class Artwork {

//    Call the below API and list the title, artist_display,fiscal_year, and artist_id using JSON parsing.
    private String title;
    private String fiscal_year;
    private String artist_display;
    private int artist_id;

    @Override
    public String toString() {
        return "Artwork{" +
                "title='" + title + '\'' +
                ", fiscal_year=" + fiscal_year +
                ", artist_display='" + artist_display + '\'' +
                ", artist_id=" + artist_id +
                '}';
    }

    public Artwork() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFiscal_year() {
        return fiscal_year;
    }

    public void setFiscal_year(String fiscal_year) {
        this.fiscal_year = fiscal_year;
    }

    public String getArtist_display() {
        return artist_display;
    }

    public void setArtist_display(String artist_display) {
        this.artist_display = artist_display;
    }

    public int getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
    }

}
