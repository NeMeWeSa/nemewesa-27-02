package de.nemewesa.level;

import java.util.*;

public class Path {
    //Asteroiden,die sich aufm Weg befinden
	public ArrayList<Asteroid>asteroids = new ArrayList<>();
	
	//Laenge,Breite und Name des Weges
	public int distance;
	public int width;
	public String name;
	
	public char[][] path;  //Der Weg als Array
	public int nblin, nbcol;
	public char tmp; //Spielerposition
	
	//Konstruktor
	public Path(String name, int width, int distance){
		this.name = name;
		this.width = width;
		this.distance = distance;
		
		nblin = width;
		nbcol = distance;
		path = new char[nblin][nbcol];
		for (int i=0; i<nblin; i++){
			for(int j=0; j<nbcol; j++){
				path[i][j] = ' ';
	    }	
	  }
	}
	
	
	public String getName(){
		return name;
	}
	
	public int getDistance(){
		return distance;
	}
	
	public int getWidth(){
		return width;
	}
	
	//Asteroiden aufm Weg hinzufuegen
	public void addAsteroid(){
		
		for (int i=0;i<path.length;i++){
			for (int j=0; j<path.length;j++){
				path[0][0] = 'P'; // P ist der Spieler(Player)
			int random = (int)(Math.random()*4);
			switch(random){
			case 0: path[i][j] = 'A'; break;
			case 1: path[i][j] = ' '; break;
			case 2: path[i][j] = ' '; break;
			case 3: path[i][j] = ' '; break;
			}
		}
	}
//		this.asteroids.add();
		System.out.println();
  }
	public void showPath(){
		System.out.println();
		for (int i=0; i<nblin; i++){
			for(int j=0; j<nbcol; j++){
			
				System.out.print(" | "+path[i][j]);
			}
			System.out.println(" | ");
		}
		System.out.println();
	}
	
    //sich auf dem Weg bewegen
	//Bewegen nach oben
	public void moveUp(){
		for (int i=0;i<nblin;i++){
			for (int j=0;j<nbcol;j++){
				if (path[i][j] =='P'){
					if (i-1>=0){
					tmp = path[i][j]; //Spieler speichern.
					path[i][j] = ' '; //alte Position verlassen.
					path[i-1][j] = tmp; //neu Position.
				    
				}
			}
		}
	}
		showPath();
  }
	//Bewegen nach unten
	public void moveDown(){
		for (int i=0;i<nblin;i++){
			for (int j=0;j<nbcol;j++){
				if (path[i][j] =='P'){
					if (i+1<=nblin){
					tmp = path[i][j]; //Spieler speichern.
					path[i][j] = ' '; //alte Position verlassen.
					path[i+1][j] = tmp; //neu Position.
					return; 
				}
			}
		}
	}
		showPath();
  }
	//Bewegen nach recht
	public void moveRigth(){
		for (int i=0;i<nblin;i++){
			for (int j=0;j<nbcol;j++){
				if (path[i][j] =='P'){
					if (j+1 <=nbcol){
					tmp = path[i][j]; //Spieler speichern.
					path[i][j] = ' '; //alte Position verlassen.
					path[i][j+1] = tmp; //neu Position.
					while(tmp !=' '){
						System.out.println("ohh you collided with a asteroid");
						System.out.println("");
					}
					break;
				}
			}
		}
	}
		showPath();
  }
	//Bewegen nach links
	public void moveLeft(){
		for (int i=0;i<nblin;i++){
			for (int j=0;j<nbcol;j++){
				if (path[i][j] =='P'){
					if (j-1>=0){
					tmp = path[i][j]; //Spieler speichern.
					path[i][j] = ' '; //alte Position verlassen.
					path[i][j-1] = tmp; //neu Position.
				   
				}
			}
		}
	}
		showPath();
  }	
	
}