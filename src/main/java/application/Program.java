package application;

import java.util.Locale;
import java.util.Scanner;
import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

    public static void main(String[] args) throws DomainException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter account data");
            System.out.println("Number: ");
            Integer number = sc.nextInt();
            System.out.println("Holder: ");
            sc.nextLine();
            String holder = sc.nextLine();
            System.out.println("Initial balance: ");
            Double balance = sc.nextDouble();
            System.out.println("Withdraw Limit: ");
            Double withdrawLimit = sc.nextDouble();
            Account ac = new Account(number, holder, balance, withdrawLimit);

            System.out.println();
            System.out.println("Enter amount for withdraw: ");
            Double amount = sc.nextDouble();

            ac.withdraw(amount);
            System.out.println(ac.getBalance());
        } catch (DomainException e) {
            System.out.println("Error in account: " + e.getMessage());
        }
        sc.close();
    }
}
