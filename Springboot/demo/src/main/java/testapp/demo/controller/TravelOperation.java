package testapp.demo.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import testapp.demo.enity.ConversionE;
import testapp.demo.enity.VocabE;

public interface TravelOperation {
  
  @GetMapping(value = "/conversions")
  @ResponseStatus(value = HttpStatus.OK)
  List<ConversionE> findAllConversions();

  @GetMapping(value = "/vocabs")
  @ResponseStatus(value = HttpStatus.OK)
  List<VocabE> findAllVocabs();


}
