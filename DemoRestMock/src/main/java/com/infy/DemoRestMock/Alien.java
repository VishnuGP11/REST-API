package com.infy.DemoRestMock;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alien {
	
	private String name;
	private int id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
	
	

}
