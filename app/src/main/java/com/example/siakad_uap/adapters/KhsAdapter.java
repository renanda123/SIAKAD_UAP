package com.example.siakad_uap.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.siakad_uap.databinding.ItemNilaiKhsBinding;
import com.example.siakad_uap.models.NilaiMatkul;
import java.util.List;

public class KhsAdapter extends RecyclerView.Adapter<KhsAdapter.KhsViewHolder> {

    private final List<NilaiMatkul> khsList;

    public KhsAdapter(List<NilaiMatkul> khsList) {
        this.khsList = khsList;
    }

    @NonNull
    @Override
    public KhsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNilaiKhsBinding binding = ItemNilaiKhsBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new KhsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull KhsViewHolder holder, int position) {
        NilaiMatkul item = khsList.get(position);

        holder.binding.tvNamaMatkulKhs.setText(item.getNamaMatkul());
        holder.binding.tvHurufNilai.setText(item.getNilai());
        holder.binding.tvSksKhs.setText("Bobot Kuliah Terpenuhi");

        // Pewarnaan dinamis: Hijau jika nilai bagus (A/B), Biru jika selain itu
        if (item.getNilai().startsWith("A") || item.getNilai().startsWith("B")) {
            holder.binding.cardBadgeNilai.setCardBackgroundColor(Color.parseColor("#E6F4EA"));
            holder.binding.tvHurufNilai.setTextColor(Color.parseColor("#137333"));
        } else {
            holder.binding.cardBadgeNilai.setCardBackgroundColor(Color.parseColor("#FCE8E6"));
            holder.binding.tvHurufNilai.setTextColor(Color.parseColor("#C5221F"));
        }
    }

    @Override
    public int getItemCount() {
        return khsList != null ? khsList.size() : 0;
    }

    static class KhsViewHolder extends RecyclerView.ViewHolder {
        final ItemNilaiKhsBinding binding;

        public KhsViewHolder(@NonNull ItemNilaiKhsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}