package com.rhode.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rhode.app.Binding.CitizenApp;
import com.rhode.app.Service.CitizenAppRegService;

@RestController
@RequestMapping("/")
public class CitizenAppRestController {
	
	@Autowired
	private CitizenAppRegService CitizenSevice;
	
	@PostMapping("CitizenApp")
	public ResponseEntity<String> saveCitizen(
			@RequestBody CitizenApp app){
		String Response=CitizenSevice.registerCitizenApp(app);
		return ResponseEntity.ok(Response);
		
	}

}
