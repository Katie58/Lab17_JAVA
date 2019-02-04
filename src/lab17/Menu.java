package lab17;
import java.util.ArrayList;

public class Menu {
	static ArrayList<String> menu = new ArrayList<String>();
			
	public ArrayList<String> getMenu() {
		return menu;
	}
	
	public static void menu() {
		menu.add("See the list of countries");
		menu.add("Add a country");
		menu.add("Exit");
	}	
}
