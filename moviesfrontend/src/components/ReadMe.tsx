import React from "react";
import Title from "./Title";

export default function ReadMe() {
  return (
    <div className="flex text-xl flex-col items-center flex-grow">
      <div className="flex text-xl flex-col items-center mb-3 font-light">
        <Title text="Kataloški skup podataka - Filmovi" />
        <header>Licenca: Creative Commons Zero v1.0 Universal</header>
        <header>Autor: Felix Bečeić</header>
        <header>Verzija skupa podataka: 1.0</header>
        <header>Jezik u kojemu se nalaze podaci: engleski </header>
        <header>Baza podataka: PostgreSQL</header>
      </div>
      <div className="flex text-xl flex-row mb-3 mx-10 mt-10">
        <div className="items-center">
          <h3 className="text-xl mb-3 font-semibold">Entitet movie:</h3>
          - id: primarni ključ entiteta, jedinstvena oznaka (INT) <br />
          - name: ime filma (VARCHAR(50)) <br />
          - country: zemlja porijekla filma (VARCHAR(40)) <br />
          - year: godina izlaska filma (INT) <br />
          - duration_min: trajanje filma u minutama (INT) <br />
          - genre1: žanr #1 filma (VARCHAR(20)) <br />
          - genre2: žanr #2 filma (VARCHAR(20)) <br />
          - directorid: strani ključ koji označava id redatelja (INT) <br />
          --- 1,1 kardinalnost između filma i redatelja
          <br />
          --- 1,n kardinalnost između redatelja i filma
          <br />
          - mparating: dobna granica po sustavu Američke filmske asocijacije
          (VARCHAR(10)) <br />
          - budget_$: budžet za izradu filma izražen u dolarima (INT) <br />
          - gross_$: svjetska zarada filma izražena u dolarima (INT) <br />
          - ratingimdb: ocjena filma na web stranici IMDb (NUMERIC(3,1)) <br />
        </div>
        <div className="ml-10">
          <h3 className="text-xl mb-3 font-semibold">Entitet director:</h3>
          - id: primarni ključ entiteta, jedinstvena oznaka (INT) <br />
          - directorname: ime redatelja (VARCHAR(40)) <br />
          - directorsurname - prezime redatelja (VARCHAR(40)) <br />
          <h3 className="text-xl my-3 font-semibold">Entitet actor:</h3>
          - id: primarni ključ entiteta, jedinstvena oznaka (INT) <br />
          - actorname: ime glumca (VARCHAR(40)) <br />
          - actorsurname: prezime glumca (VARCHAR(40)) <br />
          <h3 className="text-xl my-3 font-semibold">Entitet casting:</h3>
          <h4 className="font-normal my-2">
            <i>NAPOMENA: </i> ovaj entitet nastao je kao join tablica zbog
            many-to-many konekcije <br /> između actor i movie entiteta actor
          </h4>
          - id: strani ključ koji označava id glumca (INT) <br />
          - movieid: strani ključ koji označava id filma (INT) <br />
          --- 1,n kardinalnost između filma i glumca <br />
          --- 1,n kardinalnost između glumca i filma <br />
          --- dolazi do kreiranja join tablice u kojoj se uparuju glumci s
          filmovima
        </div>
      </div>
    </div>
  );
}
