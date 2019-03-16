package com.example.ricardogarcia.movieapp.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.ricardogarcia.movieapp.BR;

public class InputDetails extends BaseObservable{
    private String input;

    @Bindable
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
        notifyPropertyChanged(BR.input);
    }
}
