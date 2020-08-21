package main;


import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import controller.Controller;
import mundo.Pelicula;
import mundo.Persona;
import mundo.Persona.Rol;
public class Main {

	public static void main(String[] args) throws IOException, CsvValidationException 
	{
		CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
		CSVReader reader = new CSVReaderBuilder(new FileReader("data/MoviesCastingRaw-small.csv")).withCSVParser(csvParser).build();
		String [] nextLine;
		//TODO
		reader.readNext();
		while ((nextLine = reader.readNext()) != null) {
			String id=nextLine[0];
			int numeroActores=Integer.parseInt(nextLine[11]);
			int numeroDirectores=Integer.parseInt(nextLine[14]);
			int numeroProductores=Integer.parseInt(nextLine[16].trim());
			Persona[] actores=((numeroActores>=5)?new Persona[5]:new Persona[numeroActores]);
			//TODO revisar for crear actores
			int i=0;
			int pos=1;
			while(i<actores.length) {
				String nombre=nextLine[pos];
				if(!nombre.equals("none")) {
					actores[i]=new Persona(nombre, Integer.parseInt(nextLine[pos+1]),  Rol.ACTOR);
					i++;
				}
				pos+=2;
				if(pos>10) {
					break;
				}
			}
			Persona director=new Persona(nextLine[12], Integer.parseInt(nextLine[13]), Rol.DIRECTOR);
			Persona productor=new Persona(nextLine[15], 0, Rol.PRODUCTOR);
			Persona guionista=new Persona(nextLine[17], 0, Rol.GUIONISTA);
			Persona editor=new Persona(nextLine[18], 0, Rol.EDITOR);
			new Pelicula(Integer.parseInt(id), numeroActores, numeroDirectores, numeroProductores, actores, director, productor, guionista, editor);
		}
		Controller controler = new Controller();
		controler.run();
	}
}
