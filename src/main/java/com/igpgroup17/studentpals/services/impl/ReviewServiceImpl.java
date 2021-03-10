package com.igpgroup17.studentpals.services.impl;

import com.igpgroup17.studentpals.dao.ReviewCrudDao;
import com.igpgroup17.studentpals.models.Review;
import com.igpgroup17.studentpals.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewCrudDao reviewCrudDao;

    @Autowired
    public ReviewServiceImpl(ReviewCrudDao reviewCrudDao) {
        this.reviewCrudDao = reviewCrudDao;
    }

    @Override
    public Review createReview(Review review) { return reviewCrudDao.createReview(review); }

    @Override
    public Review readReview(String id) {
        return reviewCrudDao.readReview(id);
    }

    @Override
    public Review updateReview(Review review) {
        return reviewCrudDao.updateReview(review);
    }

    @Override
    public String deleteReview(String id) {
        reviewCrudDao.deleteReview(id);
        return "Deleted review";
    }
}