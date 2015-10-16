package com.bankonet;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	private static int iteration = 0;

	public static void IHM(){
		String choixUtilisateur = Menu.GestionMenu();
		Menu.GestionChoix(choixUtilisateur);
	}
	
	public static void AfficheMenu() {
		System.out.println("****APPLICATION CONSEILLER BANCAIRE***");
		System.out.println("0. Arrêter le programme");
		System.out.println("1. Ouvrir un compte courant");
		System.out.println("2. Lister tous les clients");
		System.out.println("Veuillez choisir une action.");
	}
	
	public static String GestionMenu(){
		Scanner sc = new Scanner(System.in);
		AfficheMenu();
		String choixUtilisateur = sc.nextLine();
		return choixUtilisateur;
	}
	
	public static void GestionChoix(String choixConseiller) {
		switch (choixConseiller) {
		case "0":
		System.out.println("Arrêt de l’application");
		//fin de l'application	
			break;
		case "1":
		iteration++;
		Client client = RecupereClient();
		CompteCourant compteCourant = client.OuvreCompteCourant(iteration);
		SauvegardeFichier("clients.properties", client);
		SauvegardeFichier("comptes.properties", compteCourant);
		IHM();
			break;
		case "2":
		ListeClients();
		IHM();
		default: 
			System.out.println("Veuillez entrer une information correcte!");
			GestionMenu();
			break;
		}
	}

	
	/**
	 * Méthode permettant de sauvegarder un objet dans un fichier
	 * @param fichierDeSauvegarde
	 * @param objetASauvegarder
	 */
	
	public static void SauvegardeFichier(String fichierDeSauvegarde, Object objetASauvegarder) {
		File file = new File(fichierDeSauvegarde); 
		    try {
		    	ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream (file));
				oos.writeObject (objetASauvegarder);
				//oos.close();
			} catch (IOException e) {
				System.out.println("Erreur lors de l'écriture de l'objet :" + objetASauvegarder.toString() + "dans la fichier " + fichierDeSauvegarde);
				e.printStackTrace();
			}
	}
	
	
	/**
	* Méthode permettant récupérer les infos d'un fichier sérialisé 
	* @param nomFichier (String) le nom du fichier à récupérer
	* @return listObjet (ArrayList): l'objet qui est renvoyé
	*/
	public static ArrayList RecupereInfoFichier (String nomFichier){
		ArrayList listObjet= new ArrayList();
		try
		{
		    ObjectInputStream ois = new ObjectInputStream (new FileInputStream (nomFichier)); 
	         byte[] buf = new byte[8];
	         int n = 0;
	         while ((n = ois.read(buf)) != -1) {
	    	listObjet.add(ois.readObject());
		    }
		    ois.close();
		}
		catch (ClassNotFoundException exception)
		{
		    System.out.println ("Impossible de lire l'objet : " + exception.getMessage());
		}
		catch (IOException exception)
		{
		    System.out.println ("Erreur lors de l'écriture : " + exception.getMessage());
		}
		return listObjet;
	}
	
	private static Client RecupereClient(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Indiquer le nom du client: ");
		String nomClient = sc.nextLine();
		System.out.println("Indiquer le prenom du client: ");
		String prenomClient = sc.nextLine();
		System.out.println("Indiquer le login du client: ");
		String loginClient = sc.nextLine();
		System.out.println("Indiquer le mot de passe du client: ");
		String motDePasse = sc.nextLine();
		Client client = new Client(Civilite.MONSIEUR, nomClient, prenomClient, loginClient, motDePasse); //TODO à modifier lors de la gestion client
		return client;
	}


	private static void ListeClients() {
		ArrayList listClient = RecupereInfoFichier("clients.properties");
		int compteurObjet=0;
		for (Object object : listClient) {
			compteurObjet++;
			System.out.println(object);
		}
		System.out.println(compteurObjet);

		
	}


	
	
}
