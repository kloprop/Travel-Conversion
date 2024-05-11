package testapp.demo.service.impl;

import testapp.demo.enity.VocabE;
import testapp.demo.repository.VocabRepository;
import testapp.demo.service.VocabService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class VocabServiceImpl implements VocabService{
  
  @Autowired 
  private VocabRepository vocabRepository;

  @Override
  public List<VocabE> findAll(){
    return vocabRepository.findAll();
  }
}
