package fr.pizzeria.dao.pizza;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplFichier implements IPizzaDao {

	private String dataDir;
	private Path p = Paths.get("C:/Users/ETY/Pizzeria_app/pizzeria-console-objet/data/");
	
	public PizzaDaoImplFichier(String dataDir){
		super();
		this.dataDir = dataDir;
	}
	
	
	
	@Override
	public List<Pizza> findAllPizzas() {
		
		try (Stream<Path> list = Files.list(Paths.get(dataDir));){
		
			return list.map(path -> {
				String code = path.toFile().getName().replaceAll(".txt","");
				
				try(Stream<String> lines = Files.lines(path);){
					
					
					String[] valueTab = lines
							                 .findFirst()
							                 .orElseThrow(() -> new StockageException("fichier vide"))
							                 .split(";");
					                         
							
					
					return  new Pizza(Integer.valueOf(valueTab[0]),code, valueTab[1],Double.valueOf(valueTab[2]), CategoriePizza.valueOf(valueTab[3]));
				}
				catch(IOException e){
				   throw new StockageException(e);	
				}
			}).collect(Collectors.toList());
		} catch (IOException e) {
			throw new StockageException(e);
		}
		
		
		
		
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) {
		
		
		//creation nouveau fichier avec l'ecriture
		String phrase = pizza.getId() +";" + pizza.getNom() +";"+ pizza.getPrix() +";"+ pizza.getType();
		byte data[] = phrase.getBytes();
		String chemin = p.toFile().getAbsolutePath() +"/" + pizza.getCode() +".txt";
		Path cheminValide = Paths.get(chemin);
		  
		
		try {
				
			//Ajouter du texte
			Files.write(cheminValide, data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		
		deletePizza(codePizza);
		saveNewPizza(pizza);
		
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		Path cheminBon = Paths.get("C:/Users/ETY/Pizzeria_app/pizzeria-console-objet/data/" +codePizza + ".txt");
		
		try {
			Files.delete(cheminBon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		
		
	}
	
	/*recupere le code
		
		
	 */
	 
	
}
