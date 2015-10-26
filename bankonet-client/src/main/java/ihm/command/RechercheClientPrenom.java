package ihm.command;

import java.util.Scanner;
import com.bankonet.Client;

import client.ClientDaoJpa;

public class RechercheClientPrenom implements IhmCommand{

	@Override
	public Integer getId() {
		return 4;
	}

	@Override
	public String getLibelleMenu() {
		return "Rechercher un client par son pr�nom";
	}

	@Override
	public void execute (Client client) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Indiquer le pr�nom recherch�");
		String prenom = sc.nextLine();
		//Client clientPrenom = recherchePrenom(prenom);
		//System.out.println("Client trouv�: " + clientPrenom);
	}
	
}
