package com.bankonet.test;

import com.bankonet.Civilite;
import com.bankonet.Client;
import com.bankonet.Stockage;

public class TestStockage {

	public static void main(String[] args) {
		
		Client client1 = new Client("2223365", Civilite.MONSIEUR, "Paul", "Hugues", "C001","secret");
		Client client2 = new Client("5669853", Civilite.MONSIEUR,"Julien", "Hugues", "C002", "secret");
		Client client3 = new Client("3232546", Civilite.MADAME,"Julie", "Hugues", "C003", "secret");
		
		Stockage<String, Client> stockageClient = new Stockage<>();
		stockageClient.ajouter(client1.getIdentifiant(), client1);
		stockageClient.ajouter(client2.getIdentifiant(), client2);
		stockageClient.ajouter(client3.getIdentifiant(), client3);
		System.out.println(stockageClient.retournerElement(client2.getIdentifiant()));
		
		
		
	}
}
