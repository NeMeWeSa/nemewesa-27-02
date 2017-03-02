package de.nemewesa.app;

import java.io.File;
import java.util.Scanner;

import de.nemewesa.character.Player;
import de.nemewesa.helper.Helper;
import de.nemewesa.level.Level;
import de.nemewesa.menu.Menu;
import de.nemewesa.menu.Menuitem;

public class Console {

	Scanner scanner = new Scanner(System.in);
	Menu menu;
	Player player;
	File playerFile = new File("level" + File.separator + Level.level 
			+ File.separator + "saves" + File.separator + "player.dat");
	
	public Console(Player player){
		this.player = player;
	}
	
	public void mainmenu(){
		
		menu = new Menu();
		
		menu.menuitems.add(
				
				new Menuitem("Aktionen"){
					public void execute(){
						actions();
					}});
		
//		menu.menuitems.add(
//				new Menuitem("Hilfe"){
//					public void execute(){
//						help();
//					}});
		
		menu.menuitems.add(
				new Menuitem("Spieler laden"){
					public void execute(){
						player.load(playerFile);
						player = App.getAppInstance().getPlayer();
						System.err.println("LADEN - AP: " + App.getAppInstance().getPlayer().getAp());
						mainmenu();
					}});
		
		menu.menuitems.add(
				new Menuitem("Spieler speichern"){
					public void execute(){
						player.save(playerFile);
						mainmenu();
					}});
		
		menu.menuitems.add(
				new Menuitem("Debug"){
					public void execute(){
						debug();
					}});
		
		menu.menuitems.add(
				new Menuitem("Logout"){
					public void execute(){
						logout();
					}});
		
		System.out.println("[Hauptmenu] Treffe eine Wahl > \n");
		
		createMenu(menu);
		
		
	}	
	
	public void farmOre(){
		
		menu = new Menu();	
		System.out.println("######################");
		System.out.println("#      Erze farmen   #");
		System.out.println("######################");
		System.out.println("Deine aktuellen Aktionspunkte: " + App.getAppInstance().getPlayer().getAp() + "\n");

		menu.menuitems.add(
				new Menuitem("Bronze  (2 AP) \t| Vorhanden: " + player.getCurrentPlanet().bronze.farm +
						"\t| Im Lager: " + player.getCurrentPlanet().bronze.storagef){
					public void execute(){
						player.getCurrentPlanet().mineBronze();
						farmOre();
					}});
		
		menu.menuitems.add(
				new Menuitem("Silber  (3 AP) \t| Vorhanden: " + player.getCurrentPlanet().silver.farm +
						"\t| Im Lager: " + player.getCurrentPlanet().silver.storagef){
					public void execute(){
						player.getCurrentPlanet().mineSilver();
						farmOre();
					}});			

		menu.menuitems.add(
				new Menuitem("Gold    (4 AP) \t| Vorhanden: " + player.getCurrentPlanet().gold.farm +
						"\t| Im Lager: " + player.getCurrentPlanet().gold.storagef){
					public void execute(){
						player.getCurrentPlanet().mineGold();
						farmOre();
					}});	
		
		menu.menuitems.add(
				new Menuitem("Juwelen (5 AP) \t| Vorhanden: " + player.getCurrentPlanet().jewel.farm +
						"\t| Im Lager: " + player.getCurrentPlanet().jewel.storagef){
					public void execute(){
						player.getCurrentPlanet().mineJewel();
						farmOre();
					}});
		
		menu.menuitems.add(
				new Menuitem("Zurueck"){
					public void execute(){
						actions();
					}});

		System.out.println("[Erze sammeln] Welche Erze moechtest Du sammeln " + player.getName() + "?\n");		
		createMenu(menu);

	}

	public void actions(){
		
		menu = new Menu();

		System.out.println("Deine aktuellen Aktionspunkte: " + App.getAppInstance().getPlayer().getAp() + "\n");
		menu.menuitems.add(
				new Menuitem("Umsehen"){
					public void execute(){
						showEnvironment();
						actions();
					}});
		
		menu.menuitems.add(
				new Menuitem("Erze sammeln"){
					public void execute(){
						farmOre();
					}});

		if(App.getAppInstance().getPlayer().getCurrentPlanet() == App.getAppInstance().getPlayer().getHomePlanet()){
		menu.menuitems.add(
				new Menuitem("Erforschen und Entwickeln"){
					public void execute(){						
						research();
					}});
		
		menu.menuitems.add(
				new Menuitem("Erze eintauschen"){
					public void execute(){						
						exchange();
					}});
		}
		if(App.getAppInstance().getPlayer().getCurrentPlanet() != App.getAppInstance().getPlayer().getHomePlanet()){

		menu.menuitems.add(
				new Menuitem("Mond angreifen"){
					public void execute(){
						attackMoon();
					}});
		}
		menu.menuitems.add(
				new Menuitem("Reisen"){
					public void execute(){
						move();
					}});
		
		menu.menuitems.add(
				new Menuitem("Runde beenden"){
					public void execute(){
						App.getAppInstance().forceNewRound();
						actions();
					}});
		
		menu.menuitems.add(
				new Menuitem("Hauptmenu"){
					public void execute(){
						mainmenu();
					}});	

		System.out.println("[Aktionen] Was moechtest Du tun " + player.getName() + "?\n");
		
		createMenu(menu);

	}
	
