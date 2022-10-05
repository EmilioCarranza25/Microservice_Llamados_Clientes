package com.bezkoder.spring.datajpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.datajpa.model.Register;
import com.bezkoder.spring.datajpa.repository.RegisterRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class RegisterController {

	@Autowired
	RegisterRepository tutorialRepository;

	@GetMapping("/resgister")
	public ResponseEntity<List<Register>> getAllTutorials(@RequestParam(required = false) String title) {
		try {
			List<Register> tutorials = new ArrayList<Register>();

			if (title == null)
				tutorialRepository.findAll().forEach(tutorials::add);
			else
//				tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);

			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/resgister/{id}")
	public ResponseEntity<Register> getTutorialById(@PathVariable("id") long id) {
		Optional<Register> tutorialData = tutorialRepository.findById(id);

		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/resgister")
	public ResponseEntity<Register> createTutorial(@RequestBody Register tutorial) {
		try {
			Register _tutorial = tutorialRepository
					.save(new Register(tutorial.getFirstName(), tutorial.getLastName(), tutorial.getPlatformName(),
							tutorial.getNameCountryOperation(), tutorial.getEnfoque(), tutorial.getCategoria(),
							tutorial.getSubCategoria(), true, tutorial.getPlanCliente()));
			return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/resgisters/{id}")
	public ResponseEntity<Register> updateTutorial(@PathVariable("id") long id, @RequestBody Register tutorial) {
		Optional<Register> tutorialData = tutorialRepository.findById(id);

		if (tutorialData.isPresent()) {
			Register _tutorial = tutorialData.get();
			_tutorial.setFirstName(tutorial.getFirstName());
			_tutorial.setLastName(tutorial.getLastName());
			_tutorial.setPlatformName(tutorial.getPlatformName());
			_tutorial.setNameCountryOperation(tutorial.getNameCountryOperation());
			_tutorial.setEnfoque(tutorial.getEnfoque());
			_tutorial.setCategoria(tutorial.getCategoria());
			_tutorial.setSubCategoria(tutorial.getSubCategoria());
			_tutorial.setEstado(tutorial.getEstado());
			_tutorial.setPlanCliente(tutorial.getPlanCliente());
			return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/resgisters/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			tutorialRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/resgisters")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			tutorialRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

//	@GetMapping("/resgisters/published")
//	public ResponseEntity<List<Register>> findByPublished() {
//		try {
//			List<Register> tutorials = tutorialRepository.findByPublished(true);
//
//			if (tutorials.isEmpty()) {
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			}
//			return new ResponseEntity<>(tutorials, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

}
