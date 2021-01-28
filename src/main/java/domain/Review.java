/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author Mihailo
 */
public class Review implements GenericEntity{
    private Long reviewID;
    private String reviewText;
    private int reviewScore;
    private LocalDateTime reviewDate;
    private Movie movie;
    private User user;

    public Review() {
    }

    public Review(Long reviewID, String reviewText, int reviewScore, Movie movie, User user) {
        this.reviewID = reviewID;
        this.reviewText = reviewText;
        this.reviewScore = reviewScore;
        this.movie = movie;
        this.user = user;
        this.reviewDate = LocalDateTime.now();
    }

    public Long getReviewID() {
        return reviewID;
    }

    public void setReviewID(Long reviewID) {
        this.reviewID = reviewID;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDateTime reviewDate) {
        this.reviewDate = reviewDate;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Review{" + "reviewID=" + reviewID + ", reviewText=" + reviewText + ", reviewScore=" + reviewScore + ", reviewDate=" + reviewDate + ", movie=" + movie + ", user=" + user + '}';
    }

    @Override
    public String getTableName() {
        return "review";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "reviewtext, reviewscore, reviewdate, movieID, userID";
    }

    @Override
    public void getInsertValues(PreparedStatement statement) throws Exception {
        reviewDate = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(reviewDate);
        statement.setString(1, reviewText);
        statement.setInt(2, reviewScore);
        statement.setTimestamp(3, timestamp);
        statement.setLong(4, movie.getMovieID());
        statement.setLong(5, user.getUserID());
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public void setId(Long id) {
        this.reviewID = id;
    }

    @Override
    public String getColumnNamesForUpdate() {
        return "reviewtext=?, reviewscore=?, reviewdate=?, movieID=?, userID=?";
    }

    @Override
    public String getConditionForUpdate() {
        return "userID=" + user.getUserID() +
                    " AND movieID=" + movie.getMovieID();
    }

    @Override
    public String getConditionForDelete() {
        return "userID=" + user.getUserID() +
                    " AND movieID=" + movie.getMovieID();
    }

    @Override
    public String getColumnNamesForSelect() {
        return "*";
    }

    @Override
    public String getTableForSelect() {
        return "review r JOIN movie m ON (m.movieID=r.movieID) "
                    + "JOIN director d ON (m.directorID = d.directorID) "
                    + "JOIN movieposter mp ON (m.movieposterID = mp.movieposterID) "
                    + "JOIN user u ON (u.userID=r.userID)";
    }

    @Override
    public String getConditionForSelect() {
        return "";
    }

    @Override
    public String getConditionForSelectSpecific() {
        if (user.getUserID() != 0l) {
            return "r.userID=" + user.getUserID();
        } else {
            return "r.movieID=" + movie.getMovieID();
        }
    }
    
    
}
