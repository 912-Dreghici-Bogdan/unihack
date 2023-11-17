Create database supply_store_1
go
use supply_store_1
go


 CREATE TABLE Managers
 (Mid INT PRIMARY KEY IDENTITY,
 Name varchar(50),
 Sales int)

CREATE TABLE Stores_1
( Mid int FOREIGN KEY REFERENCES Managers(Mid),
Stid INT PRIMARY KEY IDENTITY,
City varchar(50) NOT NULL,
NoOfClients int,
NoOfStores int)

CREATE TABLE Product_Types1
(Tid INT PRIMARY KEY IDENTITY,
Type varchar(50) DEFAULT 'INFRASTRUCTURE',
NoOfProd int)

CREATE TABLE Products_1
(Pid INT PRIMARY KEY IDENTITY,
Name varchar(50),
Quantity int CHECK (Quantity =1 or Quantity = 2),
Price int,
Tid int FOREIGN KEY REFERENCES Product_Types1(Tid)
)




  CREATE TABLE Salesmans_1
(
Stid int FOREIGN KEY REFERENCES Stores_1(Stid),
Sid INT PRIMARY KEY IDENTITY,
Name varchar(50),
NoOfSales int,)

CREATE TABLE Orders_1
(Sid int FOREIGN KEY REFERENCES Salesmans_1(Sid),
Oid int PRIMARY KEY IDENTITY,
  Ptid int FOREIGN KEY REFERENCES Products_1(Pid),
  NoOfProducts int)


SET IDENTITY_INSERT Managers on
insert into Managers(Mid, Name, Sales) VALUES (1, 'Marcel Bogdan',34)
insert into Managers(Mid, Name, Sales) VALUES (2, 'Marian Micu',12)
SET IDENTITY_INSERT Managers off

SET IDENTITY_INSERT Stores_1 on
insert into Stores_1(Mid, Stid, City, NoOfClients,NoOfStores) VALUES (1, 1,'Brasov',34,1)
insert into Stores_1(Mid, Stid, City, NoOfClients,NoOfStores) VALUES (2, 2, 'Sighisoara',12,1)
SET IDENTITY_INSERT Stores_1 off

SET IDENTITY_INSERT Salesmans_1 on
insert into Salesmans_1(Stid,Sid,Name,NoOfSales) VALUES (1,1,'Mihai Neagu',12)
insert into Salesmans_1(Stid,Sid,Name,NoOfSales) VALUES (1,2,'Alex Margineanu',10)
insert into Salesmans_1(Stid,Sid, Name,NoOfSales) VALUES (1,3,'George Micu', 12)
SET IDENTITY_INSERT Salesmans_1 off

SET IDENTITY_INSERT Product_Types1 on
insert into Product_Types1(Tid,Type,NoOfProd) VALUES (1,'Furniture', 4)
insert into Product_Types1(Tid,Type,NoOfProd) VALUES (2, 'Bolts and nuts',2)
insert into Product_Types1(Tid,Type,NoOfProd) VALUES (3, 'Kitchen',0)
SET IDENTITY_INSERT Product_Types1 off

SET IDENTITY_INSERT Products_1 on
insert into Products_1(Pid,Name,Quantity,Price,Tid) VALUES (1,'Chair',1,70,1)
insert into Products_1(Pid,Name,Quantity,Price,Tid) VALUES (2,'Table',2,120,1)
insert into Products_1(Pid,Name,Quantity,Price,Tid) VALUES (3,'Sofa',1,450,1)
insert into Products_1(Pid,Name,Quantity,Price,Tid) VALUES (4,'Desk',2,350,1)
insert into Products_1(Pid,Name,Quantity,Price,Tid) VALUES (7,'Sauna',2,670,1)

insert into Products_1(Pid,Name,Quantity,Price,Tid) VALUES (5,'Hex Bolts',2,2,2)
insert into Products_1(Pid,Name,Quantity,Price,Tid) VALUES (6,'Flange Bolts',2,1.20,2)
insert into Products_1(Pid,Name,Quantity,Price,Tid) VALUES (8,'Nut',2,2,2)
insert into Products_1(Pid,Name,Quantity,Price,Tid) VALUES (9,'Saw',2,2,2)


SET IDENTITY_INSERT Products_1 off

