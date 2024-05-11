package testapp.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testapp.demo.enity.ConversionE;


@Repository
public interface ConversionRepository extends JpaRepository<ConversionE, Long>{
  // default method from stocksRespository, save, findByID, findAll
}
