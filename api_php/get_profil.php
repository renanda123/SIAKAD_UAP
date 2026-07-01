<?php
header('Content-Type: application/json');
require 'koneksi.php';

$npm = $_GET['npm'] ?? '';

if (empty($npm)) {
    echo json_encode(["status" => "error", "message" => "NPM harus diisi"]);
    exit;
}

$query = "SELECT npm, nama, program_studi, semester, foto_profil FROM mahasiswa WHERE npm = '$npm'";
$result = mysqli_query($koneksi, $query);

if (mysqli_num_rows($result) > 0) {
    $data = mysqli_fetch_assoc($result);
    echo json_encode(["status" => "success", "data" => $data]);
} else {
    echo json_encode(["status" => "error", "message" => "Mahasiswa tidak ditemukan"]);
}
?>
