package com.pradera.backend.repository;

import com.pradera.backend.model.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDAO, String> {

    boolean existsByEmailOrPhoneNumber(String email, String phoneNumber);

}
