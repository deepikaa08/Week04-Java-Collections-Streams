import java.util.*;
import java.util.stream.Collectors;

public class ProductSalesAnalysis{


    public static class Sale {
        private int productId;
        private int quantity;
        private double price;

        public Sale(int productId, int quantity, double price) {
            this.productId = productId;
            this.quantity = quantity;
            this.price = price;
        }


        public int getProductId() {
            return productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPrice() {
            return price;
        }
    }


    public static class ProductSales {
        private int productId;
        private double totalRevenue;

        public ProductSales(int productId, double totalRevenue) {
            this.productId = productId;
            this.totalRevenue = totalRevenue;
        }

        public int getProductId() {
            return productId;
        }

        public double getTotalRevenue() {
            return totalRevenue;
        }

        @Override
        public String toString() {
            return "ProductSales{productId=" + productId + ", totalRevenue=" + totalRevenue + "}";
        }
    }

    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
                new Sale(1, 15, 50),
                new Sale(2, 8, 100),
                new Sale(3, 20, 30),
                new Sale(1, 5, 50),
                new Sale(4, 30, 20),
                new Sale(2, 12, 90)
        );

        List<Sale> filteredSales = sales.stream()
                .filter(sale -> sale.getQuantity() > 10)
                .collect(Collectors.toList());

        List<ProductSales> productSalesList = filteredSales.stream()
                .collect(Collectors.groupingBy(
                        Sale::getProductId,
                        Collectors.summingDouble(sale -> sale.getQuantity() * sale.getPrice())
                ))
                .entrySet().stream()
                .map(entry -> new ProductSales(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        List<ProductSales> sortedProductSales = productSalesList.stream()
                .sorted(Comparator.comparing(ProductSales::getTotalRevenue).reversed())
                .collect(Collectors.toList());

        List<ProductSales> topNProducts = sortedProductSales.stream()
                .limit(5)
                .collect(Collectors.toList());


        System.out.println("Top 5 Products by Total Revenue: ");
        topNProducts.forEach(System.out::println);
    }
}
