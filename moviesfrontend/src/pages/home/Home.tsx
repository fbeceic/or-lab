import React, { useEffect, useState } from "react";
import PageContainer from "../../components/PageContainer";
import ReadMe from "../../components/ReadMe";
import IconButton from "../../components/IconButton";
import { CloudDownloadIcon } from "@heroicons/react/solid";
import CsvDownload from "react-json-to-csv";
import { Movie } from "../../types";

export default function Home() {
  const [movies, setMovies] = useState<Movie[]>([]);

  useEffect(() => {
    fetch("/movies")
      .then((data) => data.json())
      .then((movies) => setMovies(movies));
  }, []);

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

  return (
    <PageContainer>
      <ReadMe />
      <div className="flex flex-row space-x-4 mb-4">
        <IconButton
          className="bg-indigo-600"
          label="Preuzmi JSON"
          onClick={downloadJSON}
          icon={CloudDownloadIcon}
        />

        <CsvDownload data={movies} filename="movies_dataset.csv">
          <IconButton
            className="bg-indigo-600"
            label="Preuzmi CSV"
            onClick={() => {}}
            icon={CloudDownloadIcon}
          />
        </CsvDownload>
      </div>
    </PageContainer>
  );
}
