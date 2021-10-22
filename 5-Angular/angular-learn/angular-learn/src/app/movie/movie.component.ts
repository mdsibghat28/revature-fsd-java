import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from './model/movie';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {

  // movie: Movie ={
  //   id: 1,
  //   title: 'Joker',
  //   genres: [
  //     {id: 4, name: "Thriller"},
  //     {id: 5, name: "Drama"}
  //   ],
  //   releaseDate: new Date(2019, 7, 31),
  //   mpaaRating: {id: 13, name: "PG-13"},
  //   rating: 8.5,
  //   duration: 122,
  //   budget: 70000000,
  //   bookingsOpen: true
  // };
  // movie: Movie = movies[4];
  @Input() 
  movie!: Movie;

  @Output() 
  favoriteSelected : EventEmitter<boolean> = new EventEmitter();

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  toggleFavorite() : void {
    this.movie.favorite = !this.movie.favorite;
    this.favoriteSelected.emit(this.movie.favorite);
  }

  showEdit(){
    this.router.navigate(['/edit-movie', this.movie.id]);
  }

}
