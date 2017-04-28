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
@Table(name="client")
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ToString
	@Column(name = "nom")
	private String nom;
	

	@ToString
	@Column(name = "prenom")
	private String prenom;
	
	@ToString
	@Column(name = "mail")
	private String mail;
	
	@ToString
	@Column(name = "mdp")
	private String mdp;
	
	// commande
	@OneToMany(mappedBy="idClient")
	private Set<Commande> cmdClient;
	
	//constructeur
	public Client() {
		
	}
	
	public Client(String nom, String prenom, String mail, String mdp){
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
	}
	
	
	//get et set
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	public Set<Commande> getCmd() {
		return cmdClient;
	}


	public void setCmd(Set<Commande> cmd) {
		this.cmdClient = cmd;
	}
	
	
}