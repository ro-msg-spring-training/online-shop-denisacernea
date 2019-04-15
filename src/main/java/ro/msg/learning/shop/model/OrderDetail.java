package ro.msg.learning.shop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Data
@ToString(exclude = {"order", "product"})
@EqualsAndHashCode(exclude = {"order", "product"})
@Entity
@Table(name = "ORDERDETAIL", uniqueConstraints = @UniqueConstraint(columnNames = {"orderid", "productid"}))
@NoArgsConstructor
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "orderid", referencedColumnName = "id")
    @JsonIgnore
    private Order order;

    @ManyToOne(optional = false)
    @JoinColumn(name = "productid", referencedColumnName = "id")
    private Product product;

    @NonNull
    @Column(nullable = false)
    private int quantity;

    public OrderDetail(Order order, Product product, int quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }
}
