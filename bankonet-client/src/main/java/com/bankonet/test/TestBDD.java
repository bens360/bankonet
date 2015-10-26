package com.bankonet.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.JDBCConnexionBDD;

public class TestBDD {

	public static void main(String[] args) {
		String request = "SELECT * FROM CLIENT";
		ResultSet resultat = JDBCConnexionBDD.jDBCRequestBDD(request);
		try {
			while (resultat.next()) {
			Integer id = resultat.getInt("id_client");
			String nom = resultat.getString("nom");
			String prenom = resultat.getString("prenom");
			String civilite = resultat.getString("civilite");
			System.out.println("Client n° " + id + " Nom: " + nom + " Prenom: " + prenom);
}
		} catch (SQLException e) {
			System.out.println("Problème à l'affichage du résultat");
			e.printStackTrace();
		}
	}

}
