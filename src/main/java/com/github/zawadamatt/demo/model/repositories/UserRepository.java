package com.github.zawadamatt.demo.model.repositories;

import com.github.zawadamatt.demo.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
