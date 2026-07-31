package com.codemaidtech.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.codemaidtech.dto.TicketInfo;
import com.codemaidtech.entity.City;
import com.codemaidtech.entity.Ticket;
import com.codemaidtech.repo.TicketRepo;
import com.codemaidtech.repo.TicketUserInfo;
import com.codemaidtech.service.TicketService;

@Service
public class TicketServiceImpByUsingRedisAnnotation implements TicketService {
	@Autowired
	private TicketUserInfo userinfo;
	
	@Autowired
	private TicketRepo repo;

	// due to this annotation fist time application is fetch database and 
	// store in data in given key(popular_cities) in redis server
	@Override
	@Cacheable(value = "popular_cities") 
	public List<City> getAllCitys() {
		System.out.println("data fetch from database");
		
		return repo.findAll();
	}

	@Override
	public void saveUser(TicketInfo info) {
		
		Ticket  ticket = new Ticket();
		
		ticket.setFname(info.getFname());
		ticket.setLname(info.getLname());
		ticket.setFromCity(info.getFromCity());
		ticket.setToCity(info.getToCity());
		
		userinfo.save(ticket);
		
//		System.out.println("user data save sucessfully");

		
	}
	

}
