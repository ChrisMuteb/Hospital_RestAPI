CREATE DATABASE IF NOT EXISTS `hospital_directory`;
USE `hospital_directory`;

--
-- Table structure
--
DROP TABLE IF EXISTS `doctor`;
DROP TABLE IF EXISTS `appointment`;
DROP TABLE IF EXISTS `patient`;
DROP TABLE IF EXISTS `bill`;
DROP TABLE IF EXISTS `payment`;
DROP TABLE IF EXISTS `insurance`;

CREATE TABLE `doctor`
(
    `doc_id` INT NOT NULL AUTO_INCREMENT primary key,
    `doc_firstname` varchar(45) DEFAULT NULL,
    `doc_lastname` varchar(45) DEFAULT NULL
);
--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment`
(
	`app_id` int NOT NULL AUTO_INCREMENT primary key,
    `doc_id` int NOT NULL,
    `pat_id` int NOT NULL,
    `bill_id` int NOT NULL,
    `app_date` varchar(45) DEFAULT NULL,
    `app_time` varchar(45) DEFAULT NULL,
    `app_duration` int DEFAULT NULL,
    `app_reason` varchar(45) DEFAULT NULL
);

--
-- Table structure for table `patient`
--

CREATE TABLE `patient`
(
    `pat_id` int NOT NULL AUTO_INCREMENT primary key,
    `pat_firstname` varchar(45),
    `pat_lastname` varchar(45),
    `pat_address` varchar(45),
    `pat_city` varchar(45),
    `pat_state` varchar(45),
    `ins_id` integer default null
);

--
-- Table structure for table `bill`
--

CREATE TABLE `bill`
(
    `bill_id` int NOT NULL AUTO_INCREMENT primary key,
    `bill_amountinsured` int default null,
    `bill_amountnotinsured` int default null,
    `bill_datesent` varchar(45),
    `bill_status` varchar(45)
);
--
-- Table structure for table `payment`
--

CREATE TABLE `payment`
(
    `pay_id` int NOT NULL AUTO_INCREMENT primary key,
    `pay_amount` int default null,
    `pay_date` varchar(45) default null,
    `pay_method` varchar(45) default null,
    `pat_id` integer,
    `bill_id` integer not null,
    `ins_id` integer
);
--
-- Table structure for table `insurance`
--

CREATE TABLE `insurance`
(
    `ins_id` int NOT NULL AUTO_INCREMENT primary key,
    `ins_benefitcontact` varchar(45),
    `ins_phonenumber` varchar(45),
    `ins_claimaddress` varchar(45)
);
--
-- Populate Tables
--

INSERT INTO `doctor` VALUES
    (1, 'Martin', 'Bernard'),
    (2, 'Chalme', 'Antoine'),
    (3, 'Daulne', 'Paul'),
    (4, 'Solti', 'Anna'),
    (5, 'Chalme', 'Julie'),
    (6, 'Dart', 'Pauline');
    
insert into `appointment` values 
	(50, 2, 100, 151, '12/08/2022', '10h30', 30, 'check up'),
    (51, 2, 101, 150, '12/08/2023', '13h30', 40, 'check up'),
    (52, 1, 103, 152, '12/08/2024', '10h30', 30, 'check up'),
    (53, 2, 100, 153, '12/05/2022', '14h30', 45, 'check up'),
    (54, 6, 102, 154, '12/03/2022', '16h30', 30, 'check up'),
    (55, 5, 100, 157, '12/05/2023', '10h30', 50, 'check up'),
    (56, 4, 104, 155, '12/08/2022', '09h30', 30, 'check up'),
    (57, 1, 105, 156, '12/08/2022', '08h30', 60, 'check up');
    
insert into `patient` values
	(100, 'dydier', 'Hung', '15 rue Caviare', 'Portugal', 'Portugal', 200),
    (101, 'Brest', 'Punk', '20 rue Caviare', 'Lyon', 'France', null),
    (102, 'dydier', 'Hung', '15 rue Caviare', 'Madrid', 'Spain', 201),
    (103, 'Sal', 'Chan', '23 rue Caviare', 'Kivu', 'DR Congo', 202),
    (104, 'Rose', 'Hung', '12 rue Caviare', 'Lefkosa', 'KKTC', null),
    (105, 'Jack', 'Chin', '15 rue Caviare', 'Pretoria', 'SA', 203);
    
insert into `bill` values
	(150, 70, 200, '12/05/2023', 'active'),
    (151, 200, 500, '12/04/2023', 'active'),
    (152, 70, 200, '12/05/2023', 'active'),
    (153, 90, 200, '12/05/2023', 'active'),
    (154, 70, 200, '12/02/2023', 'active'),
    (155, 150, 200, '18/05/2023', 'active'),
    (156, 70, 200, '12/05/2023', 'active'),
    (157, 50, 200, '14/05/2023', 'active');
    
insert into `payment` values
	(250, 185, '15/04/2023', 'insurance', 101, 151, null),
    (251, 205, '15/04/2023', 'credit card', 102, 150, 201),
    (252, 185, '15/04/2023', 'insurance', 100, 153, 200),
    (253, 20, '15/04/2023', 'insurance', 104, 152, null),
    (254, 185, '15/04/2023', 'credit card', 103, 157, 202),
    (255, 150, '15/04/2023', 'credit card', 105, 156, 203),
	(256, 500, '15/04/2023', 'insurance', 102, 154, 200);
    
insert into `insurance` values
	(200, 'PariBas', '01253647', 'Paris' ),
    (201, 'Santam', '01214647', 'Pretoria' ),
    (202, 'Momemtum', '01483647', 'Pretoria' ),
    (203, 'CIAS', '01257247', 'Paris' );
    
--
-- Primary Keys
--
-- alter table `doctor` add constraint `doc_pk` primary key (`doc_id`);

-- alter table `appointment` add constraint `app_pk` primary key (`app_id`);

-- alter table `patient` add constraint `pat_pk` primary key (`pat_id`);

-- alter table `bill` add constraint `bill_pk` primary key (`bill_id`);

-- alter table `payment` add constraint `pay_pk` primary key (`pay_id`);

-- alter table `insurance` add constraint `ins_pk` primary key (`ins_id`);

--
-- Foreign Keys
--
alter table `appointment` add constraint `app_doc_fk` foreign key (`doc_id`) references doctor(`doc_id`) on delete cascade;
alter table `appointment` add constraint `app_pat_fk` foreign key (`pat_id`) references patient(`pat_id`) on delete cascade;
alter table `appointment` add constraint `app_bill_fk` foreign key (`bill_id`) references bill(`bill_id`) on delete cascade;

alter table `patient` add constraint `pat_ins_fk` foreign key (`ins_id`) references insurance(`ins_id`) on delete cascade;

alter table `payment` add constraint `pay_pat_fk` foreign key (`pat_id`) references patient(`pat_id`) on delete cascade;
alter table `payment` add constraint `pay_bill_fk` foreign key (`bill_id`) references bill(`bill_id`) on delete cascade;
alter table `payment` add constraint `pay_ins_fk` foreign key (`ins_id`) references insurance(`ins_id`) on delete cascade;









