package entities;

public class Company extends TaxPayer {
	
	private Integer employee;
	
	public Company() {
		super();
	}


	public Company(String name, Double anualIncome, Integer employee) {
		super(name, anualIncome);
		this.employee = employee;
	}

	@Override
	public Double tax() {
		if(employee > 10) {
			return getAnualIncome() * 0.14;
		}
		else {
			return getAnualIncome() * 0.16;
		}
	}

}
