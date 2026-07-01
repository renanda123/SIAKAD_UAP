package com.example.siakad_uap.activities;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.siakad_uap.adapters.KhsAdapter;
import com.example.siakad_uap.models.NilaiMatkul;
import com.example.siakad_uap.R;
import java.util.ArrayList;
import java.util.List;

public class KhsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle Bundle) {
        super.onCreate(Bundle);
        // Memanggil langsung layout activity_khs.xml
        setContentView(R.layout.activity_khs);

        // 1. Inisialisasi Ringkasan Teks Nilai Atas
        TextView tvIpSemester = findViewById(R.id.tvIpSemester);
        TextView tvIpk = findViewById(R.id.tvIpk);

        if (tvIpSemester != null) tvIpSemester.setText("3.85");
        if (tvIpk != null) tvIpk.setText("3.80");

        // 2. Inisialisasi List Data Nilai Kuliah
        List<NilaiMatkul> listKhs = new ArrayList<>();
        listKhs.add(new NilaiMatkul("Mobile Programming", "A"));
        listKhs.add(new NilaiMatkul("Basis Data Lanjut", "A"));
        listKhs.add(new NilaiMatkul("Jaringan Komputer", "B"));
        listKhs.add(new NilaiMatkul("Pemrograman Web", "A"));
        listKhs.add(new NilaiMatkul("Rekayasa Perangkat Lunak", "A"));

        // 3. Menghubungkan RecyclerView dengan ID rvKhs yang ada di XML
        RecyclerView rvKhs = findViewById(R.id.rvKhs);
        if (rvKhs != null) {
            rvKhs.setLayoutManager(new LinearLayoutManager(this));
            KhsAdapter adapter = new KhsAdapter(listKhs);
            rvKhs.setAdapter(adapter);
        }
    }
}