	public void exchange() {
		System.out.println("######################");
		System.out.println("#     Auktionshaus   #");
		System.out.println("######################");
		menu = new Menu();
		
		menu.menuitems.add(
				new Menuitem("Bronze |\t Kurs: " + App.getAppInstance().getPlayer().getHomePlanet().bronze.value + "\\1 |\tBronze Lager: " + App.getAppInstance().getPlayer().getHomePlanet().bronze.storagef){
					public void execute(){
						App.getAppInstance().getPlayer().getHomePlanet().spacestation.exchangeBronze();
						exchange();
					}});
		menu.menuitems.add(
				new Menuitem("Silber |\t Kurs: " + App.getAppInstance().getPlayer().getHomePlanet().silver.value + "\\1 |\tSilber Lager: " + App.getAppInstance().getPlayer().getHomePlanet().silver.storagef){
					public void execute(){
						App.getAppInstance().getPlayer().getHomePlanet().spacestation.exchangeSilver();
						exchange();
					}});
		
		menu.menuitems.add(
				new Menuitem("Gold   |\t Kurs: " + App.getAppInstance().getPlayer().getHomePlanet().gold.value + "\\1 |\tGold Lager: " + App.getAppInstance().getPlayer().getHomePlanet().gold.storagef){
					public void execute(){
						App.getAppInstance().getPlayer().getHomePlanet().spacestation.exchangeGold();
						exchange();
					}});
		
		menu.menuitems.add(
				new Menuitem("Juwel  |\t Kurs: " + App.getAppInstance().getPlayer().getHomePlanet().jewel.value + "\\1 |\tJuwel Lager: " + App.getAppInstance().getPlayer().getHomePlanet().jewel.storagef){
					public void execute(){
						App.getAppInstance().getPlayer().getHomePlanet().spacestation.exchangeJewel();
						exchange();
					}});
		
		menu.menuitems.add(
				new Menuitem("Zurueck"){
					public void execute(){
						actions();
					}});
		
		System.out.println("[Auktionshaus] Was moechtest Du eintauschen " + player.getName() + "?\n");
		System.out.println("Aktueller Kontostand: " + App.getAppInstance().getPlayer().getHomePlanet().spacestation.bank);
		System.out.println("Deine aktuellen Aktionspunkte: " + App.getAppInstance().getPlayer().getAp() + "\n");
		
		createMenu(menu);
	}
	
	public void showEnvironment(){
		player.showEnvironment();
	}
	
	public void research(){
		
		System.out.println("########################");
		System.out.println("# Entwickeln und bauen #");
		System.out.println("########################");
		
		menu = new Menu();
		
		menu.menuitems.add(
				new Menuitem("Forschen"){
					public void execute(){
						researching();
					}});

		menu.menuitems.add(
				new Menuitem("Entwickeln"){
					public void execute(){
						build();
					}});
		
		
		menu.menuitems.add(
				new Menuitem("Zurueck"){
					public void execute(){
						actions();
					}});
		System.out.println("[Forschung und Entwicklung] Willkommen " + player.getName() +"\n");		
		createMenu(menu);

	}
	
	public void help(){
		System.out.println("Helfe...");
		mainmenu();
	}
	
	public void debug(){
		
		menu = new Menu();
		
		menu.menuitems.add(
				new Menuitem("Umsehen"){
					public void execute(){
						showEnvironment();
						debug();
					}});
		
		menu.menuitems.add(
				new Menuitem("Dem Spieler AK abziehen"){
					public void execute(){
						player.setAp(player.getAp() - 2);
						debug();
					}});
		
		menu.menuitems.add(
				new Menuitem("Spieler laden"){
					public void execute(){
						player.load(playerFile);
						player = App.getAppInstance().getPlayer();
						System.err.println("LADEN - AP: " + App.getAppInstance().getPlayer().getAp());
						debug();
					}});
		
		menu.menuitems.add(
				new Menuitem("Spieler speichern"){
					public void execute(){
						player.save(playerFile);
						debug();
					}});
		
		menu.menuitems.add(
				new Menuitem("Hauptmenue"){
					public void execute(){
						mainmenu();
					}});
		
		System.out.println("[Debug] Treffe eine Wahl > ");
		
		createMenu(menu);
		
	}

