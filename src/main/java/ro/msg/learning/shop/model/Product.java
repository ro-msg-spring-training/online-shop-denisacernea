package ro.msg.learning.shop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Data
@ToString(exclude = {"productCategory", "supplier", "orderDetails"})
@EqualsAndHashCode(exclude = {"productCategory", "supplier", "orderDetails"})
@Entity
@Table(name = "PRODUCT")
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Integer id;

    @NonNull
    @Column(nullable = false)
    private String name;


    private String description;

    @NonNull
    @Column(nullable = false)
    private BigDecimal price;


    private double weight;

    @ManyToOne(optional = false)
    @JoinColumn(name = "productcategoryid", referencedColumnName = "id")
    private ProductCategory productCategory;

    @ManyToOne(optional = false)
    @JoinColumn(name = "supplierid", referencedColumnName = "id")
    private Supplier supplier;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<OrderDetail> orderDetails;


    public Product(String name, String description, BigDecimal price, double weight, ProductCategory productCategory, Supplier supplier) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.productCategory = productCategory;
        this.supplier = supplier;
    }

}
