<?php
header('Content-Type: application/json');
require 'koneksi.php';

$npm = $_GET['npm'] ?? '';

$query = "SELECT * FROM pembayaran WHERE npm = '$npm' ORDER BY tanggal_bayar DESC";
$result = mysqli_query($koneksi, $query);

$pembayaran = [];
while ($row = mysqli_fetch_assoc($result)) {
    $pembayaran[] = $row;
}

echo json_encode(["status" => "success", "data" => $pembayaran]);
?>
