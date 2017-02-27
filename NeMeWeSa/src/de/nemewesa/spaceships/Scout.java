package de.nemewesa.spaceships;

import java.util.ArrayList;
import java.util.List;

import de.nemewesa.buildings.Storage;
import de.nemewesa.character.Enemy;
import de.nemewesa.level.Planet;
import de.nemewesa.level.SpaceStation;

public class Scout extends Transporter{
	
	public Scout(String shipName, String shipType, int shipHealth, int shipStrange, int shipFuel, Storage capacity)
	{
		super(shipName,shipType, shipHealth, shipStrange, shipFuel, capacity);
	}

	public void die()
	{
		System.out.println(this.shipName + " ist zerstört!!!");
	}
	
	// nehme ich gleich raus
	public int shipAttack(Enemy target)
	{
		return target.enemyHealth = target.enemyHealth - this.shipStrange;
	}
	
	//Hier wird der Rohsrtoff vom gewählten PLANETEN AUFGENOMMEN
//	public int pickUp(Planet start)
//	{	
//		 return  start.resourceStock = start.resourceStock - capacity;
//	 
//	}
//	
//	// Die Frage ist ob man wirklich diese Methode braucht?
//	public void transport()
//	{
//		
//	}
//	
//	// Hier wird der Rohstoff in der jeweiligen Raumstation abgelegt
//	
//	
//	public int dropDown(SpaceStation goal)
//	{
//		return goal.warehouse = goal.warehouse + capacity;
//	}
}
