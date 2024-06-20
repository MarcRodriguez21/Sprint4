package cat.itacademy.barcelonactiva.Rodriguez.Marc.s04.t02.n02.S04T02N02RodriguezMarc.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fruit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int quantity;
    public Fruit() {}
    public Fruit(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Fruit {\n" +
                "    id: " + id + ",\n" +
                "    name: '" + name + "',\n" +
                "    quantity: " + quantity + "\n" +
                '}';
    }

}



