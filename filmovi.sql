CREATE TABLE movies(
   name             VARCHAR(31) NOT NULL PRIMARY KEY
  ,country          VARCHAR(14) NOT NULL
  ,year             INTEGER  NOT NULL
  ,duration_min     INTEGER  NOT NULL
  ,genre0           VARCHAR(9) NOT NULL
  ,genre1           VARCHAR(9) NOT NULL
  ,directorname     VARCHAR(12) NOT NULL
  ,directorsurname  VARCHAR(10) NOT NULL
  ,MPA_rating       VARCHAR(5) NOT NULL
  ,budget_          INTEGER  NOT NULL
  ,gross_           INTEGER  NOT NULL
  ,rating_IMDb      NUMERIC(3,1) NOT NULL
  ,actors0name      VARCHAR(9) NOT NULL
  ,actors0surname   VARCHAR(9) NOT NULL
  ,actors1name      VARCHAR(10) NOT NULL
  ,actors1surname   VARCHAR(8) NOT NULL
);
INSERT INTO mytable(name,country,year,duration_min,genre0,genre1,directorname,directorsurname,MPA_rating,budget_,gross_,rating_IMDb,actors0name,actors0surname,actors1name,actors1surname) VALUES ('Dune','United States',2021,155,'Action','Adventure','Denis','Villeneuve','PG-13',165000000,223211174,8.3,'Timothee','Chalamet','Rebecca','Ferguson');
INSERT INTO mytable(name,country,year,duration_min,genre0,genre1,directorname,directorsurname,MPA_rating,budget_,gross_,rating_IMDb,actors0name,actors0surname,actors1name,actors1surname) VALUES ('Pulp Fiction','United States',2021,154,'Crime','Drama','Quentin','Tarantino','R',8000000,213928762,8.9,'John','Travolta','Uma','Thurman');
INSERT INTO mytable(name,country,year,duration_min,genre0,genre1,directorname,directorsurname,MPA_rating,budget_,gross_,rating_IMDb,actors0name,actors0surname,actors1name,actors1surname) VALUES ('The Shining','United States',1980,146,'Drama','Horror','Stanley','Kubrick','R',19000000,46998772,8.4,'Jack','Nicholson','Shelley','Duvall');
INSERT INTO mytable(name,country,year,duration_min,genre0,genre1,directorname,directorsurname,MPA_rating,budget_,gross_,rating_IMDb,actors0name,actors0surname,actors1name,actors1surname) VALUES ('The Dark Knight','United States',2008,152,'Action','Crime','Jonathan','Nolan','PG-13',185000000,1005973645,9.0,'Christian','Bale','Heath','Ledger');
INSERT INTO mytable(name,country,year,duration_min,genre0,genre1,directorname,directorsurname,MPA_rating,budget_,gross_,rating_IMDb,actors0name,actors0surname,actors1name,actors1surname) VALUES ('Monty Python and the Holy Grail','United Kingdom',1975,91,'Adventure','Comedy','Terry','Gilliam','PG',315780,1940906,8.2,'Graham','Chapman','John','Cleese');
INSERT INTO mytable(name,country,year,duration_min,genre0,genre1,directorname,directorsurname,MPA_rating,budget_,gross_,rating_IMDb,actors0name,actors0surname,actors1name,actors1surname) VALUES ('Monty Python''s Life of Brian','United Kingdom',1979,94,'Comedy','Satire','Terry','Jones','R',4000000,20742852,8.1,'Graham','Chapman','John','Cleese');
INSERT INTO mytable(name,country,year,duration_min,genre0,genre1,directorname,directorsurname,MPA_rating,budget_,gross_,rating_IMDb,actors0name,actors0surname,actors1name,actors1surname) VALUES ('Parasite','South Korea',2019,132,'Comedy','Drama','Bong','Joon-ho','R',11400000,258668626,8.6,'Kang-ho','Sung','Sun-kyun','Lee');
INSERT INTO mytable(name,country,year,duration_min,genre0,genre1,directorname,directorsurname,MPA_rating,budget_,gross_,rating_IMDb,actors0name,actors0surname,actors1name,actors1surname) VALUES ('The Sixth Sense','United States',1999,107,'Drama','Mystery','M. Night','Shyamalan','PG-13',40000000,672806432,8.1,'Bruce','Willis','Haley Joel','Osment');
INSERT INTO mytable(name,country,year,duration_min,genre0,genre1,directorname,directorsurname,MPA_rating,budget_,gross_,rating_IMDb,actors0name,actors0surname,actors1name,actors1surname) VALUES ('The Truman Show','United States',1998,103,'Comedy','Drama','Peter','Weir','PG',60000000,264118201,8.1,'Jim','Carrey','Ed','Harris');
INSERT INTO mytable(name,country,year,duration_min,genre0,genre1,directorname,directorsurname,MPA_rating,budget_,gross_,rating_IMDb,actors0name,actors0surname,actors1name,actors1surname) VALUES ('Trainspotting','United Kingdom',1996,93,'Drama','Comedy','Danny','Boyle','R',2062320,16771303,8.1,'Ewan','McGregor','Ewen','Bremner');
INSERT INTO mytable(name,country,year,duration_min,genre0,genre1,directorname,directorsurname,MPA_rating,budget_,gross_,rating_IMDb,actors0name,actors0surname,actors1name,actors1surname) VALUES ('A Clockwork Orange','United Kingdom',1971,136,'Crime','Drama','Stanley','Kubrick','R',2200000,26904636,8.3,'Malcolm','McDowell','Patrick','Magee');
INSERT INTO mytable(name,country,year,duration_min,genre0,genre1,directorname,directorsurname,MPA_rating,budget_,gross_,rating_IMDb,actors0name,actors0surname,actors1name,actors1surname) VALUES ('Scary Movie','United States',2000,88,'Comedy','Horror','Keenen Ivory','Wayans','R',19000000,278019771,6.2,'Anna','Faris','Jon','Abrahams');
