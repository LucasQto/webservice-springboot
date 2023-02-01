package com.devlucas.firstwebservice.repository;

import com.devlucas.firstwebservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
