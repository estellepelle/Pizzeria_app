package fr.pizzeria.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="livreur")
public class Livreur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ToString
	@Column(name = "nom")
	private String nom;
	
	@ToString
	@Column(name = "prenom")
	private String prenom;
	
	// commande
	@OneToMany(mappedBy="idLivreur")
	private Set<Commande> cmdLivreur;
	
	
	//constructeur
	public Livreur() {
		
	}

	// get et set
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

	public Set<Commande> getCmdLivreur() {
		return cmdLivreur;
	}

	public void setCmdLivreur(Set<Commande> cmdLivreur) {
		this.cmdLivreur = cmdLivreur;
	}
	
	
}
