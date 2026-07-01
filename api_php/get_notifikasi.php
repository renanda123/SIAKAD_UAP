<?php
header('Content-Type: application/json');
require 'koneksi.php';

$npm = $_GET['npm'] ?? '';

$query = "SELECT * FROM notifikasi WHERE npm = '$npm' ORDER BY tanggal DESC";
$result = mysqli_query($koneksi, $query);

$notifikasi = [];
while ($row = mysqli_fetch_assoc($result)) {
    $notifikasi[] = $row;
}

echo json_encode(["status" => "success", "data" => $notifikasi]);
?>
