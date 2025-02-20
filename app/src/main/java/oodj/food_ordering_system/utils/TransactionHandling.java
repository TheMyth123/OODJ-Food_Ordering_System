package oodj.food_ordering_system.utils;

import oodj.food_ordering_system.models.Credit;
import oodj.food_ordering_system.models.Payment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TransactionHandling {

    public static List<Object[]> getTransactionLog(String customerID) {
        List<Object[]> transactions = new ArrayList<>();

        // Fetch Credits (Top-Ups)
        ArrayList<Credit> credits = OrderHandling.getCredits();
        for (Credit credit : credits) {
            transactions.add(new Object[]{
                credit.getDate(),               // Date
                "Top-Up",                       // Transaction Type
                "RM + " + credit.getAmount(),     // Amount
                credit.getStatus(),             // Status
                credit.getCreditID(),           // Transaction ID
                "---"                            // Order ID (N/A for top-ups)
            });
        }

        // Fetch Payments (Orders)
        ArrayList<Payment> payments = OrderHandling.getOrderHistory();
        for (Payment payment : payments) {
            transactions.add(new Object[]{
                LocalDate.parse(payment.getDate()),                // Date
                "Order Payment",                  // Transaction Type
                "RM - " + payment.getTotalAmount(), // Amount (negative for spending)
                payment.getPaymentStatus(),       // Status
                "---",                             // Transaction ID (N/A for payments)
                payment.getOrderID()               // Order ID
            });
        }

        // Sort transactions by date (latest first)
        transactions.sort(Comparator.comparing((Object[] o) -> (LocalDate) o[0]).reversed());

        return transactions;
    }
}
