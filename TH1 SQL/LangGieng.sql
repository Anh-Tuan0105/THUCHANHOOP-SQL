CREATE TABLE LANGGIENG(
	MA_TTP VARCHAR(3),
	LG VARCHAR(3),
	PRIMARY KEY(MA_TTP, LG),
);

ALTER TABLE LANGGIENG ADD CONSTRAINT FK_LANGGIENG_TINH_TP FOREIGN KEY(MA_TTP) REFERENCES TINH_TP(MA_TTP)