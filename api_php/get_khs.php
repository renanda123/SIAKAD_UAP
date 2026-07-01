<?php
header('Content-Type: application/json');
require 'koneksi.php';

$npm = $_GET['npm'] ?? '';

$query = "SELECT khs.id_khs, khs.nilai_angka, khs.nilai_huruf, 
                 mk.kode_mk, mk.nama_mk, mk.sks 
          FROM khs 
          JOIN mata_kuliah mk ON khs.kode_mk = mk.kode_mk 
          WHERE khs.npm = '$npm'";
$result = mysqli_query($koneksi, $query);

$khs = [];
while ($row = mysqli_fetch_assoc($result)) {
    $khs[] = $row;
}

echo json_encode(["status" => "success", "data" => $khs]);
?>
