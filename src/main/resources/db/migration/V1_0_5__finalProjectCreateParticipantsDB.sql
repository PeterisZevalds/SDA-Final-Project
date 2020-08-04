/*Table for participants list*/
CREATE TABLE IF NOT EXISTS participants
(
    `id`             INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`          VARCHAR(100) NOT NULL UNIQUE,
    `surname`          VARCHAR(100) NOT NULL UNIQUE,
    `email`          VARCHAR(100) NOT NULL UNIQUE,
    `password`          VARCHAR(MAX) NOT NULL UNIQUE
) ENGINE = InnoDB;

CREATE SEQUENCE SEQ_PARTICIPANT increment by 1;

/*test values for participants database*/
insert into participants values (SEQ_PARTICIPANT.nextVal, 'Ingrīda', 'Pīkstiņa', 'ingrida.pikstina@epasts.lv', 'ingrida_parole');
insert into participants values (SEQ_PARTICIPANT.nextVal, 'Raimonds', 'Karulis', 'raimonds.karulis@epasts.lv', 'raimonds_parole');


