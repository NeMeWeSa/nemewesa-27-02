package de.nemewesa.buildings;

import java.util.ArrayList;

import de.nemewesa.level.Resource;
import de.nemewesa.modules.Module;

public class SpaceStation {
	
	public ArrayList<Storage> warehouse;
	public String name;
	// Hier kommt spaeter vom Objekt Human
	public String humanName;
	public int researchWas;
	
	public SpaceStation(String name){
		this.name = name;
	}
	
	public Resource bronze = new Resource("Bronze", 1, 0, 0, 2, 8, 85, 0, 0);
	public Resource silver = new Resource("Silber", 2, 0, 0,  2, 10, 60, 0, 0);
	public Resource gold = new Resource("Gold", 3, 0, 0, 2, 12, 45, 0, 0);
	public Resource jewel= new Resource("Juwel", 5, 0, 0, 1, 14, 15, 0, 0);
	
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
