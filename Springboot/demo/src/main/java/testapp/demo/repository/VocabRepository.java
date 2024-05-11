package testapp.demo.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testapp.demo.enity.VocabE;

@Repository
public interface VocabRepository extends JpaRepository<VocabE, Long>{
  // default method from stocksRespository, save, findByID, findAll
}
