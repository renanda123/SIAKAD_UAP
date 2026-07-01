package com.example.siakad_uap.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.siakad_uap.databinding.ItemPembayaranBinding;
import com.example.siakad_uap.models.Pembayaran; // Pastikan nama kelas model Anda sesuai
import java.util.List;

public class PembayaranAdapter extends RecyclerView.Adapter<PembayaranAdapter.PembayaranViewHolder> {

    private final List<Pembayaran> pembayaranList;

    public PembayaranAdapter(List<Pembayaran> pembayaranList) {
        this.pembayaranList = pembayaranList;
    }

    @NonNull
    @Override
    public PembayaranViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPembayaranBinding binding = ItemPembayaranBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new PembayaranViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PembayaranViewHolder holder, int position) {
        Pembayaran item = pembayaranList.get(position);

        holder.binding.tvNamaTagihan.setText(item.getNamaTagihan());
        holder.binding.tvNominalTagihan.setText(item.getNominalText());
        holder.binding.tvStatusPembayaran.setText(item.getStatus());

        // Pengaturan Warna Lencana Kapsul secara Dinamis
        if (item.getStatus().equalsIgnoreCase("Lunas")) {
            holder.binding.cardBadgeStatus.setCardBackgroundColor(Color.parseColor("#DCFCE7"));
            holder.binding.tvStatusPembayaran.setTextColor(Color.parseColor("#15803D"));
        } else {
            holder.binding.cardBadgeStatus.setCardBackgroundColor(Color.parseColor("#FCE8E6"));
            holder.binding.tvStatusPembayaran.setTextColor(Color.parseColor("#C5221F"));
        }
    }

    @Override
    public int getItemCount() {
        return pembayaranList != null ? pembayaranList.size() : 0;
    }

    static class PembayaranViewHolder extends RecyclerView.ViewHolder {
        final ItemPembayaranBinding binding;

        public PembayaranViewHolder(@NonNull ItemPembayaranBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}