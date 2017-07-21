package org.redi_school.bigben.api;

import org.redi_school.bigben.data.UserInfo;

import java.io.IOException;

import android.content.Context;

import com.google.gson.GsonBuilder;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by joseluisugia on 12.07.17.
 */

public class AuthenticatedRestClient {

    private static final String BASE_URL = "https://punktlich-api.appspot.com";

    private Retrofit retrofit;
    private final Context context;

    private static AuthenticatedRestClient authenticatedRestClient;

    public static AuthenticatedRestClient getInstance(Context context){
        if (authenticatedRestClient == null ){
            authenticatedRestClient = new AuthenticatedRestClient(context);
        }
        return authenticatedRestClient;
    }

    private AuthenticatedRestClient(Context context) {

        this.context = context;

        GsonBuilder gsonBuilder = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder().addInterceptor(authInterceptor);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
                .client(okHttpClientBuilder.build())
                .build();
    }

    public <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

    private final Interceptor authInterceptor = new Interceptor() {

        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {

            String userToken = UserInfo.getCurrentUser(AuthenticatedRestClient.this.context).getToken();
            Request newRequest = chain.request().newBuilder()
                                      .addHeader("Authorization", "Bearer " + userToken)
                                      .build();

            return chain.proceed(newRequest);
        }
    };
}