package com.github.zawadamatt.demo.model.repositories;

import com.github.zawadamatt.demo.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
