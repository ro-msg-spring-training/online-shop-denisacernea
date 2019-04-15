package ro.msg.learning.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

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
@ToString(exclude = {"location"})
@EqualsAndHashCode(exclude = {"location"})
@Entity
@Table(name = "REVENUE", uniqueConstraints = @UniqueConstraint(columnNames = {"locationid", "salesdate"}))
@AllArgsConstructor
@NoArgsConstructor
public class Revenue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "locationid", referencedColumnName = "id")
    private Location location;

    @NonNull
    @Column(name = "salesdate", nullable = false)
    private LocalDate date;

    @NonNull
    @Column(name = "salessum", nullable = false)
    private BigDecimal sum;

    public Revenue(Location location, LocalDate date, BigDecimal sum) {
        this.location = location;
        this.date = date;
        this.sum = sum;
    }
}
