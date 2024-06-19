package cat.itacademy.barcelonactiva.rodriguez.marc.s04.t02.n01.S04T02N01RodriguezMarc.model.services;

import cat.itacademy.barcelonactiva.rodriguez.marc.s04.t02.n01.S04T02N01RodriguezMarc.model.domain.Fruit;

public interface FruitServices {

    Fruit createFruit(Fruit fruit);
    Fruit updateFruit(Fruit fruit);
    boolean deleteFruit(int id);
    Fruit getFruit(int id);
    Iterable<Fruit> getAllFruits();
}
