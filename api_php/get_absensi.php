<?php
header('Content-Type: application/json');
require 'koneksi.php';

$npm = $_GET['npm'] ?? '';

$query = "SELECT a.id_absensi, a.pertemuan_ke, a.tanggal, a.status_hadir,
                 j.hari, j.jam_mulai, j.jam_selesai, j.ruangan,
                 mk.nama_mk
          FROM absensi a
          JOIN jadwal_kuliah j ON a.id_jadwal = j.id_jadwal
          JOIN mata_kuliah mk ON j.kode_mk = mk.kode_mk
          WHERE a.npm = '$npm'
          ORDER BY a.tanggal DESC";
$result = mysqli_query($koneksi, $query);

$absensi = [];
while ($row = mysqli_fetch_assoc($result)) {
    $absensi[] = $row;
}

echo json_encode(["status" => "success", "data" => $absensi]);
?>
