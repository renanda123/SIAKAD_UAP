package com.example.siakad_uap.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.siakad_uap.databinding.ItemKrsBinding;
import com.example.siakad_uap.models.MataKuliah;
import java.util.List;

public class KrsAdapter extends RecyclerView.Adapter<KrsAdapter.KrsViewHolder> {

    private final List<MataKuliah> krsList;

    public KrsAdapter(List<MataKuliah> krsList) {
        this.krsList = krsList;
    }

    @NonNull
    @Override
    public KrsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Menggunakan View Binding untuk memanggil item_krs.xml secara bersih
        ItemKrsBinding binding = ItemKrsBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new KrsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull KrsViewHolder holder, int position) {
        MataKuliah matkul = krsList.get(position);

        // Mengisi komponen layout sesuai dengan data dari model MataKuliah
        holder.binding.tvNamaMatkul.setText(matkul.getNama());
        holder.binding.tvSks.setText(matkul.getSks() + " SKS");

        // Catatan: Jika model MataKuliah Anda belum memiliki data Kode dan Dosen,
        // kode di bawah ini menggunakan data statis/default agar aplikasi tidak error saat di-run.
        holder.binding.tvKodeMatkul.setText("INF-" + (301 + position));
        holder.binding.tvDosen.setText("Dosen Pengampu Berkompeten");
    }

    @Override
    public int getItemCount() {
        return krsList != null ? krsList.size() : 0;
    }

    static class KrsViewHolder extends RecyclerView.ViewHolder {
        // Menyimpan objek binding agar komponen di dalam item_krs.xml langsung terbaca
        final ItemKrsBinding binding;

        public KrsViewHolder(@NonNull ItemKrsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}