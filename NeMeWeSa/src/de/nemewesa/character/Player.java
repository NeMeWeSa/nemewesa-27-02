package de.nemewesa.character;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import de.nemewesa.app.App;
import de.nemewesa.app.Observer;
import de.nemewesa.app.Round;
import de.nemewesa.level.Generetable;
import de.nemewesa.level.Planet;
import de.nemewesa.level.Solarsystem;

public class Player implements Observer, Serializable{
	
	private String name;
	private Planet currentPlanet = null;
	private Planet homePlanet = null;
	private Solarsystem homeSolarsystem = null;
	private ArrayList<Generetable> ownership = new ArrayList<>();
	private Round round;
	
	private int ap = App.PLAYER_AP;
	
	public Player(String name){
		this.name = name;
		this.round = Round.getRoundInstance();
		this.round.registerObserver(this);
	}
	
	public String toString(){
		String info = "";
		
		// SPIELER
		info += "[Spieler] Du hast " + this.ap + " Aktionspunkte \n";
		info += "[Spieler] Du befindest dich auf dem Planeten " + this.currentPlanet.name + ".\n";
		info += "[Spieler] " + this.homePlanet.name + " ist dein Heimatplanet.\n";
		info += "[Spieler] Dein Heimat-Solarsystem ist der " + this.homeSolarsystem.name + ".\n";
		
		// RAUMSTATION
		if(this.currentPlanet.spacestation != null){
			info += "[Raumstation] Auf diesem Planeten befindet sich die Raumstation " 
					+ this.currentPlanet.spacestation.name + "\n";
		}
		
		// NACHBARPLANETEN UND PFADE
		// LINKS
		if(this.getLeftNeighbouringPlanet() != null){
			info += "[Planet] Dein linker Nachbarplanet ist der " + this.getLeftNeighbouringPlanet().name +"\n";
			info += "[Pfad] und ist ueber den Pfad " + this.currentPlanet.pathLeft.name + " (" + this.currentPlanet.pathLeft.distance + ") erreichbar \n";
		}
		// RECHTS
		if(this.getRightNeighbouringPlanet() != null){
			info += "[Planet] Dein rechter Nachbarplanet ist der " + this.getRightNeighbouringPlanet().name +"\n";
			info += "[Pfad] und ist ueber den Pfad " + this.currentPlanet.pathRight.name + " (" + this.currentPlanet.pathRight.distance + ") erreichbar \n";
		}
		
		// PLANETEN IM BESITZT		
		info += "[Spieler] Dein Besitz >> \n";
		for(Generetable ownership : ownership){
			info += "[" + ownership.getClass().getSimpleName() + "] > " + ownership.getName() +"\n";
		}
		return info;
	}
	
	public void showEnvironment(){
		System.out.println(this.toString());
	}

	public Generetable getOwnership(int index) {
		return this.ownership.get(index);
	}

	public void addOwnership(Generetable ownership) {
		this.ownership.add(ownership);
	}

	public void setCurrentPlanet(Planet currPlanet){
		this.currentPlanet = currPlanet;
	}

	public Planet getHomePlanet(){
		return this.homePlanet;
	}

	public void setHomePlanet(Planet homePlanet){
		this.homePlanet = homePlanet;
	}
	
	public void setHomeSolarsystem(Solarsystem homeSolarsystem){
		this.homeSolarsystem = homeSolarsystem;
	}	
	
	public Planet getCurrentPlanet(){
		return this.currentPlanet;
	}	
	
	public String getName(){
		return this.name;
	}

	public int getAp() {
		return ap;
	}

	@Override
	public void update(int round) {
		System.out.println(this.name + " lautet die Runde " + round + " ein.");
	}
	
	public void saveAsString(String filename) {
		
		File f = new File(filename);
		String str = this.toString();
		
		try (BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(f /*, true => wenn angehaengt werden soll */));) {
			fos.write(str.getBytes());
		}
		catch(FileNotFoundException e){
			System.out.println("FileNotFoundException: " + e.getMessage());
		}
		catch(IOException e) {
			System.out.println("IOException: " + e.getMessage());
		}		
		
	}
	
	public Planet getLeftNeighbouringPlanet(){
		
		if(this.currentPlanet.parent.getPlanetIndex(this.currentPlanet) > 0){
			return this.currentPlanet.parent.getPlanet(
					this.currentPlanet.parent.getPlanetIndex(this.currentPlanet) -1);
		}
		return null;
	}
	
	public Planet getRightNeighbouringPlanet(){
		
		if(this.currentPlanet.parent.getPlanetIndex(this.currentPlanet) < (this.currentPlanet.parent.getPlanets().size() - 1)){
			return this.currentPlanet.parent.getPlanet(
					this.currentPlanet.parent.getPlanetIndex(this.currentPlanet) +1);
		}
		return null;
	}	
	
	public void move(Planet planet){
		if(this.ap >= 1){
			this.currentPlanet = planet;
			this.ap--;
		}
	}
	
	public void save(String filename){

		//Savable h = this;
		Runnable thread = () -> {

		//Thread thread = new Thread( new Runnable() {
			
			//public void run() {
			
				try (ObjectOutputStream out = 
						new ObjectOutputStream(
							new BufferedOutputStream(
								new FileOutputStream(filename)));) {
					
					//out.writeObject(this);
					out.writeObject(this);
					out.close();
				} 
				catch (FileNotFoundException e) {
					e.printStackTrace();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
		
		};
		new Thread(thread).start();
				
		//}});
		//thread.start();				
	
	}
	
	public void load(String filename){
		
		
		//Runnable thread = () -> {		
		Thread thread = new Thread( new Runnable() {
			
			public void run() {
		
			try (ObjectInputStream in = 
					new ObjectInputStream(
						new BufferedInputStream(
							new FileInputStream(filename)));) {
				
				//Object object = null;
			
				Object object = in.readObject();
					
				if(object != null) {
					Player importedObj = (Player) object;
					System.out.println("Der importierte Player: " + importedObj);
				}
				in.close();
				
			} 
			catch (IOException e) {
				e.printStackTrace();
			} 
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		//};
		//new Thread(thread).start();
			
		}});
		thread.start();			
			
	}

}
