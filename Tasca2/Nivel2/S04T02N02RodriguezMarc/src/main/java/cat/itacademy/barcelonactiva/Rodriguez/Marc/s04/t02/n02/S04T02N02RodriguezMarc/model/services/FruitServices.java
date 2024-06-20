package cat.itacademy.barcelonactiva.Rodriguez.Marc.s04.t02.n02.S04T02N02RodriguezMarc.model.services;


import cat.itacademy.barcelonactiva.Rodriguez.Marc.s04.t02.n02.S04T02N02RodriguezMarc.model.domain.Fruit;

public interface FruitServices {

    Fruit createFruit(Fruit fruit);
    Fruit updateFruit(Fruit fruit);
    boolean deleteFruit(int id);
    Fruit getFruit(int id);
    Iterable<Fruit> getAllFruits();
}

