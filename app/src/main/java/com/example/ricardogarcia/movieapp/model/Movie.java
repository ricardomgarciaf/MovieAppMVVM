package com.example.ricardogarcia.movieapp.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.ricardogarcia.movieapp.BR;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public class Movie extends BaseObservable{

    @SerializedName("Title")
    @Expose
    private String title;

    @SerializedName("Year")
    @Expose
    private String year;

    @SerializedName("Genre")
    @Expose
    private String genre;

    @SerializedName("Plot")
    @Expose
    private String plot;

    @SerializedName("Poster")
    @Expose
    private String poster;

    @SerializedName("Response")
    @Expose
    @JsonAdapter(StringToIntTypeAdapter.class)
    private int response=-1;

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setMovie(Movie movie){
        setTitle(movie.getTitle());
        setGenre(movie.getGenre());
        setPlot(movie.getPlot());
        setPoster(movie.getPoster());
        setYear(movie.getYear());
        setResponse(movie.getResponse());
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
        notifyPropertyChanged(BR.year);
    }

    @Bindable
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);
    }

    @Bindable
    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
        notifyPropertyChanged(BR.plot);
    }

    @Bindable
    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
        notifyPropertyChanged(BR.poster);
    }

    @BindingAdapter({"android:poster"})
    public static void loadPoster(ImageView view, String imageUrl){
        Glide.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }

    @Bindable
    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
        notifyPropertyChanged(BR.response);
    }
}
