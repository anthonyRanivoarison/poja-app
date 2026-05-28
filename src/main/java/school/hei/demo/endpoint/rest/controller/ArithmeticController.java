package school.hei.demo.endpoint.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.hei.demo.PojaGenerated;
import school.hei.demo.model.ArithmeticResult;
import school.hei.demo.service.ArithmeticService;

@PojaGenerated
@RestController
@AllArgsConstructor
public class ArithmeticController {

  private final ArithmeticService arithmeticService;

  @GetMapping("/add")
  public ArithmeticResult add(@RequestParam Double a, @RequestParam Double b) {
    return arithmeticService.add(a, b);
  }

  @GetMapping("/subtract")
  public ArithmeticResult subtract(@RequestParam Double a, @RequestParam Double b) {
    return arithmeticService.subtract(a, b);
  }

  @GetMapping("/multiply")
  public ArithmeticResult multiply(@RequestParam Double a, @RequestParam Double b) {
    return arithmeticService.multiply(a, b);
  }

  @GetMapping("/divide")
  public ArithmeticResult divide(@RequestParam Double a, @RequestParam Double b) {
    return arithmeticService.divide(a, b);
  }
}
