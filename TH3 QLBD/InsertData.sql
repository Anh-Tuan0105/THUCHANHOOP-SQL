INSERT INTO DOI(MADOI, TENDOI) VALUES
('VN', 'Viet Nam'),
('LA', 'Lao'),
('TL', 'Thai Lan'),
('CPC', 'Campuchia')

INSERT INTO TRANDAU(MATD, MASAN, NGAY, GIO) VALUES
('01', 'MOD', CONVERT(DATE, '14/08/2017', 103), CAST('15:00' AS TIME)),
('02', 'NAS', CONVERT(DATE, '16/08/2017', 103), CAST('17:00' AS TIME)),
('03', 'MOD', CONVERT(DATE, '16/08/2017', 103), CAST('15:00' AS TIME)),
('04', 'IMO', CONVERT(DATE, '18/08/2017', 103), CAST('19:00' AS TIME))

ALTER TABLE TRANDAU ALTER COLUMN GIO TIME(0);

INSERT INTO CT_TRANDAU(MATD, MADOI, SOBANTHANG) VALUES
('01', 'VN' , 3),
('01', 'TL' , 1),
('02', 'VN' , 5),
('02', 'LA' , 0),
('03', 'TL' , 3),
('03', 'CPC' ,3),
('04', 'TL' , 2),
('04', 'LA' , 0)


--CAU1
SELECT D.MADOI, D.TENDOI, COUNT(MATD) AS SoTD
FROM CT_TRANDAU C
JOIN DOI D ON D.MADOI = C.MADOI
GROUP BY D.MADOI, D.TENDOI

--CAU2,3
SELECT  DISTINCT T1.MaTD, 
       CONCAT(T1.MaDoi, '-', T2.MaDoi) AS DoiTranDau,
       CONCAT(T1.SoBanThang, '-', T2.SoBanThang) AS TySo
FROM CT_TranDau T1
JOIN CT_TranDau T2 ON T1.MaTD = T2.MaTD AND T1.MaDoi <> T2.MaDoi
WHERE T1.MaDoi < T2.MaDoi --TRANH LAY TRUNG
GROUP BY T1.MaTD, T1.MaDoi, T1.SoBanThang, T2.MaDoi, T2.SoBanThang;


--CAU4
SELECT MaTD, MaDoi, 
       CASE 
           WHEN SoBanThang = (SELECT MAX(SoBanThang) FROM CT_TranDau WHERE MaTD = CT.MaTD) THEN 3
           WHEN SoBanThang = (SELECT MIN(SoBanThang) FROM CT_TranDau WHERE MaTD = CT.MaTD) THEN 0
           ELSE 1
       END AS Diem
FROM CT_TranDau CT;

--CAU5
WITH DiemTranDau AS (
    SELECT CT.MaTD, CT.MaDoi,
           CASE 
               WHEN CT.SoBanThang = MAX_CT.MaxBanThang THEN 3  -- Đội thắng
               WHEN CT.SoBanThang = MIN_CT.MinBanThang THEN 0  -- Đội thua
               ELSE 1  -- Trường hợp hòa
           END AS Diem
    FROM CT_TranDau CT
    JOIN (SELECT MaTD, MAX(SoBanThang) AS MaxBanThang FROM CT_TranDau GROUP BY MaTD) AS MAX_CT 
         ON CT.MaTD = MAX_CT.MaTD
    JOIN (SELECT MaTD, MIN(SoBanThang) AS MinBanThang FROM CT_TranDau GROUP BY MaTD) AS MIN_CT 
         ON CT.MaTD = MIN_CT.MaTD
)
SELECT D.MaDoi, D.TenDoi, SUM(Diem) AS TongDiem
FROM Doi D
JOIN DiemTranDau DT ON D.MaDoi = DT.MaDoi
GROUP BY D.MaDoi, D.TenDoi;

--CAU6
SELECT D.MaDoi, D.TenDoi, 
       SUM(
           CASE 
               WHEN CT.SoBanThang = MaxMin_CT.MaxBanThang THEN 3  -- Thắng
               WHEN CT.SoBanThang = MaxMin_CT.MinBanThang THEN 0  -- Thua
               ELSE 1  -- Hòa
           END
       ) AS TongDiem,
       SUM(CT.SoBanThang) - SUM(Opp.SoBanThang) AS HieuSoBanThang
FROM Doi D
JOIN CT_TranDau CT ON D.MaDoi = CT.MaDoi
JOIN (SELECT MaTD, MAX(SoBanThang) AS MaxBanThang, MIN(SoBanThang) AS MinBanThang 
      FROM CT_TranDau GROUP BY MaTD) AS MaxMin_CT ON CT.MaTD = MaxMin_CT.MaTD
JOIN CT_TranDau Opp ON CT.MaTD = Opp.MaTD AND CT.MaDoi <> Opp.MaDoi
GROUP BY D.MaDoi, D.TenDoi
ORDER BY TongDiem DESC, HieuSoBanThang DESC;

--CAU7
SELECT D1.MaDoi AS Doi1, D2.MaDoi AS Doi2
FROM Doi D1, Doi D2
WHERE D1.MaDoi < D2.MaDoi
AND NOT EXISTS (
    SELECT 1 FROM CT_TranDau CT1
    JOIN CT_TranDau CT2 ON CT1.MaTD = CT2.MaTD
    WHERE CT1.MaDoi = D1.MaDoi AND CT2.MaDoi = D2.MaDoi
);
