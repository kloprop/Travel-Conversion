package testapp.demo.controller.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import testapp.demo.controller.TravelOperation;
import testapp.demo.enity.PairE;
import testapp.demo.service.PairService;

@RestController
@RequestMapping(value = "/api/v1")
public class TravelController implements TravelOperation{

  @Autowired
  private PairService pairService;

  @Override

  public List<PairE> findAll(){
    return pairService.findAll();
  }
  
}
