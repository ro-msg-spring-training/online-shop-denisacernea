package ro.msg.learning.shop.exceptions;

import java.time.LocalDate;

public class SalesRevenueException extends RuntimeException {
    public SalesRevenueException(LocalDate date) {
        super("No revenue for date: " + date);
    }
}
