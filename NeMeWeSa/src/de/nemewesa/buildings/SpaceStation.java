package de.nemewesa.buildings;

import java.util.ArrayList;

import de.nemewesa.level.Planet;
import de.nemewesa.modules.Module;

public class SpaceStation {
	
	public String name;

	public int researchPoint;
	public int bank;
	public Module modul;

	
	public SpaceStation(String name) {
		this.name = name;
		this.researchPoint = 1;
		this.bank = 0;
	}
	
	public void researching() {
		this.researchPoint +=1;
	}
		
	public void produce() {
		this.modul.moduleLevel +=1;
	}	
	public void defending() {
		
	}
}
