import React, { useEffect, useState } from "react";
import PageContainer from "../components/PageContainer";
import cx from "classnames";
import * as yup from "yup";
import IconButton from "../components/IconButton";
import { CloudDownloadIcon } from "@heroicons/react/solid";
import { Movie, Term } from "../types";
import { Formik, FormikProps } from "formik";
import FilterForm from "../components/FilterForm";
import Title from "../components/Title";
import Button from "../components/Button";
import CsvDownload from "react-json-to-csv";
import { useAuth0 } from "@auth0/auth0-react";

export default function DataTable() {
  const [movies, setMovies] = useState<Movie[]>([]);
  const [number, setNumber] = useState(5);
  const [page, setPage] = useState(1);
  const [buttons, setButtons] = useState([
    <Button
      label=""
      className="bg-gray-100 text-gray-800"
      onClick={() => setNumber(3)}
    />,
  ]);
  const [searchTerm, setSearchTerm] = useState("");
  const [find, setFind] = useState(false);
  const [filter, setFilter] = useState("");
  const [all, setAll] = useState(false);
  const { isAuthenticated, loginWithRedirect } = useAuth0();

  const downloadJSON = async () => {
    const fileName = "movies_dataset";
    const json = JSON.stringify(movies);
    const blob = new Blob([json], { type: "application/json" });
    const href = URL.createObjectURL(blob);
    const link = document.createElement("a");
    link.href = href;
    link.download = fileName + ".json";
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
  };

  const validationSchema = yup.object().shape({
    term: yup.string().optional(),
    choice: yup.string().optional(),
    number: yup.string().optional(),
  });

  const columnClass = cx({
    "px-4 py-2 text-gray-500 text-center text-sm": true,
  });

  const columnContentClass = cx({
    "px-4 py-2 text-left bg-gray-50 text-gray-800": true,
  });

  useEffect(() => {
    fetch("/movies")
      .then((data) => data.json())
      .then((movies) => setMovies(movies));
  }, [all]);

  useEffect(() => {
    fetch("/movies/" + filter + "/" + searchTerm, {})
      .then((data) => {
        if (data.ok) {
          return data.json();
        } else {
          throw new Error("Can't fetch this right now.");
        }
      })
      .then((movies) => setMovies(movies))
      .catch((error) => {
        console.log(error);
      });
  }, [find, filter, searchTerm]);

  useEffect(() => {
    setButtons([]);
    for (let i = 0; i < movies.length / number; i++) {
      let mark = (i + 1).toString();
      setButtons((buttons) => [
        ...buttons,
        <div className="flex flex-col">
          <Button
            className="bg-gray-50 px-3 py-2 hover:bg-gray-100 text-gray-700"
            label={mark}
            onClick={() => setPage(i + 1)}
          />
        </div>,
      ]);
    }
  }, [number, movies.length]);

  const onSubmit = (values: Term) => {
    if (values.term === "") {
      setAll(!all);
      setSearchTerm("");
    } else {
      setSearchTerm(values.term);
      setPage(1);
      switch (values.choice) {
        case "Sva polja (wildcard)":
          setFilter("wildcard");
          setFind(!find);
          break;
        case "Ime filma (name)":
          setFilter("name");
          setFind(!find);
          break;
        case "Zemlja (country)":
          setFilter("country");
          setFind(!find);
          break;
        case "Godina (year)":
          setFilter("year");
          setFind(!find);
          break;
        case "Trajanje (duration)":
          setFilter("duration");
          setFind(!find);
          break;
        case "Žanr (genre)":
          setFilter("genre");
          setFind(!find);
          break;
        case "Redatelj (director)":
          setFilter("director");
          setFind(!find);
          break;
        case "Glumci (actors)":
          setFilter("actor");
          setFind(!find);
          break;
        case "Dobna granica (MPA rating)":
          setFilter("mparating");
          setFind(!find);
          break;
        case "Budžet (budget)":
          setFilter("budget");
          setFind(!find);
          break;
        case "Zarada (gross)":
          setFilter("gross");
          setFind(!find);
          break;
        case "IMDb ocjena (IMDb rating)":
          setFilter("imdb");
          setFind(!find);
          break;
      }
    }
    switch (values.number) {
      case "3":
        setNumber(3);
        setPage(1);
        break;
      case "5":
        setNumber(5);
        setPage(1);
        break;
      case "10":
        setNumber(10);
        setPage(1);
        break;
    }
  };

  if (!isAuthenticated) {
    return <div>{loginWithRedirect()}</div>;
  }

  return (
    <PageContainer>
      <div className="text-lg items-center my-3 font-light">
        <Title text="Kataloški skup podataka - Filmovi" className="text-2xl" />
      </div>
      <div className="flex justify-between flex-row items-start w-full mt-1">
        <Formik
          initialValues={{ term: "", choice: "", number: "5" } as Term}
          onSubmit={onSubmit}
          validationSchema={validationSchema}
        >
          {({ handleSubmit }: FormikProps<any>) => (
            <form
              onChange={handleSubmit}
              className="flex justify-between flex-row items-start self-start w-full px-2"
            >
              <FilterForm />
            </form>
          )}
        </Formik>
      </div>
      <table className="table table-striped w-full">
        <thead className="bg-gray-100">
          <tr>
            <th className={columnClass}> No.</th>
            <th className={columnClass}> Name</th>
            <th className={columnClass}> Country</th>
            <th className={columnClass}> Year</th>
            <th className={columnClass}>
              Duration
              <br />
              (min)
            </th>
            <th className={columnClass}> Genre</th>
            <th className={columnClass}> Director</th>
            <th className={columnClass}> Actors</th>
            <th className={columnClass}>
              MPA <br />
              Rating
            </th>
            <th className={columnClass}> Budget ($)</th>
            <th className={columnClass}> Gross ($)</th>
            <th className={columnClass}>
              IMDb <br />
              Rating
            </th>
          </tr>
        </thead>
        <tbody>
          {movies.map(
            (movie) =>
              ((movies.indexOf(movie) + 1 <= number && page === 1) ||
                (movies.indexOf(movie) + 1 > number &&
                  page !== 1 &&
                  movies.indexOf(movie) + 1 <= page * number &&
                  movies.indexOf(movie) + 1 > number * (page - 1))) && (
                <tr key={movie.id}>
                  <td className={columnContentClass}>{movie.id}</td>
                  <td className={columnContentClass}>{movie.name}</td>
                  <td className={columnContentClass}>{movie.country}</td>
                  <td className={columnContentClass}>{movie.year}</td>
                  <td className={columnContentClass}>{movie.duration}</td>
                  <td className={columnContentClass}>
                    {movie.genre1}, {movie.genre2}
                  </td>
                  <td className={columnContentClass}>
                    {movie.director.name} {movie.director.surname}
                  </td>
                  <td className={columnContentClass}>
                    {movie.actors[0].name} {movie.actors[0].surname},<br />
                    {movie.actors[1].name} {movie.actors[1].surname}
                  </td>
                  <td className={columnContentClass}>{movie.mparating}</td>
                  <td className={columnContentClass}>{movie.budget}</td>
                  <td className={columnContentClass}>{movie.gross}</td>
                  <td className={columnContentClass}>{movie.rating}</td>
                </tr>
              )
          )}
        </tbody>
      </table>
      <div className="flex flex-row w-full justify-between px-6 bg-gray-50 items-center">
        <div className="text-s">
          {number * page <= movies.length
            ? `Prikazuje se ${page * number - number + 1} do ${
                number * page
              } od ${movies.length} unosa`
            : `Prikazuje se ${page * number - number + 1} do ${
                movies.length
              } od ${movies.length} unosa`}
        </div>
        <div className="flex flex-row space-x-2">
          <IconButton
            className="bg-gray-400 hover:bg-gray-500"
            label="Preuzmi JSON"
            onClick={downloadJSON}
            icon={CloudDownloadIcon}
          />

          <CsvDownload data={movies} filename="movies_dataset.csv">
            <IconButton
              className="bg-gray-400 hover:bg-gray-500"
              label="Preuzmi CSV"
              onClick={() => {}}
              icon={CloudDownloadIcon}
            />
          </CsvDownload>
        </div>
        <div className="flex items-start flex-row my-4 space-x-5">
          {buttons}
        </div>
      </div>
    </PageContainer>
  );
}
