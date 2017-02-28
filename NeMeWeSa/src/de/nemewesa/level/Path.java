package de.nemewesa.level;

import java.util.*;
import de.nemewesa.character.Player;
import de.nemewesa.helper.Helper;
import de.nemewesa.app.App;
import de.nemewesa.level.Generetable;
import de.nemewesa.level.Planet;
import de.nemewesa.level.Solarsystem;
import de.nemewesa.level.Asteroid;

public class Path implements Generetable{
	
    //Asteroiden,die sich aufm Weg befinden
	public ArrayList<Asteroid>asteroids = new ArrayList<>();
	public Asteroid asteroid;
	public Player player;
	
	public Planet planetW;
	public Planet planetE;
	
	//Laenge,Breite und Name des Weges
	public int distance;
	public int width;
	public String name;
	
	public char[][] path;  //Der Weg als Array
	public int nblin, nbcol;
	public char tmp; //Spielerposition
	public String[] name0 ={"Las","Wus","Gas","Gis","Nos","Los","Min", "Ro", "Sen", "Ta", "Bue", "Ur", "Ban", "Iak","Sol","Fa","Man","Yuh"};
	
	//Konstruktor
	public Path(){
		this.name = generateName();
		this.width = Helper.random(3, 5);
		this.distance = Helper.random(7,15);
		
		nblin = width;  //Anzahl der Reihen
		nbcol = distance;  //Anzahl der Spalten
		
		path = new char[nblin][nbcol];
		for (int i=0; i<nblin; i++){
			for(int j=0; j<nbcol; j++){
				path[i][j] = ' ';
	    }	
	  }
	}
	
	public String generateName(){
		String str1 = name0[Helper.random(0, name0.length)];
		String str2 = name0[Helper.random(0, name0.length)];
		String str3 = str1 + str2.toLowerCase();
		return str3;
	}
	
	
	public String getName(){
		return this.name;
	}
	
	public int getDistance(){
		return this.distance;
	}
	
	public int getWidth(){
		return this.width;
	}
	
	public Planet getPlanetW(){
		return this.planetW;
	}
	
	public Planet getPlanetE(){
		return this.planetE;
	}
	
	public void setPlanetW(Planet planetW){
		this.planetW = planetW;
	}
	
	public void setPlanetE(Planet planetE){
		this.planetE = planetW;
	}
	
	public void setDistance(){
		this.distance = Helper.random(7,15);
	}
	
	public void setWidth(){
		this.width = Helper.random(3,5);
	}
	
	public String toString(){
		return "Path's name: "+this.name+"\nWidth = "+this.width+"\nDistance = "+this.distance;
	}
	
	//Asteroiden aufm Weg hinzufuegen
	public void addAsteroid(){
		
		for (int i=0;i<path.length;i++){
			for (int j=0; j<path.length;j++){
				path[0][0] = 'P'; // P ist der Spieler(Player)
			int random = Helper.random(0, 3);
			switch(random){
			case 0: path[i][j] = 'A'; break;
			case 1: path[i][j] = ' '; break;
			case 2: path[i][j] = ' '; break;
			case 3: path[i][j] = ' '; break;
			}
		}
	}
		System.out.println("\nWelcome to the path");
		System.out.println(toString()+"\n");
		System.out.print("You can go to ");
		if (getPlanetE() != null) System.out.print("East ");
		if (getPlanetW() != null) System.out.print("West ");
		System.out.println(".");
		System.out.println();
  }
	public void showPath(){
		System.out.println("-------------------------------------------------------\n");
		for (int i=0; i<nblin; i++){
			for(int j=0; j<nbcol; j++){
			
				System.out.print(" | "+path[i][j]);
			}
			System.out.println(" | ");
		}
		System.out.println("--------------------------------------------------------\n");
	}
	
