package testapp.demo.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import testapp.demo.enity.PairE;

public interface TravelOperation {
  
  @GetMapping(value = "/pairs")
  @ResponseStatus(value = HttpStatus.OK)
  
  List<PairE> findAll();
}
