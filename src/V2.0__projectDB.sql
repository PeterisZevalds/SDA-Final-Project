CREATE TABLE IF NOT EXISTS users
(

    id           INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(100) NOT NULL,
    surname      VARCHAR(100) NOT NULL,
    email        VARCHAR(100) NOT NULL UNIQUE,
    phone_number VARCHAR(100) NOT NULL UNIQUE,
    username     VARCHAR(100) NOT NULL UNIQUE,
    password     VARCHAR(100) NOT NULL,
    status       INT     DEFAULT (1),
    is_active    BOOLEAN DEFAULT TRUE

) ENGINE = InnoDB;

insert into users (name, surname, email, phone_number, username, password, status, is_active) values
("Test1" ,"TestSurname", "example@example.com", "+371239299329", "testusername", "testpassword", 1, TRUE);
