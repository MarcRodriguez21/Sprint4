package cat.itacademy.barcelonactiva.rodriguez.marc.s04.t02.n01.S04T02N01RodriguezMarc.controllers;

import cat.itacademy.barcelonactiva.rodriguez.marc.s04.t02.n01.S04T02N01RodriguezMarc.model.domain.Fruit;
import cat.itacademy.barcelonactiva.rodriguez.marc.s04.t02.n01.S04T02N01RodriguezMarc.model.services.FruitServices;
import cat.itacademy.barcelonactiva.rodriguez.marc.s04.t02.n01.S04T02N01RodriguezMarc.model.services.impl.FruitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/fruit")
public class FruitController {

    @Autowired
    private FruitServices fruitServices;

    @PostMapping("/add")
    public ResponseEntity<String> createFruit(@RequestBody Fruit fruit) {
        return ResponseEntity.ok(fruitServices.createFruit(fruit).toString() + " created");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateFruit(@RequestBody Fruit fruit) {
        Fruit updatedFruit = fruitServices.updateFruit(fruit);
        if (updatedFruit != null) {
            return ResponseEntity.ok(updatedFruit.toString() + " updated");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("fruit not found");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFruit(@PathVariable int id) {
        boolean isDeleted = fruitServices.deleteFruit(id);
        if (isDeleted) {
            return ResponseEntity.ok("Fruit deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fruit not found");
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<String> getFruit(@PathVariable int id) {
        Optional<Fruit> fruitOpt = Optional.ofNullable(fruitServices.getFruit(id));
        if (fruitOpt.isPresent()) {
            return ResponseEntity.ok(fruitOpt.get().toString());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("fruit not found");
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<String> getAllFruit() {
        return ResponseEntity.ok(fruitServices.getAllFruits().toString());
    }
}


