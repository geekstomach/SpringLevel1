package entities;

import java.math.BigDecimal;

public class Product {
    private Long id; //Важно ли какой тип данных использовать(примитив или ссылочный)
    private String title;
    private BigDecimal cost;

    public Product(){

    }

    public Product(Long id, String title, BigDecimal cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
