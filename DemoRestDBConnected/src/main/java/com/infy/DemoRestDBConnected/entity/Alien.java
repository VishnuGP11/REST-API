package com.infy.DemoRestDBConnected.entity;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alien {
	
	private Long id;
	private String name;
	private int points;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	@Override
	public String toString() {
		return "Alien [id=" + id + ", name=" + name + ", points=" + points + "]";
	}


}
