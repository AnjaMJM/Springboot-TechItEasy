package com.crafter.springboottechiteasy.repositories;

import com.crafter.springboottechiteasy.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TelevisionRepository extends JpaRepository<Television, Long> {

}
