package Tugas2;

import java.util.Scanner;
/**
 * Kelas SimpleCalculator adalah kalkulator sederhana yang memungkinkan pengguna
 * untuk melakukan operasi dasar aritmatika seperti penjumlahan, pengurangan,
 * perkalian, dan pembagian.
 * Metode dalam kelas ini telah diekstraksi untuk memisahkan logika
 * mendapatkan input, memilih operasi, menghitung hasil, dan menampilkan hasil.
 * Kelas ini menggunakan konstanta simbolis untuk menggantikan nilai karakter operasi.
 */
public class SimpleCalculator {
    // Konstanta untuk operasi aritmatika
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    /**
     * Metode utama untuk menjalankan kalkulasi.
     * Meminta pengguna memasukkan dua angka, memilih operasi,
     * melakukan operasi, dan menampilkan hasilnya.
     */
    public void calculate() {
        int num1 = getInput("Enter first number: ");
        int num2 = getInput("Enter second number: ");
        char operation = getOperation();
        int result = performOperation(num1, num2, operation);
        displayResult(result);
    }

    /**
     * Meminta input dari pengguna untuk angka.
     *
     * @param prompt Pesan yang ditampilkan kepada pengguna untuk meminta angka.
     * @return Angka yang dimasukkan oleh pengguna.
     */
    private int getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        return scanner.nextInt();
    }

    /**
     * Meminta input dari pengguna untuk operasi aritmatika.
     *
     * @return Karakter operasi aritmatika yang dipilih oleh pengguna.
     */
    private char getOperation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose operation: (+, -, *, /)");
        return scanner.next().charAt(0);
    }

    /**
     * Melakukan operasi aritmatika antara dua angka berdasarkan operasi yang dipilih.
     *
     * @param num1 Angka pertama yang dimasukkan oleh pengguna.
     * @param num2 Angka kedua yang dimasukkan oleh pengguna.
     * @param operation Karakter operasi yang dipilih oleh pengguna.
     * @return Hasil dari operasi aritmatika.
     */
    private int performOperation(int num1, int num2, char operation) {
        if (operation == ADDITION) {
            return num1 + num2;
        } else if (operation == SUBTRACTION) {
            return num1 - num2;
        } else if (operation == MULTIPLICATION) {
            return num1 * num2;
        } else if (operation == DIVISION) {
            if (num2 != 0) {
                return num1 / num2;
            } else {
                System.out.println("Cannot divide by zero.");
                return 0;
            }
        } else {
            System.out.println("Invalid operation.");
            return 0;
        }
    }

    /**
     * Menampilkan hasil dari operasi aritmatika.
     *
     * @param result Hasil operasi aritmatika.
     */
    private void displayResult(int result) {
        System.out.println("Result: " + result);
    }

    /**
     * Metode main untuk menjalankan aplikasi SimpleCalculator.
     *
     * @param args Argumen baris perintah (tidak digunakan).
     */
    public static void main(String[] args) {
        SimpleCalculator calculator = new SimpleCalculator();
        calculator.calculate();
    }
}
