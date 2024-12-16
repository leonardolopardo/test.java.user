--DROP TABLE IF EXISTS USER;
--DROP TABLE IF EXISTS PHONE;

CREATE TABLE USER(
	ID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	NAME VARCHAR(255) NOT NULL
	EMAIL VARCHAR(255) NOT NULL
	PASSWORD VARCHAR(255) NOT NULL
	);

CREATE TABLE PHONE (
	ID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	NUMBER VARCHAR(255) NOT NULL
	CITYCODE VARCHAR(255) NOT NULL
	COUNTRYCODE VARCHAR(255) NOT NULL
	FOREIGN KEY (id_user) REFERENCES user(id)
);