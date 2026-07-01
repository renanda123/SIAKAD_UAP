package com.example.siakad_uap.models;

public class JadwalKuliah {
    private final String hari;
    private final String jamMulai;
    private final String jamSelesai;
    private final String namaMatkul;
    private final String ruangan;
    private final int sks;

    public JadwalKuliah(String hari, String jamMulai, String jamSelesai, String namaMatkul, String ruangan, int sks) {
        this.hari = hari;
        this.jamMulai = jamMulai;
        this.jamSelesai = jamSelesai;
        this.namaMatkul = namaMatkul;
        this.ruangan = ruangan;
        this.sks = sks;
    }

    public String getHari() { return hari; }
    public String getJamMulai() { return jamMulai; }
    public String getJamSelesai() { return jamSelesai; }
    public String getNamaMatkul() { return namaMatkul; }
    public String getRuangan() { return ruangan; }
    public int getSks() { return sks; }
}