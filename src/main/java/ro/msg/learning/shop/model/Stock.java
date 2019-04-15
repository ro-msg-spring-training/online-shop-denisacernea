package ro.msg.learning.shop.model;

import lombok.AllArgsConstructor;
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
@ToString(exclude = {"product", "location"})
@EqualsAndHashCode(exclude = {"product", "location"})
@Entity
@Table(name = "STOCK", uniqueConstraints = @UniqueConstraint(columnNames = {"productid", "locationid"}))
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "productid", referencedColumnName = "id")
    private Product product;

    @ManyToOne(optional = false)
    @JoinColumn(name = "locationid", referencedColumnName = "id")
    private Location location;

    @NonNull
    @Column(nullable = false)
    private Integer quantity;
}
