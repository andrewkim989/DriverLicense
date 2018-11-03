package com.andrewkim.driverlicense.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.andrewkim.driverlicense.models.License;
import com.andrewkim.driverlicense.models.Person;
import com.andrewkim.driverlicense.services.DriverLicenseService;

@Controller
public class DriverLicenseController {
	private final DriverLicenseService driverLicenseService;
	
	public DriverLicenseController(DriverLicenseService driverLicenseService) {
        this.driverLicenseService = driverLicenseService;
    }
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/persons/new")
	public String createPerson(Model model, @ModelAttribute("person") Person person) {
		model.addAttribute("person", person);
		return "newperson.jsp";
	}
	
	@RequestMapping(value = "/persons/new/process", method = RequestMethod.POST)
	public String createPersonProcess(@ModelAttribute("person") Person person, HttpSession session) {
		System.out.println(person.getFirstName());
		driverLicenseService.createPerson(person);
		Long id = person.getId();
		session.setAttribute("id", id);
		return "redirect:/licenses/new";
	}
	
	@RequestMapping("/licenses/new")
	public String createLicense(Model model, @ModelAttribute("license") License license) {
		List<Person> people = driverLicenseService.allPerson();
		model.addAttribute("people", people);
		return "newlicense.jsp";
	}
	
	@RequestMapping(value = "/licenses/new/process", method = RequestMethod.POST)
	public String createLicenseProcess(@ModelAttribute("license") License license,
			Model model, HttpSession session) {
		driverLicenseService.createLicense(license);
		model.addAttribute("license", license);
		Long id = (Long) session.getAttribute("id");
		return "redirect:/persons/" + id;
	}
	
	@RequestMapping("/persons/{id}")
    public String show (@PathVariable("id") Long id, Model model) {
		Person person = driverLicenseService.findPerson(id);
		int number = Integer.parseInt(person.getLicense().getNumber());
		String l = String.format("%05d", number);
		model.addAttribute("person", person);
		Date date = person.getLicense().getExpiration_date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String time = sdf.format(date);
		model.addAttribute("time", time);
		model.addAttribute("licenseNum", l);
        return "driverlicense.jsp";
    }
}
