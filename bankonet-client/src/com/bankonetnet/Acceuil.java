package com.bankonetnet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import com.bankonet.Client;
import com.bankonet.Compte;
import com.bankonet.CompteCourant;
import com.bankonet.Menu;
import com.sun.org.apache.bcel.internal.generic.GOTO;


public class Acceuil {

	public static void main(String[] args) {
	 
		 
	}


	private static Client client;
	
	
	private void menuLogIn() {
		Scanner sc = new Scanner(System.in);
		boolean mdpOKKO =false;
		while (mdpOKKO  == false) {
		System.out.println("Veuillez saisir votre login");
		String loginClient = sc.nextLine();
		System.out.println("Veuillez saisir votre mot de passe");
		mdpOKKO = testLoginMdp();			
		}
		client = recupereClient();
		IHM();
	}


/**
 * Méthode testant l'adéquation du couple login / mot de passe, renseigné par le client
 * @return 
 */
	private boolean testLoginMdp() {
		
		return false;
	}



private Client recupereClient() {
	// TODO Auto-generated method stub
	return null;
}

public static void IHM(){
	String choixUtilisateur = GestionMenu();
	GestionChoix(choixUtilisateur);
}

/**
 * Méthode récupérant le choix de l'utilisateur par rapport au menu affiché
 * @return String: choixUtilisateur: le choix de l'utilisateur
 */
public static String GestionMenu(){
	String choixUtilisateur=new String();
	try {
	Scanner sc = new Scanner(System.in);
	AfficheMenu();
	choixUtilisateur = sc.nextLine();
	} catch (Exception e) {
		System.out.println("Erreur dans Gestion menu");
	}
	return choixUtilisateur;
}


/**
 * Méthode affichant le menu
 * 
 */
public static void AfficheMenu() {
	System.out.println("****APPLICATION CLIENT***");
	System.out.println("0. Arrêter le programme");
	System.out.println("1. Consulter les soldes des comptes");
	System.out.println("2. Effectuer un dépot");
	System.out.println("3. Effectuer un retrait");
	System.out.println("4. Effectuer un virement entre vos comptes");
	System.out.println("5. Effectuer un virement externe");
	System.out.println("Veuillez choisir une action.");
}


/**
 * Méthode gérant le choix de l'utilisateur par rapport au menu
 * 
 * @param
 */

public static void GestionChoix(String choixClient) {
	switch (choixClient) {
	case "0":
	System.out.println("Arrêt de l’application");
	//fin de l'application	
		break;
	case "1":
	SoldeDesComptes();
	IHM();
		break;
	case "2":
	Compte compte = SelectioneCompte();
	EffectueDepot(compte);
	IHM();
		break;
	case "3":
	compte = SelectioneCompte();
	EffectueRetrait(compte);
	IHM();
		break;
	case "4":
	Compte compteDebit = SelectioneCompte();
	Compte compteCredit = SelectioneCompte();
	EffectueVirementEntreCompte();
	IHM();
		break;
	case "5":
	EffectueVirementExterne();
	IHM();
	default: 
		System.out.println("Veuillez entrer une information correcte!");
		GestionMenu();
		break;
	}
}


private static Compte SelectioneCompte() {
	System.out.println("On est dans SelectioneCompte");
	Compte compteSelection;
	
	/*
	 try {
	Collection<Compte> collectionDesComptes = client.getComptesList();
	for (Compte compte : collectionDesComptes) {
		System.out.println(compte);
	}
	System.out.println("Choissisez le compte à crediter");
	Scanner sc = new Scanner(System.in);
	String choixUtilisateur = sc.nextLine();
	compteSelectione = ?? */
	
	return compteSelection=null;
}


private static void EffectueVirementExterne() {
	System.out.println("on est dans EffectueVirementExterne");
	
	
}


private static void EffectueVirementEntreCompte() {
	// TODO Auto-generated method stub
	System.out.println("on est dans EffectueVirementEntreCompte");
}


private static void EffectueRetrait(Compte compte) {
	// TODO Auto-generated method stub
	System.out.println("on est dans EffectueRetrait");
	
	
	
}


private static void EffectueDepot(Compte compte) {
	System.out.println("on est dans EffectueDepot");
	/*System.out.println("Montant à crediter?");
	Scanner sc = new Scanner(System.in);
	double montantCrediter = Double.parseDouble(sc.nextLine());
	try {
	compte.crediter(montantCrediter);
	} catch (Exception e) {
		System.out.println("Erreur dans la réalisation du dépot");
	}
	*/
	
}


private static void SoldeDesComptes() {
	System.out.println("on est dans SoldeDesComptes");
	/*try {
		Collection<Compte> collectionDesComptes = client.getComptesList();
	for (Compte compte : collectionDesComptes) {
		System.out.println("Le solde du compte: " + compte.getIntitule() + " est de : "+ compte.getSolde());
	}
	} catch (Exception e) {
		System.out.println("Erreur dans Soldes des comptes");
	} 
	*/
}

}