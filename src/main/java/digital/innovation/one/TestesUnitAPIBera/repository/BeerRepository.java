package digital.innovation.one.TestesUnitAPIBera.repository;

import digital.innovation.one.TestesUnitAPIBera.entity.BeerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BeerRepository extends JpaRepository<BeerModel, Long> {
    Optional<BeerModel> findByName(String name);
}
