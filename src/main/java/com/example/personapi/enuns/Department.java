package com.example.personapi.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Department {

    FINANCES("Finances"),
    SALES("Sales"),
    STOCK("Stock"),
    SUPERMARKET_CASHIER("Supermarket Cashier"),
    SECURITY("Security"),
    MANAGEMENT("Management");

    private String Description_Department;
}
