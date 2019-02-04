package lab17;
import java.util.List;
import java.util.Scanner;

public class CountriesUtil {
	static Scanner scnr = new Scanner(System.in);
	
	public static void greeting() {
		System.out.println("Welcome to the Countries Maintenance Application\n");
	}

	public static void menu() {
		boolean retry = true;
		while(retry) {
			for (int i = 0; i < Menu.menu.size(); i++) {
				System.out.println((i + 1) + ". " + Menu.menu.get(i));
			}
			System.out.println();
			switch(validateInt("Enter menu number: ", Menu.menu.size())) {
			case 1: countriesList();
			break;
			case 2: countriesAdd();
			break;
			case 3: retry = false;
			break;
			}
		}
	}
	
	public static void countriesList() {
		List<String> countries = CountriesTextFile.readFile();
		if (countries.size() == 0) {
			System.out.println("No Countries to Display!");
		} else {
			int count = 0;
			for (String element : countries) {
				count++;
				String[] country = element.split("-");
				System.out.println(count + ". " + new Country(country[0].trim(), Long.parseLong(country[1].trim())));
			}			
		}
		System.out.print("Press ENTER to continue... ");
		scnr.nextLine();
	}
	
	public static void countriesAdd() {////////////////////////////////////////
		boolean retry = true;
		while(retry) {
			CountriesTextFile.appendToFile(userInCountry());
			retry = retry("enter another country");
		}		
	}
	
	public static Country userInCountry() {
		Country country = new Country();
		System.out.print("\nEnter country: ");
		country.name = scnr.nextLine();
		country.population = validateLong("Enter poplutation: ", Long.MAX_VALUE);
		return country;
	}
	
	public static int validateInt(String request, int max) {
		while(true) {
			System.out.print(request);
			String input = scnr.nextLine().trim();
			if (input.matches("[-0-9]*")) {
				int output = (int) Integer.parseInt(input);
				if (output > 0 && output <= max) {
					return output;
				} else {
					System.out.println("That menu option doesn't exist, perhaps try a number between 1-" + max + "...");
					continue;
				}
			} else {
				System.out.println("You did not enter a valid number, maybe check your numlock...");
				continue;
			}			
		}
	}
	
	public static Long validateLong(String request, Long max) {
		while(true) {
			System.out.print(request);
			if (scnr.hasNextLong()) {
				Long input = scnr.nextLong();
				scnr.nextLine();
				if (input > 0) {
					if (input > 0 && input <= max) {
						return input;
					} else {
						System.out.println("ummm, we are talking about the living here, try again...");
						continue;
					}					
				}
			}
		}
	}
	
 	public static boolean retry(String question) {
		System.out.print("\nWould you like to " + question + "? (y/n) ");
		return validateYesNo(scnr.nextLine().charAt(0));
	}
	
	public static boolean validateYesNo(char input) {
		while (input != 'y' && input != 'Y' && input != 'n' && input != 'N') {
			System.out.print("This is a simple yes or no question, try again...");
			input = scnr.nextLine().charAt(0);
		}
		return (input == 'y' || input == 'Y');
	}
	
	public static void exit() {
		System.out.println("GOODBYE!");
		scnr.close();
	}
	
}
