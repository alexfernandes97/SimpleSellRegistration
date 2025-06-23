package br.com.alex;

import java.util.Scanner;

public class SalesRegistration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SaleRepository repository = new SaleRepository("sales.txt");

        SaleService service = new SaleService(repository);
        SaleController controller = new SaleController(service, scanner);

        controller.begin();

        scanner.close();
    }
}
