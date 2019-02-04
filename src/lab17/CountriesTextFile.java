package lab17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountriesTextFile {
	static Path folder = Paths.get("Countries");
	static Path txt = Paths.get("Countries/countries.txt");
		
	public static void createFile() {//CountriesApp.main()
		checkForDirectory("Countries", folder);
		checkForFile(txt);
	}
	
	private static void checkForDirectory(String dirPathString, Path dirPath) {
		if (Files.notExists(Paths.get(dirPathString))){			
			try {
				Files.createDirectory(dirPath);
				createPrint(dirPath);
			} catch (IOException e) {
				exPrint();
			}
		} 
	}
	
	private static void checkForFile(Path filePath) {
		if (Files.notExists(filePath)) {			
			try {
				Files.createFile(filePath);
				createPrint(filePath);
			} catch (IOException e) {
				exPrint();
			}
		} 
	}
			
	public static void appendToFile(Country country) {
		String item = country.name + " - " + country.population;
		List<String> itemsToAdd = Arrays.asList(item);
		try {
			Files.write(txt, itemsToAdd, StandardOpenOption.APPEND);
		} catch (IOException ex) {
			exPrint();
		}
	}
	
	public static List<String> readFile() {//CountrieUtil.countriesList()
		List<String> countries = new ArrayList<String>();
		try {
			countries = Files.readAllLines(txt);			
		} catch (IOException ex) {
			exPrint();
		}
		return countries;
	}
	
	private static void exPrint() {
		System.out.println("Most likey, permission to store countries into a file, has been denied.");
	}
	
	private static void createPrint(Path path) {
		System.out.println(path.toAbsolutePath() + " is being created!");
	}

}
