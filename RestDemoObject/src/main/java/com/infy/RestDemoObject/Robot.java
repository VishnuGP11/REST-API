package com.infy.RestDemoObject;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Robot {
	
	private String name;
	private Long serialNo;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(Long serialNo) {
		this.serialNo = serialNo;
	}


}
