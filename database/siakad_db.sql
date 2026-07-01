-- phpMyAdmin SQL Dump
-- Database: `siakad_uap`

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--
CREATE TABLE `mahasiswa` (
  `npm` varchar(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nama` varchar(150) NOT NULL,
  `program_studi` varchar(100) NOT NULL,
  `semester` int(11) NOT NULL DEFAULT 1,
  `foto_profil` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `mata_kuliah`
--
CREATE TABLE `mata_kuliah` (
  `kode_mk` varchar(20) NOT NULL,
  `nama_mk` varchar(150) NOT NULL,
  `sks` int(11) NOT NULL,
  `semester_mk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `jadwal_kuliah`
--
CREATE TABLE `jadwal_kuliah` (
  `id_jadwal` int(11) NOT NULL,
  `kode_mk` varchar(20) NOT NULL,
  `nama_dosen` varchar(150) NOT NULL,
  `hari` varchar(20) NOT NULL,
  `jam_mulai` time NOT NULL,
  `jam_selesai` time NOT NULL,
  `ruangan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `krs`
--
CREATE TABLE `krs` (
  `id_krs` int(11) NOT NULL,
  `npm` varchar(20) NOT NULL,
  `kode_mk` varchar(20) NOT NULL,
  `semester_tempuh` int(11) NOT NULL,
  `status_persetujuan` enum('Menunggu','Disetujui','Ditolak') NOT NULL DEFAULT 'Menunggu'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `khs`
--
CREATE TABLE `khs` (
  `id_khs` int(11) NOT NULL,
  `npm` varchar(20) NOT NULL,
  `kode_mk` varchar(20) NOT NULL,
  `nilai_angka` float DEFAULT NULL,
  `nilai_huruf` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `absensi`
--
CREATE TABLE `absensi` (
  `id_absensi` int(11) NOT NULL,
  `npm` varchar(20) NOT NULL,
  `id_jadwal` int(11) NOT NULL,
  `pertemuan_ke` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `status_hadir` enum('Hadir','Izin','Sakit','Alpa') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--
CREATE TABLE `pembayaran` (
  `id_pembayaran` int(11) NOT NULL,
  `npm` varchar(20) NOT NULL,
  `jenis_pembayaran` varchar(100) NOT NULL,
  `jumlah_tagihan` decimal(15,2) NOT NULL,
  `status` enum('Belum Lunas','Lunas') NOT NULL DEFAULT 'Belum Lunas',
  `tanggal_bayar` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `informasi`
--
CREATE TABLE `informasi` (
  `id_informasi` int(11) NOT NULL,
  `judul` varchar(255) NOT NULL,
  `isi_informasi` text NOT NULL,
  `tanggal_publish` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `notifikasi`
--
CREATE TABLE `notifikasi` (
  `id_notifikasi` int(11) NOT NULL,
  `npm` varchar(20) NOT NULL,
  `judul` varchar(255) NOT NULL,
  `pesan` text NOT NULL,
  `is_read` tinyint(1) NOT NULL DEFAULT 0,
  `tanggal` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`npm`);

--
-- Indexes for table `mata_kuliah`
--
ALTER TABLE `mata_kuliah`
  ADD PRIMARY KEY (`kode_mk`);

--
-- Indexes for table `jadwal_kuliah`
--
ALTER TABLE `jadwal_kuliah`
  ADD PRIMARY KEY (`id_jadwal`),
  ADD KEY `kode_mk` (`kode_mk`);

--
-- Indexes for table `krs`
--
ALTER TABLE `krs`
  ADD PRIMARY KEY (`id_krs`),
  ADD KEY `npm` (`npm`),
  ADD KEY `kode_mk` (`kode_mk`);

--
-- Indexes for table `khs`
--
ALTER TABLE `khs`
  ADD PRIMARY KEY (`id_khs`),
  ADD KEY `npm` (`npm`),
  ADD KEY `kode_mk` (`kode_mk`);

--
-- Indexes for table `absensi`
--
ALTER TABLE `absensi`
  ADD PRIMARY KEY (`id_absensi`),
  ADD KEY `npm` (`npm`),
  ADD KEY `id_jadwal` (`id_jadwal`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`id_pembayaran`),
  ADD KEY `npm` (`npm`);

--
-- Indexes for table `informasi`
--
ALTER TABLE `informasi`
  ADD PRIMARY KEY (`id_informasi`);

--
-- Indexes for table `notifikasi`
--
ALTER TABLE `notifikasi`
  ADD PRIMARY KEY (`id_notifikasi`),
  ADD KEY `npm` (`npm`);

--
-- AUTO_INCREMENT for dumped tables
--

ALTER TABLE `jadwal_kuliah` MODIFY `id_jadwal` int(11) NOT NULL AUTO_INCREMENT;
ALTER TABLE `krs` MODIFY `id_krs` int(11) NOT NULL AUTO_INCREMENT;
ALTER TABLE `khs` MODIFY `id_khs` int(11) NOT NULL AUTO_INCREMENT;
ALTER TABLE `absensi` MODIFY `id_absensi` int(11) NOT NULL AUTO_INCREMENT;
ALTER TABLE `pembayaran` MODIFY `id_pembayaran` int(11) NOT NULL AUTO_INCREMENT;
ALTER TABLE `informasi` MODIFY `id_informasi` int(11) NOT NULL AUTO_INCREMENT;
ALTER TABLE `notifikasi` MODIFY `id_notifikasi` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

ALTER TABLE `jadwal_kuliah`
  ADD CONSTRAINT `jadwal_kuliah_ibfk_1` FOREIGN KEY (`kode_mk`) REFERENCES `mata_kuliah` (`kode_mk`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `krs`
  ADD CONSTRAINT `krs_ibfk_1` FOREIGN KEY (`npm`) REFERENCES `mahasiswa` (`npm`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `krs_ibfk_2` FOREIGN KEY (`kode_mk`) REFERENCES `mata_kuliah` (`kode_mk`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `khs`
  ADD CONSTRAINT `khs_ibfk_1` FOREIGN KEY (`npm`) REFERENCES `mahasiswa` (`npm`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `khs_ibfk_2` FOREIGN KEY (`kode_mk`) REFERENCES `mata_kuliah` (`kode_mk`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `absensi`
  ADD CONSTRAINT `absensi_ibfk_1` FOREIGN KEY (`npm`) REFERENCES `mahasiswa` (`npm`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `absensi_ibfk_2` FOREIGN KEY (`id_jadwal`) REFERENCES `jadwal_kuliah` (`id_jadwal`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `pembayaran`
  ADD CONSTRAINT `pembayaran_ibfk_1` FOREIGN KEY (`npm`) REFERENCES `mahasiswa` (`npm`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `notifikasi`
  ADD CONSTRAINT `notifikasi_ibfk_1` FOREIGN KEY (`npm`) REFERENCES `mahasiswa` (`npm`) ON DELETE CASCADE ON UPDATE CASCADE;

COMMIT;
