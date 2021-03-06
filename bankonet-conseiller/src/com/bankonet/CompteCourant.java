package com.bankonet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CompteCourant extends Compte {
	

	private double montantDecouvertAutorise;
	private static int nbCompteCourants = 0;
	
	
		
	public CompteCourant(String numero, String libelle, double solde, double montantDecouvertAutorise) {
		super(numero, libelle, solde);		
		this.montantDecouvertAutorise = montantDecouvertAutorise;
		nbCompteCourants++;
	}
	
	
	public double getMontantDecouvertAutorise() {
		return montantDecouvertAutorise;
	}
	public void setMontantDecouvertAutorise(double montantDecouvertAutorise) {
		this.montantDecouvertAutorise = montantDecouvertAutorise;
	}
	
	public static int getNbCompteCourant() {
		return nbCompteCourants;
	}
	
	


	@Override
	public String toString() {
		return String.format("CompteCourant [numero=%s, intitule=%s, solde=%s, montantDecouvertAutorise=%s]", getNumero(),
				getIntitule(), getSolde(), montantDecouvertAutorise);
	}


	@Override
	protected double calculerDebitMaximum() {
		return montantDecouvertAutorise + getSolde();
	}
	
	public void SauvegardeCompteCourant() {
		File comptesProperties = new File("comptes.properties"); 
		    try {
		    	ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream (comptesProperties));
				oos.writeObject (this);
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}
