insert into Users (id, login_name, password_hash, role_name) values (-1, 'user', 'PBKDF2WithHmacSHA256:2048:e9vXAAs/amAf2/PT/eVw2UbG6DcdtIZArf0FqMG8ClI=:UTOAQ8LsucZL3nua/RQj3VyDid3KhaSUFc5AaVI8T4A=', 'USER')
insert into Users (id, login_name, password_hash, role_name) values (-2, 'manager', 'PBKDF2WithHmacSHA256:2048:e9vXAAs/amAf2/PT/eVw2UbG6DcdtIZArf0FqMG8ClI=:UTOAQ8LsucZL3nua/RQj3VyDid3KhaSUFc5AaVI8T4A=', 'MANAGER')
insert into Users (id, login_name, password_hash, role_name) values (-3, 'admin', 'PBKDF2WithHmacSHA256:2048:e9vXAAs/amAf2/PT/eVw2UbG6DcdtIZArf0FqMG8ClI=:UTOAQ8LsucZL3nua/RQj3VyDid3KhaSUFc5AaVI8T4A=', 'ADMIN')



insert into VehicleCategories (id, categoryName) values (-1,'Lokomotīve')
insert into VehicleCategories (id, categoryName) values (-2,'Elektrovilciena vagons')
insert into VehicleCategories (id, categoryName) values (-3,'Dīzeļvilciena vagons')
insert into VehicleCategories (id, categoryName) values (-4,'Pasažieru vagons')
insert into VehicleCategories (id, categoryName) values (-5,'Kravas vagons')
insert into VehicleCategories (id, categoryName) values (-6,'Sliežu ceļa mašīna')
insert into VehicleCategories (id, categoryName) values (-7,'Ceļamkrāns')
insert into VehicleCategories (id, categoryName) values (-8,'Citas mašīnas')

-- insert into VehicleTypes (id, vehicleCategory_id, typeName) values (-1,-1,'Kravas')
insert into VehicleTypes (id, vehicleCategory_id, typeName) values (-2,-1,'Manevru')
insert into VehicleTypes (id, vehicleCategory_id, typeName) values (-3,-5,'Cisterna')
insert into VehicleTypes (id, vehicleCategory_id, typeName) values (-4,-5,'Segtais')
insert into VehicleTypes (id, vehicleCategory_id, typeName) values (-5,-5,'Platfoma')
insert into VehicleTypes (id, vehicleCategory_id, typeName) values (-6,-5,'Konteineris')
insert into VehicleTypes (id, vehicleCategory_id, typeName) values (-7,-5,'Pusvagons')
insert into VehicleTypes (id, vehicleCategory_id, typeName) values (-8,-5,'Dumpkars')


insert into VehicleModels (id, vehicleType_id, modelName) values (-11,-4,'11-066-08')
insert into VehicleModels (id, vehicleType_id, modelName) values (-12,-2,'ČME3')
insert into VehicleModels (id, vehicleType_id, modelName) values (-1,-3,'15-1443')
insert into VehicleModels (id, vehicleType_id, modelName) values (-2,-3,'15-1443-80')
insert into VehicleModels (id, vehicleType_id, modelName) values (-3,-3,'15-1500')
insert into VehicleModels (id, vehicleType_id, modelName) values (-4,-3,'15-1547')
insert into VehicleModels (id, vehicleType_id, modelName) values (-5,-3,'15-1566')
insert into VehicleModels (id, vehicleType_id, modelName) values (-10,-4,'11-066-04')
insert into VehicleModels (id, vehicleType_id, modelName) values (-12,-4,'11-280')

insert into VehicleModels (id, vehicleType_id, modelName) values (-13,-4,'11-7038')
insert into VehicleModels (id, vehicleType_id, modelName) values (-6,-5,'15-1566')
insert into VehicleModels (id, vehicleType_id, modelName) values (-7,-5,'13-401')
insert into VehicleModels (id, vehicleType_id, modelName) values (-8,-5,'13-4012M')
insert into VehicleModels (id, vehicleType_id, modelName) values (-9,-5,'31-638')




insert into Countries (id, countryName) values (-1, 'Latvija')
insert into Countries (id, countryName) values (-2, 'Francija')
insert into Countries (id, countryName) values (-3, 'Ukraina')
insert into Countries (id, countryName) values (-4, 'Saūda Arābija')
insert into Countries (id, countryName) values (-5, 'Jemena')
insert into Countries (id, countryName) values (-6, 'Kamerūna')
insert into Countries (id, countryName) values (-7, 'Dānija')
