package com.example.siakad_uap.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.siakad_uap.adapters.AbsensiAdapter;
import com.example.siakad_uap.databinding.ActivityAbsensiBinding;
import com.example.siakad_uap.models.AbsensiMatkul;
import java.util.ArrayList;
import java.util.List;

public class AbsensiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAbsensiBinding binding = ActivityAbsensiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Membuat Data List Absensi Dummy Mahasiswa Semester 5
        List<AbsensiMatkul> listAbsen = new ArrayList<>();
        listAbsen.add(new AbsensiMatkul("Mobile Programming", 14, 0, 0));
        listAbsen.add(new AbsensiMatkul("Basis Data Lanjut", 13, 1, 0));
        listAbsen.add(new AbsensiMatkul("Jaringan Komputer", 12, 0, 2));
        listAbsen.add(new AbsensiMatkul("Pemrograman Web", 14, 0, 0));
        listAbsen.add(new AbsensiMatkul("Rekayasa Perangkat Lunak", 14, 0, 0));

        // Rata-rata Kehadiran Total
        binding.tvRerataAbsen.setText("95.7%");

        // Memasang Setup List Kehadiran
        binding.rvAbsensi.setLayoutManager(new LinearLayoutManager(this));
        binding.rvAbsensi.setAdapter(new AbsensiAdapter(listAbsen));
    }
}