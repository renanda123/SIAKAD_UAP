package com.example.siakad_uap.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.siakad_uap.R;
import com.example.siakad_uap.models.MenuDashboard;
import com.google.android.material.card.MaterialCardView;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private final List<MenuDashboard> menuList;
    private final OnMenuClickListener listener;

    public interface OnMenuClickListener {
        void onMenuClick(MenuDashboard menu);
    }

    public MenuAdapter(List<MenuDashboard> menuList, OnMenuClickListener listener) {
        this.menuList = menuList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu_dashboard, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        MenuDashboard menu = menuList.get(position);
        holder.tvTitle.setText(menu.getTitle());
        holder.imgIcon.setImageResource(menu.getIconRes());

        // Warnai background card dan icon secara dinamis sesuai menu
        holder.cardMenu.setCardBackgroundColor(Color.parseColor(menu.getBgColor()));
        holder.cardMenu.setStrokeColor(Color.parseColor(menu.getIconColor())); // Outline tipis senada
        holder.imgIcon.setColorFilter(Color.parseColor(menu.getIconColor()));

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onMenuClick(menu);
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    static class MenuViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView cardMenu;
        ImageView imgIcon;
        TextView tvTitle;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            cardMenu = (MaterialCardView) itemView;
            imgIcon = itemView.findViewById(R.id.imgIconMenu);
            tvTitle = itemView.findViewById(R.id.tvTitleMenu);
        }
    }
}