import React from "react";
import Select from "./Select";
import Input from "./Input";

export default function FilterForm() {
  return (
    <React.Fragment>
      <div className="flex flex-row items-center mx-2 mt-6">
        Prikaži{" "}
        <Select
          name="number"
          label=""
          placeholder="Broj"
          options={["3", "5", "10"]}
          getOptionValue={(option) => option}
          getOptionLabel={(option) => option}
          className="mx-2"
        />{" "}
        unosa
      </div>
      <div className="flex flex-row space-x-2 mx-2">
        <Select
          name="choice"
          label="Filtriranje po pojedinom polju:"
          placeholder="Odaberite polje"
          options={[
            "Sva polja (wildcard)",
            "Ime filma (name)",
            "Zemlja (country)",
            "Godina (year)",
            "Trajanje (duration)",
            "Žanr (genre)",
            "Redatelj (director)",
            "Glumci (actors)",
            "Dobna granica (MPA rating)",
            "Budžet (budget)",
            "Zarada (gross)",
            "IMDb ocjena (IMDb rating)",
          ]}
          getOptionValue={(option) => option}
          getOptionLabel={(option) => option}
          className="mr-2"
        />
        <Input name="term" label="Polje za pretragu:" className="mr-2" />
      </div>
    </React.Fragment>
  );
}
