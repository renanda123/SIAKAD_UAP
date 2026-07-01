package com.example.siakad_uap.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.siakad_uap.databinding.ItemAbsensiBinding;
import com.example.siakad_uap.models.AbsensiMatkul;
import java.util.List;

public class AbsensiAdapter extends RecyclerView.Adapter<AbsensiAdapter.AbsensiViewHolder> {

    private final List<AbsensiMatkul> absensiList;

    public AbsensiAdapter(List<AbsensiMatkul> absensiList) {
        this.absensiList = absensiList;
    }

    @NonNull
    @Override
    public AbsensiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemAbsensiBinding binding = ItemAbsensiBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new AbsensiViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AbsensiViewHolder holder, int position) {
        AbsensiMatkul item = absensiList.get(position);

        holder.binding.tvNamaMatkulAbsen.setText(item.getNamaMatkul());
        holder.binding.tvHadirCount.setText(item.getHadir() + " Hadir");
        holder.binding.tvIzinCount.setText(item.getIzin() + " Izin");
        holder.binding.tvSakitCount.setText(item.getSakit() + " Sakit");

        // Rumus sederhana menghitung persentase kehadiran (Total Pertemuan Asumsi: 14)
        int totalMasuk = item.getHadir();
        int persentase = (int) ((totalMasuk / 14.0) * 100);
        if (persentase > 100) persentase = 100;

        holder.binding.tvPersentaseAbsen.setText(persentase + "%");
        holder.binding.progressKehadiran.setProgress(persentase);
    }

    @Override
    public int getItemCount() {
        return absensiList != null ? absensiList.size() : 0;
    }

    static class AbsensiViewHolder extends RecyclerView.ViewHolder {
        final ItemAbsensiBinding binding;

        public AbsensiViewHolder(@NonNull ItemAbsensiBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}