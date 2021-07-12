/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.PreparedStatement;

/**
 *
 * @author Mihailo
 */
public class UserStatistics implements GenericEntity{
    private User user;
    private String highestRatedMovie;
    private double score;
    private int collectionSize;
    private int reviewCount;

    public UserStatistics() {
    }

    public UserStatistics(User user, String highestRatedMovie, double score, int collectionSize, int reviewCount) {
        this.user = user;
        this.highestRatedMovie = highestRatedMovie;
        this.score = score;
        this.collectionSize = collectionSize;
        this.reviewCount = reviewCount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getHighestRatedMovie() {
        return highestRatedMovie;
    }

    public void setHighestRatedMovie(String highestRatedMovie) {
        this.highestRatedMovie = highestRatedMovie;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getCollectionSize() {
        return collectionSize;
    }

    public void setCollectionSize(int collectionSize) {
        this.collectionSize = collectionSize;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    @Override
    public String getTableName() {
        return "";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "";  
    }

    @Override
    public void getInsertValues(PreparedStatement statement) throws Exception {
        
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public void setId(Long id) {
        
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
        return "";
    }

    @Override
    public String getColumnNamesForSelect() {
        return "u.userID, u.username, u.status, " +
                        "(SELECT COUNT(*) FROM collection c WHERE c.userID = u.userID) AS collection_size," +
                        "(SELECT COUNT(*) FROM review r WHERE r.userID = u.userID) AS review_count," +
                        "(SELECT MAX(reviewscore) AS highest_rated_movie FROM review r INNER JOIN movie m ON r.movieID=m.movieID WHERE r.userID=u.userID) AS score," +
                        "(SELECT m.name FROM movie m JOIN review r ON m.movieID=r.movieID WHERE r.userID=u.userID HAVING MAX(r.reviewscore)) AS highest_rated_movie";
    }

    @Override
    public String getTableForSelect() {
        return "user u";
    }

    @Override
    public String getConditionForSelect() {
        return "";
    }

    @Override
    public String getConditionForSelectSpecific() {
        return "";
    }

    @Override
    public String getAdditionalQueries() {
        return "";
    }

    
}
