package com.example.siakad_uap.models;

public class Notifikasi {
    private final String judul;
    private final String isi;
    private final String waktu;
    private final String tipe; // "akademik", "keuangan", "info"
    private final boolean isRead;

    public Notifikasi(String judul, String isi, String waktu, String tipe, boolean isRead) {
        this.judul = judul;
        this.isi = isi;
        this.waktu = waktu;
        this.tipe = tipe;
        this.isRead = isRead;
    }

    public String getJudul() { return judul; }
    public String getIsi() { return isi; }
    public String getWaktu() { return waktu; }
    public String getTipe() { return tipe; }
    public boolean isRead() { return isRead; }
}