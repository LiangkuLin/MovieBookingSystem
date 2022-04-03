package com.example.demo.controller;

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


import com.example.demo.model.Show;
import com.example.demo.model.ShowRepository;

@CrossOrigin(origins = "http://localhost:8081") // use for Vue
@RestController
@RequestMapping("/api")
public class ShowController {
	
	@Autowired
	ShowRepository showRepository;
	
	@GetMapping("/shows")
	public ResponseEntity<List<Show>> getShows(@RequestParam(required =false ) String name) {
		return new ResponseEntity<>(showRepository.findAll(), HttpStatus.OK);
		
	}
	
	
	@GetMapping("/shows/{id}")
	public ResponseEntity<Show> getShowById(@PathVariable("id") long id) {
		Optional<Show> showData = showRepository.findById(id);

		if (showData.isPresent()) {
			return new ResponseEntity<>(showData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	
	@PostMapping("/shows")
	public ResponseEntity<Show> createMovie(@RequestBody Show show ){
		try {
			Show newShow = new Show(show.getDate(),show.getStartTime(),show.getEndTime());
			Show _show = showRepository.save(newShow);
			return new ResponseEntity<>(_show, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/shows/{id}")
	public ResponseEntity<Show> updateShow(@PathVariable("id") long id, @RequestBody Show show) {
		Optional<Show> showData = showRepository.findById(id);

		if (showData.isPresent()) {
			Show _show = showData.get();
			_show.setDate(show.getDate());
			_show.setEndTime(show.getEndTime());
			_show.setStartTime(show.getStartTime());
			return new ResponseEntity<>(showRepository.save(_show), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/shows/{id}")
	public ResponseEntity<HttpStatus> deleteMovie(@PathVariable("id") long id) {
		try {
			showRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
