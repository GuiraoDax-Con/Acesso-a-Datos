DROP DATABASE IF EXISTS hogwarts;
CREATE DATABASE hogwarts;

USE hogwarts;

CREATE TABLE house(
  id INTEGER PRIMARY KEY,
  name varchar(50) not null
);
insert into house values (1, "Gryffindor");
insert into house values (2, "Hufflepuff");
insert into house values (3, "Ravenclaw");
insert into house values (4, "Slytherin");

CREATE TABLE person (
    id INTEGER PRIMARY KEY,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    house_id INTEGER,
    FOREIGN KEY (house_id) REFERENCES house(id)
);
INSERT INTO person VALUES(1, "Euan", "Abercrombie", 1);
INSERT INTO person VALUES(2, "Katie", "Bell", 1);
INSERT INTO person VALUES(3, "Lavender", "Brown", 1);
INSERT INTO person VALUES(4, "Ritchie", "Coote", 1);
INSERT INTO person VALUES(5, "Colin", "Creevey", 1);
INSERT INTO person VALUES(6, "Dennis", "Creevey", 1);
INSERT INTO person VALUES(7, "Seamus", "Finnigan", 1);
INSERT INTO person VALUES(8, "Hermione", "Granger", 1);
INSERT INTO person VALUES(9, "Angelina", "Johnson", 1);
INSERT INTO person VALUES(10, "Lee", "Jordan", 1);
INSERT INTO person VALUES(11, "Andrew", "Kirke", 1);
INSERT INTO person VALUES(12, "Neville", "Longbottom", 1);
INSERT INTO person VALUES(13, "Natalie", "McDonald", 1);
INSERT INTO person VALUES(14, "Mary", "Macdonald", 1);
INSERT INTO person VALUES(15, "Cormac", "McLaggen", 1);
INSERT INTO person VALUES(16, "Parvati", "Patil", 1);
INSERT INTO person VALUES(17, "Jimmy", "Peakes", 1);
INSERT INTO person VALUES(18, "Sally-Anne", "Perks", 1);
INSERT INTO person VALUES(19, "Harry", "Potter", 1);
INSERT INTO person VALUES(20, "Demelza", "Robins", 1);
INSERT INTO person VALUES(21, "Jack", "Sloper", 1);
INSERT INTO person VALUES(22, "Alicia", "Spinnet", 1);
INSERT INTO person VALUES(23, "Dean", "Thomas", 1);
INSERT INTO person VALUES(24, "Romilda", "Vane", 1);
INSERT INTO person VALUES(25, "Fred", "Weasley", 1);
INSERT INTO person VALUES(26, "George", "Weasley", 1);
INSERT INTO person VALUES(27, "Ginny", "Weasley", 1);
INSERT INTO person VALUES(28, "Ron", "Weasley", 1);
INSERT INTO person VALUES(29, "Oliver", "Wood", 1);
INSERT INTO person VALUES(30, "Hannah", "Abbott", 2);
INSERT INTO person VALUES(31, "Susan", "Bones", 2);
INSERT INTO person VALUES(32, "Eleanor", "Branstone", 2);
INSERT INTO person VALUES(33, "Owen", "Cauldwell", 2);
INSERT INTO person VALUES(34, "Cedric", "Diggory", 2);
INSERT INTO person VALUES(35, "Justin", "Finch-Fletchley", 2);
INSERT INTO person VALUES(36, "Ernie", "Macmillan", 2);
INSERT INTO person VALUES(37, "Laura", "Madley", 2);
INSERT INTO person VALUES(38, "Eloise", "Midgeon", 2);
INSERT INTO person VALUES(39, "Zacharias", "Smith", 2);
INSERT INTO person VALUES(40, "Kevin", "Whitby", 2);
INSERT INTO person VALUES(41, "Rose", "Zeller", 2);
INSERT INTO person VALUES(42, "Stewart", "Ackerley", 3);
INSERT INTO person VALUES(43, "Marcus", "Belby", 3);
INSERT INTO person VALUES(44, "Terry", "Boot", 3);
INSERT INTO person VALUES(45, "Mandy", "Brocklehurst", 3);
INSERT INTO person VALUES(46, "Cho", "Chang", 3);
INSERT INTO person VALUES(47, "Eddie", "Carmichael", 3);
INSERT INTO person VALUES(48, "Penelope", "Clearwater", 3);
INSERT INTO person VALUES(49, "Michael", "Corner", 3);
INSERT INTO person VALUES(50, "Roger", "Davies", 3);
INSERT INTO person VALUES(51, "Marietta", "Edgecombe", 3);
INSERT INTO person VALUES(52, "S", "Fawcett", 3);
INSERT INTO person VALUES(53, "Anthony", "Goldstein", 3);
INSERT INTO person VALUES(54, "Luna", "Lovegood", 3);
INSERT INTO person VALUES(55, "Padma", "Patil", 3);
INSERT INTO person VALUES(56, "Orla", "Quirke", 3);
INSERT INTO person VALUES(57, "Lisa", "Turpin", 3);
INSERT INTO person VALUES(58, "Malcolm", "Baddock", 4);
INSERT INTO person VALUES(59, "Miles", "Bletchley", 4);
INSERT INTO person VALUES(60, "Millicent", "Bullstrode", 4);
INSERT INTO person VALUES(61, "Vincent", "Crabbe", 4);
INSERT INTO person VALUES(62, "Marcus", "Flint", 4);
INSERT INTO person VALUES(63, "Gregory", "Goyle", 4);
INSERT INTO person VALUES(64, "Terence", "Higgs", 4);
INSERT INTO person VALUES(65, "Draco", "Malfoy", 4);
INSERT INTO person VALUES(66, "Theodore", "Nott", 4);
INSERT INTO person VALUES(67, "Pansy", "Parkinson", 4);
INSERT INTO person VALUES(68, "Graham", "Pritchard", 4);
INSERT INTO person VALUES(69, "Adrian", "Pucey", 4);
INSERT INTO person VALUES(70, "Blaise", "Zabini", 4);

