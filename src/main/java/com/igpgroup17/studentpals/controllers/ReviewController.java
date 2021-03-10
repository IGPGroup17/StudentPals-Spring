package com.igpgroup17.studentpals.controllers;

import com.igpgroup17.studentpals.models.Review;
import com.igpgroup17.studentpals.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/v1/reviews/{id}")
    public ResponseEntity<?> getReviewById(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(reviewService.readReview(id));
    }

    @PostMapping("/v1/reviews")
    public ResponseEntity<?> createReview(@RequestBody Review review) {
        return ResponseEntity.ok(reviewService.createReview(review));
    }

    @PutMapping("/v1/review")
    public ResponseEntity<?> updateReview(@RequestBody Review review) {
        return ResponseEntity.ok(reviewService.updateReview(review));
    }

    @DeleteMapping("/v1/review/{id}")
    public ResponseEntity<?> deleteReviewById(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(reviewService.deleteReview(id));
    }
}