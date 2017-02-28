package de.nemewesa.app;

import java.util.Scanner;

import de.nemewesa.character.Player;
import de.nemewesa.menu.Menu;
import de.nemewesa.menu.Menuitem;

public class Console {

	Scanner scanner = new Scanner(System.in);
	
	public void mainmenu(Player player){

		while(true){

			System.out.println("[NeMeWeSa] Treffe eine Wahl > ");
			System.out.println("[NeMeWeSa] 1. Aktionen | 2. Hilfe | 3. Logout > ");

			try
			{
				int decision = scanner.nextInt();
				if(decision >= 1 && decision <= 3){
					switch(decision){

					case 1:	actions(player);
					return;

					case 2:	help(player);
					return;
					
					case 3:	logout(player);
					return;

					//case "q":	return;

					default:
						System.out.println("[NeMeWeSa] Ungueltige Wahl");
					}
				}
				else{
					System.out.println("UNGUELTIGE ZAHL, BITTE NOCHMAL VERSUCHEN");
				}				
			}
			catch (java.util.InputMismatchException exception)
			{
				System.out.println("BITTE NUR ZAHLEN EINGEBEN");
				scanner.next();
			}
		}
	}	

	
	public void actions(Player player){
		
		Menu menu = new Menu();
		
		menu.menuitems.add(
				new Menuitem("Umsehen"){
					public void execute(	){
						showEnvironment(player);
					}});	
		
		menu.menuitems.add(
				new Menuitem("Bauen"){
					public void execute(	){
						build(player);
					}});			

		menu.menuitems.add(
				new Menuitem("Reisen"){
					public void execute(	){
						move(player);
					}});	
		
		menu.menuitems.add(
				new Menuitem("Hauptmenu"){
					public void execute(	){
						mainmenu(player);
					}});	

		System.out.println("[NeMeWeSa] Was moechtest Du tun " + player.getName() + "?");
		
		printMenu(menu);

	}
	
	public void showEnvironment(Player player){
		
		player.showEnvironment();
		actions(player);

	}
	
	public void build(Player player){
		System.out.println("Baue...");
		actions(player);
	}
	
//	public void move(Player player){
//		
//		while(true){
//
//			System.out.println("[NeMeWeSa] Zu welchen Nachbarplaneten moechtest Du reisen " + player.getName() + "?");
//			
//			if(player.getLeftNeighbouringPlanet() != null)
//				System.out.println("[NeMeWeSa] 1. " + player.getLeftNeighbouringPlanet().name + " > ");
//			if(player.getRightNeighbouringPlanet() != null)
//				System.out.println("[NeMeWeSa] 2. " + player.getRightNeighbouringPlanet().name + " > ");
//
//			System.out.println("[NeMeWeSa] 3. Hauptmenu > ");
//			
//			try
//			{
//				int decision = scanner.nextInt();
//				if(decision >= 1 && decision <= 3){
//					switch(decision){
//
//					case 1:	
//						if(player.getLeftNeighbouringPlanet() != null){
//							player.move(player.getLeftNeighbouringPlanet());
//							actions(player);
//						}
//						else{
//							move(player);
//						}
//					return;
//
//					case 2:	
//						if(player.getRightNeighbouringPlanet() != null){
//							player.move(player.getRightNeighbouringPlanet());
//							actions(player);
//						}
//						else{
//							move(player);
//						}
//					return;
//					
//					case 3:	mainmenu(player);
//					return;
//
//					default:
//						System.out.println("[NeMeWeSa] Ungueltige Wahl");
//					}
//				}
//				else{
//					System.out.println("UNGUELTIGE ZAHL, BITTE NOCHMAL VERSUCHEN");
//				}				
//			}
//			catch (java.util.InputMismatchException exception)
//			{
//				System.out.println("BITTE NUR ZAHLEN EINGEBEN");
//				scanner.next();
//			}
//		}
//	}
	
	public void help(Player player){
		System.out.println("Helfe...");
		mainmenu(player);
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
	
	public void logout(Player player){
		System.out.println("Verlasse das Spiel...");
	}
	
	public void move(Player player){
		
		Menu menu = new Menu();
		
		if(player.getLeftNeighbouringPlanet() != null){
			menu.menuitems.add(
					new Menuitem(player.getLeftNeighbouringPlanet().name){
						public void execute(	){
							player.move(player.getLeftNeighbouringPlanet());
							actions(player);
						}});
		}
		
		if(player.getRightNeighbouringPlanet() != null){
			menu.menuitems.add(
					new Menuitem(player.getRightNeighbouringPlanet().name){
						public void execute(	){
							player.move(player.getRightNeighbouringPlanet());
							actions(player);
						}});
		}
		
		menu.menuitems.add(
			new Menuitem("Hauptmenu"){
				public void execute(	){
					mainmenu(player);
				}});

		System.out.println("[NeMeWeSa] Zu welchen Nachbarplaneten moechtest Du reisen " + player.getName() + "?");
		
		printMenu(menu);
		
	}
	
	public void dynmenu(Player player){
		
		Menu menu = new Menu();
		
		menu.menuitems.add(
				new Menuitem("Umgebung anzeigen"){
					public void execute(	){
						player.showEnvironment();
					}});
		
		menu.menuitems.add(
				
				new Menuitem("Weitere Optionen"){
					public void execute(	){
						actions(player);
					}});		
		
		printMenu(menu);
		
	}
	
	public void printMenu(Menu menu){
		
		int i = 0;
		
		for(Menuitem item : menu.menuitems){
			System.out.println("[NeMeWeSa] " + ++i + ". " + item.desc + " > ");
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

// CHECK THIS
// TODO Command Pattern ansehen
/*

interface Movable  {

	Player player;
		
	public void move( Player player );

}

new Movable() {
	public void move( Player player ) {
		drive();
	}
	public void move( Spaceship ship) {
		takeOff();
		fly();
		land();
	}
};


// Console richtig implementiert 
print(return String);

readLine (return String);

*/
