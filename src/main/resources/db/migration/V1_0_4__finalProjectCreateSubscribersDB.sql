/*Table for subscribers list*/
CREATE TABLE IF NOT EXISTS subscribers
(
    `id`             INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `email`          VARCHAR(100) NOT NULL UNIQUE,
    `subscriber_is_active` BOOLEAN DEFAULT TRUE
) ENGINE = InnoDB;

CREATE SEQUENCE SEQ_SUBSCRIBER increment by 1;

/*test values for subscribers database*/
insert into subscribers values (1, 'epasts1@epasts.lv', TRUE);
insert into subscribers values (2, 'epasts2@epasts.lv', TRUE);


