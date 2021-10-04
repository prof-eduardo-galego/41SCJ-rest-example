package fiap.scj41.parkmgm.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping
  public String helloWorld() {
    return "It's working! Hello World";
  }

}
