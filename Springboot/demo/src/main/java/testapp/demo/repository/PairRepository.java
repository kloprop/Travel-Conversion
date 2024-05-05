package testapp.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testapp.demo.enity.PairE;

@Repository
public interface PairRepository extends JpaRepository<PairE, Long>{
  // default method from stocksRespository, save, findByID, findAll
}
