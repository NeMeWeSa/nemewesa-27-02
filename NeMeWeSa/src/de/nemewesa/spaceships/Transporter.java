package de.nemewesa.spaceships;

import de.nemewesa.buildings.SpaceStation;
import de.nemewesa.buildings.Storage;
import de.nemewesa.character.Enemy;
import de.nemewesa.level.Planet;

public class Transporter extends Spaceship{
	
	//private static Object resourceName;
	public Storage storage;

	public Transporter(String shipName, String shipType, int maxCapacity, int shipHealth, int shipStrange, int shipFuel, Storage storage, Planet currentPlanet) {
		super(shipName, shipType, shipHealth, maxCapacity, shipStrange, shipFuel, currentPlanet);
		this.storage = storage;
	}
	
	
//	public Transporter(int capacity){
//		super("Donkey","Transporter",60,10,500);
//		this.capacity = capacity;
//	}
	
	public void die()
	{
		System.out.println(this.shipName + " ist zerstört!!!");
	}
	
	// nehme ich gleich raus
	public int shipAttack(Enemy target)
	{
		return target.enemyHealth = target.enemyHealth - this.shipStrange;
	}
	
	public void pickUpGold()
	{			
		
		// Also erstmal resourcen gibt es nicht sondern nur die Objekze der Rohstoffe
		// Dann muss ich im Transporter ein neues Objekt erstellen vom Rohstoff so wie in der pickup Methode und storagef dazupacken
		
		if(this.currentPlanet.resource.get(2).storagef > 0) // Hier will ich erst gucken ob der Planet rohstoffe zum abholen hat
		{
			int actualAmount = this.currentPlanet.resource.get(2).storagef;

			this.currentPlanet.resource.get(2).storagef -= actualAmount;

			
			
			if(this.maxCapacity > actualAmount)
			{
				this.currentPlanet.pickupResource(this.currentPlanet.resource.get(2), actualAmount);
			}
		//	this.storage.resources.add(actualAmount, this.currentPlanet.resource.get(2));

			// Vielleicht muss ich die aktuelle Kapazität berechnen nicht nur maxCapacity
		}


	else 
	{	
		System.out.println("Hier gibt es kein " + this.currentPlanet.resource.get(2).resourceName +  "die man abholen kann! ");	
	}
}
	
	//Hier wird der Rohsrtoff vom gewählten PLANETEN AUFGENOMMEN
//	public int pickUp(Planet start)
//	{	
//		// Es geht nicht weil ich ein Inhalt von einer ArrayList von ner anderen abziehen will und die zwei werte haben
//		// 
//		if(Resource.lot < 1000 )
//		{
//			for(int weight: Planet.ressource) 
//			{
//				if(Planet.resourceName.equals(Transporter.resourceName))
//				{
//					
//				}
//			}
//			return  start.resourceStock = start.resourceStock - capacity;
//		}
//		
//		 
//	 
//	}
	
	// Die Frage ist ob man wirklich diese Methode braucht?
	public void transport()
	{
		
	}
	
	// Hier wird der Rohstoff in der jeweiligen Raumstation abgelegt
//	public int dropDown(SpaceStation goal)
//	{
//		return goal.warehouse = goal.warehouse + capacity;
//	}

}
