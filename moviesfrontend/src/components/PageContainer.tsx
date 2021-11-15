import React from "react";
import { Helmet } from "react-helmet";

type ContainerProps = {
  children: React.ReactNode;
};
export default function PageContainer({ children }: ContainerProps) {
  return (
    <div className="flex justify-start flex-col items-center flex-grow">
      <Helmet>
        <title>Movies Dataset</title>
        <meta charSet="utf-8" />
        <meta
          name="Description"
          content="movies dataset with the ability to filter and download the dataset"
        />
        <meta name="Keywords" content="JSON, CSV, database, async, dataset" />
        <meta name="Author" content="Felix Bečeić" />
      </Helmet>
      {children}
    </div>
  );
}
