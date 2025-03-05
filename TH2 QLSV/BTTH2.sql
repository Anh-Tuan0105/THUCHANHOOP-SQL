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
