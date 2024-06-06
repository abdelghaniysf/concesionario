INSERT INTO motor (horsepower, torque, engine_cc, description, engine_volume, fuel_type) VALUES (530, 750, 2000, 'V8 Biturbo', 4.4, 'DIESEL');
INSERT INTO motor (horsepower, torque, engine_cc, description, engine_volume, fuel_type) VALUES (707, 650, 6200, 'Supercharged V8', 6.2, 'PETROL');
INSERT INTO motor (horsepower, torque, engine_cc, description, engine_volume, fuel_type) VALUES (503, 600, 3000, 'Inline-6 Twin-Turbo', 3.0, 'DIESEL');
INSERT INTO motor (horsepower, torque, engine_cc, description, engine_volume, fuel_type) VALUES (577, 664, 4000, 'AMG V8 Biturbo', 4.0, 'PETROL');
INSERT INTO motor (horsepower, torque, engine_cc, description, engine_volume, fuel_type) VALUES (670, 860, 3996, 'V8 Turbo', 4.0, 'DIESEL');
INSERT INTO motor (horsepower, torque, engine_cc, description, engine_volume, fuel_type) VALUES (1000, 1050, 8000, 'Quad-Turbo W16', 8.0, 'PETROL');
INSERT INTO car (chassis_serial_number, motor_id, car_brand, price, km, description, model, model_year, color, number_doors, transmission, weight, number_seats, traction, steering, category, car_for, image_path) VALUES ('1HGCM82633A004351', 1, 'TOYOTA', 25000.00, 50000, 'Compact car, good condition', 'Corolla', '2019-01-15', 'Red', 4, 'AUTOMATIC', 1300, 5, 'FRONT_WHEEL_DRIVE', 'ELECTRIC', 'SPORT', 'SALE', 'https://scene7.toyota.eu/is/image/toyotaeurope/review-nuevo-corolla?wid=1280&fit=fit,1&ts=0&resMode=sharp2&op_usm=1.75,0.3,2,0');
INSERT INTO car (chassis_serial_number, motor_id, car_brand, price, km, description, model, model_year, color, number_doors, transmission, weight, number_seats, traction, steering, category, car_for, image_path) VALUES ('1HGCM82633A004352', 2, 'BUGATTI_SUPERCAR', 25000.00, 50000, 'Compact car, good condition', 'Veyron', '2019-01-15', 'Red', 4, 'AUTOMATIC', 1300, 5, 'ALL_WHEEL_DRIVE', 'ELECTROHYDRAULIC', 'SUPERCAR', 'RENT', 'https://hips.hearstapps.com/es.h-cdn.co/cades/contenidos/8388/bugatti-veyron-super-sport-car-1024x678.jpg?crop=0.888888888888889xw:1xh;center,top&resize=1200:*');
INSERT INTO car (chassis_serial_number, motor_id, car_brand, price, km, description, model, model_year, color, number_doors, transmission, weight, number_seats, traction, steering, category, car_for, image_path) VALUES ('1HGCM82633A004353', 3, 'HONDA', 18000.00, 40000, 'Sedán compacto, excelente estado', 'Civic', '2018-06-20', 'Azul', 4, 'MANUAL', 1200, 5, 'FRONT_WHEEL_DRIVE', 'ELECTRIC', 'SPORT', 'SALE', 'https://hips.hearstapps.com/hmg-prod/images/gbmd4761-1576574948.jpg?crop=1.00xw:0.847xh;0,0.0622xh&resize=2048:*');
INSERT INTO car (chassis_serial_number, motor_id, car_brand, price, km, description, model, model_year, color, number_doors, transmission, weight, number_seats, traction, steering, category, car_for, image_path) VALUES ('1HGCM82633A004354', 4, 'FERRARI_SUPERCAR', 350000.00, 15000, 'Supercarro en excelente condición', 'LaFerrari', '2021-03-10', 'Rojo', 2, 'CVT', 1400, 2, 'REAR_WHEEL_DRIVE', 'HYDRAULIC', 'HYPERCAR', 'RENT', 'https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.pixelstalk.net%2Fwp-content%2Fuploads%2F2016%2F11%2FAuto-Ferrari-Laferrari-Photos.jpg&f=1&nofb=1&ipt=4adedd169a1315e1b8c43d48176c6e571253cad5bd2347bcab5af2e023285ff7&ipo=images');
INSERT INTO car (chassis_serial_number, motor_id, car_brand, price, km, description, model, model_year, color, number_doors, transmission, weight, number_seats, traction, steering, category, car_for, image_path) VALUES ('1HGCM82633A004355', 5, 'MERCEDES', 350000.00, 15000, 'Supercar killer', 'gt63se', '2021-03-10', 'Rojo', 2, 'AUTOMATIC', 1400, 2, 'REAR_WHEEL_DRIVE', 'ELECTRIC', 'SPORT', 'SALE', 'https://cdn.motor1.com/images/mgl/MkkY7X/s3/mercedes-amg-gt-63-s-e-performance-f1-edition.jpg');
INSERT INTO car (chassis_serial_number, motor_id, car_brand, price, km, description, model, model_year, color, number_doors, transmission, weight, number_seats, traction, steering, category, car_for, image_path) VALUES ('1HGCM82633A004356', 6, 'BMW', 350000.00, 15000, 'Supercar killer', 'M5 CS', '2021-03-10', 'Rojo', 2, 'AUTOMATIC', 1400, 2, 'REAR_WHEEL_DRIVE', 'ELECTRIC', 'SPORT', 'RENT', 'https://cdn.motor1.com/images/mgl/x6wO6/s1/2021-bmw-m5-cs.webp');


-- Insertar roles
INSERT INTO roles_db (role) VALUES ('ADMIN');
INSERT INTO roles_db (role) VALUES ('USER');

-- Insertar usuario con la contraseña encriptada
INSERT INTO user_db (national_id, username, firstname, lastname, email, address, date_of_birth, phone_number, password)VALUES ('12345678A', 'mohammed', 'mohammed', 'el yousfi', 'mohammedelyousfi@gmail.com', '123 Main St','1990-01-01', '555-555-5555', '$2a$10$e0MYzXyjpJS7Pd0RVvHwHeF.Z.UmvJxa4riqZraA9P3hrKkT36n6C');
INSERT INTO user_db (national_id, username, firstname, lastname, email, address, date_of_birth, phone_number, password)VALUES ('12345678B', 'abdel', 'abdel', 'el yousfi', 'abdelelyousfi@gmail.com', '123 Main St','1990-01-01', '155-555-5555', '$2a$10$RvDzLitpCGR72IyHiurGLeZ4kiWLpAytMD/L1dURju/8HtQCiQXB6');

-- Obtener el ID del usuario insertado (suponiendo que es el primero en ser insertado)
SET @userId = (SELECT national_id FROM user_db WHERE email = 'mohammedelyousfi@gmail.com');

-- Obtener los IDs de los roles
SET @adminRoleId = (SELECT id FROM roles_db WHERE role = 'ADMIN');
SET @userRoleId = (SELECT id FROM roles_db WHERE role = 'USER');

-- Vincular usuario con roles
INSERT INTO users_roles (user_id, role_id) VALUES (@userId, @adminRoleId);
INSERT INTO users_roles (user_id, role_id) VALUES (@userId, @userRoleId);
