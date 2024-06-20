package cat.itacademy.barcelonactiva.Rodriguez.Marc.s04.t02.n02.S04T02N3RodriguezMarc.model.services;

import cat.itacademy.barcelonactiva.Rodriguez.Marc.s04.t02.n02.S04T02N3RodriguezMarc.model.domain.Fruit;

public interface FruitServices {

    Fruit createFruit(Fruit fruit);
    Fruit updateFruit(Fruit fruit);
    boolean deleteFruit(String id); // Cambiado a String para ser compatible con MongoDB
    Fruit getFruit(String id); // Cambiado a String para ser compatible con MongoDB
    Iterable<Fruit> getAllFruits();
}
