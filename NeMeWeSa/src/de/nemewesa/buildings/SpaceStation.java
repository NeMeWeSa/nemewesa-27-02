package de.nemewesa.buildings;

import java.util.ArrayList;

import de.nemewesa.level.Planet;
import de.nemewesa.modules.Module;

public class SpaceStation {
	
	public String name;

	public int researchPoint;
	public boolean avaiable = false;
	public int bank;
	public Module modul;

	
	public SpaceStation(String name) {
		this.name = name;
		this.researchPoint = 1;
		this.bank = 0;
		this.avaiable = false;
	}
	
	public void researching() {
		
	}
		
	public void produce() {
		switch (researchPoint) {
		case 1:
			this.modul.moduleLevel +=1;
			break;
		case 2:
			this.modul.moduleLevel +=1;
			break;
		default:
			break;
		}
	}
	
	public void defending() {
		
	}
}