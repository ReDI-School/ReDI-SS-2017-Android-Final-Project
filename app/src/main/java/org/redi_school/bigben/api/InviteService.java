package org.redi_school.bigben.api;

import com.google.gson.annotations.SerializedName;

import org.redi_school.bigben.api.requestdata.InviteData;
import org.redi_school.bigben.entities.Invite;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by admin on 13/07/2017.
 */

public interface InviteService {

    @GET("/invites")
    Call<List<Invite>> getPendingInvites();

    @GET("/invites/{inviteId}")
    Call<Invite> getInvite(@Path("inviteId") Long inviteId);

    @POST("/invites")
    Call<Void> inviteUser(@Body InviteData inviteData);

    @DELETE("/invites/{inviteId}")
    Call<Void> deleteInvite(@Path("inviteId") Long inviteId, @Query("recipient_id") Long recipient_id);

    @POST("/invites/{invites_id}/accept")
    Call<Void> acceptInvite(@Path("invites_id") Long invites_id);

    @POST("/invites/{invites_id}/reject")
    Call<Void> rejectInvite(@Path("invites_id") Long invites_id);


}
