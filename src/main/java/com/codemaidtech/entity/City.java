package com.codemaidtech.entity;


import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class City implements Serializable  { //Redis itself does not understand Java objects. It only stores bytes (or strings).
	//Why implements Serializable?

	//When Spring uses Java's built-in serialization mechanism (JdkSerializationRedisSerializer), every object must implement:

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String city;
	
}
