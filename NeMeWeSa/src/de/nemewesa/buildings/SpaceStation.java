package de.nemewesa.buildings;

import java.util.ArrayList;

import de.nemewesa.level.Planet;
import de.nemewesa.modules.Module;

public class SpaceStation {
	
	public String name;

	public int researchPoint;
	public boolean avaiable = false;
	public int bank;

	
	public SpaceStation(String name) {
		this.name = name;
		this.researchPoint = 0;
		this.bank = 0;
		this.avaiable = false;
	}
	
	public static void researching() {
		
	}
	
	// Hier wird das Modul upgegradet
	public int moduleUpgrate(Module level) {
		System.out.println("Das Modul " + level.moduleName + " ist eine Stufe aufgestiegen! ");
		return level.moduleLevel = level.moduleLevel + 1;
	}
	
	public void produce() {
		
	}
	
	public void defending() {
		
	}
}