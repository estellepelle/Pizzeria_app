package fr.pizzeria.dao.pizza;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao{

	private List<Pizza> pizzas;
	public static int codePizza = 0;

	
	public PizzaDaoImpl(){
		pizzas = new ArrayList<>();
		saveNewPizza(new Pizza("PEP", "Peperoni", 12.50, CategoriePizza.VIANDE));
		saveNewPizza(new Pizza( "MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		saveNewPizza(new Pizza("REI", "La Reine", 11.50, CategoriePizza.VIANDE));
		saveNewPizza(new Pizza( "FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		saveNewPizza(new Pizza( "CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		saveNewPizza(new Pizza( "SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		saveNewPizza(new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.VIANDE));
		saveNewPizza(new Pizza("IND", "L'indienne", 14.00, CategoriePizza.VIANDE));
	}
	
	public PizzaDaoImpl(List<Pizza> pizzas){
		this.pizzas = pizzas;
	}
	
	@Override
	public List<Pizza> findAllPizzas() {
		
		return pizzas;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) {
		
		pizzas.add(pizza);
		return true;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		
		int indexPizzaAModifier = -1;
		for (int index=0; index<pizzas.size(); index++){
			if (pizzas.get(index).getCode().equals(codePizza)){
				
				pizzas.get(index).setCode(pizza.getCode());
				pizzas.get(index).setNom(pizza.getNom());
				pizzas.get(index).setPrix(pizza.getPrix());
				pizzas.get(index).setType(pizza.getType());
				
				break;
			}
		}
		
		if (indexPizzaAModifier==-1){
			throw new UpdatePizzaException();
			
		}
		else {
			
			
			pizzas.get(indexPizzaAModifier).equals(pizza);
		}
		return true;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException{
		
		int indexPizzaASupprimer = -1;
		for (int index=0; index<pizzas.size(); index++){
			if ( pizzas.get(index).getCode().equals(codePizza)){
				pizzas.remove(index);
			}
		}
		
		if (indexPizzaASupprimer==-1){
			throw new DeletePizzaException();
		}
		
	
		return false;
	}
	
	
}
