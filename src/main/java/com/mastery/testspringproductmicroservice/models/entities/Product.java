package com.mastery.testspringproductmicroservice.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(length = 10)
    private String name;

    @Column(length = 20)
    private String description;

    @Column(precision = 6,scale = 2)
    private BigDecimal price;

    @Column(length = 1024)
    private String photo;

    @ManyToOne(cascade = CascadeType.ALL) // owning side of the relationship between Category and Product tables
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product") // inverse side of the relationship between Detail and Product tables
    @JsonIgnore // resolves infinite recursion
    private List<Detail> details;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }
}