	public void attackMoon() {
		
		System.out.println("######################");
		System.out.println("#  Mond attackieren  #");
		System.out.println("######################");
		System.out.println("Dieser Mond heisst: " + App.getAppInstance().getPlayer().getCurrentPlanet().moon.getName());
		System.out.println("Er wird vom Monster: " + App.getAppInstance().getPlayer().getCurrentPlanet().moon.enemy.getName() + " bewacht");
		
		System.out.println();
		menu = new Menu();
		
		System.out.println("Deine aktuellen Aktionspunkte: " + App.getAppInstance().getPlayer().getAp() + "\n");
		System.out.println("Fuer die Reise zum Mond werden dir 20 AP abgezogen.");
		System.out.println("High Risk = High reward!!");
		System.out.println("Solltest du " + App.getAppInstance().getPlayer().getCurrentPlanet().moon.enemy.getName() + " besiegen so gehoert Dir der Planet " 
		+ App.getAppInstance().getPlayer().getCurrentPlanet().getName() + "!");
		System.out.println("Solltest du aber scheitern " + App.getAppInstance().getPlayer().getName() + ", verlierst du diese Runde\n");

		if(App.getAppInstance().getPlayer().getAp() >= 20) {
			System.out.println("Deine restlichen " + (App.getAppInstance().getPlayer().getAp() - 20) + " AP sind deine Kampfenergie");
			
			menu.menuitems.add(
			new Menuitem("Kaempfen"){
				public void execute(){
					fight();
				}});
		}
				
		
		menu.menuitems.add(
				new Menuitem("Nicht kaempfen"){
					public void execute(){
						actions();
					}});
		
		createMenu(menu);
		
	}
	
	public Login login(){

		//scanner = new Scanner(System.in);
		System.out.println("[Login] Gebe bitte Deinen Loginnamen ein > ");
		String loginname = scanner.nextLine();
		System.out.println("[Login] Gebe bitte Dein Passwort ein > ");
		String pass = scanner.nextLine();	

		Login login = new Login(loginname, pass);
		return login;

	}
	
	public void logout(){
		System.out.println("[NeMeWeSa] " + player.getName() + " hat das Spiel verlassen.");
	}
	public void fight() {
		App.getAppInstance().getPlayer().setAp(App.getAppInstance().getPlayer().getAp()-20);
		while(App.getAppInstance().getPlayer().getAp() > 0) {
			System.out.println("######################");
			System.out.println("#      Kampf         #");
			System.out.println("######################");
			
			System.out.println("Deine aktuellen HP: " + App.getAppInstance().getPlayer().getAp() + "");
			System.out.println("Gegner HP: " + App.getAppInstance().getPlayer().getCurrentPlanet().moon.enemy.getEnemyHealth()+"\n");
			
			int attackEnemy = Helper.random(1, App.getAppInstance().getPlayer().getCurrentPlanet().moon.enemy.getEnemyAttack());
			System.out.println(App.getAppInstance().getPlayer().getCurrentPlanet().moon.enemy.getName() + " trifft dich fuer " + 
			 attackEnemy + " Schaden");
			
			int attackPlayer = 100;//Helper.random(1, 10);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			
			App.getAppInstance().getPlayer().getCurrentPlanet().moon.enemy.setEnemyHealth(App.getAppInstance().getPlayer().getCurrentPlanet().moon.enemy.enemyHealth - attackPlayer);
			App.getAppInstance().getPlayer().setAp(App.getAppInstance().getPlayer().getAp() - attackEnemy);		
			if(App.getAppInstance().getPlayer().getCurrentPlanet().moon.enemy.getEnemyHealth() <= 0) {
				break;
			}
		}
		if(App.getAppInstance().getPlayer().getCurrentPlanet().moon.enemy.getEnemyHealth() <= 0){
			System.out.println("Glueckwunsch ab jetzt gehoert Dir der Planet " + App.getAppInstance().getPlayer().getCurrentPlanet().getName() + " und deren Einwohner");
			App.getAppInstance().getPlayer().getCurrentPlanet().income();
			App.getAppInstance().getPlayer().addOwnership(App.getAppInstance().getPlayer().getCurrentPlanet());
			menu = new Menu();
			menu.menuitems.add(
					new Menuitem("Zurueck"){
						public void execute(){
							actions();
						}});
			
			createMenu(menu);
		}
		else {
			System.out.println("Dein Spiel ist leider vorbei");
			menu = new Menu();

			menu.menuitems.add(
					new Menuitem("Zurueck"){
						public void execute(){
							actions();
						}});
			
			createMenu(menu);
		}
	
	}

