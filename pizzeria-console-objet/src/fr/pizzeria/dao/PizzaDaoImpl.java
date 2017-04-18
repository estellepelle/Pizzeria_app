package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao{

	private List<Pizza> pizzas;
	public static int codePizza = 0;

	
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