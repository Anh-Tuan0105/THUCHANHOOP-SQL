-- Cau 1:
INSERT INTO SINHVIEN ([MSSV], [HOTEN], [NTNS], [PHAI], [MALOP]) 
VALUES ('190001', 'Dao Thi Tuyet Hoa', CONVERT(DATE, '08/03/2001', 103), 0, '19DTH02');
-- Cau 2:
UPDATE [dbo].[MONHOC]
SET [TENMH] = 'Toan roi rac'
WHERE [TENMH] = 'Ly thuyet do thi'
-- Cau 3:
SELECT [TENMH]
FROM [dbo].[MONHOC]
WHERE [TCTH] = 0;
-- Cau 4:
SELECT [TENMH]
FROM [dbo].[MONHOC]
WHERE [TCTH] > 0 AND [TCLT] > 0;
-- Cau 5:
SELECT [TENMH]
FROM [dbo].[MONHOC]
WHERE [TENMH] LIKE 'C%';
-- Cau 6:
SELECT *
FROM [dbo].[SINHVIEN]
WHERE [HOTEN] LIKE '%Thi%'
-- Cau 7:
SELECT TOP 2 *
FROM [dbo].[LOP]
ORDER BY [SISO] DESC
-- Cau 8:
SELECT L.MALOP, S.MSSV, S.HOTEN, S.NTNS, S.PHAI
FROM [dbo].[SINHVIEN] AS S
JOIN LOP AS L ON L.MALOP = S.MALOP

--fix 8
SELECT MSSV, HoTen, YEAR(NTNS) AS NamSinh,
	CASE WHEN PHAI = 1 THEN 'Nam' ELSE 'Nu' END AS GT, MaLop
FROM SINHVIEN
ORDER BY MaLop ASC;

-- Cau 9:
SELECT *
FROM [dbo].[SINHVIEN]
WHERE DATEDIFF(YEAR, [NTNS], GETDATE()) >= 20;
-- Cau 10:
SELECT M.TENMH
FROM [dbo].[MONHOC] AS M
JOIN [dbo].[DIEMSV] AS D ON M.MAMH = D.MAMH
WHERE D.DIEM IS NULL
-- Cau 11:
SELECT TOP 1 S.MSSV, S.HOTEN, M.TENMH, D.DIEM
FROM [dbo].[SINHVIEN] AS S
JOIN [dbo].[DIEMSV] AS D ON D.MSSV = S.MSSV
JOIN [dbo].[MONHOC] AS M ON M.MAMH = D.MAMH
WHERE S.MSSV = '170001';
-- Cau 12:
SELECT S.HOTEN, D.MAMH
FROM [dbo].[SINHVIEN] AS S
JOIN [dbo].[DIEMSV] AS D ON D.MSSV = S.MSSV
WHERE D.DIEM > 7
-- Cau 13:
SELECT M.TENMH, COUNT(S.MSSV) AS SoLuongSinhVien
FROM [dbo].[SINHVIEN] AS S
JOIN [dbo].[DIEMSV] AS D ON D.MSSV = S.MSSV
JOIN [dbo].[MONHOC] AS M ON M.MAMH = D.MAMH
WHERE D.DIEM IS NOT NULL
GROUP BY M.TENMH
-- Cau 14:
SELECT S.HOTEN, AVG(D.DIEM) AS DiemTrungBinh
FROM [dbo].[SINHVIEN] AS S
JOIN [dbo].[DIEMSV] AS D ON D.MSSV = S.MSSV
GROUP BY S.HOTEN
-- Cau 15:
SELECT S.HOTEN
FROM [dbo].[SINHVIEN] AS S
JOIN [dbo].[DIEMSV] AS D ON D.MSSV = S.MSSV
JOIN [dbo].[MONHOC] AS M ON M.MAMH = D.MAMH
WHERE M.TENMH = 'Ky thuat lap trinh'
AND D.DIEM = (
	SELECT MAX(DIEM)
	FROM [dbo].[DIEMSV]
	WHERE MAMH = (
		SELECT [MAMH]
		FROM [dbo].[MONHOC]
		WHERE TENMH = 'Ky thuat lap trinh'
	)
);

--CAU 16
SELECT S.MSSV, S.HOTEN, AVG(D.DIEM) AS DIEMTB
FROM DIEMSV D
JOIN SINHVIEN S ON D.MSSV = S.MSSV
GROUP BY S.MSSV, S.HOTEN
HAVING AVG(D.DIEM) = (
	SELECT MAX(DIEM_TB)
	FROM (
		SELECT AVG(DIEM) AS DIEM_TB
		FROM DIEMSV
		GROUP BY MSSV
		) AS TMP);

--CAU17
SELECT *
FROM SINHVIEN S
WHERE S.MSSV NOT IN (
	SELECT S.MSSV
	FROM MONHOC M
	JOIN DIEMSV D ON D.MaMH = M.MaMH
	JOIN SINHVIEN S ON D.MSSV = S.MSSV
	WHERE M.TenMH = 'Toan Roi Rac'
	)

