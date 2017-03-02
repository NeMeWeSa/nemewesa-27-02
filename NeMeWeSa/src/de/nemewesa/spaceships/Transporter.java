package de.nemewesa.spaceships;

import de.nemewesa.buildings.SpaceStation;
import de.nemewesa.buildings.Storage;
import de.nemewesa.character.Enemy;
import de.nemewesa.level.Planet;
import de.nemewesa.level.Resource;

public class Transporter extends Spaceship{
	
	//private static Object resourceName;
	public Storage storage;

	public Transporter(String shipName, String shipType, int maxCapacity, int shipHealth, int shipStrange, int shipFuel, Storage storage, Planet currentPlanet, int currentCapacity) {
		super(shipName, shipType, shipHealth, maxCapacity, shipStrange, shipFuel, currentPlanet, currentCapacity);
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

		if(this.maxCapacity >= actualAmount + this.currentCapacity)
		{				
			if(this.currentPlanet.pickupResource(this.currentPlanet.bronze, actualAmount)){
				Resource bronze = new Resource("Bronze", actualAmount);
				this.storage.resources.add(bronze);
				currentCapacity = currentCapacity + actualAmount;
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

		if(this.maxCapacity >= actualAmount + this.currentCapacity)
		{				
			if(this.currentPlanet.pickupResource(this.currentPlanet.silver, actualAmount)){
				Resource silver = new Resource("Silver", actualAmount);
				this.storage.resources.add(silver);
				currentCapacity = currentCapacity + actualAmount;
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

		if(this.maxCapacity >= actualAmount + this.currentCapacity)
		{		
			
			System.out.println("auf planeten vorhanden " + this.currentPlanet.gold.storagef);		
			if(this.currentPlanet.pickupResource(this.currentPlanet.gold, actualAmount)){	
				
				Resource gold = new Resource("Gold", actualAmount);
				this.storage.resources.add(gold);
				currentCapacity = currentCapacity + actualAmount;
				System.out.println("GELADEN: " + this.storage.resources.get(0).storagef);
				System.out.println("alter Planet "+ this.currentPlanet.name);
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

		if(this.maxCapacity >= actualAmount + this.currentCapacity)
		{				
			if(this.currentPlanet.pickupResource(this.currentPlanet.jewel, actualAmount)){
				Resource jewel = new Resource("Jewel", actualAmount);
				this.storage.resources.add(jewel);
				currentCapacity += actualAmount;
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
	
	
	public void dropDownGold()//Planet goal)
	{	
		//this.currentPlanet.gold.storagef += this.storage.resources.indexOf(gold)
		
		for(int i = 0; i < this.storage.resources.size(); i++){
			if(this.storage.resources.get(i).resourceName.equals("Gold")){
				System.out.println("entladen" + this.storage.resources.get(i).storagef);
				
	// hier ist die frage ob das auch der nächste Planet ist und ob es auch in den neuen storagF entladet
				System.out.println("Neuer Planet: " + this.currentPlanet.name);
				this.currentPlanet.gold.storagef += this.storage.resources.get(i).storagef;
				System.out.println("StorageF vom neuen Planeten " + this.currentPlanet.gold.storagef);
			}
		}
	}
		public void dropDownBronze()//Planet goal)
		{	
			//this.currentPlanet.gold.storagef += this.storage.resources.indexOf(gold)
			
			for(int i = 0; i < this.storage.resources.size(); i++){
				if(this.storage.resources.get(i).resourceName.equals("Bronze")){
					System.out.println("entladen" + this.storage.resources.get(i).storagef);
					
		// hier ist die frage ob das auch der nächste Planet ist und ob es auch in den neuen storagF entladet
					System.out.println("Neuer Planet: " + this.currentPlanet.name);
					this.currentPlanet.bronze.storagef += this.storage.resources.get(i).storagef;
					System.out.println("StorageF vom neuen Planeten " + this.currentPlanet.bronze.storagef);
				}
			}
		}
			public void dropDownSilver()//Planet goal)
			{	
				//this.currentPlanet.gold.storagef += this.storage.resources.indexOf(gold)
				
				for(int i = 0; i < this.storage.resources.size(); i++){
					if(this.storage.resources.get(i).resourceName.equals("Silver")){
						System.out.println("entladen" + this.storage.resources.get(i).storagef);
						
			// hier ist die frage ob das auch der nächste Planet ist und ob es auch in den neuen storagF entladet
						System.out.println("Neuer Planet: " + this.currentPlanet.name);
						this.currentPlanet.silver.storagef += this.storage.resources.get(i).storagef;
						System.out.println("StorageF vom neuen Planeten " + this.currentPlanet.silver.storagef);
					}
				}
			}
				public void dropDownJewel()//Planet goal)
				{	
					//this.currentPlanet.gold.storagef += this.storage.resources.indexOf(gold)
					
					for(int i = 0; i < this.storage.resources.size(); i++){
						if(this.storage.resources.get(i).resourceName.equals("Jewel")){
							System.out.println("entladen" + this.storage.resources.get(i).storagef);
							
				// hier ist die frage ob das auch der nächste Planet ist und ob es auch in den neuen storagF entladet
							System.out.println("Neuer Planet: " + this.currentPlanet.name);
							this.currentPlanet.jewel.storagef += this.storage.resources.get(i).storagef;
							System.out.println("StorageF vom neuen Planeten " + this.currentPlanet.jewel.storagef);
						}
					}
		//this.storage.resources.remove(gold);
		//this.storage.resources.removeAll(null);
		//this.goal.storage.warehouse.add(resources);
		//goal.warehouse = goal.warehouse + capacity;
	}
				
				public void dropDownJewelStation()//Planet goal)
				{	
					//this.currentPlanet.gold.storagef += this.storage.resources.indexOf(gold)
					
					for(int i = 0; i < this.storage.resources.size(); i++){
						if(this.storage.resources.get(i).resourceName.equals("Jewel")){
							System.out.println("entladen" + this.storage.resources.get(i).storagef);
							
				// hier ist die frage ob das auch der nächste Planet ist und ob es auch in den neuen storagF entladet
							System.out.println("Neuer Planet: " + this.currentPlanet.name);
							//this
							this.currentPlanet.jewel.storagef += this.storage.resources.get(i).storagef;
							System.out.println("StorageF vom neuen Planeten " + this.currentPlanet.jewel.storagef);
						}
					}
		//this.storage.resources.remove(gold);
		//this.storage.resources.removeAll(null);
		//this.goal.storage.warehouse.add(resources);
		//goal.warehouse = goal.warehouse + capacity;
	}

}
