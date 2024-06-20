package cat.itacademy.barcelonactiva.Rodriguez.Marc.s04.t02.n02.S04T02N02RodriguezMarc.model.services.impl;


import cat.itacademy.barcelonactiva.Rodriguez.Marc.s04.t02.n02.S04T02N02RodriguezMarc.model.domain.Fruit;
import cat.itacademy.barcelonactiva.Rodriguez.Marc.s04.t02.n02.S04T02N02RodriguezMarc.model.repository.FruitRepository;
import cat.itacademy.barcelonactiva.Rodriguez.Marc.s04.t02.n02.S04T02N02RodriguezMarc.model.services.FruitServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FruitServicesImpl implements FruitServices {

    @Autowired
    private FruitRepository fruitRepository;
    @Override
    public Fruit createFruit(Fruit fruit) {
        Fruit newFruit;
        try {
            newFruit = fruitRepository.save(new Fruit(fruit.getName(), fruit.getQuantity()));
        } catch (Exception e) {
            System.out.println("Error creating fruit: " + e.getMessage());
            newFruit = null;
        }
        return newFruit;
    }
    @Override
    public Fruit updateFruit(Fruit fruit) {
        Optional<Fruit> fruitOpt = fruitRepository.findById(fruit.getId());
        Fruit updatedFruit = null;
        try{
            fruitOpt.isPresent();
            updatedFruit = fruitOpt.get();
            updatedFruit.setName(fruit.getName());
            updatedFruit.setQuantity(fruit.getQuantity());
            fruitRepository.save(updatedFruit);
        }catch(Exception e){
            System.out.println("Error updating fruit: " + e.getMessage());
            updatedFruit = null;
        }
        return updatedFruit;
    }
    @Override
    public boolean deleteFruit(int id) {
        Optional<Fruit> fruitOpt = fruitRepository.findById(id);
        if (fruitOpt.isPresent()) {
            try {
                Fruit deletedFruit = fruitOpt.get();
                fruitRepository.delete(deletedFruit);
                return true;
            } catch (Exception e) {
                System.out.println("Error deleting fruit: " + e.getMessage());
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public Fruit getFruit(int id) {
        Optional<Fruit> fruitOpt = fruitRepository.findById(id);
        Fruit fruit = null;
        if (fruitOpt.isPresent()) {
            fruit = fruitOpt.get();
        }
        return fruit;
    }
    @Override
    public Iterable<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

}

