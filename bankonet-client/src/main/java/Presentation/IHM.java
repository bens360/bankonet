package Presentation;

import com.bankonet.Client;

public class IHM {

	/**
	 * M�thode affichant le menu
	 * @param client 
	 * 
	 */
	public static void AfficheMenu(Client client) {
		System.out.println("****APPLICATION CLIENT***");
		System.out.println("0. Arr�ter le programme");
		System.out.println("1. Consulter les soldes des comptes");
		System.out.println("2. Effectuer un d�pot");
		System.out.println("3. Effectuer un retrait");
		System.out.println("4. Effectuer un virement entre vos comptes");
		System.out.println("5. Effectuer un virement externe");
		System.out.println("Veuillez choisir une action." + client.getCivilite() + " " + client.getNom()+ " " + client.getPrenom());
	}

	
	/**
	 * M�thode affichant l'�cran Login/MDP
	 */
	public static void AfficheMenuLogin(){
		System.out.println("****** Menu LOGIN ******");
		System.out.println("Veuillez renseigner votre login puis votre mot de passe");
	}

}
