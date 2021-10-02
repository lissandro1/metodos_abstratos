package application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Insira o número de contribuintes: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Contribuinte #" + i + " dados:");
			System.out.print("Individual ou empresa (i/c)? ");
			char type = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Renda anual: ");
			double anualIncome = sc.nextDouble();
			
			if(type == 'i') {
				System.out.print("Despesas com saude: ");
				double health = sc.nextDouble();
				list.add(new Individual(name, anualIncome, health));
			}
			
			else {
				System.out.print("Numero de funcionarios: ");
				int employee = sc.nextInt();
				list.add(new Company(name, anualIncome, employee));
			}
		}
		
		System.out.println();
		double sum = 0.0;
		System.out.println("TAXA PAGA:");
		for(TaxPayer p : list) {
			System.out.println(p.getName() + ": $ " + String.format("%.2f", p.tax()));
			sum += p.tax();
		}
		System.out.println();
		System.out.println("TOTAL DE TAXAS: $ " + String.format("%.2f", sum));		

		
		sc.close();
	}

}
