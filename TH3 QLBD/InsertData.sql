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

