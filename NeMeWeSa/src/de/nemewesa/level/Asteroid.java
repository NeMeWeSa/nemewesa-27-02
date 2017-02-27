package de.nemewesa.level;

public class Asteroid {

	public String name;
	public int damage;
	
	public Asteroid(String name, int damage){
		this.name = name;
		this.damage = damage;
	}
	
	//Getter
	public String getName(){
		return name;
	}
	
	public int getDamage(){
		return damage;
	}
	
	//Setter
	public void setName(String name){
		String[] form1 ={"tre","tzu","dir","mi","do","re","sol","fa","man","yuh"};
		String[] form2 ={"las","wus","gas","gis","nos","los","mus","bis","fios","mios"};
		int random = (int)(Math.random()*10);
		name = form1[random];
		random = (int)(Math.random()*10);
		name = name+""+form2[random];
		System.out.println(name);
		this.name = name;
	}
	
	//Schaden verursachen
	public void collision(int damage){
		int x =0;
	    x = 5+ (int)(Math.random()*(10-5)+1);
	    damage = x;
	    this.damage = damage;
	}		
}
   