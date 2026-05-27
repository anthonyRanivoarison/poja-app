package school.hei.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import school.hei.demo.PojaGenerated;
import school.hei.demo.model.ArithmeticResult;

@PojaGenerated
@Service
@AllArgsConstructor
public class ArithmeticService {

  public ArithmeticResult add(Double a, Double b) {
    return ArithmeticResult.builder().operation("add").a(a).b(b).result(a + b).build();
  }

  public ArithmeticResult subtract(Double a, Double b) {
    return ArithmeticResult.builder().operation("subtract").a(a).b(b).result(a - b).build();
  }

  public ArithmeticResult multiply(Double a, Double b) {
    return ArithmeticResult.builder().operation("multiply").a(a).b(b).result(a * b).build();
  }

  public ArithmeticResult divide(Double a, Double b) {
    if (b == 0) {
      throw new ArithmeticException("Division by zero");
    }
    return ArithmeticResult.builder().operation("divide").a(a).b(b).result(a / b).build();
  }
}
