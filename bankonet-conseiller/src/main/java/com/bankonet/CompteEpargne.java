package com.bankonet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "compte_epargne")
public class CompteEpargne extends Compte {
	private static final double PLAFOND = 12000;
	
	private double tauxInteret;

	public CompteEpargne(int numero, String intitule, double solde, double tauxInteret) {
		super(numero, intitule, solde);
		this.tauxInteret = tauxInteret;
	}
	
	public CompteEpargne(){
		
	}

	public double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}

	@Override
	public void crediter(double montant) throws CompteException {
		if(getSolde() + montant > PLAFOND) {
			throw new CreditException();
		}
		super.crediter(montant);
	}

	@Override
	public String toString() {
		return String.format("CompteEpargne [tauxInteret=%s, getNumero()=%s, getIntitule()=%s, getSolde()=%s]",
				tauxInteret, getNumero(), getIntitule(), getSolde());
	}

	@Override
	protected double calculerDebitMaximum() {
		return getSolde();
	}
	
	
	
	

}
