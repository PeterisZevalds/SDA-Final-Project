/*Table for student entity*/
CREATE TABLE IF NOT EXISTS users
(

    `id`             INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`           VARCHAR(50)  NOT NULL,
    `surname`        VARCHAR(50)  NOT NULL,
    `email`          VARCHAR(100) NOT NULL UNIQUE,
    `phone_number`   VARCHAR(20)  NOT NULL UNIQUE,
    `username`       VARCHAR(50)  NOT NULL UNIQUE,
    `password`       VARCHAR(MAX) NOT NULL,
    `status`         INT DEFAULT 1,
    `user_is_active` BOOLEAN DEFAULT TRUE
) ENGINE = InnoDB;

/*Table for event entity*/
CREATE TABLE IF NOT EXISTS event
(

    `id`                 int          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `event_name`         VARCHAR(100) NOT NULL,
    `event_date`         VARCHAR(20) NOT NULL,
    `event_street`       VARCHAR(100) NOT NULL,
    `event_city`         VARCHAR(20) NOT NULL,
    `event_price`        VARCHAR(20) NOT NULL,
    `event_max_visitors` VARCHAR(10) NOT NULL,
    `event_duration`     VARCHAR(20) NOT NULL,
    `event_link`         VARCHAR(50),
    `event_email`        VARCHAR(255),
    `event_phone_number` VARCHAR(20),
    `event_is_active`    BOOLEAN DEFAULT TRUE
) ENGINE = InnoDB;


-- insert into event values (1, 'Pirmais pasākums', '23.03.2020.', 'Ielas nosaukums', 'Pilsēta', 'free', '30', '1 hour', 'www.lapa.lv', 'epasts@epasts.lv' '22222222', TRUE);

/*Table for all events */
-- CREATE TABLE IF NOT EXISTS events
-- (
--
--     `id`                 int          NOT NULL AUTO_INCREMENT PRIMARY KEY,
--     `event_title`         VARCHAR(100) NOT NULL,
--     `event_date`         VARCHAR(20) NOT NULL,
--     `event_speaker`       VARCHAR(100) NOT NULL,
--     `event_address`         VARCHAR(20) NOT NULL,
--     `event_duration`     VARCHAR(20) NOT NULL,
--     `event_is_active`    BOOLEAN DEFAULT TRUE
-- ) ENGINE = InnoDB;

/*Table for eventRegistration*/
CREATE TABLE IF NOT EXISTS eventRegister
(

    `id`       INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_id`  INT NOT NULL,
    `event_id` INT NOT NULL,
    FOREIGN KEY (user_id)
        REFERENCES `users` (id)
        ON DELETE CASCADE,
    FOREIGN KEY (event_id)
        REFERENCES `event` (id)
        ON DELETE CASCADE
) ENGINE = InnoDB;

CREATE SEQUENCE SEQ_EVENT increment by 1;

/*insert into users (name, surname, email, phone_number, username, password, status, is_active) values
            ("Test1" ,"TestSurname", "example@example.com", "+371239299329", "testusername", "testpassword", 1, TRUE);*/
