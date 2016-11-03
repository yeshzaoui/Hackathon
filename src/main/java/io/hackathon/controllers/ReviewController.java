package io.hackathon.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.hackathon.entities.Review;
import io.hackathon.entities.Transaction;
import io.hackathon.services.ProfileService;
import io.hackathon.services.ReviewService;
import io.hackathon.services.TransactionService;

@RestController
@RequestMapping(value ="/reviews") 
public class ReviewController {
	
	@Resource
	private ReviewService reviewService;
	
	@Resource
	private TransactionService transactionService;
	
	@Resource
	private ProfileService profileService;
	

	@RequestMapping(method = RequestMethod.POST)
	public Review createReview(@RequestBody Review review) {
		List<Transaction> transactions = this.transactionService.getAllTransactions()
				.stream().filter(t -> t.getBuyer().getId() == review.getReviewer().getId()).collect(Collectors.toList());
		List<Review> reviews = this.reviewService.getAllReviews()
				.stream().filter(r -> r.getReviewer().getId() == review.getReviewer().getId()).collect(Collectors.toList());
		if(!transactions.isEmpty() && reviews.isEmpty()){
			review.setCreatedIn(new Date());
			return this.reviewService.createReview(review);		
		}
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<Review> getPageableReviews(@Param(value = "page") int page, @Param(value = "size") int size) {
		return this.reviewService.getAllReviews(page, size);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Review getReviewById(@PathVariable(value = "id") Long id) {
		return this.reviewService.getReviewById(id);
	}
	
	@RequestMapping(value = "reviewer/{id}", method = RequestMethod.GET)
	public List<Review> getReviewsByReviewer(@PathVariable(value = "id") Long id) {
		List<Review> reviews = this.reviewService.getAllReviews();
		return reviews.stream().filter(review -> review.getReviewer().getId() == id).collect(Collectors.toList());
	}
	
	@RequestMapping(value = "reviewing/{id}", method = RequestMethod.GET)
	public List<Review> getReviewsByReviewing(@PathVariable(value = "id") Long id) {
		List<Review> reviews = this.reviewService.getAllReviews(); 
		return reviews.stream().filter(review -> review.getReviewing().getId() == id).collect(Collectors.toList());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) 
	public void deleteReview(@PathVariable(value = "id") Long id) {
		this.reviewService.deleteReview(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Review updateReview(@PathVariable(value = "id") Long id, @RequestBody Review review) {
 		
		if(this.reviewService.getReviewById(id).equals(null)){
			review.setId(id);
			review.setCreatedIn(new Date());
			return this.reviewService.createReview(review);		
		}
		return null;
 	}
	
// Getter & Setter

	public ReviewService getReviewService() {
		return reviewService;
	}

	public void setReviewService(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	public TransactionService getTransactionService() {
		return transactionService;
	}

	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

}
