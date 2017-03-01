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
		
		System.out.println("[Hauptmenu] Treffe eine Wahl > ");
		
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
				new Menuitem("Bauen"){
					public void execute(){
						build();
					}});			

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

		System.out.println("[Aktionen] Was moechtest Du tun " + player.getName() + "?");
		
		createMenu(menu);

	}
	
	public void showEnvironment(){
		player.showEnvironment();
		actions();
	}
	
	public void build(){
		System.out.println("Baue...");
		actions();
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

		System.out.println("[Reisen] Zu welchen Nachbarplaneten moechtest Du reisen " + player.getName() + "?");
		
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