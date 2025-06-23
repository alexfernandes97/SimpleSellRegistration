package br.com.alex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaleRepository {
    private List<Sales> sales = new ArrayList<>();
    private String fileName;

    public SaleRepository(String fileName) {
        this.fileName = fileName;
    }

    private void load() {
        File file = new File(fileName);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(";");
                if (arr.length == 3) {
                    String item = arr[0];
                    int quantity = Integer.parseInt(arr[1]);
                    double price = Double.parseDouble(arr[2]);

                    sales.add(new Sales(item, quantity, price));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar: " + e.getMessage());
        }
    }

    public void saveData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Sales s : sales) {
                bw.write(s.getProductName() + ";" + s.getQuantity() + ";" + s.getUnitPrice());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    public List<Sales> getSales() {
        return sales;
    }

    public void addSales(Sales sale) {
        sales.add(sale);
        saveData();
    }
}
