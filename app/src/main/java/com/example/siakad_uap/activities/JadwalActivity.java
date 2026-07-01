package com.example.siakad_uap.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.siakad_uap.adapters.JadwalAdapter;
import com.example.siakad_uap.models.JadwalKuliah;
import com.example.siakad_uap.R;
import java.util.ArrayList;
import java.util.List;

public class JadwalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal);

        List<JadwalKuliah> listJadwal = new ArrayList<>();
        listJadwal.add(new JadwalKuliah("Senin", "08.00", "10.30", "Mobile Programming", "Lab Komputer 2", 3));
        listJadwal.add(new JadwalKuliah("Selasa", "10.00", "12.30", "Basis Data", "Ruang Aula Gedung B", 3));
        listJadwal.add(new JadwalKuliah("Rabu", "13.00", "15.30", "Jaringan Komputer", "Lab Jaringan", 3));
        listJadwal.add(new JadwalKuliah("Kamis", "08.00", "10.30", "Pemrograman Web", "Lab Komputer 1", 3));
        listJadwal.add(new JadwalKuliah("Jumat", "10.00", "12.30", "Rekayasa Perangkat Lunak (RPL)", "Kelas R.302", 2));

        RecyclerView rvJadwal = findViewById(R.id.rvJadwal);
        if (rvJadwal != null) {
            rvJadwal.setLayoutManager(new LinearLayoutManager(this));
            JadwalAdapter adapter = new JadwalAdapter(listJadwal);
            rvJadwal.setAdapter(adapter);
        }
    }
}