package com.lucas.crud.enums;

import lombok.Getter;

@Getter
public enum Classification {
    BAD("Ruim"),
    GOD("Bom"),
    EXCELLENT("Excelente");

    private final String value;
    Classification(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
