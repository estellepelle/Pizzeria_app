package fr.pizzeria.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="commande")
public class Commande implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name = "num_cmd")
	private int numCmd;
	
	@ToString
	@Column(name = "statut")
	private String statut;
	
	@Column(name = "date_cmd")
	private Date dateCmd;
	
	@ManyToOne
	@JoinColumn(name = "id_livreur")
	private Livreur idLivreur;
	
	@ManyToOne
	@JoinColumn(name = "id_client")
	private Client idClient;
	
	@ManyToMany(mappedBy="cmds")
	private Set<Pizza> pizzas;
	
	public Commande() {
		// TODO Auto-generated constructor stub
	}
	
	
	//get and set
	public int getNumCmd() {
		return numCmd;
	}

	public void setNumCmd(int numCmd) {
		this.numCmd = numCmd;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getDateCmd() {
		return dateCmd;
	}

	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}

	public Livreur getIdLivreur() {
		return idLivreur;
	}

	public void setIdLivreur(Livreur idLivreur) {
		this.idLivreur = idLivreur;
	}

	public Client getIdClient() {
		return idClient;
	}

	public void setIdClient(Client idClient) {
		this.idClient = idClient;
	}


	public Set<Pizza> getPizzas() {
		return pizzas;
	}


	public void setPizzas(Set<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
	
}