INSERT INTO person VALUES(71, "Sirius", "Black", 1);
INSERT INTO person VALUES(72, "James", "Potter", 1);
INSERT INTO person VALUES(73, "Lily", "Potter", 1);
INSERT INTO person VALUES(74, "Arthur", "Weasley", 1);
INSERT INTO person VALUES(75, "Bill", "Weasley", 1);
INSERT INTO person VALUES(76, "Charlie", "Weasley", 1);
INSERT INTO person VALUES(77, "Molly", "Weasley", 1);
INSERT INTO person VALUES(78, "Percy", "Weasley", 1);
INSERT INTO person VALUES(79, "Justin", "Finch-Fletchley", 2);
INSERT INTO person VALUES(80, "Nymphadora", "Tonks", 2);
INSERT INTO person VALUES(81, "Filius", "Flitwick", 3);
INSERT INTO person VALUES(82, "Regulus", "Black", 4);
INSERT INTO person VALUES(83, "Bellatrix", "Lestrange", 4);
INSERT INTO person VALUES(84, "Rabastan", "Lestrange", 4);
INSERT INTO person VALUES(85, "Rodolphus", "Lestrange", 4);
INSERT INTO person VALUES(86, "Abraxas", "Malfoy", 4);
INSERT INTO person VALUES(87, "Lucius", "Malfoy", 4);
INSERT INTO person VALUES(88, "Narcissa", "Malfoy", 4);
INSERT INTO person VALUES(89, "Tom", "Riddle", 4);
INSERT INTO person VALUES(90, "Peter", "Pettigrew", 1);

INSERT INTO person VALUES(91, "Godric", "Gryffindor", 1);
INSERT INTO person VALUES(92, "Helga", "Hufflepuff", 2);
INSERT INTO person VALUES(94,"Rowena","Ravenclaw", 3);
INSERT INTO person VALUES(93, "Salazar", "Slytherin", 4);

