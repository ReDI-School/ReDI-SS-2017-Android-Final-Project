package org.redi_school.bigben.api;

import org.redi_school.bigben.entities.UserData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by admin on 13/07/2017.
 */

public interface UserService {

    @GET("/users")
    Call<List<UserData>> getUsers(@Query("id") List<String> userIDs);

    @GET("/users/me")
    Call<UserData> getMe();
}
