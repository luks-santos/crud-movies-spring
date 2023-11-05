package com.lucas.crud.enums;

public enum MovieClassification {
    RUIM("Ruim"),
    BOM("Bom"),
    EXCELENTE("Excelente");

    private String value;
    private MovieClassification(String value) {
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