--CAU18
SELECT S2.*
FROM SINHVIEN S1
JOIN SINHVIEN S2 ON Year(S1.NTNS) = Year(S2.NTNS)
WHERE S1.HoTen LIKE '%Danh%' AND S1.MSSV <> S2.MSSV;

--CAU19
SELECT COUNT(*) AS TongSoSinhVien,
       (SELECT COUNT(*) FROM SINHVIEN WHERE Phai = 0) AS TongSoSinhVienNu
FROM SINHVIEN;

--CAU20
SELECT DISTINCT *
FROM SINHVIEN S
JOIN DIEMSV D ON D.MSSV = S.MSSV
WHERE D.DIEM <= 4;

--CAU 21
SELECT S.MSSV, S.HOTEN
FROM DIEMSV D
JOIN SINHVIEN S ON S.MSSV = D.MSSV
WHERE D.Diem IS NOT NULL
GROUP BY S.MSSV, S.HoTen
HAVING COUNT(D.MAMH) >= 3;

--CAU22
SELECT  L.TENLOP, S.MSSV, S.HOTEN, M.TENMH, D.DIEM
FROM [dbo].[SINHVIEN] AS S
JOIN [dbo].[DIEMSV] AS D ON S.MSSV = D.MSSV
JOIN [dbo].[LOP] AS L ON S.MALOP = L.MALOP
JOIN [dbo].[MONHOC] AS M ON D.MAMH = M.MAMH
WHERE M.TENMH = 'Ky thuat Lap Trinh'
AND D.DIEM = (
    SELECT MAX(DIEM)
    FROM [dbo].[DIEMSV]
    WHERE MAMH = (SELECT MAMH FROM [dbo].[MONHOC] WHERE TENMH = 'Ky thuat Lap Trinh')
    AND MSSV = S.MSSV
)
ORDER BY L.TENLOP, D.DIEM DESC;

--CAU23
SELECT SV.MSSV, SV.HoTen, D.MaMH, SV.MaLop, D.Diem
FROM DIEMSV D
JOIN SINHVIEN SV ON D.MSSV = SV.MSSV
JOIN (
    SELECT D.MaMH, S.MaLop, MAX(Diem) AS MaxDiem
    FROM DIEMSV D
    JOIN SINHVIEN S ON D.MSSV = S.MSSV
    GROUP BY MaMH, S.MaLop
) AS MaxD ON D.MaMH = MaxD.MaMH 
        AND SV.MaLop = MaxD.MaLop 
        AND D.Diem = MaxD.MaxDiem;

--CAU24
SELECT SV.MSSV, SV.HoTen, D.MaMH, D.Diem
FROM DIEMSV D
JOIN SINHVIEN SV ON D.MSSV = SV.MSSV
JOIN (
    SELECT MaMH, MAX(Diem) AS MaxDiem
    FROM DIEMSV
    GROUP BY MaMH
) AS MaxD ON D.MaMH = MaxD.MaMH 
        AND D.Diem = MaxD.MaxDiem;

--CAU25
SELECT S.MSSV, S.HoTen
FROM SINHVIEN S
WHERE NOT EXISTS (
    SELECT 1 FROM DIEMSV D WHERE D.MSSV = S.MSSV
);

--CAU26
SELECT S.MSSV, S.HoTen
FROM SINHVIEN S
WHERE EXISTS (
    SELECT 1 FROM DIEMSV D WHERE D.MSSV = S.MSSV AND D.Diem = 10
);

--CAU27
SELECT S.MaLop, 
       COUNT(CASE WHEN S.Phai = 1 THEN 1 ELSE NULL END) AS SoNam,
       COUNT(CASE WHEN S.Phai = 0 THEN 1 ELSE NULL END) AS SoNu
FROM SINHVIEN S
GROUP BY S.MaLop;

--CAU28
SELECT S.MSSV, S.HoTen
FROM SINHVIEN S
WHERE EXISTS (
    SELECT 1 FROM DIEMSV D WHERE D.MSSV = S.MSSV AND D.Diem >= 5
)
AND (SELECT COUNT(D.MaMH) FROM DIEMSV D WHERE D.MSSV = S.MSSV) = 
    (SELECT COUNT(MaMH) FROM MONHOC);

--CAU29
DELETE FROM SINHVIEN
WHERE MSSV NOT IN (SELECT DISTINCT MSSV FROM DIEMSV);

--CAU30
SELECT M.MaMH, M.TenMH
FROM MONHOC M
WHERE NOT EXISTS (
    SELECT 1 FROM SINHVIEN S WHERE S.MSSV NOT IN 
        (SELECT D.MSSV FROM DIEMSV D WHERE D.MaMH = M.MaMH)
);
