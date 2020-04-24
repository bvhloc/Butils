package com.bvhloc.general.prefs;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by COVISOFT on 7/6/2017.
 */

public final class LoginPrefs {

    private final String PREFERENCE_LOGIN = "PREFERENCE_LOGIN";

    private final String ACCESS_TOKEN = "ACCESS_TOKEN";
    private final String USERNAME = "USERNAME";
    private final String PASSWORD = "PASSWORD";
    private final String AUTO_LOGIN = "AUTO_LOGIN";

    private SharedPreferences preferences;

    public LoginPrefs(Context context) {
        preferences = context.getSharedPreferences(PREFERENCE_LOGIN, Context.MODE_PRIVATE);
    }

    public String getAccessToken() {
        return preferences.getString(ACCESS_TOKEN, "");
    }

    public void setAccessToken(String accessToken) {
        preferences.edit()
                .putString(ACCESS_TOKEN, accessToken)
                .apply();
    }

    public String getUsername() {
        return preferences.getString(USERNAME, "");
    }

    public void setUsername(String username) {
        preferences.edit()
                .putString(USERNAME, username)
                .apply();
    }

    public String getPassword() {
        return preferences.getString(PASSWORD, "");
    }

    public void setPassword(String password) {
        preferences.edit()
                .putString(PASSWORD, password)
                .apply();
    }

    public boolean isAutoLogin() {
        return preferences.getBoolean(AUTO_LOGIN, false);
    }

    public void setAutoLogin(boolean autoLogin) {
        preferences.edit()
                .putBoolean(AUTO_LOGIN, autoLogin)
                .apply();
    }
}
