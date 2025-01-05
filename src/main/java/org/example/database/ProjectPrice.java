package org.example.database;

import java.math.BigDecimal;

public class ProjectPrice {
    private String name;
    private BigDecimal price;

    public ProjectPrice(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ProjectPrice{name='" + name + "', price=" + price + "}";
    }
}