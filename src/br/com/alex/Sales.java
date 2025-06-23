package br.com.alex;

public class Sales {
    private String productName;
    private int quantity;
    private double unitPrice;

    public Sales(String productName, int quantity, double unitPrice) {
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return "Produto: " + productName + " | Quantidade: " + quantity + " | Preço unitário: " + unitPrice;
    }
}
