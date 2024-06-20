package cat.itacademy.barcelonactiva.Rodriguez.Marc.s04.t02.n02.S04T02N02RodriguezMarc.model.repository;


import cat.itacademy.barcelonactiva.Rodriguez.Marc.s04.t02.n02.S04T02N02RodriguezMarc.model.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruit, Integer> {
}

