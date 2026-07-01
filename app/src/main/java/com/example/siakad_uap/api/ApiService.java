package com.example.siakad_uap.api;

import com.example.siakad_uap.models.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponse> login(
            @Field("npm") String npm,
            @Field("password") String password
    );

    // TODO: Tambahkan endpoint lain (KRS, KHS, dll) di sini nanti
}
