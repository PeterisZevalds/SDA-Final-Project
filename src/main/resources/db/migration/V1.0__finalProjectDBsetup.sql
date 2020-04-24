/*Table for student entity*/
CREATE TABLE IF NOT EXISTS users
(

    `id`             INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`           VARCHAR(50)  NOT NULL,
    `surname`        VARCHAR(50)  NOT NULL,
    `email`          VARCHAR(100) NOT NULL UNIQUE,
    `phone_number`   VARCHAR(20)  NOT NULL UNIQUE,
    `username`       VARCHAR(50)  NOT NULL UNIQUE,
    `password`       VARCHAR(50)  NOT NULL,
    `status`         INT DEFAULT 1,
    `user_is_active` BOOLEAN DEFAULT TRUE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

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
    `event_email`        VARCHAR(10),
    `event_phone_number` VARCHAR(20),
    `event_is_active`    BOOLEAN DEFAULT TRUE
) ENGINE = InnoDB;

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


/*insert into users (name, surname, email, phone_number, username, password, status, is_active) values
            ("Test1" ,"TestSurname", "example@example.com", "+371239299329", "testusername", "testpassword", 1, TRUE);*/
