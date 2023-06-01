DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS questions;


CREATE TABLE employee (
    id long (11) unsigned NOT NULL AUTO_INCREMENT,
    personal_id long (11) unsigned NOT NULL,
    first_name varchar (300) NOT NULL DEFAULT '',
    last_name varchar (300) NOT NULL DEFAULT '',
    email VARCHAR(300) NOT NULL DEFAULT '',
    PRIMARY KEY (id)
);

CREATE TABLE questions (
    id Long (11) unsigned NOT NULL AUTO_INCREMENT,
    questionIs varchar (300) NOT NULL DEFAULT '',
    answerA varchar(300) NOT NULL DEFAULT '',
    answerB varchar(300) NOT NULL DEFAULT '',
    answerC varchar(300) NOT NULL DEFAULT '',
    answerD varchar(300) NOT NULL DEFAULT '',
    PRIMARY KEY (id)
);

