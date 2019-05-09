package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import model.service.ContractService;
import model.service.PayPalService;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Enter contract data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Date (dd/MM/yyyy): ");
			Date date = sdf.parse(sc.next());
			System.out.print("Contract value: ");
			double totalValue = sc.nextDouble();
			System.out.print("Enter number of installments: ");
			int installments = sc.nextInt();
			System.out.println("Installments:");
			
			Contract contract = new Contract(number, date, totalValue);
			ContractService contractService = new ContractService(new PayPalService());
			
			contractService.processContract(contract, installments);
			
			for (Installment x : contract.getInstallments()) {
				System.out.println(x);
			}
		}
		catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			if (sc != null) {
				sc.close();
			}
		}
	}

}