	public void build(){ //TODO runden zeiten
		System.out.println("######################");
		System.out.println("#      Werkstatt     #");
		System.out.println("######################");
		menu = new Menu();
		menu.menuitems.add(
				new Menuitem("Bohrer verbessern \t| 50 Spacedollar | (10 AP)"){
					public void execute(){		
						if(App.getAppInstance().getPlayer().getHomePlanet().spacestation.researchPoint > App.getAppInstance().getPlayer().getHomePlanet().spacestation.modulePoint) {
							App.getAppInstance().getPlayer().getHomePlanet().spacestation.produce();
							build();
						}
						else {
							System.out.println("Dieser Bohrer muss erst erforscht werden)");
							build();
						}
					}});
		
		menu.menuitems.add(
				new Menuitem("Zurueck"){
					public void execute(){
						research();
					}});
		System.out.println("[Entwicklung] Was soll gebaut werden, " + player.getName() + "?\n");
		System.out.println("Aktueller Kontostand: " + App.getAppInstance().getPlayer().getHomePlanet().spacestation.bank);
		System.out.println("Aktueller Bohrerlevel: " + App.getAppInstance().getPlayer().getHomePlanet().spacestation.modulePoint +"\n");
		System.out.println("Deine aktuellen Aktionspunkte: " + App.getAppInstance().getPlayer().getAp() + "\n");
		createMenu(menu);
	}
	public void researching() {
		System.out.println("######################");
		System.out.println("#  Forschungszenter  #");
		System.out.println("######################");
		menu = new Menu();
		
		menu.menuitems.add(
				new Menuitem("Bohrer verbessern erlernen \t| 25 Spacedollar | (20 AP)"){
					public void execute(){
						App.getAppInstance().getPlayer().getHomePlanet().spacestation.researching();
						researching();
					}});
		
		menu.menuitems.add(
				new Menuitem("Zurueck"){
					public void execute(){
						research();
					}});
		
		System.out.println("[Forschung] Was soll erforscht werden, " + player.getName() + "?\n");
		System.out.println("Aktueller Kontostand: " + App.getAppInstance().getPlayer().getHomePlanet().spacestation.bank);
		System.out.println("Aktuller Forschungstand: " + App.getAppInstance().getPlayer().getHomePlanet().spacestation.researchPoint +"\n");
		System.out.println("Deine aktuellen Aktionspunkte: " + App.getAppInstance().getPlayer().getAp() + "\n");

		createMenu(menu);
	}
	public void move(){
		
		menu = new Menu();
		
		if(player.getLeftNeighbouringPlanet() != null){
			menu.menuitems.add(
				new Menuitem(player.getLeftNeighbouringPlanet().name){
					public void execute(){
						player.move(player.getLeftNeighbouringPlanet());
						actions();
					}});
		}
		
		if(player.getRightNeighbouringPlanet() != null){
			menu.menuitems.add(
				new Menuitem(player.getRightNeighbouringPlanet().name){
					public void execute(){
						player.move(player.getRightNeighbouringPlanet());
						actions();
					}});
		}
		
		menu.menuitems.add(
			new Menuitem("Hauptmenu"){
				public void execute(){
					mainmenu();
				}});
		
		menu.menuitems.add(
				new Menuitem("Zurueck"){
					public void execute(){
						actions();
					}});

		System.out.println("[Reisen] Zu welchen Nachbarplaneten moechtest Du reisen " + player.getName() + "?\n");
		
		createMenu(menu);
		
	}
	
	public void createMenu(Menu menu){
		
		int i = 0;
		
		for(Menuitem item : menu.menuitems){
			System.out.println("[Option] " + ++i + ". " + item.desc + " > ");
		}
		
		while(true){
			
			try
			{
				int decision = scanner.nextInt();
				if(decision >= 1 && decision <= menu.menuitems.size()){
					
					menu.menuitems.get(decision-1).execute();
					break;
					
				}
				else{
					System.out.println("UNGUELTIGE WAHL, BITTE NOCHMAL VERSUCHEN");
				}				
			}
			catch (java.util.InputMismatchException exception)
			{
				System.out.println("BITTE NUR ZAHLEN EINGEBEN");
				scanner.next();
			}
		}
		
	}

}