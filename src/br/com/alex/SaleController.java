package br.com.alex;

import java.util.Scanner;

public class SaleController {
    private SaleService service;
    private Scanner scanner;

    public SaleController(SaleService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void begin() {
        int opc;

        do {
            System.out.println("\n ====== Menu =====");
            System.out.println("1 - Registrar venda");
            System.out.println("2 - Listar vendas");
            System.out.println("3 - Total de vendas");
            System.out.println("0 - Sair");

            opc = Integer.parseInt(scanner.nextLine());

            switch (opc) {
                case 1 -> registerSale();
                case 2 -> listSales();
                case 3 -> totalSale();
                case 0 -> System.out.println("Saindo");
                default -> System.out.println("Opção inválida");
            }
        } while (opc != 0);
    }

    private void registerSale() {
        System.out.println("Informe o item: ");
        String item = scanner.nextLine();

        System.out.println("Informe a quantidade: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.println("Informe o preço unitário: ");
        double price = Double.parseDouble(scanner.nextLine());

        service.registerSale(item, quantity, price);
        System.out.println("Venda registrada");
    }

     private void listSales() {
         System.out.println("\n===== Vendas registradas =====");

         for (Sales s : service.listSales()) {
             System.out.println(s);
         }
     }
     private void totalSale() {
        double total = service.totalSales();
         System.out.println("Valor total das vendas : " + total);
     }
}
