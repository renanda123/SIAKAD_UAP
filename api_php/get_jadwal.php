<?php
header('Content-Type: application/json');
require 'koneksi.php';

$query = "SELECT j.id_jadwal, j.hari, j.jam_mulai, j.jam_selesai, j.ruangan, j.nama_dosen,
                 mk.kode_mk, mk.nama_mk, mk.sks
          FROM jadwal_kuliah j
          JOIN mata_kuliah mk ON j.kode_mk = mk.kode_mk
          ORDER BY FIELD(j.hari, 'Senin', 'Selasa', 'Rabu', 'Kamis', 'Jumat', 'Sabtu', 'Minggu'), j.jam_mulai";

$result = mysqli_query($koneksi, $query);

$jadwal = [];
while ($row = mysqli_fetch_assoc($result)) {
    $jadwal[] = $row;
}

echo json_encode(["status" => "success", "data" => $jadwal]);
?>
