package io.eventuate.examples.tram.sagas.ordersandcustomers.products.domain;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Access(AccessType.FIELD)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long stock;

    private String name;

    private Long price;

    public Product() {
    }

   public Product(Long id, Long stock, String name, Long price) {
        this.id = id;
        this.stock = stock;
        this.name = name;
        this.price = price;
    }

  public Product( Long stock, String name, Long price) {

    this.stock = stock;
    this.name = name;
    this.price = price;
  }

    public Long getId() {
        return id;
    }

    public Long getStock() {
        return stock;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }
}
