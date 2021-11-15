export type Actor = {
  id: number;
  name: string;
  surname: string;
};

export type Director = {
  id: number;
  name: string;
  surname: string;
};

export type Movie = {
  id: number;
  name: string;
  country: string;
  year: number;
  duration: number;
  genre1: string;
  genre2: string;
  director: Director;
  actors: Actor[];
  mparating: string;
  budget: number;
  gross: number;
  rating: number;
};

export type Term = {
  term: string;
  choice: string;
  number: string;
};
