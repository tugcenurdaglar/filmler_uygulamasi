package com.tugcenurdaglar.filmleruygulamasi;

public class ApiUtils {

    public static final String BASE_URL = "http://kasimadalan.pe.hu/";

    public static FilmlerDaoInterface getFilmlerDaoInterface(){
        return RetrofitClient.getClient(BASE_URL).create(FilmlerDaoInterface.class);
    }

    public static KategorilerDaoInterface getKategorilerDaoInterface(){
        return RetrofitClient.getClient(BASE_URL).create(KategorilerDaoInterface.class);
    }
}
