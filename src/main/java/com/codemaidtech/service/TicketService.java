package com.codemaidtech.service;

import java.util.List;

import com.codemaidtech.dto.TicketInfo;
import com.codemaidtech.entity.City;

public interface TicketService {

	public List<City> getAllCitys();
	
	public void saveUser(TicketInfo info);
}
