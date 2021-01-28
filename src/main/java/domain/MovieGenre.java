/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.PreparedStatement;
import java.util.Objects;

/**
 *
 * @author Mihailo
 */
public class MovieGenre implements GenericEntity{
    private Genre genre;
    private Movie movie;

    public MovieGenre() {
    }

    public MovieGenre(Genre genre, Movie movie) {
        this.genre = genre;
        this.movie = movie;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.genre);
        hash = 97 * hash + Objects.hashCode(this.movie);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MovieGenre other = (MovieGenre) obj;
        if (!Objects.equals(this.genre, other.genre)) {
            return false;
        }
        if (!Objects.equals(this.movie, other.movie)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MovieGenre{" + "genre=" + genre + ", movie=" + movie + '}';
    }

    @Override
    public String getTableName() {
        return "movie_genre";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "genreID, movieID";
    }

    @Override
    public void getInsertValues(PreparedStatement statement) throws Exception{
        statement.setLong(1, genre.getGenreID());
        statement.setLong(2, movie.getMovieID());
    }

    @Override
    public void setId(Long id) {
        
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnNamesForUpdate() {
        return "";
    }

    @Override
    public String getConditionForUpdate() {
        return "";
    }

    @Override
    public String getConditionForDelete() {
        return "movieID = " + movie.getMovieID();
    }

    @Override
    public String getColumnNamesForSelect() {
        return "g.name as gname, g.genreID as ggenreID ";
    }

    @Override
    public String getTableForSelect() {
        return "movie m JOIN movie_genre mg ON (m.movieID = mg.movieID) "
                + "JOIN genre g ON (mg.genreID = g.genreID)";
    }

    @Override
    public String getConditionForSelect() {
        return "mg.movieID = " + movie.getMovieID();
    }

    @Override
    public String getConditionForSelectSpecific() {
        return "";
    }
    
    
}
