package cat.itacademy.barcelonactiva.Rodriguez.Marc.s04.t02.n02.S04T02N3RodriguezMarc.model.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fruits")
public class Fruit {

    @Id
    private String id;

    private String name;
    private int quantity;

    public Fruit() {
    }

    public Fruit(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
