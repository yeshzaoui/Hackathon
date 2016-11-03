package io.hackathon.services;

import java.util.List;

import org.springframework.data.domain.Page;

import io.hackathon.entities.Profile;
import io.hackathon.entities.Review;

public interface ReviewService {
	
	public List<Review> getAllReviews();
	
	public Page<Review> getAllReviews(int page, int size);
	
	public Review getReviewById(Long id);
	
	public Review createReview(Review review);
	
	public Review updateReview(Review review);
	
	public void deleteReview(Long id);
	
	public List<Review> getReviewsByReviewer(Profile profile);
	
	public List<Review> getReviewsByReviewing(Profile profile);

}
