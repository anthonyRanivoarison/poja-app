package school.hei.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArithmeticResult {
  private String operation;
  private Double a;
  private Double b;
  private Double result;
}
