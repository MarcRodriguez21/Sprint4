package cat.itacademy.barcelonactiva.Rodriguez.Marc.s04.t02.n02.S04T02N3RodriguezMarc.model.services.impl;

import cat.itacademy.barcelonactiva.Rodriguez.Marc.s04.t02.n02.S04T02N3RodriguezMarc.model.domain.Fruit;
import cat.itacademy.barcelonactiva.Rodriguez.Marc.s04.t02.n02.S04T02N3RodriguezMarc.model.repository.FruitRepository;
import cat.itacademy.barcelonactiva.Rodriguez.Marc.s04.t02.n02.S04T02N3RodriguezMarc.model.services.FruitServices;
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
        try {
            Optional<Fruit> fruitOpt = fruitRepository.findById(fruit.getId());
            if (fruitOpt.isPresent()) {
                Fruit existingFruit = fruitOpt.get();
                existingFruit.setName(fruit.getName());
                existingFruit.setQuantity(fruit.getQuantity());
                return fruitRepository.save(existingFruit);
            } else {
                throw new RuntimeException("Fruit not found with id: " + fruit.getId());
            }
        } catch (Exception e) {
            System.out.println("Error updating fruit: " + e.getMessage());
            throw new RuntimeException("Error updating fruit: " + e.getMessage());
        }
    }



    @Override
    public boolean deleteFruit(String id) {
        try {
            Optional<Fruit> fruitOpt = fruitRepository.findById(id);
            if (fruitOpt.isPresent()) {
                Fruit deletedFruit = fruitOpt.get();
                fruitRepository.delete(deletedFruit);
                return true;
            } else {
                return false; // No se encontró el fruto con el ID dado
            }
        } catch (Exception e) {
            System.out.println("Error deleting fruit: " + e.getMessage());
            return false; // Error al intentar eliminar el fruto
        }
    }


    @Override
    public Fruit getFruit(String id) {
        Optional<Fruit> fruitOpt = fruitRepository.findById(id);
        return fruitOpt.orElse(null);
    }

    @Override
    public Iterable<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }
}
