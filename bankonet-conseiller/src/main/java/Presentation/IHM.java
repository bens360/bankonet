package Presentation;

import java.util.Random;
import java.util.Scanner;

import com.bankonet.Civilite;
import com.bankonet.Client;

public class IHM {

	/**
	 * Affichage du menu
	 */
	public static void AfficheMenu() {
		System.out.println("****APPLICATION CONSEILLER BANCAIRE***");
		System.out.println("0. Arrêter le programme");
		System.out.println("1. Ouvrir un compte courant");
		System.out.println("2. Lister tous les clients");
		System.out.println("Veuillez choisir une action.");
	}

	/**
	 * Méthode permettant de renseigner les champs d'un client
	 * et qui crée un client
	 * @return client
	 */
	public static Client RecupereClient(){
		Random identifiantClient = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("Indiquer le nom du client: ");
		String nomClient = sc.nextLine();
		System.out.println("Indiquer le prenom du client: ");
		String prenomClient = sc.nextLine();
		System.out.println("Indiquer le login du client: ");
		String loginClient = sc.nextLine();
		System.out.println("Indiquer le mot de passe du client: ");
		String motDePasse = sc.nextLine();
		Client client = new Client(identifiantClient.toString() ,Civilite.MONSIEUR, nomClient, prenomClient, loginClient, motDePasse); //TODO à modifier lors de la gestion client
		return client;
	}

	/**
	 * Méthode qui gère l'affichage du menu et renvoi le choix de l'utilisateur
	 * @return choixUtilisateur
	 */
	public static String GestionMenu(){
		Scanner sc = new Scanner(System.in);
		IHM.AfficheMenu();
		String choixUtilisateur = sc.nextLine();
		return choixUtilisateur;
	}
}
