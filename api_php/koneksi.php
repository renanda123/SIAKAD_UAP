<?php
$host = "localhost";
$user = "root";
$pass = "";
$db   = "siakad_uap";

$koneksi = mysqli_connect($host, $user, $pass, $db);
if (!$koneksi) {
    die(json_encode(["status" => "error", "message" => "Gagal terhubung ke database"]));
}
?>
