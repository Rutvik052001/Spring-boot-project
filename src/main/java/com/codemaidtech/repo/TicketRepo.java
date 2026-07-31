package com.codemaidtech.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codemaidtech.entity.City;
@Repository
public interface TicketRepo extends JpaRepository<City, Integer> {

}
