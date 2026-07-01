package com.example.siakad_uap.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static final String PREF_NAME = "SiakadSession";
    private static final String IS_LOGGED_IN = "isLoggedIn";
    private static final String KEY_NPM = "npm";
    private static final String KEY_NAMA = "nama";
    private static final String KEY_PRODI = "program_studi";
    private static final String KEY_SEMESTER = "semester";

    public SessionManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(String npm, String nama, String prodi, int semester) {
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(KEY_NPM, npm);
        editor.putString(KEY_NAMA, nama);
        editor.putString(KEY_PRODI, prodi);
        editor.putInt(KEY_SEMESTER, semester);
        editor.apply();
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }

    public void logout() {
        editor.clear();
        editor.apply();
    }

    public String getNpm() {
        return sharedPreferences.getString(KEY_NPM, "");
    }

    public String getNama() {
        return sharedPreferences.getString(KEY_NAMA, "");
    }

    public String getProdi() {
        return sharedPreferences.getString(KEY_PRODI, "");
    }

    public int getSemester() {
        return sharedPreferences.getInt(KEY_SEMESTER, 0);
    }
}
