<?php
header('Content-Type: application/json');
require 'koneksi.php';

$query = "SELECT * FROM informasi ORDER BY tanggal_publish DESC";
$result = mysqli_query($koneksi, $query);

$informasi = [];
while ($row = mysqli_fetch_assoc($result)) {
    $informasi[] = $row;
}

echo json_encode(["status" => "success", "data" => $informasi]);
?>
