package testapp.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import testapp.demo.enity.ConversionE;
import testapp.demo.repository.ConversionRepository;
import testapp.demo.service.ConversionService;




@Service
public class ConversionServiceImpl implements ConversionService{
  
  @Autowired 
  private ConversionRepository conversionRepository;

  @Override
  public List<ConversionE> findAll(){
    return conversionRepository.findAll();
  }

  
}
