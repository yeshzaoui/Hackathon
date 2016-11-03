package io.hackathon.controllers;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.hackathon.entities.Profile;
import io.hackathon.services.ProfileService;


@RestController
@RequestMapping(value ="/profiles") 
public class ProfileController {
	
	@Resource
	private ProfileService profileService;
	
	@RequestMapping(method = RequestMethod.POST)
	public Profile createProfile(@RequestBody Profile profile) {
		profile.setUsername(profile.getLastName() + profile.getFirstName());
		profile.setCeatedIn(new Date());
		profile.setVerified(false);
		profile.setPicture("goo.gl/Z09hu3");
		return this.profileService.createProfile(profile);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<Profile> getPageableProfiles(@Param(value = "page") int page, @Param(value = "size") int size) {
		return this.profileService.getAllProfiles(page, size);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Profile getProfileById(@PathVariable(value = "id") Long id) {
		return this.profileService.getProfileById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) 
	public void deleteProfile(@PathVariable(value = "id") Long id) {
		this.profileService.deleteProfile(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Profile updatePlace(@PathVariable(value = "id") Long id, @RequestBody Profile profile) {
		profile.setId(id);
		profile.setCeatedIn(new Date());
 		return this.profileService.updateProfile(profile);
 	}
	
// Getter & Setter

	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}
	
	

}
