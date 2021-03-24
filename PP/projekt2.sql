-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 24 Mar 2021, 22:54
-- Wersja serwera: 10.4.6-MariaDB
-- Wersja PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `projekt2`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pogoda`
--

CREATE TABLE `pogoda` (
  `id_Pogody` int(11) NOT NULL,
  `Miasto` varchar(60) NOT NULL,
  `Temperatura` varchar(10) NOT NULL,
  `Data` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `pogoda`
--

INSERT INTO `pogoda` (`id_Pogody`, `Miasto`, `Temperatura`, `Data`) VALUES
(35, 'Białystok', '7°C', '2021-03-24'),
(36, 'Bydgoszcz', '7°C', '2021-03-24'),
(37, 'Kraków', '7°C', '2021-03-24'),
(38, 'Gdańsk', '8°C', '2021-03-24'),
(39, 'Katowice', '7°C', '2021-03-24'),
(40, 'Kielce', '6°C', '2021-03-24'),
(41, 'Łódź', '9°C', '2021-03-24'),
(42, 'Lublin', '9°C', '2021-03-24'),
(43, 'Olsztyn', '7°C', '2021-03-24'),
(44, 'Opole', '8°C', '2021-03-24'),
(45, 'Poznań', '8°C', '2021-03-24'),
(46, 'Rzeszów', '9°C', '2021-03-24'),
(47, 'Szczecin', '10°C', '2021-03-24'),
(48, 'Warszawa', '8°C', '2021-03-24'),
(49, 'Wrocław', '8°C', '2021-03-24'),
(50, 'Zielona Góra', '9°C', '2021-03-24');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `uzytkownicy`
--

CREATE TABLE `uzytkownicy` (
  `id_user` int(11) NOT NULL,
  `login` varchar(20) NOT NULL,
  `pass` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `uzytkownicy`
--

INSERT INTO `uzytkownicy` (`id_user`, `login`, `pass`) VALUES
(1, 'Janusz', '123');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `pogoda`
--
ALTER TABLE `pogoda`
  ADD PRIMARY KEY (`id_Pogody`);

--
-- Indeksy dla tabeli `uzytkownicy`
--
ALTER TABLE `uzytkownicy`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `pogoda`
--
ALTER TABLE `pogoda`
  MODIFY `id_Pogody` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT dla tabeli `uzytkownicy`
--
ALTER TABLE `uzytkownicy`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
