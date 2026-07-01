package com.example.siakad_uap.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.example.siakad_uap.R;
import com.example.siakad_uap.api.ApiClient;
import com.example.siakad_uap.api.ApiService;
import com.example.siakad_uap.models.LoginResponse;
import com.example.siakad_uap.utils.SessionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Memanggil langsung layout activity_login.xml
        setContentView(R.layout.activity_login);

        // Menghubungkan variabel Java dengan ID yang ada di XML
        TextInputEditText etNpm = findViewById(R.id.etNpm);
        TextInputEditText etPassword = findViewById(R.id.etPassword);
        MaterialButton btnLogin = findViewById(R.id.btnLogin);

        // Logika Tombol Masuk
        if (btnLogin != null) {
            btnLogin.setOnClickListener(v -> {
                String npm = etNpm != null && etNpm.getText() != null ? etNpm.getText().toString().trim() : "";
                String password = etPassword != null && etPassword.getText() != null ? etPassword.getText().toString().trim() : "";

                if (npm.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "NPM dan Password wajib diisi!", Toast.LENGTH_SHORT).show();
                } else {
                    // Panggil API Login via Retrofit
                    ApiService apiService = ApiClient.getClient().create(ApiService.class);
                    Call<LoginResponse> call = apiService.login(npm, password);

                    call.enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                            if (response.isSuccessful() && response.body() != null) {
                                LoginResponse loginResponse = response.body();
                                if ("success".equals(loginResponse.getStatus())) {
                                    // Simpan ke SharedPreferences
                                    SessionManager session = new SessionManager(LoginActivity.this);
                                    LoginResponse.MahasiswaData data = loginResponse.getData();
                                    session.createLoginSession(data.getNpm(), data.getNama(), data.getProgramStudi(), data.getSemester());

                                    Toast.makeText(LoginActivity.this, "Login Berhasil!", Toast.LENGTH_SHORT).show();

                                    // Pindah ke Dashboard
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(LoginActivity.this, "Terjadi kesalahan pada respon server", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {
                            Toast.makeText(LoginActivity.this, "Gagal koneksi ke server lokal: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });
        }
    }
}