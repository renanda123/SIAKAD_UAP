package com.example.siakad_uap.models;

public class Informasi {
    private final String kategori;
    private final String judul;
    private final String isi;
    private final String tanggal;

    public Informasi(String kategori, String judul, String isi, String tanggal) {
        this.kategori = kategori;
        this.judul = judul;
        this.isi = isi;
        this.tanggal = tanggal;
    }

    public String getKategori() { return kategori; }
    public String getJudul() { return judul; }
    public String getIsi() { return isi; }
    public String getTanggal() { return tanggal; }
}