package com.igpgroup17.studentpals.services;


import com.igpgroup17.studentpals.models.Review;

public interface ReviewService {

    Review createReview(Review review);

    Review readReview(String id);

    Review updateReview(Review review);

    String deleteReview(String id);
}
