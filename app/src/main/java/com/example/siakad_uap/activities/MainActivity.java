package com.example.siakad_uap.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import com.example.siakad_uap.adapters.MenuAdapter;
import com.example.siakad_uap.databinding.ActivityMainBinding;
import com.example.siakad_uap.models.MenuDashboard;
import com.example.siakad_uap.utils.SessionManager;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Ambil Data dari SessionManager
        SessionManager session = new SessionManager(this);
        
        // Cek jika belum login (untuk keamanan tambahan)
        if (!session.isLoggedIn()) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        // Set Data Identitas Mahasiswa di Dashboard
        binding.tvNamaMahasiswa.setText(session.getNama());
        binding.tvDetailMahasiswa.setText("NPM: " + session.getNpm() + "  |  Semester " + session.getSemester());
        binding.tvProdiMahasiswa.setText(session.getProdi());

        // Inisialisasi Data 8 Menu dengan Palet Warna Pastel Premium
        List<MenuDashboard> listMenu = new ArrayList<>();
        listMenu.add(new MenuDashboard("KRS", android.R.drawable.ic_menu_agenda, "#F3E8FF", "#6B21A8"));
        listMenu.add(new MenuDashboard("KHS", android.R.drawable.ic_menu_sort_by_size, "#E0F2FE", "#0369A1"));
        listMenu.add(new MenuDashboard("Absensi", android.R.drawable.ic_menu_my_calendar, "#DCFCE7", "#15803D"));
        listMenu.add(new MenuDashboard("Pembayaran Akademik", android.R.drawable.ic_menu_report_image, "#FEF3C7", "#B45309"));
        listMenu.add(new MenuDashboard("Informasi Akademik", android.R.drawable.ic_menu_info_details, "#E0F2FE", "#2563EB"));
        listMenu.add(new MenuDashboard("Jadwal Kuliah", android.R.drawable.ic_menu_today, "#FCE7F3", "#DB2777"));
        listMenu.add(new MenuDashboard("Notifikasi", android.R.drawable.ic_popup_reminder, "#FFEDD5", "#EA580C"));
        listMenu.add(new MenuDashboard("Profil", android.R.drawable.ic_menu_view, "#E2E8F0", "#475569"));

        // Set layout manager Grid 2 Kolom untuk Menu
        binding.rvMenu.setLayoutManager(new GridLayoutManager(this, 2));

        // Konfigurasi Navigasi Klik Menu (Sudah Disamakan dengan Nama File Java Anda)
        MenuAdapter adapter = new MenuAdapter(listMenu, menu -> {
            switch (menu.getTitle()) {
                case "KRS":
                    startActivity(new Intent(MainActivity.this, KrsActivity.class));
                    break;
                case "KHS":
                    startActivity(new Intent(MainActivity.this, KhsActivity.class));
                    break;
                case "Absensi":
                    startActivity(new Intent(MainActivity.this, AbsensiActivity.class));
                    break;
                case "Pembayaran Akademik":
                    startActivity(new Intent(MainActivity.this, PembayaranActivity.class));
                    break;
                case "Informasi Akademik":
                    startActivity(new Intent(MainActivity.this, InformasiActivity.class));
                    break;
                case "Jadwal Kuliah":
                    startActivity(new Intent(MainActivity.this, JadwalActivity.class));
                    break;
                case "Notifikasi":
                    startActivity(new Intent(MainActivity.this, NotifikasiActivity.class));
                    break;
                case "Profil":
                    startActivity(new Intent(MainActivity.this, ProfilActivity.class));
                    break;
            }
        });
        binding.rvMenu.setAdapter(adapter);

        // LOGIKA TOMBOL LOGOUT UTAMA DI BAGIAN BAWAH DASHBOARD
        binding.btnLogoutMain.setOnClickListener(v -> {
            new MaterialAlertDialogBuilder(this)
                    .setTitle("Konfirmasi Keluar")
                    .setMessage("Apakah Anda yakin ingin keluar?")
                    .setPositiveButton("Ya", (dialog, which) -> {
                        // Logout dari sesi
                        session.logout();
                        
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    })
                    .setNegativeButton("Tidak", (dialog, which) -> dialog.dismiss())
                    .show();
        });
    }
}