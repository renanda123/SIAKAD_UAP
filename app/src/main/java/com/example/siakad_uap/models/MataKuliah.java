package com.example.siakad_uap.models;

public class MataKuliah {
    private final String nama;
    private final int sks;

    public MataKuliah(String nama, int sks) {
        this.nama = nama;
        this.sks = sks;
    }

    public String getNama() {
        return nama;
    }

    public int getSks() {
        return sks;
    }
}