package com.example.siakad_uap.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.siakad_uap.R;
import com.example.siakad_uap.databinding.ActivityProfilBinding;

public class ProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityProfilBinding binding = ActivityProfilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 1. Pengisian Data Identitas Renanda
        binding.tvNamaUtama.setText("Renanda Setiawan");
        binding.tvNpmUtama.setText("230201023");
        binding.tvProdi.setText("S1 Teknik Informatika");
        binding.tvSemester.setText("5");
        binding.tvEmail.setText("renanda@uap.ac.id");
        binding.tvNoHp.setText("081234567890");
        binding.tvAlamat.setText("Pringsewu, Lampung");

        // 2. Set Foto Offline Wajah Anda dari drawable
        binding.imgFotoProfil.setImageResource(R.drawable.foto_renanda);
    }
}