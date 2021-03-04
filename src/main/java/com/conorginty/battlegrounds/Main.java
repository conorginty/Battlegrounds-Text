package com.conorginty.battlegrounds;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        String tier1JsonFilename = "JSON/tier1.json";

        URL res = Main.class.getClassLoader().getResource(tier1JsonFilename);
        System.out.println(res.toString());
        File file = Paths.get(res.toURI()).toFile();
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);

//        Gson gson = new Gson();
//        JsonReader reader = new JsonReader(new FileReader(tier1JsonFilename));
//        Review data = gson.fromJson(reader, Review.class);
//        data.toScreen(); // prints to screen some values
//        Minion[] tier1Minions = new Gson().fromJson(jsonString, Review[].class);
    }
}
