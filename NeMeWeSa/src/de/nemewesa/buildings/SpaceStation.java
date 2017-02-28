package de.nemewesa.buildings;

import java.util.ArrayList;

import de.nemewesa.modules.Module;

public class SpaceStation {
	
	public ArrayList<String> warehouse;
	public String name;
	// Hier kommt spaeter vom Objekt Human
	public String humanName;
	public int researchWas;
	
	public SpaceStation(String name){
		this.name = name;
	}
	
	public static void researching()
	{
		
	}
	
	// Hier wird das Modul upgegradet
	public int moduleUpgrate(Module level)
	{
		System.out.println("Das Modul " + level.moduleName + " ist eine Stufe aufgestiegen! ");
		return level.moduleLevel = level.moduleLevel + 1;
	}
	
	public void produce()
	{
		
	}
	
	public void defending()
	{
		
	}
}
