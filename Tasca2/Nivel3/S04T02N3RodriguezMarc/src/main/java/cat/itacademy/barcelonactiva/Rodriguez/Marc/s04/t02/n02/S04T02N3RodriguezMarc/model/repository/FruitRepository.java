package cat.itacademy.barcelonactiva.Rodriguez.Marc.s04.t02.n02.S04T02N3RodriguezMarc.model.repository;


import cat.itacademy.barcelonactiva.Rodriguez.Marc.s04.t02.n02.S04T02N3RodriguezMarc.model.domain.Fruit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FruitRepository extends MongoRepository<Fruit, String> {
}



