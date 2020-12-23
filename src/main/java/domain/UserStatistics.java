/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author Mihailo
 */
public class UserStatistics implements Serializable{
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

    
}
