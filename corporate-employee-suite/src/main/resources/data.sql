DROP TABLE IF EXISTS HealthIndex;
CREATE TABLE HealthIndex (
  UserName VARCHAR(25)  PRIMARY KEY,
  First_Name VARCHAR(50) NOT NULL,
  Last_Name VARCHAR(50) NOT NULL,
  Temparature INT not NULL,
  DryCough boolean not null,
  BloodPressure INT not null,
  Headache boolean not null,
  Status VARCHAR(15) not null,
  LastUpdatedDate timestamp not null
);

DROP TABLE IF EXISTS Seat;

CREATE TABLE  Seat (
  id int primary key,
  Floor VARCHAR(50) not null,
  Section VARCHAR(50) NOT NULL,
  SeatNumber VARCHAR(50) NOT NULL,
  AdminOpened boolean,
  UserAllocated boolean
);

DROP TABLE IF EXISTS EmployeeSeat;
CREATE TABLE  EmployeeSeat (
id int primary key,
  Floor VARCHAR(50) not null,
  Section VARCHAR(50) NOT NULL,
  SeatNumber VARCHAR(50) NOT NULL,
  UserName VARCHAR(25)  not null,
  FOREIGN KEY (Floor) REFERENCES Seat(Floor),
  FOREIGN KEY (Section) REFERENCES Seat(Section),
  FOREIGN KEY (SeatNumber) REFERENCES Seat(SeatNumber),
  FOREIGN KEY (UserName) REFERENCES Employee(UserName),
  Login timestamp,
  Logout timestamp
);

DROP TABLE IF EXISTS Employee;

CREATE TABLE  Employee (
  UserName VARCHAR(25)  PRIMARY KEY,
  First_Name VARCHAR(50) NOT NULL,
  Last_Name VARCHAR(50) NOT NULL,
  Department VARCHAR(50) NOT NULL
);


