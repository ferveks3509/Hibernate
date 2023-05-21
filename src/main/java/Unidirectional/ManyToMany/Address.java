package Unidirectional.ManyToMany;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String numb;

    public static Address of(String street, String numb) {
        Address address = new Address();
        address.street = street;
        address.numb = numb;
        return address;
    }
    public Address() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumb() {
        return numb;
    }

    public void setNumb(String numb) {
        this.numb = numb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id && Objects.equals(street, address.street) && Objects.equals(numb, address.numb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, numb);
    }
}
