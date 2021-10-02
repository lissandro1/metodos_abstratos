package entities;

public class Individual extends TaxPayer {
	
	private double health;


	public Individual() {
		super();
	}
	
	public Individual(String name, Double anualIncome, double health) {
		super(name, anualIncome);
		this.health = health;
	}


	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	@Override
	public Double tax() {
		if (getAnualIncome() < 20000.00){
			return (getAnualIncome() * 0.15) - (health * 0.50);
		}
		
		else  {
			return (getAnualIncome() * 0.25) - (health * 0.50);
		}

	}

}
