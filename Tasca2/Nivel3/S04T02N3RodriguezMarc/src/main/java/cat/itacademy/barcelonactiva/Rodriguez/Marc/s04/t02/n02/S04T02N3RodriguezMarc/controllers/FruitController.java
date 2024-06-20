package cat.itacademy.barcelonactiva.Rodriguez.Marc.s04.t02.n02.S04T02N3RodriguezMarc.controllers;

import cat.itacademy.barcelonactiva.Rodriguez.Marc.s04.t02.n02.S04T02N3RodriguezMarc.model.domain.Fruit;
import cat.itacademy.barcelonactiva.Rodriguez.Marc.s04.t02.n02.S04T02N3RodriguezMarc.model.services.FruitServices;
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
        Fruit createdFruit = fruitServices.createFruit(fruit);
        if (createdFruit != null) {
            return ResponseEntity.ok(createdFruit.toString() + " created");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create fruit");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateFruit(@RequestBody Fruit fruit) {
        Fruit updatedFruit = fruitServices.updateFruit(fruit);
        if (updatedFruit != null) {
            return ResponseEntity.ok(updatedFruit.toString() + " updated");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fruit not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFruit(@PathVariable String id) {
        boolean isDeleted = fruitServices.deleteFruit(id);
        if (isDeleted) {
            return ResponseEntity.ok("Fruit deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fruit not found");
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getFruit(@PathVariable String id) {
        Optional<Fruit> fruitOpt = Optional.ofNullable(fruitServices.getFruit(id));
        return fruitOpt.map(fruit -> ResponseEntity.ok(fruit.toString())).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fruit not found"));
    }

    @GetMapping("/getAll")
    public ResponseEntity<String> getAllFruit() {
        return ResponseEntity.ok(fruitServices.getAllFruits().toString());
    }
}
