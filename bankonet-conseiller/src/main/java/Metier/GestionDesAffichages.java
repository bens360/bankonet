package Metier;

import com.bankonet.Client;
import com.bankonet.CompteCourant;

import DAO.DAOFile;
import Presentation.IHM;

public class GestionDesAffichages {
	/**
	 * Champ permettant d'incr�menter le num�ro de compte
	 */
	private static int iteration = 0;
	
	
	/**
	 * M�thode qui permet de lancer l'IHM
	 */
	public static void gestionIHMconseiller(){
		String choixUtilisateur = IHM.GestionMenu();
		GestionChoix(choixUtilisateur);
	}

	/**
	 * M�thode qui g�re le choix du conseiller et l'affichage du menu
	 * @param choixConseiller
	 */
	public static void GestionChoix(String choixConseiller) {
		switch (choixConseiller) {
		case "0":
		System.out.println("Arr�t de l�application");
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
