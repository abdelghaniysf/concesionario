-- Insert initial data into motor table
INSERT INTO motor (id, horsepower, torque, engine_cc, description, engine_volume, fuel_type) VALUES
                                                                                                 (1, 450, 550, 5.0, 'V8 Engine', 5.0, 'GASOLINE'),
                                                                                                 (2, 350, 400, 3.0, 'V6 Engine', 3.0, 'DIESEL'),
                                                                                                 (3, 300, 350, 2.0, 'Inline-4 Engine', 2.0, 'GASOLINE'),
                                                                                                 (4, 200, 250, 1.6, 'Inline-4 Engine', 1.6, 'HYBRID'),
                                                                                                 (5, 500, 600, 6.0, 'V12 Engine', 6.0, 'GASOLINE');

-- Insert initial data into car table
INSERT INTO car (chassis_serial_number, motor_id, car_brand, price, km, description, model, model_year, color, number_doors,
                 transmission, weight, number_seats, traction, steering, category, car_for, image_path) VALUES
                                                                                                            ('1HGCM82633A123456', 1, 'AUDI', 50000, 10000, 'Sporty sedan', 'A4', '2020-01-01', 'Red', 4, 'AUTOMATIC', 1500, 5,
                                                                                                             'FRONT_WHEEL_DRIVE', 'ELECTRIC', 'SPORT', 'BUYING', 'https://fotos.quecochemecompro.com/audi-a4/audi-a4-vista-delantera-lateral.jpg?size=750x400'),
                                                                                                            ('2T1BURHE1FC123456', 2, 'BMW', 75000, 5000, 'Luxury SUV', 'X5', '2021-05-15', 'Black', 4, 'MANUAL', 2000, 5,
                                                                                                             'ALL_WHEEL_DRIVE', 'HYDRAULIC', 'LUXURY', 'RENTING', 'https://cdn.drivek.com/configurator-imgs/cars/es/Original/BMW/X5/41510_TODOTERRENO-5-PUERTAS/bmw-x5-front-view.jpg'),
                                                                                                            ('3VWFE21C04M000001', 3, 'HONDA', 20000, 20000, 'Compact car', 'Civic', '2019-03-20', 'Blue', 4, 'CVT', 1200, 5,
                                                                                                             'FRONT_WHEEL_DRIVE', 'HYDRAULIC', 'SPORT', 'BUYING', 'https://soymotor.com/sites/default/files/imagenes/noticia/honda-civic-type-r-2023-soymotor.jpg'),
                                                                                                            ('1N4AL3AP5FC123457', 4, 'TOYOTA', 30000, 15000, 'Hybrid sedan', 'Prius', '2022-08-05', 'Green', 4, 'AUTOMATIC', 1300, 5,
                                                                                                             'FRONT_WHEEL_DRIVE', 'ELECTRIC', 'LUXURY', 'BUYING', 'https://www.lugenergy.com/imagenes//2024/01/punto-recarga-toyota-prius.png'),
                                                                                                            ('5YJSA1E26GF123456', 5, 'TESLA', 80000, 1000, 'Electric luxury car', 'Model S', '2023-02-11', 'White', 4, 'AUTOMATIC', 2000, 5,
                                                                                                             'ALL_WHEEL_DRIVE', 'ELECTRIC', 'SUPERCAR', 'RENTING', 'https://acnews.blob.core.windows.net/imgnews/paragraph/NPAZ_4efd84a1463741eda0a9b91f13d4d80d.jpg');
