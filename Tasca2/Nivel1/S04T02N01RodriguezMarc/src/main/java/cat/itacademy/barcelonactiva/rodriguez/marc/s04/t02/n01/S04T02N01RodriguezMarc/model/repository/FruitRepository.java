package cat.itacademy.barcelonactiva.rodriguez.marc.s04.t02.n01.S04T02N01RodriguezMarc.model.repository;

import cat.itacademy.barcelonactiva.rodriguez.marc.s04.t02.n01.S04T02N01RodriguezMarc.model.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruit, Integer> {
}
