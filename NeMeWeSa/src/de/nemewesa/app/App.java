package de.nemewesa.app;

import java.util.Timer;

import de.nemewesa.buildings.SpaceStation;
import de.nemewesa.character.Player;
import de.nemewesa.db.DB;
import de.nemewesa.level.Level;
import de.nemewesa.level.Path;
import de.nemewesa.level.Resource;


public class App {
	
	public static final int PLAYER_AP = 20;
	// Legt fest, ob Statusinformationen angezeigt werden sollen.
	public static final boolean DEV_MODE = false;
	
	private Player player;
	private Level level;
	private Round round = Round.getRoundInstance();
	private DB db = DB.getInstance();
	private Console console;
	private Login login;
	private String prefix = "[NeMeWeSa] ";

	public static void main(String[] args)  {
		App app = new App();
//		app.init();
		app.pathTest();
	}
	
	public void init(){
		if(DEV_MODE)
			db.createUsersTable();
		
		//loginUser();
		createNewLevel(1);
		//createPlayer(login.name);
		createPlayer("Master");
		createConsole(player);
		runTests();
		
		// Timeout fuer blockierende Spieler
		//Timer timer = new Timer();
		//timer.scheduleAtFixedRate(new RoundTimer(), 2000, 30000);
		
		//loginUser();
		
	}

	public void createNewLevel(int lev){
		level = new Level(lev);
		level.generate();
		if(DEV_MODE)
			level.printChildren();
	}
	
	public void createPlayer(String name){
		
		player = new Player(name);
		player.setCurrentPlanet(level.getSector(0).getSolarsystem(0).getPlanet(0));
		player.setHomePlanet(player.getCurrentPlanet());
		player.setHomeSolarsystem(level.getSector(0).getSolarsystem(0));
		player.addOwnership(player.getHomePlanet());
		
		player.getHomePlanet().spacestation = new SpaceStation("SST_001");

		System.out.println(prefix + "Willkommen im NeMeWeSa " + player.getName());
		if(DEV_MODE)		
			System.out.println(player);
	
	}
	
	public void createConsole(Player player){
		this.console = new Console(player);
	}
	
