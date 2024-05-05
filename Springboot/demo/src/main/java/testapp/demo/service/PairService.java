package testapp.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import testapp.demo.enity.PairE;

public interface PairService {
  List<PairE> findAll();
}
