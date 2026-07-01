package com.example.siakad_uap.models;

public class Pembayaran {
    private final String namaTagihan;
    private final String nominalText;
    private final String status;

    public Pembayaran(String namaTagihan, String nominalText, String status) {
        this.namaTagihan = namaTagihan;
        this.nominalText = nominalText;
        this.status = status;
    }

    public String getNamaTagihan() {
        return namaTagihan;
    }

    public String getNominalText() {
        return nominalText;
    }

    public String getStatus() {
        return status;
    }
}