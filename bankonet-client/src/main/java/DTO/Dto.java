package DTO;

import java.util.Scanner;

import com.bankonet.Client;
import com.bankonet.Compte;
import DAO.ClientDao;
import Metier.ActionCompte;

public class Dto {

	/**
	 * Méthode gérant le choix de l'utilisateur par rapport au menu
	 * @param client 
	 * 
	 * @param
	 */
	public static void GestionChoix (Client client) {
		String choixClient = RecupereChoixUtilisateur(client);
		switch (choixClient) {
		case "0":
		System.out.println("Arrêt de l’application");	
			break; //fin de l'application
		case "1":
			System.out.println("Cas solde des comptes");
			ClientDao.SoldeDesComptes(client);
			GestionChoix(client);
			break;
		case "2":
		Compte compte = ClientDao.SelectioneCompte();
		ActionCompte.EffectueDepot(compte);
		GestionChoix(client);
			break;
		case "3":
		compte = ClientDao.SelectioneCompte();
		ActionCompte.EffectueRetrait(compte);
		GestionChoix(client);
			break;
		case "4":
		Compte compteDebit = ClientDao.SelectioneCompte();
		Compte compteCredit = ClientDao.SelectioneCompte();
		ActionCompte.EffectueVirementEntreCompte();
		GestionChoix(client);
			break;
		case "5":
		ActionCompte.EffectueVirementExterne();
		GestionChoix(client);
		default: 
			System.out.println("Veuillez entrer une information correcte!");
			RecupereChoixUtilisateur(client);
			break;
		}
	}

	
	public static void gestionIHM(){
		Client client = GestionMenuLogIn();
		while (client!=null) {
			GestionChoix(client);
		}
	
	}
	
	/**
	 * Méthode récupérant le choix de l'utilisateur par rapport au menu affiché
	 * @param client 
	 * @return String: choixUtilisateur: le choix de l'utilisateur
	 */
	public static String RecupereChoixUtilisateur(Client client){
		String choixUtilisateur=new String();
		try {
		Scanner sc = new Scanner(System.in);
		Presentation.IHM.AfficheMenu(client);
		choixUtilisateur = sc.nextLine();
		} catch (Exception e) {
			System.out.println("Erreur dans RecupereChoixUtilisateur");
		}
		return choixUtilisateur;
	}

	/**
	 * Méthode gérant l'écran Login/MDP
	 * renvoi le client correspond au couple Login/MDP
	 * @return Client
	 */
	public static Client GestionMenuLogIn() {
		Scanner sc = new Scanner(System.in);
		boolean mdpOKKO =false;
		String loginClient="";
		String mdpClient="";
		
		while (mdpOKKO  == false || loginClient.equals("") || mdpClient.equals(""))  {
		Presentation.IHM.AfficheMenuLogin();
		System.out.println("Veuillez saisir votre login");
		loginClient = sc.nextLine();
		System.out.println("Veuillez saisir votre mot de passe");
		mdpClient = sc.nextLine();
		mdpOKKO = ClientDao.testLoginMdp(loginClient, mdpClient);
		}
		Client client = ClientDao.recupereClient(loginClient, mdpClient);
		return client;
	}

}
