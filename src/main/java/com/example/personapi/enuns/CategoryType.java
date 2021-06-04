package com.example.personapi.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter // todos os getters (Dãh)
@AllArgsConstructor
public enum CategoryType {
    A1("A1"),
    A2("A2"),
    A3("A3"),
    A4("A4");
    private final String Description;

}
