/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comm;

import java.io.Serializable;

/**
 *
 * @author Mihailo
 */
public enum Operation implements Serializable{
    LOGIN, INSERT_USER, UPDATE_USER, DELETE_USER, SELECT_USER, SELECT_USER_STATISTICS,
    SELECT_MOVIES, SELECT_ALL_MOVIES, 
    INSERT_COLLECTION, DELETE_COLLECTION, SELECT_ALL_COLLECTIONS, SELECT_COLLECTIONS,
    INSERT_REVIEW, UPDATE_REVIEW, DELETE_REVIEW, SELECT_ALL_REVIEWS, SELECT_REVIEWS,
    LOGOUT, LOGOUT_ALL,
}
