package com.example.siakad_uap.models;

public class NilaiMatkul {
    private final String namaMatkul;
    private final String nilai;

    public NilaiMatkul(String namaMatkul, String nilai) {
        this.namaMatkul = namaMatkul;
        this.nilai = nilai;
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public String getNilai() {
        return nilai;
    }
}