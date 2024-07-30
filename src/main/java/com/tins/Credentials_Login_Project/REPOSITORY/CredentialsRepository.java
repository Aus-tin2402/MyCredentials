package com.tins.Credentials_Login_Project.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tins.Credentials_Login_Project.DTO.Credentials;

public interface CredentialsRepository extends JpaRepository<Credentials, String> {
	public Credentials findByContact(long contact);
}
