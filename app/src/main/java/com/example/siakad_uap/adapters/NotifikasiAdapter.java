package com.example.siakad_uap.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.siakad_uap.databinding.ItemNotifikasiBinding;
import com.example.siakad_uap.models.Notifikasi;
import java.util.List;

public class NotifikasiAdapter extends RecyclerView.Adapter<NotifikasiAdapter.NotifikasiViewHolder> {

    private final List<Notifikasi> listNotif;

    public NotifikasiAdapter(List<Notifikasi> listNotif) {
        this.listNotif = listNotif;
    }

    @NonNull
    @Override
    public NotifikasiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNotifikasiBinding binding = ItemNotifikasiBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new NotifikasiViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NotifikasiViewHolder holder, int position) {
        Notifikasi item = listNotif.get(position);

        holder.binding.tvJudulNotif.setText(item.getJudul());
        holder.binding.tvIsiNotif.setText(item.getIsi());
        holder.binding.tvWaktuNotif.setText(item.getWaktu());

        // 1. Atur visibilitas Unread Dot Indicator (Sudah Aman Tanpa AppGlobals)
        if (item.isRead()) {
            holder.binding.viewUnreadDot.setVisibility(View.GONE);
        } else {
            holder.binding.viewUnreadDot.setVisibility(View.VISIBLE);
        }

        // 2. Pewarnaan Kapsul Ikon Secara Dinamis berdasarkan Tipe Parameter
        String tipe = item.getTipe().toLowerCase();
        if (tipe.equals("akademik")) {
            holder.binding.cardIconNotif.setCardBackgroundColor(Color.parseColor("#DCFCE7")); // Hijau Pastel
            holder.binding.ivIconNotif.setColorFilter(Color.parseColor("#15803D"));
        } else if (tipe.equals("keuangan")) {
            holder.binding.cardIconNotif.setCardBackgroundColor(Color.parseColor("#FEE2E2")); // Merah Pastel
            holder.binding.ivIconNotif.setColorFilter(Color.parseColor("#B91C1C"));
        } else {
            holder.binding.cardIconNotif.setCardBackgroundColor(Color.parseColor("#E0F2FE")); // Biru Pastel
            holder.binding.ivIconNotif.setColorFilter(Color.parseColor("#0284C7"));
        }
    }

    @Override
    public int getItemCount() {
        return listNotif != null ? listNotif.size() : 0;
    }

    static class NotifikasiViewHolder extends RecyclerView.ViewHolder {
        final ItemNotifikasiBinding binding;
        public NotifikasiViewHolder(@NonNull ItemNotifikasiBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}