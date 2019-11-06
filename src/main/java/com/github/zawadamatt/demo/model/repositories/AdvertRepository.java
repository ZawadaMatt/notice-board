package com.github.zawadamatt.demo.model.repositories;

import com.github.zawadamatt.demo.model.domain.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertRepository extends JpaRepository<Advert, Long> {

}
