package io.hackathon.services;

import java.util.List;

import org.springframework.data.domain.Page;

import io.hackathon.entities.Profile;

public interface ProfileService {
	
	public List<Profile> getAllProfiles();
	
	public Page<Profile> getAllProfiles(int page, int size);
	
	public Profile getProfileById(Long id);
	
	public Profile createProfile(Profile profile);
	
	public Profile updateProfile(Profile profile);
	
	public void deleteProfile(Long id);

}
