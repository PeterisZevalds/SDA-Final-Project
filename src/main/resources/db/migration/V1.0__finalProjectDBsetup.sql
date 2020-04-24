/*Table for student entity*/
CREATE TABLE IF NOT EXISTS users (

  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone_number VARCHAR(100) NOT NULL UNIQUE,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100)NOT NULL,
    status INT DEFAULT(1),
    is_active BOOLEAN DEFAULT TRUE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table for event entity*/
/*CREATE TABLE IF NOT EXISTS event (

    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `eventName` VARCHAR(100) NOT NULL,
    `eventDate` VARCHAR(100) NOT NULL,
    `eventStreet` VARCHAR(100) NOT NULL,
    `eventCity` VARCHAR(100) NOT NULL,
    `eventPrice` VARCHAR(100) NOT NULL,
    `eventMaxVisitors` VARCHAR(100) NOT NULL,
    `eventDuration` VARCHAR(100) NOT NULL,
    `eventLink` VARCHAR (100),
    `eventEmail` VARCHAR (100),
    `eventPhoneNumber` VARCHAR (100),
    `eventActive` BOOLEAN DEFAULT TRUE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;*/

/*Table for eventRegistration*/
/*CREATE TABLE IF NOT EXISTS eventRegister (

    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_id` INT NOT NULL,
    `event_id` INT NOT NULL,
    FOREIGN KEY (user_id)
        REFERENCES `users` (id)
        ON DELETE CASCADE,
    FOREIGN KEY (event_id)
        REFERENCES `event` (id)
        ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;*/


/*insert into users (name, surname, email, phone_number, username, password, status, is_active) values
            ("Test1" ,"TestSurname", "example@example.com", "+371239299329", "testusername", "testpassword", 1, TRUE);*/
