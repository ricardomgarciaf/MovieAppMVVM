package com.example.ricardogarcia.movieapp.model;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class StringToIntTypeAdapter extends TypeAdapter<Integer> {
    @Override
    public void write(JsonWriter out, Integer value) throws IOException {
        if(value==null){
            out.nullValue();
            return;
        }
        switch (value){
            case 0:
                out.value(String.valueOf(false));
                break;
            case 1:
                out.value(String.valueOf(true));
                break;
            default:
                throw new IllegalArgumentException("Cannot convert " + value + " to a boolean literal");
        }
    }

    @Override
    public Integer read(JsonReader in) throws IOException {
        if(in.peek()==null){
            return null;
        }
        return Boolean.valueOf(in.nextString())?1:0;
    }
}
