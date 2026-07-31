package com.codemaidtech.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codemaidtech.entity.Ticket;

public interface TicketUserInfo extends JpaRepository<Ticket, Integer> {

}
