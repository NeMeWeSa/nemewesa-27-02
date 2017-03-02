package de.nemewesa.level;

import de.nemewesa.helper.Helper;
import de.nemewesa.level.Generetable;
import de.nemewesa.level.Path;

public class Asteroid implements Generetable{

	public String name;
	public int damage;
	public Path path;
	
	
	public Asteroid(){
		this.name = generateName();
		this.damage = Helper.random(1, 5);
	}
	
	//Getter
	public String getName(){
		return name;
	}
	
	public int getDamage(){
		return damage;
	}
	
	//Setter
	public String generateName(){
		String[] form1 ={"Tre","Tzu","Dir","Mi","Do","Re","Sol","Fa","Man","Yuh"};
		String[] form2 ={"las","wus","gas","gis","nos","los","mus","bis","fios","mios"};

		String name1 = form1[Helper.random(0, form1.length)];
		String name2 = form2[Helper.random(0, form2.length)];
		String name = name1 + name2;

		return name;
	}
	
	//Schaden verursachen
		public void setDamage(int damage){
			int x =0;
		    x = Helper.random(5, 10);
		    damage = x;
		    this.damage = damage;
		}
	
	public String toString(){
		return "Asteroidsname: "+this.name+"\nSchaden = -"+this.damage+" AP";
	}
	

	@Override
	public void generate(int element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printChildren() {
		// TODO Auto-generated method stub
		
	}		
}

   