SET IDENTITY_INSERT Orders_1 on
insert into Orders_1(Sid,Oid,Ptid,NoOfProducts) VALUES (1,1,5,35)
insert into Orders_1(Sid,Oid,Ptid,NoOfProducts) VALUES (1,2,2,1)
insert into Orders_1(Sid,Oid,Ptid,NoOfProducts) VALUES (2,3,6,25)
insert into Orders_1(Sid,Oid,Ptid,NoOfProducts) VALUES (3,4,3,1)
SET IDENTITY_INSERT Orders_1 off

select * from Managers
select * from Stores_1
select * from Product_Types1
select * from Salesmans_1
select * from Products_1
	
UPDATE Products_1
SET Price = 451
Where Pid = 9
UPDATE Products_1
SET Price = 2
WHERE Name Like 'H__%' AND Quantity = 2 AND Price is not null

UPDATE Salesmans_1
SET NoOfSales = NoOfSales+14
WHERE  Sid = 2

UPDATE Stores_1
SET NoOfClients = NoOfClients + 14
WHERE Stid =1

UPDATE Managers
SET Sales = Sales+14
WHERE Mid = 1 OR Mid =2

delete from Stores_1 WHERE NoOfClients between 0 and 19
delete from Managers WHERE Sales<20

--a. 3 queries with UNION, INTERSECT, EXCEPT (one query per operator);

SELECT *
FROM Products_1
WHERE Name like 'S_%' AND Price >450

SELECT *
FROM Products_1
WHERE Name like 'S_%' 
UNION
SELECT *
FROM Products_1
WHERE Price >450

SELECT s1.Name
FROM Products_1 s1
WHERE Name like 'S_%'
INTERSECT
SELECT s2.Name
FROM Products_1 s2
WHERE Price > 450
ORDER BY s1.Name

SELECT s1.Name
FROM Products_1 s1
WHERE Name like 'S_%'
EXCEPT 
SELECT s2.Name
FROM Products_1 s2
WHERE Price > 450
ORDER BY s1.Name

--b. 4 queries with INNER JOIN, LEFT JOIN, RIGHT JOIN, FULL JOIN (one query per operator); one query will join at least 3 tables;

select *
from Orders_1 o INNER JOIN Products_1 p ON
o.Ptid =p.Tid

select * 
from Orders_1 o LEFT OUTER JOIN Products_1 p ON
o.Ptid=p.Tid

select * 
from Orders_1 o RIGHT OUTER JOIN Products_1 p ON
o.Ptid=p.Tid

select * 
from Orders_1 o FULL OUTER JOIN Products_1 p ON
o.Ptid=p.Tid FULL OUTER JOIN Salesmans_1 s ON s.Sid = o.Sid

--c. 2 queries using IN and EXISTS to introduce a subquery in the WHERE clause (one query per operator);
-- d. 1 query with a subquery in the FROM clause;
select p.Pid, p.Name
from Products_1 p
where Price >100 and p.Pid IN (select Pid from Orders_1)

select p.Pid, p.Name
from Products_1 p 
where Price >100 and EXISTS ( SELECT * FROM Orders_1 o where o.Ptid=p.Tid)

-- e. 3 queries with the GROUP BY clause, from which 2 queries will also contain the HAVING clause; 1 query from the latter 2 will also have a subquery in the HAVING 
--clause; use the aggregation operators: SUMM, AVG, MIN, MAX, COUNT. 

select p.Pid, p.Name, COUNT(o.Oid)
from Products_1 p INNER JOIN Orders_1 o ON p.Tid = o.Ptid
GROUP BY p.Pid,p.Name

select p.Tid, AVG(pp.Price) AS average_price
from Product_Types1 p LEFT JOIN Products_1 pp ON p.Tid=pp.Tid
GROUP BY p.Tid
HAVING AVG(pp.Price)<(select max(Price) from Products_1) 

select p.Tid, AVG(p.Price)
from Products_1 p RIGHT JOIN Product_Types1 pt ON pt.Tid = p.Tid
GROUP BY p.Tid
HAVING AVG(p.Price)>=(select min(Price) from Products_1)

select A.Tid, A.Name
from( select p.Tid, p.Name, pp.Tid as tt
             from Products_1 p LEFT JOIN Product_Types1 pp ON p.Tid=pp.Tid
			 where pp.NoOfProd !=0)A

select DISTINCT p.Price
from Products_1 p

select Name, Price
from Products_1
order by Price asc

select TOP 2 Name,Price
from Products_1