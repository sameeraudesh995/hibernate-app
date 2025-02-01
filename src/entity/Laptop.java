package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Laptop {
    @Id
    private long id;
    private String brand;

    @OneToOne
    @JoinColumn(unique = true)
    private Student student;

    public Laptop(long id, String brand) {
        this.id = id;
        this.brand = brand;
    }

    public Laptop() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
