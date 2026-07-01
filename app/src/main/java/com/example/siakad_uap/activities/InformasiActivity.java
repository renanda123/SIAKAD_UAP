package com.example.siakad_uap.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.siakad_uap.adapters.InformasiAdapter;
import com.example.siakad_uap.databinding.ActivityInformasiBinding;
import com.example.siakad_uap.models.Informasi;
import java.util.ArrayList;
import java.util.List;

public class InformasiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityInformasiBinding binding = ActivityInformasiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Pengisian Data Dummy Pengumuman Kampus
        List<Informasi> listInfo = new ArrayList<>();
        listInfo.add(new Informasi("Akademik", "Pelaksanaan Ujian Akhir Semester (UAS) Ganjil", "Diberitahukan kepada seluruh mahasiswa Teknik Informatika bahwa UAS akan dilaksanakan mulai tanggal 22 Juni secara luring.", "12 Juni 2026"));
        listInfo.add(new Informasi("Beasiswa", "Pembukaan Pendaftaran Beasiswa Berprestasi UAP", "Pendaftaran beasiswa internal UAP gelombang ke-2 resmi dibuka. Segera kumpulkan berkas IPK terakhir Anda ke bagian kemahasiswaan.", "10 Juni 2026"));
        listInfo.add(new Informasi("Kegiatan", "Workshop Mobile Development Bersama Google Expert", "Ikuti seminar dan bedah tuntas arsitektur Android modern menggunakan Clean Architecture. Kuota terbatas untuk 100 peserta pendaftar pertama.", "08 Juni 2026"));

        // Setup RecyclerView List Informasi
        binding.rvInformasi.setLayoutManager(new LinearLayoutManager(this));
        binding.rvInformasi.setAdapter(new InformasiAdapter(listInfo));
    }
}