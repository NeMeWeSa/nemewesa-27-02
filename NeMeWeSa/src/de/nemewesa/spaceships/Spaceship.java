package de.nemewesa.spaceships;

import java.util.ArrayList;

import javax.annotation.Resource;

import de.nemewesa.character.Enemy;
import de.nemewesa.level.Moon;
import de.nemewesa.level.Planet;

public class Spaceship {
	
	public String shipName;
	public String shipType;
	public int shipHealth;
	public int shipStrange;
	public int shipFuel;
	public int currentCapacity;
	
	public Planet currentPlanet = null;
	
	public static ArrayList<Resource> stock; 
	public int maxCapacity;
	
	public Spaceship(String shipName, String shipType, int maxCapacity, int shipHealth, int shipStrange, int shipFuel, Planet currentPlanet, int currentCapacity) {
		this.shipName = shipName;
		this.shipType = shipType;
		this.shipHealth = shipHealth;
		this.shipStrange = shipStrange;
		this.shipFuel = shipFuel;
		this.maxCapacity = maxCapacity;
		this.currentPlanet = currentPlanet;
		this.currentCapacity = currentCapacity;
	}

	public void fly(Planet planet)
	{
		this.currentPlanet = planet;
	}
	
	public int shipAttack(Enemy target)
	{
		return target.enemyHealth = target.enemyHealth - this.shipStrange;
	}
	
	// Zugehörigkeit zum Mond. 
	// Hier wird der Mond erobert
	public boolean capturing(Moon affiliation)
	{
		System.out.println("Glückwunsch! "+ affiliation.moonName + " wurde erobert!!!");
		return affiliation.captured = true;
				
	}
	
	
	

}
