package com.example.siakad_uap.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.siakad_uap.databinding.ItemJadwalBinding;
import com.example.siakad_uap.models.JadwalKuliah;
import java.util.List;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.JadwalViewHolder> {

    private final List<JadwalKuliah> listJadwal;

    public JadwalAdapter(List<JadwalKuliah> listJadwal) {
        this.listJadwal = listJadwal;
    }

    @NonNull
    @Override
    public JadwalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemJadwalBinding binding = ItemJadwalBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new JadwalViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalViewHolder holder, int position) {
        JadwalKuliah item = listJadwal.get(position);

        holder.binding.tvHariJadwal.setText(item.getHari());
        holder.binding.tvJamJadwal.setText(item.getJamMulai());
        holder.binding.tvJamSelesaiJadwal.setText(item.getJamSelesai() + " WIB");
        holder.binding.tvNamaMatkulJadwal.setText(item.getNamaMatkul());
        holder.binding.tvRuanganJadwal.setText(item.getRuangan());
        holder.binding.tvSksJadwal.setText(item.getSks() + " SKS");

        // Mewarnai kapsul badge secara dinamis berdasarkan hari kuliah
        String hari = item.getHari().toLowerCase();
        if (hari.contains("senin")) {
            holder.binding.cardHariJadwal.setCardBackgroundColor(Color.parseColor("#F3E8FF")); // Ungu
            holder.binding.tvHariJadwal.setTextColor(Color.parseColor("#7C3AED"));
        } else if (hari.contains("selasa")) {
            holder.binding.cardHariJadwal.setCardBackgroundColor(Color.parseColor("#E0F2FE")); // Biru
            holder.binding.tvHariJadwal.setTextColor(Color.parseColor("#0369A1"));
        } else if (hari.contains("rabu")) {
            holder.binding.cardHariJadwal.setCardBackgroundColor(Color.parseColor("#E6F9ED")); // Hijau
            holder.binding.tvHariJadwal.setTextColor(Color.parseColor("#15803D"));
        } else if (hari.contains("kamis")) {
            holder.binding.cardHariJadwal.setCardBackgroundColor(Color.parseColor("#FEF3C7")); // Kuning
            holder.binding.tvHariJadwal.setTextColor(Color.parseColor("#D97706"));
        } else {
            holder.binding.cardHariJadwal.setCardBackgroundColor(Color.parseColor("#FCE7F3")); // Pink
            holder.binding.tvHariJadwal.setTextColor(Color.parseColor("#DB2777"));
        }
    }

    @Override
    public int getItemCount() {
        return listJadwal != null ? listJadwal.size() : 0;
    }

    static class JadwalViewHolder extends RecyclerView.ViewHolder {
        final ItemJadwalBinding binding;
        public JadwalViewHolder(@NonNull ItemJadwalBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}