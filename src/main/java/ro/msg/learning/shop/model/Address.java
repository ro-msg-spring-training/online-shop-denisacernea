package ro.msg.learning.shop.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ADDRESS")
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false)
    private Integer id;

    @NonNull
    @Column(nullable = false)
    private String country;

    @NonNull
    @Column(nullable = false)
    private String city;

    private String county;

    @NonNull
    @Column(nullable = false)
    private String street;

    public String toString() {
        return country + "," + county + "," + city + "," + street;
    }

}
