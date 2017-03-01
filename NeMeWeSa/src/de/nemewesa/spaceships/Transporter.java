package de.nemewesa.spaceships;

import de.nemewesa.buildings.SpaceStation;
import de.nemewesa.buildings.Storage;
import de.nemewesa.character.Enemy;
import de.nemewesa.level.Planet;
import de.nemewesa.level.Resource;

public class Transporter extends Spaceship{
	
	//private static Object resourceName;
	public Storage storage;

	public Transporter(String shipName, String shipType, int maxCapacity, int shipHealth, int shipStrange, int shipFuel, Storage storage, Planet currentPlanet, int currantCapacity) {
		super(shipName, shipType, shipHealth, maxCapacity, shipStrange, shipFuel, currentPlanet, currantCapacity);
		this.storage = storage;
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
	
	public void pickUpBronze()
	{			
		
		// Also erstmal resourcen gibt es nicht sondern nur die Objekte der Rohstoffe
		// Dann muss ich im Transporter ein neues Objekt erstellen vom Rohstoff so wie in der pickup Methode und storagef dazupacken
		
		int actualAmount = this.currentPlanet.bronze.storagef;

		if(this.maxCapacity >= actualAmount + this.currantCapacity)
		{				
			if(this.currentPlanet.pickupResource(this.currentPlanet.bronze, actualAmount)){
				Resource bronze = new Resource("Bronze", actualAmount);
				this.storage.resources.add(bronze);
				currantCapacity = currantCapacity + actualAmount;
//				- beladen - in stogage packen
//				- currCapacity aktualisieren
			}								
		}
		else 
		{	
			System.out.println("Die Kapazitaet im Transporter reicht nicht aus. ");	
		}
	}
	
	public void pickUpSilver()
	{					
		int actualAmount = this.currentPlanet.silver.storagef;

		if(this.maxCapacity >= actualAmount + this.currantCapacity)
		{				
			if(this.currentPlanet.pickupResource(this.currentPlanet.silver, actualAmount)){
				Resource silver = new Resource("Silver", actualAmount);
				this.storage.resources.add(silver);
				currantCapacity = currantCapacity + actualAmount;
//				- beladen - in stogage packen
//				- currCapacity aktualisieren
			}								
		}
		else 
		{	
			System.out.println("Die Kapazitaet im Transporter reicht nicht aus. ");	
		}
	}
	
	public void pickUpGold()
	{			
		int actualAmount = this.currentPlanet.gold.storagef;

		if(this.maxCapacity >= actualAmount + this.currantCapacity)
		{				
			if(this.currentPlanet.pickupResource(this.currentPlanet.gold, actualAmount)){
				Resource gold = new Resource("Gold", actualAmount);
				this.storage.resources.add(gold);
				currantCapacity = currantCapacity + actualAmount;
//				- beladen - in stogage packen
//				- currCapacity aktualisieren
			}								
		}
		else 
		{	
			System.out.println("Die Kapazitaet im Transporter reicht nicht aus. ");	
		}
	}
	
	public void pickUpJewel()
	{					

		int actualAmount = this.currentPlanet.jewel.storagef;

		if(this.maxCapacity >= actualAmount + this.currantCapacity)
		{				
			if(this.currentPlanet.pickupResource(this.currentPlanet.jewel, actualAmount)){
				Resource jewel = new Resource("Jewel", actualAmount);
				this.storage.resources.add(jewel);
				currantCapacity = currantCapacity + actualAmount;
//				- beladen - in stogage packen
//				- currCapacity aktualisieren
			}								
		}
		else 
		{	
			System.out.println("Die Kapazitaet im Transporter reicht nicht aus. ");	
		}
	}
	
	// Hier wird der Rohstoff in der jeweiligen Raumstation abgelegt
//	public int dropDown(SpaceStation goal)
//	{
//		return goal.warehouse = goal.warehouse + capacity;
//	}

}
