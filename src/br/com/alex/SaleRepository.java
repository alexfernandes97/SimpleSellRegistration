package br.com.alex;
import static br.com.alex.util.DateUtils.FORMATTER;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SaleRepository {
    private List<Sales> sales = new ArrayList<>();
    private String fileName;

    public SaleRepository(String fileName) {
        this.fileName = fileName;
        load();
    }

    private void load() {
        File file = new File(fileName);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(";");
                if (arr.length == 4) {
                    String item = arr[0];
                    int quantity = Integer.parseInt(arr[1]);
                    double price = Double.parseDouble(arr[2]);
                    LocalDateTime localDateTime = LocalDateTime.parse(arr[3], FORMATTER);

                    sales.add(new Sales(item, quantity, price, localDateTime));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar: " + e.getMessage());
        }
    }

    public void saveData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Sales s : sales) {
                bw.write(s.getProductName() + ";" + s.getQuantity() + ";" + s.getUnitPrice() + ";" + s.getLocalDateTime().format(FORMATTER));
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
