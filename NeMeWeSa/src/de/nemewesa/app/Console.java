package de.nemewesa.app;

import java.util.Scanner;

import de.nemewesa.character.Player;
import de.nemewesa.menu.Menu;
import de.nemewesa.menu.Menuitem;

public class Console {

	Scanner scanner = new Scanner(System.in);
	Menu menu;
	Player player;
	
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
		
		menu.menuitems.add(
				new Menuitem("Hilfe"){
					public void execute(){
						help();
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
		
		menu.menuitems.add(
				new Menuitem("Umsehen"){
					public void execute(){
						showEnvironment();
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

		menu.menuitems.add(
				new Menuitem("Reisen"){
					public void execute(){
						move();
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
	
		
		createMenu(menu);
	}
	
	public void showEnvironment(){
		player.showEnvironment();
		actions();
	}
	
	public void research(){
		
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

	public void build(){ //TODO runden zeiten
		menu = new Menu();
		
		menu.menuitems.add(
				new Menuitem("Bohrer verbessern \t| 50 Spacedollar \t | (10 AP)"){
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
		createMenu(menu);
	}
	public void researching() {
		
		menu = new Menu();
		
		menu.menuitems.add(
				new Menuitem("Bohrer verbessern erlernen \t| 25 Spacedollar \t| (20 AP)"){
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