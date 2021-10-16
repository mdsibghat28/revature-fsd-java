import { Genre } from "./genre";
import { MpaaRating } from "./mpaa-rating";

export interface Movie {
  id: number,
  title: string,
  genres: Genre[],
  releaseDate: Date,
  mpaaRating: MpaaRating,
  rating: number,
  duration: number,
  budget: number,
  bookingsOpen: boolean
}