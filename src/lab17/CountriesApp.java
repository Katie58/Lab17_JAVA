package lab17;

public class CountriesApp {
	
	public static void main(String[] args) {
		boolean retry = true;
		Menu.menu();
		CountriesTextFile.createFile();
		
		while(retry) {
			CountriesUtil.greeting();
			CountriesUtil.menu();
			retry = !CountriesUtil.retry("exit");
		}
		CountriesUtil.exit();
	}
}
