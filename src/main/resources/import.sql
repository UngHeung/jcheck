-- insert data for admin
INSERT INTO admin (admin_id, admin_name, admin_password, admin_authority) VALUES ('admin1', 'adam', '123', false), ('admin2', 'david', '456', false);

-- insert data for distributor
INSERT INTO distributor (distributor_name, distributor_type) VALUES ('dist1', 'SKT'), ('dist3', 'SKT'), ('dist4', 'KT'), ('dist2', 'SKT'), ('dist5', 'KT'), ('dist6', 'KT'), ('dist7', 'LGU+'), ('dist8', 'LGU+');

-- insert data for product
INSERT INTO product (product_model_name, product_pet_name, product_memory, product_price, product_manufacturer, product_colors) VALUES ('S24', 'SM-S921_256', 256, 119500, 'Samsung', 'red,yellow,green');
INSERT INTO product (product_model_name, product_pet_name, product_memory, product_price) VALUES ('S24', 'SM-S921_512', 512, 139500);
INSERT INTO product (product_model_name, product_pet_name, product_memory, product_price, product_colors) VALUES ('아이폰15', 'AIP15_128', 128, 990000, 'black,yellow,pink');
INSERT INTO product (product_model_name, product_pet_name, product_memory, product_price, product_manufacturer) VALUES ('아이폰15', 'AIP15_256', 256, 1200000, 'apple');