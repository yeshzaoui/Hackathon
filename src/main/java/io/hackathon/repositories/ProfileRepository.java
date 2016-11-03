package io.hackathon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.hackathon.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
