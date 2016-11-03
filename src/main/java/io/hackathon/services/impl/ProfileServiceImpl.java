package io.hackathon.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import io.hackathon.entities.Profile;
import io.hackathon.repositories.ProfileRepository;
import io.hackathon.services.ProfileService;

@Service(value = "profileService")
public class ProfileServiceImpl implements ProfileService {
	
	@Resource
	private ProfileRepository profileRepository;

	@Override
	public List<Profile> getAllProfiles() {
		return this.profileRepository.findAll();
	}

	@Override
	public Page<Profile> getAllProfiles(int page, int size) {
		return this.profileRepository.findAll(new PageRequest(page, size));
	}

	@Override
	public Profile getProfileById(Long id) {
		return this.profileRepository.findOne(id);
	}

	@Override
	public Profile createProfile(Profile profile) {
		return this.profileRepository.save(profile);
	}

	@Override
	public Profile updateProfile(Profile profile) {
		return this.profileRepository.save(profile);
	}

	@Override
	public void deleteProfile(Long id) {
		this.profileRepository.delete(id);
	}

//	Getter & Setter
	
	public ProfileRepository getProfileRepository() {
		return profileRepository;
	}

	public void setProfileRepository(ProfileRepository profileRepository) {
		this.profileRepository = profileRepository;
	}
	
	

}
