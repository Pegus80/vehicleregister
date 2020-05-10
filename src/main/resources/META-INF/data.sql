insert into Users (id, login_name, password_hash, role_name) values (-1, 'user', 'PBKDF2WithHmacSHA256:2048:e9vXAAs/amAf2/PT/eVw2UbG6DcdtIZArf0FqMG8ClI=:UTOAQ8LsucZL3nua/RQj3VyDid3KhaSUFc5AaVI8T4A=', 'USER')
insert into Users (id, login_name, password_hash, role_name) values (-2, 'manager', 'PBKDF2WithHmacSHA256:2048:e9vXAAs/amAf2/PT/eVw2UbG6DcdtIZArf0FqMG8ClI=:UTOAQ8LsucZL3nua/RQj3VyDid3KhaSUFc5AaVI8T4A=', 'MANAGER')
insert into Users (id, login_name, password_hash, role_name) values (-3, 'admin', 'PBKDF2WithHmacSHA256:2048:e9vXAAs/amAf2/PT/eVw2UbG6DcdtIZArf0FqMG8ClI=:UTOAQ8LsucZL3nua/RQj3VyDid3KhaSUFc5AaVI8T4A=', 'ADMIN')



insert into VehicleCategories (id, categoryName) values (-1,'Locomotive')
insert into VehicleCategories (id, categoryName) values (-2,'Electric train wagon')
insert into VehicleCategories (id, categoryName) values (-3,'Diesel train wagon')
insert into VehicleCategories (id, categoryName) values (-4,'Passenger wagon')
insert into VehicleCategories (id, categoryName) values (-5,'Cargo wagon')
insert into VehicleCategories (id, categoryName) values (-6,'Track machine')
insert into VehicleCategories (id, categoryName) values (-7,'Crane')
insert into VehicleCategories (id, categoryName) values (-8,'Other machines')

insert into VehicleTypes (id, vehicleCategory_id, typeName) values (-1,-1,'Cargo')
insert into VehicleTypes (id, vehicleCategory_id, typeName) values (-2,-1,'Shunter')
insert into VehicleTypes (id, vehicleCategory_id, typeName) values (-3,-5,'Cistern')
insert into VehicleTypes (id, vehicleCategory_id, typeName) values (-4,-5,'Covered')
insert into VehicleTypes (id, vehicleCategory_id, typeName) values (-5,-5,'Platform')
insert into VehicleTypes (id, vehicleCategory_id, typeName) values (-6,-5,'Container')
insert into VehicleTypes (id, vehicleCategory_id, typeName) values (-7,-5,'Gondola')
insert into VehicleTypes (id, vehicleCategory_id, typeName) values (-8,-5,'Dumpcar')


insert into VehicleModels (id, vehicleType_id, modelName) values (-1,-3,'15-1443')
insert into VehicleModels (id, vehicleType_id, modelName) values (-2,-3,'15-1443-80')
insert into VehicleModels (id, vehicleType_id, modelName) values (-3,-3,'15-1500')
insert into VehicleModels (id, vehicleType_id, modelName) values (-4,-3,'15-1547')
insert into VehicleModels (id, vehicleType_id, modelName) values (-5,-3,'15-1566')
insert into VehicleModels (id, vehicleType_id, modelName) values (-10,-4,'11-066-04')
insert into VehicleModels (id, vehicleType_id, modelName) values (-11,-4,'11-066-08')
insert into VehicleModels (id, vehicleType_id, modelName) values (-12,-4,'11-280')
insert into VehicleModels (id, vehicleType_id, modelName) values (-13,-4,'11-7038')
insert into VehicleModels (id, vehicleType_id, modelName) values (-6,-5,'15-1566')
insert into VehicleModels (id, vehicleType_id, modelName) values (-7,-5,'13-401')
insert into VehicleModels (id, vehicleType_id, modelName) values (-8,-5,'13-4012M')
insert into VehicleModels (id, vehicleType_id, modelName) values (-9,-5,'31-638')






