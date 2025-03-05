INSERT INTO LOP([MALOP], [TENLOP], [SISO]) VALUES
('18DTH01', 'CNTT Khoa 18, Lop 1', 50),
('18DTH02', 'CNTT Khoa 18, Lop 2', 45),
('19DTH01', 'CNTT Khoa 19, Lop 1', 55),
('19DTH02', 'CNTT Khoa 19, Lop 2', 50),
('19DTH03', 'CNTT Khoa 19, Lop 3', 40)

INSERT INTO MONHOC([MAMH], [TENMH], [TCLT], [TCTH]) VALUES
('COS201', 'Ky thuat lap trinh', 2, 1),
('COS202', 'Ly thuyet do thi', 2, 1),
('COS203', 'CSDL va quan tri CSDL', 3, 0),
('COS204', 'Phan tich thiet ke he thong', 3, 0),
('COS205', 'CSDL phan tan', 3, 0)

INSERT INTO SINHVIEN([MSSV], [HOTEN], [NTNS], [PHAI], [MALOP]) VALUES
('170001', 'Le Hoai An', CONVERT(DATE, '12/10/1999', 103), 1, '18DTH01'),
('180002', 'Nguyen Thi Hoa Binh', CONVERT(DATE, '20/11/2000', 103), 1, '18DTH01'),
('180003', 'Pham Tuong Chau', CONVERT(DATE, '07/06/2000', 103), 0, '18DTH02'),
('180004', 'Tran Cong Danh', CONVERT(DATE, '31/01/2000', 103), 0, '19DTH01')


INSERT INTO DIEMSV([MSSV], [MAMH], [DIEM]) VALUES
('170001', 'COS201', 10),
('170001', 'COS202', 10),
('170001', 'COS203', 10),
('170001', 'COS204', 10),
('170001', 'COS205', 10),
('180002', 'COS201', 3.5),
('180002', 'COS202', 7),
('180003', 'COS201', 8.5),
('180003', 'COS202', 2),
('180003', 'COS203', 6.5),
('180004', 'COS201', 8),
('180004', 'COS204', NULL)
