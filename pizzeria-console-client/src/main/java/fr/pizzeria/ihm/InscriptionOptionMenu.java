package fr.pizzeria.ihm;

import java.sql.SQLException;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.pizzeria.dao.pizza.IClientDao;
import fr.pizzeria.model.Client;

public class InscriptionOptionMenu extends OptionMenu{
	private Scanner question = new Scanner(System.in);
	
	IClientDao clientDao ; 

	public InscriptionOptionMenu(Scanner question,IClientDao clientDao) {
		this.question=question;
		this.clientDao = clientDao;
		this.libelle = "1. S'inscrire ";
	}

	public boolean execute() throws SQLException {
		System.out.println("Veuillez saisir un nom:");
		String nom = question.next();
		System.out.println("Veuillez saisir un prenom:");
		String prenom = question.next();
		System.out.println("Veuillez saisir un email:");
		String mail = question.next();
		System.out.println("Veuillez saisir un mot de passe:");
		String mdp = question.next();

		Client client = new Client(nom,prenom,mail,mdp);
		clientDao.saveNewPizza(client);
		
		return true;

	}
}
