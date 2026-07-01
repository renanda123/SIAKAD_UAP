package com.example.siakad_uap.models;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private MahasiswaData data;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public MahasiswaData getData() {
        return data;
    }

    public static class MahasiswaData {
        @SerializedName("npm")
        private String npm;

        @SerializedName("nama")
        private String nama;

        @SerializedName("program_studi")
        private String programStudi;

        @SerializedName("semester")
        private int semester;

        public String getNpm() {
            return npm;
        }

        public String getNama() {
            return nama;
        }

        public String getProgramStudi() {
            return programStudi;
        }

        public int getSemester() {
            return semester;
        }
    }
}