INSERT INTO person VALUES(95, "Albus", "Dumbledore", 1);
INSERT INTO person VALUES(96, "Rubeus", "Hagrid", 1);
INSERT INTO person VALUES(97, "Minerva", "McGonagall", 1);
INSERT INTO person VALUES(98, "Pomona", "Sprout", 2);
INSERT INTO person VALUES(99, "Severus", "Snape", 4);
INSERT INTO person VALUES(100, "Cuthbert", "Binns", 1);
INSERT INTO person VALUES(101, "Aurora", "Sinistra", 1);
INSERT INTO person VALUES(102, "Rolanda", "Hooch", 1);
INSERT INTO person VALUES(103, "Charity", "Burbage", 1);
INSERT INTO person VALUES(104, "Sybill", "Trelawney", 1);
INSERT INTO person VALUES(105, "Septima", "Vector", 1);
INSERT INTO person VALUES(106, "Bathsheda", "Babbling", 1);
INSERT INTO person VALUES(107, "Horace", "Slughorn", 4);
INSERT INTO person VALUES(108, "Alastor", "Moody", 1);


ALTER TABLE house ADD head_teacher INTEGER ;
UPDATE house SET head_teacher = (SELECT id FROM person WHERE first_name='Minerva' AND last_name='McGonagall')
WHERE id = 1;
UPDATE house SET head_teacher = (SELECT id FROM person WHERE first_name='Pomona' AND last_name='Sprout')
WHERE id = 2;
UPDATE house SET head_teacher = (SELECT id FROM person WHERE first_name='Filius' AND last_name='Flitwick')
WHERE id = 3;
UPDATE house SET head_teacher = (SELECT id FROM person WHERE first_name='Severus' AND last_name='Snape')
WHERE id = 4;
ALTER TABLE house ADD FOREIGN KEY (head_teacher) REFERENCES person(id);
ALTER TABLE house ADD UNIQUE(head_teacher);


CREATE TABLE house_points (
    id INTEGER NOT NULL AUTO_INCREMENT,
    giver INTEGER, 
    receiver INTEGER, 
    points INTEGER,
    PRIMARY KEY (id),
    FOREIGN KEY (giver) REFERENCES person(id), 
    FOREIGN KEY (receiver) REFERENCES person(id)
);
INSERT INTO house_points (giver,receiver,points)VALUES

((SELECT id FROM person WHERE first_name='Severus' AND last_name='Snape'),
 (SELECT id FROM person WHERE first_name='Harry' AND last_name='Potter'),-50),
 ((SELECT id FROM person WHERE first_name='Severus' AND last_name='Snape'),
 (SELECT id FROM person WHERE first_name='Ron' AND last_name='Weasley'),-50),
  ((SELECT id FROM person WHERE first_name='Severus' AND last_name='Snape'),
 (SELECT id FROM person WHERE first_name='Hermione' AND last_name='Granger'),-50),
 ((SELECT id FROM person WHERE first_name='Minerva' AND last_name='McGonagall'),
 (SELECT id FROM person WHERE first_name='Harry' AND last_name='Potter'),50),
 ((SELECT id FROM person WHERE first_name='Albus' AND last_name='Dumbledore'),
 (SELECT id FROM person WHERE first_name='Harry' AND last_name='Potter'),100),
 ((SELECT id FROM person WHERE first_name='Pomona' AND last_name='Sprout'),
 (SELECT id FROM person WHERE first_name='Hermione' AND last_name='Granger'),20),
((SELECT id FROM person WHERE first_name='Severus' AND last_name='Snape'),31, 20),
((SELECT id FROM person WHERE first_name='Severus' AND last_name='Snape'), 40, 50),
((SELECT id FROM person WHERE first_name='Minerva' AND last_name='McGonagall'),42,100),
((SELECT id FROM person WHERE first_name='Minerva' AND last_name='McGonagall'),44,-80),
((SELECT id FROM person WHERE first_name='Minerva' AND last_name='McGonagall'),60,30);




SELECT * FROM house;
SELECT * FROM person;
SELECT * FROM house_points;