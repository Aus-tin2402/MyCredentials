package com.tins.Credentials_Login_Project.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tins.Credentials_Login_Project.DTO.Credentials;
import com.tins.Credentials_Login_Project.RESPONSESTRUCTURE.ResponseStructure;
import com.tins.Credentials_Login_Project.SERVICE.CredentialsService;

@RestController
@CrossOrigin
public class CredentialsController {
	@Autowired
private CredentialsService service;
	@PostMapping("/sign_Up")
	public ResponseStructure<Credentials> signUp(@RequestBody Credentials  credentials){
		return service.signUp(credentials);
	}
	
	@GetMapping("/LoginID")
	public ResponseStructure<List<Credentials>> login(){
		return service.login();
	}
	
	@GetMapping("/getOpt/{contact}")
	public ResponseStructure<Credentials> getOtp(@PathVariable long contact){
		return service.getOtp(contact);
	}
	
	@PutMapping("/Forgot/{contact}/{password}")
	public ResponseStructure<Credentials> forgotPassword(@PathVariable long contact,@PathVariable String password){
		return service.updatePassword(contact, password);
	}
}
