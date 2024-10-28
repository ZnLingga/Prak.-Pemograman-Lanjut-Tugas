package Tugas1;

import java.util.ArrayList;
import java.util.Scanner;

class MenuItem {
    String name;
    int price;

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

class OrderItem {
    MenuItem menuItem;
    int quantity;

    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return menuItem.price * quantity;
    }
}

public class RestaurantOrderApp {
    private static final double TAX_RATE = 0.1;
    private static final double DISCOUNT_RATE = 0.05;
    private final ArrayList<OrderItem> orderItems = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private final MenuItem[] menu = {
            new MenuItem("Nasi Goreng", 20000),
            new MenuItem("Mie Goreng", 18000),
            new MenuItem("Ayam Bakar", 25000),
            new MenuItem("Soto Ayam", 15000)
    };

    public void displayMenu() {
        System.out.println("Menu Restoran:");
        for (int i = 0; i < menu.length; i++) {
            System.out.printf("%d. %s - %d%n", i + 1, menu[i].name, menu[i].price);
        }
    }

    public void createOrder() {
        displayMenu();
        System.out.println("Masukkan nomor menu dan jumlah pesanan (ketik 0 untuk selesai):");

        while (true) {
            System.out.print("Nomor menu: ");
            int menuNumber = scanner.nextInt();
            if (menuNumber == 0) break;

            if (menuNumber < 1 || menuNumber > menu.length) {
                System.out.println("Menu tidak valid.");
                continue;
            }

            System.out.print("Jumlah: ");
            int quantity = scanner.nextInt();
            orderItems.add(new OrderItem(menu[menuNumber - 1], quantity));
        }
    }

    public void printReceipt() {
        System.out.println("\n--- Nota Pemesanan ---");
        int totalOrder = calculateTotal();
        double discount = calculateDiscount(totalOrder);
        double tax = calculateTax(totalOrder);
        double finalTotal = totalOrder - discount + tax;

        for (OrderItem item : orderItems) {
            System.out.printf("%s x %d = %d%n", item.menuItem.name, item.quantity, item.getTotalPrice());
        }
        System.out.printf("Subtotal: %d%nDiskon: %.2f%nPajak: %.2f%nTotal Bayar: %.2f%n", totalOrder, discount, tax, finalTotal);
        System.out.println("Terima kasih telah memesan!");
    }

    public int calculateTotal() {
        return orderItems.stream().mapToInt(OrderItem::getTotalPrice).sum();
    }

    public double calculateDiscount(int total) {
        return (total > 100000) ? total * DISCOUNT_RATE : 0;
    }

    public double calculateTax(int total) {
        return total * TAX_RATE;
    }

    public static void main(String[] args) {
        RestaurantOrderApp app = new RestaurantOrderApp();
        app.createOrder();
        app.printReceipt();
    }
}
