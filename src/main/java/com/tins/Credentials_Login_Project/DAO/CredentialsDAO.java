package com.tins.Credentials_Login_Project.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tins.Credentials_Login_Project.DTO.Credentials;
import com.tins.Credentials_Login_Project.REPOSITORY.CredentialsRepository;

@Repository
public class CredentialsDAO {
	@Autowired
	private CredentialsRepository repository;

	public Credentials save(Credentials credentials) {
		return repository.save(credentials);
	}

	public List<Credentials> fetchAll() {
		return repository.findAll();
	}

	public Credentials fetchByContact(long contact) {
		return repository.findByContact(contact);
	}
}