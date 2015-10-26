package Metier;

import com.bankonet.Client;
import com.bankonet.CompteCourant;

import DAO.DAOFile;
import Presentation.IHM;

public class GestionDesAffichages {
	/**
	 * Champ permettant d'incrémenter le numéro de compte
	 */
	private static int iteration = 0;
	
	
	/**
	 * Méthode qui permet de lancer l'IHM
	 */
	public static void gestionIHMconseiller(){
		String choixUtilisateur = IHM.GestionMenu();
		GestionChoix(choixUtilisateur);
	}

	/**
	 * Méthode qui gère le choix du conseiller et l'affichage du menu
	 * @param choixConseiller
	 */
	public static void GestionChoix(String choixConseiller) {
		switch (choixConseiller) {
		case "0":
		System.out.println("Arrêt de l’application");
		//fin de l'application	
			break;
		case "1":
		iteration++;
		Client client = IHM.RecupereClient();
		CompteCourant compteCourant = client.OuvreCompteCourant(iteration);
		DAOFile.SauvegardeFichier("clients.properties", client);
		DAOFile.SauvegardeFichier("comptes.properties", compteCourant);
		gestionIHMconseiller();
			break;
		case "2":
			DAOFile.ListeClients();
			gestionIHMconseiller();
		default: 
			System.out.println("Veuillez entrer une information correcte!");
			IHM.GestionMenu();
			break;
		}
	}



}
