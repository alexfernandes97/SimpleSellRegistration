package br.com.alex;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SaleService {
    private SaleRepository  repository;
    Scanner scanner = new Scanner(System.in);

    public SaleService(SaleRepository repository) {
        this.repository = repository;
    }

    public void registerSale(String item, int quantity, double price, LocalDateTime localDateTime) {
        Sales novo = new Sales(item, quantity, price, localDateTime);
        repository.addSales(novo);
    }

    public List<Sales> listSales() {
        return repository.getSales();
    }

    public double totalSales() {
        return repository.getSales().stream().mapToDouble(Sales::getTotalValue).sum();
    }

    public void filterByProduct () {
        System.out.println("Digite o nome do produto para filtrar");
        String name = scanner.nextLine().trim().toLowerCase();

        List<Sales> results = repository.getSales().stream().filter(v -> v.getProductName().toLowerCase().contains(name)).toList();

        if (results.isEmpty()) {
            System.out.println("Nenhuma venda encontrada para o produto informado.");
        } else {
            System.out.println("\n--- Vendas filtrada ---");
            for (Sales sales : results) {
                System.out.println(sales);
            }
        }
    }
}
