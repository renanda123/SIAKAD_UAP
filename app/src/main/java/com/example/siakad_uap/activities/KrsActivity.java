package com.example.siakad_uap.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.siakad_uap.adapters.KrsAdapter;
import com.example.siakad_uap.databinding.ActivityKrsBinding;
import com.example.siakad_uap.models.MataKuliah;
import java.util.ArrayList;
import java.util.List;

public class KrsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inisialisasi View Binding untuk activity_krs.xml
        ActivityKrsBinding binding = ActivityKrsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Membuat Data List Mata Kuliah dummy
        List<MataKuliah> listKrs = new ArrayList<>();
        listKrs.add(new MataKuliah("Mobile Programming", 3));
        listKrs.add(new MataKuliah("Basis Data Lanjut", 3));
        listKrs.add(new MataKuliah("Jaringan Komputer", 3));
        listKrs.add(new MataKuliah("Pemrograman Web", 3));
        listKrs.add(new MataKuliah("Rekayasa Perangkat Lunak", 3));

        // Menghitung Otomatis Total SKS yang dikontrak
        int totalSks = 0;
        for (MataKuliah mk : listKrs) {
            totalSks += mk.getSks();
        }
        binding.tvTotalSks.setText(totalSks + " SKS");

        // Memasang Adapter ke dalam RecyclerView
        binding.rvKrs.setLayoutManager(new LinearLayoutManager(this));
        KrsAdapter adapter = new KrsAdapter(listKrs);
        binding.rvKrs.setAdapter(adapter);
    }
}