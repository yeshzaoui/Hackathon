package io.hackathon.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.hackathon.entities.Profile;
import io.hackathon.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	public List<Review> findByReviewing(Profile profile);
	
	public List<Review> findByReviewer(Profile profile);

}
