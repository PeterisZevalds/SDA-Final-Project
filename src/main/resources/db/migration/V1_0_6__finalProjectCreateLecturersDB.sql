/* create table for lecturers list*/

CREATE TABLE  IF NOT EXISTS lecturers
(
    `id`            INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`          VARCHAR(100) NOT NULL,
    `surname`       VARCHAR(100) NOT NULL,
    `description`   VARCHAR(MAX) NOT NULL,
    `email`         VARCHAR(100) NOT NULL,
) ENGINE = InnoDB;

CREATE SEQUENCE SEQ_LECTURERS increment by 1;

/*test value for lecturers database*/

insert into lecturers values (SEQ_LECTURERS.nextVal, 'Alīna', 'Fridriksone', 'Apraksts par Alīnu', 'Alina.Fridriksone@gmail.com');
insert into lecturers values (SEQ_LECTURERS.nextVal, 'Zanda', 'Stārastniece', 'Apraksts par Zandu', 'Starastniece@gmail.com');
