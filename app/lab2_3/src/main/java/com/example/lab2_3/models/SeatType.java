package com.example.lab2_3.models;

public enum SeatType {
    COMMON_TYPE("Обычное"),
    COUPE("Купе"),
    RESERVED_SEATS("Плацкарт"),
    LUXURY("Лухари");

    private final String name;

    SeatType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
