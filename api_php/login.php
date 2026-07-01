<?php
header('Content-Type: application/json');
require 'koneksi.php';

$npm = $_POST['npm'] ?? '';
$password = $_POST['password'] ?? '';

if (empty($npm) || empty($password)) {
    echo json_encode(["status" => "error", "message" => "NPM dan password harus diisi"]);
    exit;
}

$query = "SELECT * FROM mahasiswa WHERE npm = '$npm' AND password = '$password'";
$result = mysqli_query($koneksi, $query);

if (mysqli_num_rows($result) > 0) {
    $data = mysqli_fetch_assoc($result);
    echo json_encode(["status" => "success", "message" => "Login berhasil", "data" => $data]);
} else {
    echo json_encode(["status" => "error", "message" => "NPM atau password salah"]);
}
?>
