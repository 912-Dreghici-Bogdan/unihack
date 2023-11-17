CREATE DATABASE Timisoara
USE Timisoara

CREATE TABLE Utilizator(
	UserName VARCHAR(50) Primary key,
	Name VARCHAR(50),
	LastName VARCHAR(50),
	Email VARCHAR(50),
	Phone VARCHAR(10)
);

CREATE TABLE Product(
	ProductName VARCHAR(50) Primary key,
);

CREATE TABLE Ingredient(
	IngredientName VARCHAR(50) Primary key,
);

CREATE TABLE ProductContains(
	ProductName VARCHAR(50),
	IngredientName VARCHAR(50),
	Primary key(ProductName, IngredientName),
 FOREIGN KEY (ProductName) REFERENCES Product(ProductName),
 FOREIGN KEY (IngredientName) REFERENCES Ingredient(IngredientName)
);

CREATE TABLE HealthCondition (
    NameCondition VARCHAR(50) Primary key,
    ConditionType VARCHAR(10) -- 'Allergy' or 'Disease'
);

CREATE TABLE Allergies (
    NameAllergy VARCHAR(50) Primary key,
    FOREIGN KEY (NameAllergy) REFERENCES HealthCondition(NameCondition)
);

CREATE TABLE Disease (
    NameDisease VARCHAR(50) Primary key,
    FOREIGN KEY (NameDisease) REFERENCES HealthCondition(NameCondition)
);

CREATE TABLE Medication (
    NameMedication VARCHAR(50) Primary key,
    FOREIGN KEY (NameMedication) REFERENCES HealthCondition(NameCondition)
);

CREATE TABLE Restriction (
    NameCondition VARCHAR(50),
    IngredientName VARCHAR(50),
    Primary key(NameCondition, IngredientName),
    FOREIGN KEY (NameCondition) REFERENCES HealthCondition(NameCondition),
    FOREIGN KEY (IngredientName) REFERENCES Ingredient(IngredientName)
);

CREATE TABLE IsSuffering (
    NameCondition VARCHAR(50),
    UserName VARCHAR(50),
    Primary key(NameCondition, UserName),
    FOREIGN KEY (NameCondition) REFERENCES HealthCondition(NameCondition),
    FOREIGN KEY (UserName) REFERENCES Utilizator(UserName)
);

