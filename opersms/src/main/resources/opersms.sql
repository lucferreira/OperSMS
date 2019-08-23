DROP TABLE IF EXISTS opersms;

CREATE TABLE opersms(

	idsms BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	datasms DATE NOT NULL,
	textosms VARCHAR (160)

)

INSERT INTO opersms (idsms, datasms, textosms) VALUES (1, 2019-08-23, "teste texto 1");
INSERT INTO opersms (idsms, datasms, textosms) VALUES (2, 2019-08-23, "teste texto 2");
INSERT INTO opersms (idsms, datasms, textosms) VALUES (3, 2019-08-23, "teste texto 3");