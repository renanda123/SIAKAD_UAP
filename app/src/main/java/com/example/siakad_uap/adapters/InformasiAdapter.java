package com.example.siakad_uap.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.siakad_uap.databinding.ItemInformasiBinding;
import com.example.siakad_uap.models.Informasi;
import java.util.List;

public class InformasiAdapter extends RecyclerView.Adapter<InformasiAdapter.InfoViewHolder> {

    private final List<Informasi> infoList;

    public InformasiAdapter(List<Informasi> infoList) {
        this.infoList = infoList;
    }

    @NonNull
    @Override
    public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemInformasiBinding binding = ItemInformasiBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new InfoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoViewHolder holder, int position) {
        Informasi item = infoList.get(position);

        holder.binding.tvKategoriInfo.setText(item.getKategori());
        holder.binding.tvJudulInfo.setText(item.getJudul());
        holder.binding.tvIsiInfo.setText(item.getIsi());
        holder.binding.tvTanggalInfo.setText(item.getTanggal());

        // Pengaturan Warna Badge Dinamis Berdasarkan Kategori Berita
        if (item.getKategori().equalsIgnoreCase("Akademik")) {
            holder.binding.cardBadgeKategori.setCardBackgroundColor(Color.parseColor("#E0F2FE")); // Biru Muda
            holder.binding.tvKategoriInfo.setTextColor(Color.parseColor("#0369A1"));
        } else if (item.getKategori().equalsIgnoreCase("Beasiswa")) {
            holder.binding.cardBadgeKategori.setCardBackgroundColor(Color.parseColor("#DCFCE7")); // Hijau
            holder.binding.tvKategoriInfo.setTextColor(Color.parseColor("#15803D"));
        } else {
            holder.binding.cardBadgeKategori.setCardBackgroundColor(Color.parseColor("#F3E8FF")); // Ungu Default
            holder.binding.tvKategoriInfo.setTextColor(Color.parseColor("#6B21A8"));
        }
    }

    @Override
    public int getItemCount() {
        return infoList != null ? infoList.size() : 0;
    }

    static class InfoViewHolder extends RecyclerView.ViewHolder {
        final ItemInformasiBinding binding;
        public InfoViewHolder(@NonNull ItemInformasiBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}