	public void loginUser(){
		
		if(login == null){
			while( true ){
				login = db.loginUser(console);
				if(login != null)
					break;
			}
			
			System.out.println("[Login] Willkommen " + login.name + ". Du bist nun angemeldet");
		}
		else{
			System.out.println("[Login] Du bist bereits angemeldet " + login.name);
		}
	}
	
	
	public void runTests(){
		
		//this.round.setNewRound();
		
		console.mainmenu();
		
//		// ROHSTOFFE ABERNTEN UND EINLAGERN
//		player.getCurrentPlanet().mineBronze();
//		player.getCurrentPlanet().mineBronze();
//		player.getCurrentPlanet().mineBronze();
//		player.getCurrentPlanet().mineBronze();
//		player.getCurrentPlanet().mineBronze();
//		player.getCurrentPlanet().mineBronze();
//		
//		System.out.println("BRONZE auf " + player.getCurrentPlanet().name + " : " + player.getCurrentPlanet().bronze.storagef);
//		
//		// ROHSTOFFE VOM PLANETEN ABHOLEN
//		if(player.getCurrentPlanet().pickupResource(player.getCurrentPlanet().bronze, 7)){
//			
//			System.out.println("Habe BRONZE auf " + player.getCurrentPlanet().name + " abgeholt. Aktueller Stand: " + player.getCurrentPlanet().bronze.storagef);
//			
//		}
//		else{
//			System.out.println("Konnte BRONZE auf " + player.getCurrentPlanet().name + " nicht abholen. Aktueller Stand: " + player.getCurrentPlanet().bronze.storagef);
//		}
//		
//		// LINKEN UND RECHTEN NACHBARPLANETEN ANZEIGEN
//		if(player.getLeftNeighbouringPlanet() != null)
//			System.out.println("Mein linker Nachbarplanet: " + player.getLeftNeighbouringPlanet().name);
//		if(player.getRightNeighbouringPlanet() != null)
//			System.out.println("Mein rechter Nachbarplanet: " + player.getRightNeighbouringPlanet().name);
		
//		int currPlanetIndex = player.getCurrentPlanet().parent.getPlanetIndex(player.getCurrentPlanet());
//		System.out.println("Der Index: " + currPlanetIndex);
//		System.out.println(player.getCurrentPlanet().name);
//
//		player.setCurrentPlanet(player.getCurrentPlanet().parent.getPlanet(currPlanetIndex+1));
//		
//		currPlanetIndex = player.getCurrentPlanet().parent.getPlanetIndex(player.getCurrentPlanet());
//		System.out.println("Der Index: " + currPlanetIndex);
//		System.out.println(player.getCurrentPlanet().name);		
		
//		System.out.println(player.getCurrentPlanet().getName());
//		System.out.println(player.getCurrentPlanet().moon.getName());
//		System.out.println("gegner " + player.getCurrentPlanet().moon.enemy.getName());
//		System.out.println(player.getCurrentPlanet().moon.enemy.getEnemyAttack());
//		System.out.println(player.getCurrentPlanet().moon.getParent());
		/*
		 * 
		 * Planet Ressourcen Test
		 * Hier kann, wenn der Planet eingenommen wurde (Methode mine "captured == true"), nach Ressourcen gefarmt werden.
		 * mit mine() wird abgefarmt 
		 * mit generateResource() wieder Ressourcen erstellt (wenn denn der die Runde mit den Nachwuchsfaktor "ressource.grow"
		 * uebereinstimmt)
		 */
//		this.round.setNewRound();		
//			
//		for (int i = 0; i < 11; i++) {
////			player.getCurrentPlanet().income();
//			
//			
//			System.out.println(i + " Einwohner: " + player.getCurrentPlanet().citizen);
//			System.out.println(i + " amount " + player.getCurrentPlanet().bronze.amount);
//			System.out.println(i + " farm " + player.getCurrentPlanet().bronze.farm);
//			System.out.println(i + " bronze storage f = " + player.getCurrentPlanet().bronze.storagef);		
//			player.getCurrentPlanet().mineBronze();
//			player.getCurrentPlanet().income();
//			System.out.println(i + " income " + player.getCurrentPlanet().bronze.farm);
//			System.out.println(i + " bronze storage f = " + player.getCurrentPlanet().bronze.storagef);
//			System.out.println("----------------------------------------------------------------");
//		}



//		System.out.println(" Nach Wieviel Runden soll regeneriert werden "+ player.getCurrentPlanet().resource.get(0).getGrow());
//		System.out.println("Welche Runde ist aktuell: " +round.getRound());		
//		player.getCurrentPlanet().mine(player.getCurrentPlanet().resource.get(0));
//		player.getCurrentPlanet().generateResource(player.getCurrentPlanet().resource.get(0));
		
		//this.player.saveAsString("level\\" + Level.level + "\\saves\\playerString.dat");
//		this.player.save("level\\" + Level.level + "\\saves\\playerObj.dat");
//		
//		try {
//			Thread.sleep(2000);
//		}catch( InterruptedException e) {}
//		
//		this.player.load("level\\" + Level.level + "\\saves\\playerObj.dat");
		
//		player.getCurrentPlanet().income();		

//	   for(int i = 0; i < 10; i++){
//		   
//		   int myVar = Helper.random(0, 2);
//		   
//		   System.out.println(myVar);
//		   
//	   }

		// Peters Teil.
		// Erstellte Objekte um zu schauen ob die methoden funktionieren

		/*
		SpaceStation alpha = new SpaceStation();
		alpha.stationName = "alpha";


		Moon luna = new Moon();
		luna.moonName = "Luna";
		luna.captured = false;

		ArrayList<Ressource> stock1 = new ArrayList<>();
		Fighter rambo = new Fighter();

		Enemy greenAlien = new Enemy();
		greenAlien.enemyHealth = 20;
		greenAlien.enemyStrange = 15;

		Enemy redAlien = new Enemy();
		redAlien.enemyHealth = 40;
		redAlien.enemyStrange = 30;

		// Hier attackiere ich als probe den Fighter(es klappt)
		//	greenAlien.enemyAttack(rambo);
		redAlien.enemyAttack(rambo);
		rambo.shipAttack(redAlien);
		rambo.shipAttack(redAlien);
		rambo.shipAttack(redAlien);
		rambo.shipAttack(redAlien);

		//Enemy.attack();
		//Enemy.attack(greenAlien);

		if(redAlien.enemyHealth <= 0)
		{
			rambo.capturing(luna); 

		} //Test

		System.out.println("Fighter Health = "+ rambo.shipHealth);
		System.out.println("RedAlien Health = "+ redAlien.enemyHealth);
		System.out.println("Ist Luna erobert " + luna.captured);
*/
		
	}

	public void pathTest(){
		Path path1 = new Path();
		path1.addAsteroid();
		path1.showPath();
		path1.howToMove();
	}
}
