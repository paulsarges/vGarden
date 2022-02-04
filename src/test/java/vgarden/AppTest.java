package vgarden;

import java.util.Scanner;



public class AppTest {

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
