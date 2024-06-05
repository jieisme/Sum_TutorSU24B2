CREATE DATABASE BUOI3_SOF2041
GO
USE BUOI3_SOF2041
GO
CREATE TABLE SinhVien(
	Ma NVARCHAR(10) PRIMARY KEY,
	Ten NVARCHAR(200) NOT NULL,
	GioiTinh BIT NOT NULL, -- Với 0 là Nam và 1 là Nữ
	NamSinh INT NOT NULL
)
GO
INSERT INTO SinhVien (Ma, Ten, GioiTinh, NamSinh)
VALUES  ('PH39309', N'Vũ Tuấn Kiệt', 0, 2004),
		('PH12345', N'Phùng Thanh Độ', 0, 1989),
		('PH56789', N'Phùng Khoa Học', 1, 2003),
		('PH54321', N'Trần Thái Linh', 0, 2005),
		('PH98765', N'Thầy Onip', 1, 2024)
GO
SELECT * FROM SinhVien