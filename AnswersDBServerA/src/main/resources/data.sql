DROP TABLE IF EXISTS answers;


CREATE TABLE answers (
    id long (11) unsigned NOT NULL AUTO_INCREMENT,
    employee_id Long (11) unsigned NOT NULL,
    question_id Long (11) NOT NULL DEFAULT '',
    answer_selected varchar (300) NOT NULL DEFAULT '',
    PRIMARY KEY (id)
);