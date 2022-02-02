package PotagerMaven;

import java.util.Scanner;

import PotagerMaven.model.Admin;
import PotagerMaven.model.Compte;
import PotagerMaven.model.Particulier;
import PotagerMaven.model.Pro;



public class AppTest {
	
	static Compte connected = null;
	
	public static String saisieString(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}

	public static double saisieDouble(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextDouble();
	}

	public static int saisieInt(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}

	public static void main(String[] args) {		
		System.out.println("test");;

	}

	public static void menuPrincipal() {

	}
	
	public static void menuAdmin() {

	}
	
	public static void connexion() {

	}
	public static void menuClient() {
	}

	public static void menuVendeur() {
		
	}
	public static void menuAchat() {
		
	}
	public static void menuPotager() {
		
	}
	
	

}
