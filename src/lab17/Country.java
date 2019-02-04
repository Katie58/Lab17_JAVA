package lab17;

import java.text.NumberFormat;

public class Country {

	protected String name;
	protected long population;
	
	public Country() {
	}
	
	public Country(String name, long population) {
		this.name = name;
		this.population = population;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPopulation(long population) {
		this.population = population;
	}
	
	public String getName() {
		return name;
	}
	
	public long getPopulation() {
		return population;
	}
	
	public String toString() {
		NumberFormat comma = NumberFormat.getInstance();
		return name + "'s population is " + comma.format(population);
	}
}
