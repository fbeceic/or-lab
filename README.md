# Kataloški skup podataka - **Filmovi**

<br/>

**Licenca**: Creative Commons Zero v1.0 Universal

**Autor**: Felix Bečeić

**Verzija skupa podataka**: 1.0

**Jezik u kojemu se nalaze podaci**: engleski

**Baza podataka**: PostgreSQL

## Opis atributa entiteta:

### Entitet _movie_:

- **id** - primarni ključ entiteta, jedinstvena oznaka (INT)
- **name** - ime filma (VARCHAR(50))
- **country** - zemlja porijekla filma (VARCHAR(40))
- **year** - godina izlaska filma (INT)
- **duration_min** - trajanje filma u minutama (INT)
- **genre1** - žanr #1 filma (VARCHAR(20))
- **genre2** - žanr #2 filma (VARCHAR(20))
- **directorid** - strani ključ koji označava id redatelja (INT)
  - 1,1 kardinalnost između filma i redatelja (film režisira točno jedan redatelj)
  - 1,n kardinalnost između redatelja i filma (jedan redatelj može režisirati jedan ili više filmova)
- **mparating** - dobna granica po sustavu Američke filmske asocijacije (VARCHAR(10))
- **budget_$** - budžet za izradu filma izražen u dolarima (INT)
- **gross_$** - svjetska zarada filma izražena u dolarima (INT)
- **ratingimdb** - ocjena filma na web stranici IMDb (NUMERIC(3,1))

### Entitet _director_:

- **id** - primarni ključ entiteta, jedinstvena oznaka (INT)
- **directorname** - ime redatelja (VARCHAR(40))
- **directorsurname** - prezime redatelja (VARCHAR(40))

### Entitet _actor_:

- **id** - primarni ključ entiteta, jedinstvena oznaka (INT)
- **actorname** - ime glumca (VARCHAR(40))
- **actorsurname** - prezime glumca (VARCHAR(40))

### Entitet _casting_:

#### NAPOMENA: ovaj entitet nastao je kao join tablica zbog many-to-many konekcije između _actor_ i _movie_ entiteta

- **actorid** - strani ključ koji označava id glumca (INT)
- **movieid** - strani ključ koji označava id filma (INT)
  - 1,n kardinalnost između filma i glumca (u filmu može glumiti jedan ili više glumaca)
  - 1,n kardinalnost između glumca i filma (glumac je mogao glumiti u jednom ili više filmova)
  - dolazi do kreiranja join tablice u kojoj se uparuju glumci s filmovima
  
## SQL -> JSON:

Izdvajanje podataka u oblik JSON vrši se SQL upitima kojima se svi podaci stavljaju unutar jednog objekta s 
jasnom parent-child hijerarhijom, uz uklanjanje bespotrebnih atributa kao što je id.
Kod kojim se u PostgreSQL-u izdvajaju podaci u oblik JSON:

    WITH j AS (
    SELECT movie.name,movie.country,movie.year,movie.duration_min, movie.genre1, movie.genre2,
        ( 
            SELECT row_to_json(d) 
            FROM ( 
                SELECT directorname,directorsurname FROM director WHERE director.id = movie.directorid) d
        ) AS director,
        movie.budget_$, movie.gross_$,movie.mpaRating,movie.ratingIMDb,
        (
            SELECT json_agg((SELECT x FROM (SELECT a.actorname,a.actorsurname) AS x))
            FROM actor a
            JOIN casting c ON a.id=c.actorid
            WHERE movie.id=c.movieid
        ) AS actors
    FROM movie)
    SELECT json_agg(row_to_json(j)) as movies FROM j;

## SQL -> CSV:

Izdvajanje podataka u oblik CSV vrši se SQL upitima u kojima se zbog parent-child veza na pojedinim mjestima
podaci roditelja ponavljaju radi očuvanja podataka bez povećanja broja stupaca.
Kod kojim se u PostgreSQL-u izdvajaju podaci u oblik CSV:

    COPY
    (SELECT movie.name,movie.country,movie.year,movie.duration_min, movie.genre1, movie.genre2,
        (
        SELECT * FROM ( 
                SELECT directorname FROM director WHERE director.id = movie.directorid) tempname
        ) AS directorname,
        (
        SELECT * FROM ( 
                SELECT directorsurname FROM director WHERE director.id = movie.directorid) tempsurname
        ) AS directorsurname,
        movie.budget_$, movie.gross_$,movie.mpaRating,movie.ratingIMDb,
        (
        SELECT * FROM ( 
                SELECT actorname FROM actor WHERE actor.id = actorid) tempname
        ) AS actorname,
            (
        SELECT * FROM ( 
                SELECT actorsurname FROM actor WHERE actor.id = actorid) tempsurname
        ) AS actorsurname
    FROM casting INNER JOIN movie ON movie.id=casting.movieid)
    TO
    'C:\filmovi.csv' DELIMITER ',' CSV HEADER;


