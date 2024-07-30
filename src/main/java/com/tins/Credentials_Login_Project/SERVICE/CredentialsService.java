package com.tins.Credentials_Login_Project.SERVICE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tins.Credentials_Login_Project.DAO.CredentialsDAO;
import com.tins.Credentials_Login_Project.DTO.Credentials;
import com.tins.Credentials_Login_Project.RESPONSESTRUCTURE.ResponseStructure;

@Service
public class CredentialsService {
	@Autowired
	private CredentialsDAO dao;

	public ResponseStructure<Credentials> signUp(Credentials credentials) {
		ResponseStructure<Credentials> structure = new ResponseStructure<Credentials>();
		structure.setData(dao.save(credentials));
		structure.setMsg("Sign-Up Sucessfully Completed");
		structure.setStatus(HttpStatus.CREATED.value());
		return structure;
	}

	public ResponseStructure<List<Credentials>> login() {
		ResponseStructure<List<Credentials>> structure = new ResponseStructure<List<Credentials>>();
		structure.setData(dao.fetchAll());
		structure.setMsg("Fetching Sucessfully");
		structure.setStatus(HttpStatus.OK.value());
		return structure;
	}

	public ResponseStructure<Credentials> getOtp(long contact) {
		ResponseStructure<Credentials> structure = new ResponseStructure<Credentials>();
		structure.setData(dao.fetchByContact(contact));
		structure.setMsg("Account Exist");
		structure.setStatus(HttpStatus.OK.value());
		return structure;
	}

	public ResponseStructure<Credentials> updatePassword(long contact, String password) {
		Credentials credentials = dao.fetchByContact(contact);
		ResponseStructure<Credentials> structure = new ResponseStructure<Credentials>();
		if (credentials != null) {
			credentials.setPassword(password);
			structure.setData(dao.save(credentials));
			structure.setMsg("Updated Sucessfully");
			structure.setStatus(HttpStatus.OK.value());
			return structure;
		} else {
			structure.setData(null);
			structure.setMsg("Can't Find The Contact");
			structure.setStatus(HttpStatus.FORBIDDEN.value());
			return structure;
		}
	}
}
