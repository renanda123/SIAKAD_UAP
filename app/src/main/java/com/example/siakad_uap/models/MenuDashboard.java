package com.example.siakad_uap.models;

public class MenuDashboard {
    private final String title;
    private final int iconRes;
    private final String bgColor;   // Warna background card (Hex)
    private final String iconColor; // Warna icon (Hex)

    public MenuDashboard(String title, int iconRes, String bgColor, String iconColor) {
        this.title = title;
        this.iconRes = iconRes;
        this.bgColor = bgColor;
        this.iconColor = iconColor;
    }

    public String getTitle() { return title; }
    public int getIconRes() { return iconRes; }
    public String getBgColor() { return bgColor; }
    public String getIconColor() { return iconColor; }
}