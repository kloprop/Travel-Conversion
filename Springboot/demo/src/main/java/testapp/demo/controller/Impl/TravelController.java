package testapp.demo.controller.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import testapp.demo.controller.TravelOperation;
import testapp.demo.enity.ConversionE;
import testapp.demo.enity.VocabE;
import testapp.demo.service.ConversionService;
import testapp.demo.service.VocabService;


@RestController
@RequestMapping(value = "/api/v1")
public class TravelController implements TravelOperation{

  @Autowired
  private ConversionService conversionService;
  @Autowired
  private VocabService vocabService;


  @Override
  public List<ConversionE> findAllConversions(){
    return conversionService.findAll();
  }
  @Override
  public List<VocabE> findAllVocabs(){
    return vocabService.findAll();
  }
  
}
