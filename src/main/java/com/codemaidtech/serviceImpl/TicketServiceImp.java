//package com.codemaidtech.serviceImpl;
//
//import java.util.HashMap;
//import java.util.List;
//
//import org.jspecify.annotations.Nullable;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//
//import com.codemaidtech.dto.TicketInfo;
//import com.codemaidtech.entity.City;
//import com.codemaidtech.entity.Ticket;
//import com.codemaidtech.repo.TicketRepo;
//import com.codemaidtech.repo.TicketUserInfo;
//import com.codemaidtech.service.TicketService;
//
//@Service
//public class TicketServiceImp implements TicketService {
//
//	@Autowired
//	private TicketRepo repo;
//	
//	@Autowired
//	private TicketUserInfo userinfo;
//	
//	@Autowired
//	private RedisTemplate<String, Object> redisTemplate;
//
//	@Override
//	public List<City> getAllCitys() {
//		
//		//first check in local cache in map there data is available or not
//		
//		@Nullable
//		List<City> citiesFromRedis = (List<City>)  redisTemplate.opsForValue().get("CITIES");
//		if(citiesFromRedis  != null && !citiesFromRedis.isEmpty()) {
//			System.out.println("data is fetch from redis server");
//			return citiesFromRedis ;
//		}
//		
//		//if data is not available in map fetch from db and store into map.
//		
//		System.out.println("data is fetch from database server ");
//		
//		List<City> allCityList =repo.findAll();
//		
//		redisTemplate.opsForValue().set("CITIES", allCityList);
//		
//		return allCityList;
//		
//		
//	}
//
//	
//
//	@Override
//	public void saveUser(TicketInfo info) {
//		
//		Ticket  ticket = new Ticket();
//		
//		ticket.setFname(info.getFname());
//		ticket.setLname(info.getLname());
//		ticket.setFromCity(info.getFromCity());
//		ticket.setToCity(info.getToCity());
//		
//		userinfo.save(ticket);
//		
////		System.out.println("user data save sucessfully");
//
//		
//	}
//	
//	
//
//	
//}
