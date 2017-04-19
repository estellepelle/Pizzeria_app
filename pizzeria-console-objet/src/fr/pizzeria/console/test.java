package fr.pizzeria.console;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;

public class test {

	public static void main(String[] args) {
		
		//private String dataDir;
		
		// TODO Auto-generated method stub
		try {
			Files.createFile(FileSystems.getDefault().getPath("C:/Users/ETY/Pizzeria_app/pizzeria-console-objet/data/ROY.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
