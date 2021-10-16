import { Component, OnInit } from '@angular/core';
import { Movie } from './model/movie';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {

  movie: Movie ={
    id: 1,
    title: 'Joker',
    genres: [
      {id: 4, name: "Thriller"},
      {id: 5, name: "Drama"}
    ],
    releaseDate: new Date(2019, 7, 31),
    mpaaRating: {id: 13, name: "PG-13"},
    rating: 8.5,
    duration: 122,
    budget: 70000000,
    bookingsOpen: true
  };
  constructor() { }

  ngOnInit(): void {
  }

}
