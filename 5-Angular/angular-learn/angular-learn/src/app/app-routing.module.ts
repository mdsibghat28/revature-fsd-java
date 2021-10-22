import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MovieListComponent } from './movie-list/movie-list.component';
import { EditMovieComponent } from './edit-movie/edit-movie.component';
import { ProfileComponent } from './profile/profile.component';

const routes: Routes = [
  {path: 'movie-list', component: MovieListComponent},
  {path: 'edit-movie/:id', component: EditMovieComponent},
  {path: 'profile', component: ProfileComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
