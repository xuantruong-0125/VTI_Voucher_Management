-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:3306
-- Thời gian đã tạo: Th5 08, 2026 lúc 01:48 PM
-- Phiên bản máy phục vụ: 8.4.7
-- Phiên bản PHP: 8.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `voucher_management`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `full_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `full_name`, `email`, `phone`, `created_at`) VALUES
(1, 'Nguyen Van An', 'an.nguyen@gmail.com', '0901234567', '2026-05-08 14:19:26'),
(2, 'Tran Thi Bich', 'bich.tran@gmail.com', '0912345678', '2026-05-08 14:19:26'),
(3, 'Le Hoang Nam', 'nam.le@gmail.com', '0923456789', '2026-05-08 14:19:26'),
(4, 'Pham Thu Ha', 'ha.pham@gmail.com', '0934567890', '2026-05-08 14:19:26'),
(5, 'Vo Minh Quan', 'quan.vo@gmail.com', '0945678901', '2026-05-08 14:19:26'),
(6, 'Dang Gia Bao', 'bao.dang@gmail.com', '0956789012', '2026-05-08 14:19:26'),
(7, 'Huynh Ngoc Linh', 'linh.huynh@gmail.com', '0967890123', '2026-05-08 14:19:26'),
(8, 'Do Tuan Kiet', 'kiet.do@gmail.com', '0978901234', '2026-05-08 14:19:26'),
(9, 'Bui Thanh Tung', 'tung.bui@gmail.com', '0989012345', '2026-05-08 14:19:26'),
(10, 'Phan My Uyen', 'uyen.phan@gmail.com', '0990123456', '2026-05-08 14:19:26'),
(11, 'Nguyen Van A', 'nguyenvana@gmail.com', '0123456789', '2026-05-08 15:53:50'),
(12, 'fhd dfgdfg', 'giamoc125@gmail.com', '12323243545', '2026-05-08 19:40:27');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `vouchers`
--

DROP TABLE IF EXISTS `vouchers`;
CREATE TABLE IF NOT EXISTS `vouchers` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `discount_percent` int NOT NULL,
  `quantity` int NOT NULL,
  `expired_date` date NOT NULL,
  `status` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ;

--
-- Đang đổ dữ liệu cho bảng `vouchers`
--

INSERT INTO `vouchers` (`id`, `code`, `discount_percent`, `quantity`, `expired_date`, `status`, `created_at`) VALUES
(1, 'SALE70', 70, 899, '2026-05-09', 'ACTIVE', '2026-05-08 14:19:41'),
(2, 'SUMMER20', 20, 0, '2026-08-30', 'ACTIVE', '2026-05-08 14:19:41'),
(3, 'FLASH15', 15, 30, '2026-06-15', 'ACTIVE', '2026-05-08 14:19:41'),
(4, 'VIP30', 30, 20, '2026-11-20', 'ACTIVE', '2026-05-08 14:19:41'),
(5, 'NEWUSER5', 5, 200, '2027-01-01', 'ACTIVE', '2026-05-08 14:19:41'),
(6, 'SALE25', 25, 40, '2026-09-10', 'INACTIVE', '2026-05-08 14:19:41'),
(7, 'BLACKFRIDAY', 50, 10, '2026-11-29', 'ACTIVE', '2026-05-08 14:19:41'),
(8, 'FREESHIP', 8, 150, '2026-10-01', 'ACTIVE', '2026-05-08 14:19:41');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `voucher_usages`
--

DROP TABLE IF EXISTS `voucher_usages`;
CREATE TABLE IF NOT EXISTS `voucher_usages` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `voucher_id` bigint NOT NULL,
  `used_at` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_voucher_usage_user` (`user_id`),
  KEY `fk_voucher_usage_voucher` (`voucher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `voucher_usages`
--

INSERT INTO `voucher_usages` (`id`, `user_id`, `voucher_id`, `used_at`) VALUES
(1, 1, 1, '2026-05-08 14:19:57'),
(2, 2, 2, '2026-05-08 14:19:57'),
(3, 3, 3, '2026-05-08 14:19:57'),
(4, 4, 4, '2026-05-08 14:19:57'),
(5, 5, 5, '2026-05-08 14:19:57'),
(6, 6, 1, '2026-05-08 14:19:57'),
(7, 7, 2, '2026-05-08 14:19:57'),
(8, 8, 7, '2026-05-08 14:19:57'),
(9, 9, 8, '2026-05-08 14:19:57'),
(11, 1, 2, '2026-05-08 16:12:22'),
(12, 1, 1, '2026-05-08 16:22:00'),
(13, 1, 1, '2026-05-08 19:57:33');

--
-- Ràng buộc đối với các bảng kết xuất
--

--
-- Ràng buộc cho bảng `voucher_usages`
--
ALTER TABLE `voucher_usages`
  ADD CONSTRAINT `fk_voucher_usage_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_voucher_usage_voucher` FOREIGN KEY (`voucher_id`) REFERENCES `vouchers` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
