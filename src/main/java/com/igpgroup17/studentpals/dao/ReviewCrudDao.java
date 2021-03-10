package com.igpgroup17.studentpals.dao;

import com.igpgroup17.studentpals.models.Review;

public interface ReviewCrudDao {
    Review createReview(Review review);
    Review readReview(String reviewId);
    Review updateReview(Review review);
    void deleteReview(String reviewId);
}
