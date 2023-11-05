package com.lucas.crud.enums;

public enum Classification {
    BAD("Ruim"),
    GOD("Bom"),
    EXCELLENT("Excelente");

    private final String value;
    private Classification(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
