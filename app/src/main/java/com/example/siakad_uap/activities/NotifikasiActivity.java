package com.example.siakad_uap.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.siakad_uap.adapters.NotifikasiAdapter;
import com.example.siakad_uap.models.Notifikasi;
import com.example.siakad_uap.R;
import java.util.ArrayList;
import java.util.List;

public class NotifikasiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifikasi);

        List<Notifikasi> listNotif = new ArrayList<>();
        listNotif.add(new Notifikasi("KRS Berhasil Disimpan", "Rencana studi Anda semester ini telah divalidasi oleh dosen pembimbing akademik.", "Baru saja", "akademik", false));
        listNotif.add(new Notifikasi("Jadwal UAS Telah Tersedia", "Silakan cek kartu ujian Anda untuk melihat detail ruangan pelaksanaan ujian.", "2 jam lalu", "info", false));
        listNotif.add(new Notifikasi("Pembayaran UAS Belum Lunas", "Segera lakukan pelunasan biaya administrasi sebelum penutupan portal pengisian.", "Hari ini", "keuangan", false));
        listNotif.add(new Notifikasi("Nilai Mobile Programming Keluar", "Dosen pengampu telah mengunggah rekapitulasi nilai akhir mata kuliah.", "Kemarin", "akademik", true));
        listNotif.add(new Notifikasi("Kalender Akademik Diperbarui", "Terdapat penyesuaian jadwal libur nasional dan minggu tenang perkuliahan.", "3 hari lalu", "info", true));

        RecyclerView rvNotifikasi = findViewById(R.id.rvNotifikasi);
        if (rvNotifikasi != null) {
            rvNotifikasi.setLayoutManager(new LinearLayoutManager(this));
            NotifikasiAdapter adapter = new NotifikasiAdapter(listNotif);
            rvNotifikasi.setAdapter(adapter);
        }
    }
}