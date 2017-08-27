create table Employee (id integer(20) auto_increment  primary key, name text, salary integer(20), departmentId integer(20));
create table Certificate(id integer(20) auto_icrement primary key, name text,empId integer(20),foreign key (empId)references Employee(id));