	public void howToMove(){
		System.out.println();
		System.out.println("Pay close attention! you are the 'P'and the characters A are Asteroids!!!");
		System.out.println("To move, press:");
		System.out.println("8 for up");
		System.out.println("2 for down");
		System.out.println("4 for left");
		System.out.println("and 6 for rigth");
		System.out.println("it's better for you to use the numeric keybord.\n");
		
		try{
			while(true){
			Scanner sc1 = new Scanner(System.in);
			char m = sc1.nextLine().charAt(0);
			switch (m){
			case '8' : 
				if (moveUp() == 1) break;
			       else if(moveUp() == 2){
				       System.out.println("ohh you collided with "+this.asteroid.toString());
				       System.out.println("your AP is now "+(this.player.getAp() - this.asteroid.getDamage()));
			       } break;
			case '2' :
				if (moveDown() == 1) break;
			       else if (moveDown() == 2){
				       System.out.println("ohh you collided with "+this.asteroid.toString());
				       System.out.println("your AP is now "+(this.player.getAp() - this.asteroid.getDamage()));
			       } break;
			case '4' :
				if (moveLeft() == 1) break;
			       else if(moveLeft() == 2){
				       System.out.println("ohh you collided with "+this.asteroid.toString());
				       System.out.println("your AP is now "+(this.player.getAp() - this.asteroid.getDamage()));
			       } break;
			case '6' :
				if (moveRigth() == 1) break;
			       else if(moveRigth() == 2){
				       System.out.println("ohh you collided with "+this.asteroid.toString());
				       System.out.println("your AP is now "+(this.player.getAp() - this.asteroid.getDamage()));
			       } break;
			default : System.out.println("wrong button!!!");
			
			sc1.close();
	        }
	      }
		}catch(Exception e){}
	}
	

    //sich auf dem Weg bewegen
	
	//Bewegen nach oben
	public int moveUp(){
		for (int i=0;i<nblin;i++){
			for (int j=0;j<nbcol;j++){
				if (path[i][j] =='P'){
					if (i-1>=0 && path[i-1][j] == ' '){
					tmp = path[i][j]; //Spieler speichern.
					path[i][j] = ' '; //alte Position verlassen.
					path[i-1][j] = tmp; //neu Position.
					showPath();
					return 1;  // ohne Kollision
					}
					if(i-1>=0 && path[i-1][j] == 'A'){
						tmp = path[i][j]; 
						path[i][j] = ' '; 
						path[i-1][j] = tmp;
						showPath();
						return 2;   // mit Kollision
					}
				}
			}
		}
		return 0;
  }
	
	
	//Bewegen nach recht
	public int moveRigth(){
		for (int i=0;i<nblin;i++){
			for (int j=0;j<nbcol;j++){
				if (path[i][j] =='P'){
					if (path[i][j+1] == ' '){
					tmp = path[i][j]; //Spieler speichern.
					path[i][j] = ' '; //alte Position verlassen.
					path[i][j+1] = tmp; //neu Position.
					showPath();
					return 1;
					}
					if(j+1 <=nbcol && path[i][j+1] == 'A'){
						tmp = path[i][j]; 
						path[i][j] = ' '; 
						path[i][j+1] = tmp;
						showPath();
						return 2;
					}
//					break;
				  }
				if (j+1 > nbcol){
					System.out.println("Welcome to the next planet!!");
				}
			}
		}
		return 0;
  }
	//Bewegen nach links
	public int moveLeft(){
		for (int i=0;i<nblin;i++){
			for (int j=0;j<nbcol;j++){
				if (path[i][j] =='P'){
					if (path[i][j-1] == ' '){
					tmp = path[i][j]; //Spieler speichern.
					path[i][j] = ' '; //alte Position verlassen.
					path[i][j-1] = tmp; //neu Position.
					showPath();
					return 1;
					}
					if(j-1>=0 && path[i][j-1] == 'A'){
						tmp = path[i][j]; 
						path[i][j] = ' '; 
						path[i][j-1] = tmp;
						showPath();
						return 2;
					}
				}	
				if (j-1 < 0){
					System.out.println("You turned back to your last planet!!");
				}
			}
		}
		return 0;
  }

	//Bewegen nach unten
		public int moveDown(){
			for (int i=0;i<nblin;i++){
				for (int j=0;j<nbcol;j++){
					if (path[i][j] =='P'){
						if (i+1<=nblin && path[i+1][j] == ' '){
						tmp = path[i][j]; //Spieler speichern.
						path[i][j] = ' '; //alte Position verlassen.
						path[i+1][j] = tmp; //neu Position.
						showPath();
						return 1;
						}
						if(i+1<=nblin && path[i+1][j] == 'A'){
							tmp = path[i][j]; 
							path[i][j] = ' '; 
							path[i+1][j] = tmp;
							showPath();
							return 2;
						}
//						break; 
					}
				}
			}
			return 0;
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