package br.com.alex;
import static br.com.alex.util.DateUtils.FORMATTER;

import java.time.LocalDateTime;

public class Sales {
    private String productName;
    private int quantity;
    private double unitPrice;
    private LocalDateTime localDateTime;
    private double totalSales;

    public Sales(String productName, int quantity, double unitPrice, LocalDateTime localDateTime) {
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.localDateTime = localDateTime;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getTotalValue() {
        return quantity * unitPrice;
    }

    @Override
    public String toString() {
        return "Produto: " + productName + " | Quantidade: " + quantity + " | Preço unitário: " + unitPrice + " | Hora/Data: "  + localDateTime.format(FORMATTER);
    }
}
