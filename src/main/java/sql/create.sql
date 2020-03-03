CREATE DATABASE carpartshop;

USE carpartshop;

CREATE TABLE users(
	user_id		BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    first_name  VARCHAR(25) NOT NULL,
    last_name   VARCHAR(30) NOT NULL,
	phone       VARCHAR(13) NOT NULL
);

CREATE TABLE orders(
	order_id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    user_id BIGINT NOT NULL,
    state ENUM('accepted', 'partcompleted', 'completed', 'cancelled') NOT NULL,
    creation_date DATETIME NOT NULL,    
    completion_date DATETIME NOT NULL,
    possible_completion_date DATETIME  NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);	

CREATE TABLE category(
	category_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    category VARCHAR(20) NOT NULL
);

CREATE TABLE car(
	car_id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    mark VARCHAR(30) NOT NULL,
    model VARCHAR(30) NOT NULL,
	creation_year YEAR NOT NULL,
    engine_volume INT NOT NULL,
    fuel_type ENUM('PETROL', 'GAS', 'DIESEL') NOT NULL,
    carcass_type ENUM('sedan', 'SW', 'coupe') NOT NULL    
);
CREATE TABLE parts(
	part_id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    car_id BIGINT,
    color VARCHAR(15),
    category_id INT NOT NULL,
    detail VARCHAR(100) NOT NULL,
    price INT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(category_id),
     FOREIGN KEY (car_id) REFERENCES car(car_id) 
);

CREATE TABLE ordered(
	order_id BIGINT NOT NULL,
    part_id BIGINT NOT NULL,
    amount_part INT  NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (part_id) REFERENCES parts(part_id)    
);