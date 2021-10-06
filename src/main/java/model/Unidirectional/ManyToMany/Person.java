package model.Unidirectional.ManyToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.MERGE})
    private List<Address> addresses = new ArrayList<>();

    public Person() {

    }
    public static Person of(String name) {
        Person person = new Person();
        person.name = name;
        return person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getList() {
        return addresses;
    }

    public void setList(List<Address> addresses) {
        this.addresses = addresses;
    }
    public void add(Address address) {
        addresses.add(address);
    }
    public List<Address> get() {
        return addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name) && Objects.equals(addresses, person.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, addresses);
    }
}
