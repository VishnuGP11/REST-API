package com.infy.DemoRestMock.repo;

import java.util.ArrayList;
import java.util.List;

import com.infy.DemoRestMock.Alien;

public class AlienRepository {
	
	List<Alien> aliens;
	
	public AlienRepository() {
		
		Alien a1 = new Alien();
		a1.setId(234);
		a1.setName("Cena");
		
		Alien a2 = new Alien();
		a2.setId(666);
		a2.setName("Undertaker");
		
		Alien a3 = new Alien();
		a3.setId(561);
		a3.setName("Punk");
		
		aliens = new ArrayList<>();
		aliens.add(a1);
		aliens.add(a2);
		aliens.add(a3);
		
		
	}
	
	public List<Alien> getAliens(){
		
		return aliens;
	}
	
	public Alien getAlienById(int id) {
		
		for(Alien a : aliens) {
			if(a.getId() == id) {
				return a;
			}
		}
		return null;
	}

	public void create(Alien a4) {
		aliens.add(a4);
	}

}
