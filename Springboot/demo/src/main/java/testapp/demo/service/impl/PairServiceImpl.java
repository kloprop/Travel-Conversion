package testapp.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testapp.demo.enity.PairE;
import testapp.demo.repository.PairRepository;
import testapp.demo.service.PairService;


@Service
public class PairServiceImpl implements PairService{
  
  @Autowired 
  private PairRepository pairRepository;

  @Override
  public List<PairE> findAll(){
    return pairRepository.findAll();
  }
}
