package org.redi_school.bigben.http;

import com.google.android.gms.tasks.Task;

import org.redi_school.bigben.entities.UserData;

import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by mlu on 09.07.2017.
 */

public interface ApiService {

    @POST("/authenticate")
    UserData authenticate(@Body Task task);

}
