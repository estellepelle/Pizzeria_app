package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.pizza.IClientDao;

public class MenuClient {
	private Scanner question = new Scanner(System.in);
	
	InscriptionOptionMenu insClient;
	
	public MenuClient(Scanner questions,IClientDao clientDao) {
		this.insClient = new InscriptionOptionMenu(questions, clientDao);
	}
	
	public void afficher(){
		System.out.println(insClient.getLibelle());
	}

	public InscriptionOptionMenu getInsClient() {
		return insClient;
	}
	
	
}
