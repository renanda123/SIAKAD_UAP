package com.example.siakad_uap.activities;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.siakad_uap.adapters.PembayaranAdapter;
import com.example.siakad_uap.databinding.ActivityPembayaranBinding;
import com.example.siakad_uap.models.Pembayaran;
import java.util.ArrayList;
import java.util.List;

public class PembayaranActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPembayaranBinding binding = ActivityPembayaranBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Pengisian Data Finansial Sesuai Gambar
        List<Pembayaran> listBayar = new ArrayList<>();
        listBayar.add(new Pembayaran("SPP Semester 5", "Rp3.500.000,00", "Lunas"));
        listBayar.add(new Pembayaran("Praktikum", "Rp500.000,00", "Lunas"));
        listBayar.add(new Pembayaran("Ujian Akhir Semester", "Rp250.000,00", "Belum Lunas"));

        // Setup Nilai Informasi Ringkasan Atas dan Bawah
        binding.tvTotalTagihan.setText("Rp4.250.000");
        binding.tvBelumDibayar.setText("Rp250.000");
        binding.tvTotalTerbayarBottom.setText("Rp4.000.000,00");

        // Memasang Setup List Tagihan Finansial
        binding.rvPembayaran.setLayoutManager(new LinearLayoutManager(this));
        binding.rvPembayaran.setAdapter(new PembayaranAdapter(listBayar));

        // Listener Tombol Riwayat
        binding.btnRiwayat.setOnClickListener(v ->
                Toast.makeText(this, "Membuka Riwayat Transaksi...", Toast.LENGTH_SHORT).show()
        );
    }
}