package com.example.siakad_uap.models;

public class AbsensiMatkul {
    private final String namaMatkul;
    private final int hadir;
    private final int izin;
    private final int sakit;

    public AbsensiMatkul(String namaMatkul, int hadir, int izin, int sakit) {
        this.namaMatkul = namaMatkul;
        this.hadir = hadir;
        this.izin = izin;
        this.sakit = sakit;
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public int getHadir() {
        return hadir;
    }

    public int getIzin() {
        return izin;
    }

    public int getSakit() {
        return sakit;
    }
}