<?php
header('Content-Type: application/json');
require 'koneksi.php';

$npm = $_GET['npm'] ?? '';

$query = "SELECT krs.id_krs, krs.semester_tempuh, krs.status_persetujuan, 
                 mk.kode_mk, mk.nama_mk, mk.sks 
          FROM krs 
          JOIN mata_kuliah mk ON krs.kode_mk = mk.kode_mk 
          WHERE krs.npm = '$npm'";
$result = mysqli_query($koneksi, $query);

$krs = [];
while ($row = mysqli_fetch_assoc($result)) {
    $krs[] = $row;
}

echo json_encode(["status" => "success", "data" => $krs]);
?>
