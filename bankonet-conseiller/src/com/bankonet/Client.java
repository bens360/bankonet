package com.bankonet;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Client implements java.io.Serializable{
	
	private Civilite civilite;
	@ToString (uppercase = true) private String nom;
	@ToString private String prenom;
	@ToString private String identifiant = UUID.randomUUID().toString();
	@ToString private String login;
	@ToString private String motDePasse;
	
	private Map<String, Compte> comptesMap = new HashMap<>();

	public Client(Civilite civilite, String nom, String prenom, String motDePasse, String login) {
		this.nom = nom;
		this.prenom = prenom;
		this.setCivilite(civilite);
		this.login = login;
		this.motDePasse = motDePasse;
	}
	
	public void creerCompte(Compte compte) {
		comptesMap.put(compte.getNumero(), compte);
	}
	
	public void supprimerCompte(Compte compte) {
		comptesMap.remove(compte.getNumero());
	}
	
	public Compte retournerCompte(String numero) throws CompteNonTrouveException {
		Compte compteRecherche = (Compte) comptesMap.get(numero);
	
		if(compteRecherche == null) {
			throw new CompteNonTrouveException();
		}
		
		return compteRecherche;
	}
	
	
	public void supprimerCompte(String numero) throws CompteNonTrouveException {
		Compte compteRecherche = retournerCompte(numero);
		comptesMap.remove(compteRecherche.getNumero());
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public Collection<Compte> getComptesList() {
		return comptesMap.values();
	}

	/*
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Client [");
		
		for(Field champ : Client.class.getDeclaredFields()) {
			ToString toStringAnn = champ.getAnnotation(ToString.class) ;
			if(toStringAnn != null) {
				sb.append(champ.getName());
				sb.append("=");
				try {
					if(toStringAnn.uppercase()) {
						sb.append(champ.get(this).toString().toUpperCase());
					} else {
						sb.append(champ.get(this));
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
				sb.append(",");
			}
		}
		sb.append("]");
		
		return sb.toString();
	}
	 */
	
	
	
	
	/**
	 * @return the civilite
	 */
	public Civilite getCivilite() {
		return civilite;
	}

	@Override
	public String toString() {
		return "Client [civilite=" + civilite + ", nom=" + nom + ", prenom="
				+ prenom + ", identifiant=" + identifiant + ", login=" + login
				+ ", motDePasse=" + motDePasse + ", comptesMap=" + comptesMap
				+ "]";
	}

	/**
	 * @param civilite the civilite to set
	 */
	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}
	
	public CompteCourant OuvreCompteCourant(int iteration) {
		String libelleCompte = "[" + this.getNom() + "]" + "_[" + this.getPrenom() + "]_COURANT_" + iteration;
		String numeroCC = "CC" + iteration;
		CompteCourant compteCourant = new CompteCourant(numeroCC, libelleCompte, 0, 0); 
		creerCompte(compteCourant);
		return compteCourant;
	}

}
