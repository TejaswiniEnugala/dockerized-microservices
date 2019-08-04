package com.stackroute.muzixapp.controller;

import com.stackroute.muzixapp.Exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.Exception.TrackNotFoundException;
import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.service.TrackDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "api/v1")
@ControllerAdvice(basePackages="com.stackroute.muzixapp")
public class TrackController {


	TrackDAO trackService;


	String exp;
	String success;
	@Autowired
	public TrackController(TrackDAO trackService) {
		this.trackService = trackService;
	}


	@ExceptionHandler(TrackAlreadyExistsException.class)
	@PostMapping("track")
	public ResponseEntity<?> saveTrack( Track track){

		ResponseEntity responseEntity;

		try{
			trackService.saveTrack(track);
			responseEntity = new ResponseEntity<String>("success", HttpStatus.CREATED);


		}catch(TrackAlreadyExistsException e){
			responseEntity = new ResponseEntity<String>("getMessage", HttpStatus.CONFLICT);

			e.printStackTrace();
		}
		return  responseEntity;

	}

	@GetMapping("tracks")
	public  ResponseEntity<?> getallTracks(){
		ResponseEntity responseEntity;
		try {
			responseEntity = new ResponseEntity <List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
		} catch (TrackNotFoundException e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);

			e.printStackTrace();
		}
		return  responseEntity;
	}

	@DeleteMapping("track/{id}")
	public 	ResponseEntity<?> delete(@PathVariable long id){

		ResponseEntity responseEntity;

		try{
			int result =  trackService.deleteTrack(id);
			System.out.println(result);
			if(result == 1){
				responseEntity = new ResponseEntity<String>("Succesfully deleted", HttpStatus.CREATED);

			}else{
				responseEntity = new ResponseEntity<String>(exp, HttpStatus.CONFLICT);

			}


		}catch(Exception e){
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);

		}

		return  responseEntity;

	}

	@ExceptionHandler(TrackNotFoundException.class)
	@PutMapping("track/{id}")
	public ResponseEntity<?> updateTrack(int id, Track track){

		ResponseEntity responseEntity;

		try{
			trackService.UpdateTrack(id,track);
			responseEntity = new ResponseEntity<String>("Succesfully updated", HttpStatus.CREATED);


		}catch(TrackNotFoundException e){
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);

		}
		return  responseEntity;

	}

	/*@PostMapping("track/{name}")
	public ResponseEntity<?> getTrackbyName(@PathVariable String name) {

		ResponseEntity responseEntity;

		try {
			responseEntity = new ResponseEntity<List<Track>>(trackService.getTrackbyName(name), HttpStatus.CREATED);


		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);

		}
		return responseEntity;

	}*/

	@GetMapping("track/{id}")
	//handler to get a track by id
	public ResponseEntity<?> getTrack(@PathVariable String id) {
		try {
			return new ResponseEntity<>(trackService.getTrackById(Integer.parseInt(id)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

}