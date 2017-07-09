package org.redi_school.bigben.http;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mlu on 09.07.2017.
 */

public class RestClient {
    // Localhost ip for the Android emulator;
    private static final String BASE_URL = "http://punktlich-api.appspot.com/";

    private Retrofit retrofit;

    private RestClient() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
                .client(new OkHttpClient())
                .build();
    }

    private static final RestClient INSTANCE = new RestClient();

    public static RestClient getInstance() {
        return INSTANCE;
    }

    public <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
