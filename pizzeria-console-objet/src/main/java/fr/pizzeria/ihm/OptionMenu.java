package fr.pizzeria.ihm;

import java.sql.SQLException;

public abstract class OptionMenu {
	
	protected String libelle;

	 public abstract boolean execute() throws SQLException, ClassNotFoundException;

	public String getLibelle() {
		return libelle;
	}



	
}
