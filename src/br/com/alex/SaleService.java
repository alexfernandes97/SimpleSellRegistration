package br.com.alex;

import java.util.List;

public class SaleService {
    private SaleRepository  repository;

    public SaleService(SaleRepository repository) {
        this.repository = repository;
    }

    public void registerSale(String item, int quantity, double price) {
        Sales novo = new Sales(item, quantity, price);
        repository.addSales(novo);
    }

    public List<Sales> listSales() {
        return repository.getSales();
    }

    public double totalSales() {
        return repository.getSales().stream().mapToDouble(s -> s.getQuantity() * s.getUnitPrice()).sum();
    }
}
