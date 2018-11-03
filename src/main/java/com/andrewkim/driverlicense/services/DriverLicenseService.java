package com.andrewkim.driverlicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.andrewkim.driverlicense.models.License;
import com.andrewkim.driverlicense.models.Person;
import com.andrewkim.driverlicense.repositories.DriverRepository;
import com.andrewkim.driverlicense.repositories.LicenseRepository;

@Service
public class DriverLicenseService {
	private final DriverRepository driverRepository;
	private final LicenseRepository licenseRepository;
	
	public DriverLicenseService (DriverRepository driverRepository, LicenseRepository licenseRepository) {
		this.driverRepository = driverRepository;
		this.licenseRepository = licenseRepository;
	}
	
	public List<Person> allPerson() {
		return driverRepository.findAll();
	}
	
	public List<License> allLicense() {
		return licenseRepository.findAll();
	}
	
	public Person createPerson(Person person) {
		return driverRepository.save(person);
	}
	
	public License createLicense(License license) {
		return licenseRepository.save(license);
	}
	
	public Person findPerson(Long id) {
		Optional<Person> optionalDriver = driverRepository.findById(id);
        if(optionalDriver.isPresent()) {
            return optionalDriver.get();
        }
        else {
            return null;
        }
	}
}
