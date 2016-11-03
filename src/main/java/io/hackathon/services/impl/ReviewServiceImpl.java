package io.hackathon.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import io.hackathon.entities.Profile;
import io.hackathon.entities.Review;
import io.hackathon.repositories.ReviewRepository;
import io.hackathon.services.ReviewService;

@Service(value = "reviewService")
public class ReviewServiceImpl implements ReviewService {
	
	@Resource
	private ReviewRepository reviewRepository;

	@Override
	public List<Review> getAllReviews() {
		return this.reviewRepository.findAll();
	}

	@Override
	public Page<Review> getAllReviews(int page, int size) {
		return this.reviewRepository.findAll( new PageRequest(page, size));
	}

	@Override
	public Review getReviewById(Long id) {
		return this.reviewRepository.findOne(id);
	}

	@Override
	public Review createReview(Review review) {
		return this.reviewRepository.save(review);
	}

	@Override
	public Review updateReview(Review review) {
		return this.reviewRepository.save(review);
	}

	@Override
	public void deleteReview(Long id) {
		this.reviewRepository.delete(id);
	}
	
	@Override
	public List<Review> getReviewsByReviewer(Profile profile) {
		return this.reviewRepository.findByReviewer(profile);
	}

	@Override
	public List<Review> getReviewsByReviewing(Profile profile) {
		return this.reviewRepository.findByReviewing(profile);
	}
	
//	Getter & Setter
	
	public ReviewRepository getReviewRepository() {
		return reviewRepository;
	}

	public void setReviewRepository(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}

}
