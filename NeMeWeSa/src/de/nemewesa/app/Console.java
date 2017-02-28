package de.nemewesa.app;

import java.util.Scanner;

import de.nemewesa.character.Player;

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

		while(true){

			System.out.println("[NeMeWeSa] Was moechtest Du tun " + player.getName() + "?");
			System.out.println("[NeMeWeSa] 1. Umsehen > ");
			System.out.println("[NeMeWeSa] 2. Bauen > ");
			System.out.println("[NeMeWeSa] 3. Reisen > ");
			System.out.println("[NeMeWeSa] 4. Hauptmenu > ");
			
			try
			{
				int decision = scanner.nextInt();
				if(decision >= 1 && decision <= 4){
					switch(decision){

					case 1:	showEnvironment(player);
					return;

					case 2:	build(player);
					return;

					case 3:	move(player);
					return;

					case 4:	mainmenu(player);
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
	
	public void showEnvironment(Player player){
		
		player.showEnvironment();
		actions(player);
		
//		System.out.println("Dein aktueller Planet > " + player.getCurrentPlanet().name);
//		System.out.println("Dein aktuelles Sonnensystem > " + player.getCurrentPlanet().parent.name);
//		System.out.println("Dein aktueller Sektor > " + player.getCurrentPlanet().parent.parent.name + "\n");

	}
	
	public void build(Player player){
		System.out.println("Baue...");
		actions(player);
	}
	
	public void move(Player player){
		System.out.println("Bewege mich...");
		actions(player);
	}
	
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

}

// CHECK
/*

interface Movable  {


	Player player;
	
	public void move( Player player );
}

new Movable() {
	public void move( Player player ) {}
	public void move( Spaceship ship) {
//		egerger
//		eggr
	}
};

print(return String);

readLine (return String);

*/
