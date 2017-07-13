package org.redi_school.bigben.data;

import org.redi_school.bigben.entities.UserData;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Created by joseluisugia on 12.07.17.
 */

public class UserInfo {

    private static final String USER_JSON_KEY = "user_json_key";

    private static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences("org.redi_school.bigben.USER_PREFERENCES", Context.MODE_PRIVATE);
    }

    public static UserData getCurrentUser(Context context) {

        String userJsonString = getPreferences(context).getString(USER_JSON_KEY, null);
        if (userJsonString == null) {
            return null;
        }

        return new Gson().fromJson(userJsonString, UserData.class);
    }

    public static void storeCurrentUser(Context context, String userString) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putString(USER_JSON_KEY, userString);
        editor.apply();
    }

    public static void clear(Context context) {
        getPreferences(context).edit().clear().apply();
    }
}
